package bupt.wxy.string;

import java.util.*;

/**
 * Created by xiyuanbupt on 9/29/16.
 */
public class Solution_332 {
    public List<String> findItinerary(String[][] tickets) {
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int s1 = o1[0].compareTo(o2[0]);
                if(s1!=0)return s1;
                else {
                    return o1[1].compareTo(o2[1]);
                }
            }
        });

        List<String> res = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];
        Arrays.fill(visited,false);
        String current = "JFK";
        DFS(tickets,visited,current,res);
        return res;
    }

    private boolean DFS(String[][] tickets,boolean[] visited,String current,List<String> res){
        int len = tickets.length;
        if(res.size()==len){
            res.add(current);
            return true;
        }
        for(int i = 0;i<len;i++){
            if(!visited[i]&&tickets[i][0].equals(current)){
                visited[i] = true;
                res.add(current);
                current = tickets[i][1];
                if(DFS(tickets,visited,current,res))return true;
                //如果没有在分支上找到结果则恢复
                visited[i] = false;
                res.remove(res.size()-1);
                current = tickets[i][0];
            }
        }
        return false;
    }

    public static void main(String[] args){
        Solution_332 sl = new Solution_332();
        String[][] tickets = {{"foo","bar"},{"foo","bar"},{"foo","bar"}};
        sl.findItinerary(tickets);
    }
}
