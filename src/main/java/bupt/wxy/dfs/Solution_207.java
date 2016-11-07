package bupt.wxy.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiyuanbupt on 11/7/16.
 There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


 */
public class Solution_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] path = new int[numCourses][numCourses];
        for(int[] prereq: prerequisites){
            path[prereq[0]][prereq[1]] = 1;
        }
        int[] can = new int[numCourses];

        for(int i = 0;i<numCourses;i++){
            // 如果不能完成
            if(can[i] == 0){
                Set<Integer> visited = new HashSet<>();
                if(!dfs(path,can,visited,i))return false;
            }
        }
        return true;
    }

    boolean dfs(int[][] path,int[] can,Set<Integer> visited,int from){
        if(visited.contains(from))return false;
        visited.add(from);
        for(int i = 0;i<path[0].length;i++){
            // 如果有前置条件,并且当前不确定是否可以完成
            if(path[from][i]==1&&can[i]==0){
                if(visited.contains(i))return false;
                else {
                    if(dfs(path,can,visited,i)){
                        can[i] = 1;
                    }else return false;
                }
            }
        }
        can[from] = 1;
        return true;
    }


    public static void main(String[] args){
        Solution_207 sl = new Solution_207();
        int[][] pre = {{1,2},{2,3}};
        sl.canFinish(10,pre);
    }
}
