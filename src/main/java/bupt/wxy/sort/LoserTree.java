package bupt.wxy.sort;

import java.util.*;

/**
 * Created by xiyuanbupt on 10/9/16.
 * 败者树的java 实现
 */
public class LoserTree<T> {

    /**
     * 非叶子节点,记录数据源的索引位置,根据节点的值可以定位到所指向的数据源
     */
    private int[] tree;

    /**
     * 叶子节点,叶子节点提供数据,数据源的输出顺序必须有序且和元素的比较结果一致
     */
    private Object[] nodes;

    /**
     * 数据源列表,为叶子节点提供数据,数据源的输出顺序必须有序,且和元素的比较结果一致
     */
    private Iterator<T>[] branches;

    /**
     * 叶子节点数据的比较对象
     */
    private Comparator<T> comparator;

    /**
     * 构造方法,按照元素的 Comparable 接口实现进行排序
     * @param branches
     */
    public LoserTree(List<Iterator<T>> branches){
        this(branches, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return ((Comparable<T>)o1).compareTo(o2);
            }
        });
    }

    /**
     * 构造方法,指定数据源分支的迭代器和元素比较对象
     * 迭代器的输出必须有序并且与Comparator对象的比较结果一致
     * @param branches
     * @param comparator
     */
    @SuppressWarnings("unchecked")
    public LoserTree(List<Iterator<T>> branches,Comparator<T> comparator){
        this.branches = branches.toArray(new Iterator[0]);
        this.comparator = comparator;
        this.init();
    }

    /**
     * 依次读取数据源的数据进行归并排序,返回排序后的数据列表
     * @return
     */
    public List<T> merge(){
        return new ArrayList<>();
    }

    /**
     * 构建初始化败者树
     */
    private void init(){
        int size = this.branches.length;
        this.tree = new int[size];
        this.nodes = new Object[size];
        //为叶子节点赋值
        for(int i = 0;i<size;i++){
            this.put(i);
        }

        int winner = 0;
        for(int i = 1;i<size;i++){
            if(beat(i,winner)){
                winner = i;
            }
        }

        //非叶子节点初始化为冠军节点
        Arrays.fill(tree,winner);
        //从后向前依次调整非叶子节点
        for(int i = size -1;i>=0;i--){
            adjust(i);
        }

    }

    /**
     * 调整第index 个叶子节点
     * 具体调整过程为:叶子节点和父节点比较,败者留在父节点的位置,胜者继续和父节点的父节点比较,直到整棵树
     * 的跟节点
     * @param index
     */
    private void adjust(int index){
        int size = this.branches.length;
        int t = (size + index)/2;
        while (t > 0){
            if(beat(tree[t],index)){
                int tmp = tree[t];
            }
        }
    }

    @SuppressWarnings("unchecked")
    private T get(int index){
        return (T)nodes[index];
    }

    /**
     * 设置第 index 个叶子节点的下一个数据
     * 如果数据源已经结束,则设置为null
     * @param index
     */
    private void put(int index){
        Iterator<T> branch = this.branches[index];
        this.nodes[index] = branch.hasNext() ? branch.next():null;
    }

    /**
     * 判断index1对应的节点是否能打败index2对应的节点
     *
     * @param index1
     * @param index2
     * @return
     */
    private boolean beat(int index1,int index2){
        T t1 = get(index1);
        T t2 = get(index2);
        if(t1 == null)return false;
        if(t2 == null)return true;
        int n = comparator.compare(t1,t2);
        return n != 0 ? n < 0 : index1 < index2;
    }

    public static void main(String[] args){
        int[] nodes = {6,8,5,4,3,7};
        int[] tree = {4,4,4,4,4,4};
        for(int i = 5;i>=0;i--){
            int index = i;
            int t = (6 + index)/2;
            while (t>0){
                if(nodes[tree[t]] < nodes[t]){
                    int tmp = tree[t];
                    tree[t] = index;
                    index = tmp;
                }
                t /= 2;
            }
            tree[0] = index;
            System.out.println(i + " : " + Arrays.toString(tree));
        }
    }
}
