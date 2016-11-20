package bupt.wxy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 11/20/16.
 Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

 Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

 Example:
 Input:
 [[0,0],[1,0],[2,0]]

 Output:
 2

 Explanation:
 The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class Solution_447 {

    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0;i<len;i++){
            for(int j = 0;j<len;j++){
                if(i==j)continue;
                int d = getDist(points[i],points[j]);
                map.put(d,map.getOrDefault(d,0)+1);
            }
            for(int val:map.values()){
                res += val * (val-1);
            }
            map.clear();
        }
        return res;
    }

    int getDist(int[] p1,int[] p2){
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx * dx + dy*dy;
    }
}
