package bupt.wxy.greedy;

import java.util.*;

/**
 * Created by xiyuanbupt on 10/11/16.
 */
public class Solution_406 {

    public int[][] reconstructQueue(int[][] people) {

        List<int[]> peopleList = Arrays.asList(people);
        Collections.sort(peopleList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : -o1[0] + o2[0];
            }
        });

        List<int[]> res = new LinkedList<>();
        for(int[] cur:people){
            res.add(cur[1],cur);
        }
        return res.toArray(new int[people.length][]);

    }

    public static void main(String[] args){
        Solution_406 sl = new Solution_406();
        int[][] people = {{7,0}, {4,4},{7,1}};

        int[][] res = sl.reconstructQueue(people);
        for(int[] lis:res){
            System.out.println(Arrays.toString(lis));
        }

    }
}
