package learn.util;

import java.util.*;

/**
 * Created by xiyuanbupt on 9/17/16.
 * 看Collections的源码,有一项学习到的地方
 * 非RandomAccess 连续的操作尽量使用ListIterator
 * Collections 中有大波 unmodifiable 的东西
 * Collections 中有一大波 Synchronized 的操作,用来将对应的Collection 编程同步的collection
 * Collections 中有一大波Checked Collection 的操作
 */
public class LCollections {
    public static void main(String[] args){
        /**
         * 测试
         */

        /**
         * addAll 将所有元素添加到collection 中取
         * (ArrayList 是 RandomAccess 的)
         */
        List<DogForCollection> dogs = new ArrayList<>(10);

        boolean res = Collections.addAll(dogs,new DogForCollection("Lele"),new DogForCollection("Huanhuan"));
        System.out.println(dogs.size());
        System.out.println(res);

        Deque<DogForCollection> dogsDeque = new ArrayDeque<>(dogs);
        /**
         * asLifoQueue
         * 以后进先出的(Lifo) Queue 的形式返回某个Deque 的视图
         * (为什么不用接口?)
         */
        Queue<DogForCollection> dogsQueue1 = dogsDeque;
        Queue<DogForCollection> dogsQueue = Collections.asLifoQueue(dogsDeque);

        /**
         * binarySearch 使用二分搜索法搜索指定的列表,已获得指定的对象
         */
        int i = Collections.binarySearch(dogs,new DogForCollection("Lele"));
        System.out.println(dogs.get(i).getName());

        /**
         * 使用Comparator 来进行二分查找
         */
        i = Collections.binarySearch(dogs, new DogForCollection("Lele"), new Comparator<DogForCollection>() {
            @Override
            public int compare(DogForCollection o1, DogForCollection o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(dogs.get(i).getName());

        /**
         * Collections 还有各种checked 版本,但是目前根本不知道如何去用
         */

        /**
         * Collections copy 将所有元素从一个列表复制到另外一个列表
         */
        List<DogForCollection> dst = new ArrayList<>(10);
        Collections.addAll(dst,new DogForCollection("Dahuang"),new DogForCollection("Huanhuan"));
        System.out.println(dst.size() + " " + dogs.size());
        Collections.copy(dst,dogs);
        System.out.println(dst.toString());

        /**
         * Collections disjoint 如果两个指定的collection 中没有相同的元素,则返回true
         */
        System.out.println(Collections.disjoint(dst,dogs));

        /**
         * Collections.empytList 返回一个空的列表(不可变的)
         * 还支持一系列其他的emptySet 等操作
         */
        List<Integer> tmp = Collections.emptyList();

        /**
         * 下面操作会引起 UnsupportedOperationException 异常
        Collections.addAll(tmp,new Integer(1),new Integer(2));
        System.out.println(tmp.toString());
         */

        /**
         * Collections frequency 返回指定collections 中等于指定对象的元素个数
         * Object 默认的equl 方法是 == ,所以下面操作找不到一个
         * 也可以通过重写equls 方法
         * (当一个类有自己特定的"逻辑相等"概念的时候重写equal 方法,如果没有重写equal
         */
        System.out.println(dogs.toString());
        System.out.println(Collections.frequency(dogs,new DogForCollection("Lele")));
        DogForCollection lele = new DogForCollection("Lele");
        dogs.add(lele);
        dogs.add(lele);
        System.out.println(Collections.frequency(dogs,lele));
        List<String> strings = new ArrayList<>(10);
        for(int index= 0;index<10;index++){
            strings.add("Lele");
        }
        //String 重写了equals 方法
        System.out.println(Collections.frequency(strings,"Lele"));
        /**
         * fill 使用指定的元素替换指定列表中所有元素
         */
        Collections.fill(dst,lele);
        System.out.println(dst.toString());
        List<String> subList = new ArrayList<>(2);
        Collections.addAll(subList,"Lele","Lele");
        /**
         * sublist 同样使用的是equals 方法
         */
        System.out.println(Collections.indexOfSubList(strings,subList));
        System.out.println(Collections.lastIndexOfSubList(strings,subList));

        /**
         * 比较实现了Comaprable 接口的元素
         */
        System.out.println(Collections.max(dogs));
        /**
         * 如果没有实现 Comparable 接口,那么可以使用Comparator
         */
        System.out.println(Collections.max(dogs, new Comparator<DogForCollection>() {
            @Override
            public int compare(DogForCollection o1, DogForCollection o2) {
                return o1.compareTo(o2);
            }
        }));
        System.out.println(Collections.max(dogs,Collections.<DogForCollection>reverseOrder()));

        /**
         * 返回由指定对象的n个副本组成的不可变的列表
         */
        List<DogForCollection> useCopies = Collections.nCopies(2,new DogForCollection("Lele"));

        DogForCollection huhu = new DogForCollection("huhu");
        /**
         * replaceAll 同样使用equals 方法来判断
         */
        Collections.replaceAll(dogs,lele,huhu);
        System.out.println(dogs.toString());

        /**
         * reverseOrder() 的两个方法用来返回一个比较器
         */

        System.out.println(dogs);
        /**
         * 根据指定的距离轮换指定列表中的元素
         */
        Collections.rotate(dogs,1);
        System.out.println(dogs);

        /**
         * shuffle 使用默认的随机源对指定列表进行置换
         */
        Collections.addAll(dogs,new DogForCollection("haha"),new DogForCollection("dahuang"),new DogForCollection("hongdou"));
        System.out.println(dogs.toString());
        Collections.shuffle(dogs);
        System.out.println(dogs.toString());

        /**
         * 根据元素的自然顺序对指定列表进行排序
         */
        Collections.sort(dogs);
        System.out.println(dogs.toString());
        Collections.sort(dogs,Collections.<DogForCollection>reverseOrder());
        System.out.println(dogs.toString());

        /**
         * 在指定列表的指定位置交换元素
         */
        Collections.swap(dogs,1,2);
        System.out.println(dogs.toString());

        /**
         * Collections 中包含一大堆synchronize 操作,这些操作一般是包装一层,然后限定操作为sync
         */
        List<DogForCollection> syncDogs = Collections.synchronizedList(dogs);

    }

    static class DogForCollection implements Comparable<DogForCollection> {
        public DogForCollection(){

        }

        public DogForCollection(String name){
            this.name = name;
        }

        @Override
        public int compareTo(DogForCollection o) {
            return name.compareTo(o.name);
        }

        String name ;

        public String getName(){
            return name;
        }

        @Override
        public String toString(){
            return this.getClass().getName() + " " + name;
        }

        @Override
        public boolean equals(Object obj){
            DogForCollection dogForCollection = (DogForCollection)obj;
            return this.name.equals(dogForCollection.name);
        }

        /**
         * 重写equals 方法就必须重写hashCode 方法
         * @return
         */
        @Override
        public int hashCode(){
            return this.name.hashCode();
        }

    }
}
