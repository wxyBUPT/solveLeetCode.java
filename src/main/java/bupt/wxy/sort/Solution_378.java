package bupt.wxy.sort;

import java.util.PriorityQueue;

/**
 * Created by xiyuanbupt on 10/20/16.
 */
public class Solution_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>();

        for(int i = 0;i<len;i++)priorityQueue.offer(new Point(0,i,matrix[0][i]));
        int i = 0;
        while (i<k-1){
            i ++;
            Point p = priorityQueue.poll();
            if(p.x == len-1)continue;
            priorityQueue.offer(new Point(p.x + 1,p.y,matrix[p.x + 1][p.y]));
        }
        return priorityQueue.poll().val;
    }

}

class Point implements Comparable<Point>{

    int x,y,val;

    public Point(int x,int y ,int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }


    @Override
    public int compareTo(Point o) {
        return val - o.val;
    }
}
