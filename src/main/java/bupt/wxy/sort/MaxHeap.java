package bupt.wxy.sort;

/**
 * Created by xiyuanbupt on 10/9/16.
 * 本代码为了复习堆排序
 */
public class MaxHeap {
    int[] heap;
    int heapsize;

    public MaxHeap(int[] array){
        this.heap = array;
        this.heapsize = array.length;
    }

    public void buildMaxHeap(){
        for(int i = heapsize/2 -1;i>=0;i--){
            adjustDown(i);
        }
    }

    public void heapSort(){
        buildMaxHeap();
        for(int i = 0;i<heap.length;i++){
            int tmp = heap[0];
            heap[heapsize-1] = tmp;
            heapsize --;
            adjustDown(0);
        }
    }

    public void adjustDown(int i){
        int l = getLeft(i);
        int r = getRight(i);
        int largest = i;

        if(l<heapsize && heap[l]>heap[i]){
            largest = l;
        }

        if(r<heapsize && heap[r]>heap[largest]){
            largest = r;
        }

        if(largest == i) return;//如果当前节点为最大节点则不需要调整

        int tmp = heap[i];
        heap[i] = heap[largest];
        heap[largest] = tmp;
        adjustDown(largest);
    }

    private int getParent(int i){
        return (i-1)/2;
    }

    private int getLeft(int i){
        return 2*(i+1) -1;
    }

    private int getRight(int i){
        return 2 * (i+1);
    }

}
