package bupt.wxy.list;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xiyuanbupt on 10/9/16.
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class Solution_23 {
    public ListNode mergeKLists(ListNode[] lists) {

        ListHeap listHeap = new ListHeap(lists);
        return listHeap.merge();

    }
}

class ListHeap{

    ListNode[] heap;
    int heapSize;

    public ListHeap(ListNode[] lists){
        //去掉null 值
        ListNode[] tmps = new ListNode[lists.length];
        heapSize = 0;
        for(int i = 0;i<lists.length;i++){
            if(lists[i]!=null){
                tmps[heapSize++] = lists[i];
            }
        }
        this.heap = tmps;
        buildHeap();
    }

    public ListNode merge(){
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        while (heapSize!=0){
            curr.next = heap[0];
            if(heap[0].next==null){
                heap[0] = heap[heapSize -1];
                heapSize --;
            }else {
                heap[0] = heap[0].next;
            }
            adjustDown(0);
            curr = curr.next;
        }
        return pre.next;
    }

    private void buildHeap(){
        for(int i = heapSize/2 -1;i>=0;i--){
            adjustDown(i);
        }
    }

    private void adjustDown(int i){
        int left = getLeft(i);
        int right = getRight(i);
        int largest = i;

        if(left<heapSize && heap[left].val<heap[i].val){
            largest = left;
        }

        if(right<heapSize && heap[right].val < heap[largest].val){
            largest = right;
        }

        if(largest == i)return;

        ListNode tmp = heap[i];
        heap[i] = heap[largest];
        heap[largest] = tmp;
        adjustDown(largest);
    }

    private int getParent(int i){
        return (i-1)/2;
    }

    private int getLeft(int i){
        return 2 * (i + 1) -1;
    }

    private int getRight(int i){
        return 2 * (i+1);
    }

}
