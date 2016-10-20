# Hbase和Mongo的比较

**这两天在抓取论坛数据，一直想用Hbase代替Mongo作为后端存储，调研了相关对比，最后果断还用mongo**

  1.Mongodb bson文档型数据库，整个数据都存在磁盘中，hbase是列式数据库，集群部署时每个familycolumn保存在单独的hdfs文件中。

  2.Mongodb 主键是“_id”,主键上面可以不建索引,记录插入的顺序和存放的顺序一样，hbase的主键就是row key，可以是任意字符串(最大长度是 64KB，实际应用中长度一般为 10-100bytes)，在hbase内部，row key保存为字节数组。存储时，数据按照Row key的字典序(byte order)排序存储。设计key时，要充分排序存储这个特性，将经常一起读取的行存储放到一起。

  字典序对int排序的结果是1,10,100,11,12,13,14,15,16,17,18,19,2,20,21,…,9,91,92,93,94,95,96,97,98,99。要保持整形的自然序，行键必须用0作左填充。3.Mongodb支持二级索引，而hbase本身不支持二级索引4.Mongodb支持集合查找，正则查找，范围查找，支持skip和limit等等，是最像mysql的nosql数据库，而hbase只支持三种查找：通过单个row key访问，通过row
  key的range，全表扫描5.mongodb的update是update-in-place，也就是原地更新，除非原地容纳不下更新后的数据记录。而hbase的修改和添加都是同一个命令：put，如果put传入的row
  key已经存在就更新原记录,实际上hbase内部也不是更新，它只是将这一份数据已不同的版本保存下来而已，hbase默认的保存版本的历史数量是3。6.mongodb的delete会将该行的数据标示为已删除，因为mongodb在删除记录时并不是真把记录从内存或文件中remove，而是将该删除记录数据置空（写0或特殊数字加以标识）同时将该记录所在地址放到一个list列表“释放列表”中，这样做的好就是就是如果有用户要执行插入记录操作时，mongodb会首先从该“释放列表”中获取size合适的“已删除记录”地址返回，这种方法会提升性能（避免了malloc内存操作），同时mongodb也使用了bucket
  size数组来定义多个大小size不同的列表，用于将要删除的记录根据其size大小放到合适的“释放列表”中。Hbase的delete是先新建一个 tombstonemarkers，然后读的时候会和 tombstonemarkers做merge，在 发生major
  compaction时delete的数据记录才会真真删除。7.mongodb和hbase都支持mapreduce，不过mongodb的mapreduce支持不够强大，如果没有使用mongodb分片，mapreduce实际上不是并行执行的8.mongodb支持shard分片，hbase根据row key自动负载均衡，这里shard key和row
  key的选取尽量用非递增的字段，尽量用分布均衡的字段，因为分片都是根据范围来选择对应的存取server的，如果用递增字段很容易热点server的产生，由于是根据key的范围来自动分片的，如果key分布不均衡就会导致有些key根本就没法切分，从而产生负载不均衡。9.mongodb的读效率比写高，hbase默认适合写多读少的情况，可以通过hfile.block.cache.size配置，该配置storefile的读缓存占用Heap的大小百分比，0.2表示20%。该值直接影响数据读的性能。如果写比读少很多，开到0.4-0.5也没问题。如果读写较均衡，0.3左右。如果写比读多，果断默认0.2吧。设置这个值的时候，你同时要参考hbase.regionserver.global.memstore.upperLimit，该值是memstore占heap的最大百分比，两个参数一个影响读，一个影响写。如果两值加起来超过80-90%，会有OOM的风险，谨慎设置。

  10.hbase采用的LSM思想(Log-Structured Merge-Tree)，就是将对数据的更改hold在内存中，达到指定的threadhold后将该批更改merge后批量写入到磁盘，这样将单个写变成了批量写，大大提高了写入速度，不过这样的话读的时候就费劲了，需要merge
  disk上的数据和memory中的修改数据，这显然降低了读的性能。mongodb采用的是mapfile+Journal思想，如果记录不在内存，先加载到内存，然后在内存中更改后记录日志，然后隔一段时间批量的写入data文件，这样对内存的要求较高，至少需要容纳下热点数据和索引。
