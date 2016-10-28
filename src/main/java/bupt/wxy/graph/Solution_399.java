package bupt.wxy.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 10/27/16.
 Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

 Example:
 Given a / b = 2.0, b / c = 3.0.
 queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 return [6.0, 0.5, -1.0, 1.0, -1.0 ].

 The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

 According to the example above:

 equations = [ ["a", "b"], ["b", "c"] ],
 values = [2.0, 3.0],
 queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 */
public class Solution_399 {

    // 找最短路径
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String,Integer> map = new HashMap<>();
        for(String[] strings:equations){
            int index = 0;
            for(String string:strings){
                if(!map.containsKey(string)){
                    map.put(string,index++);
                }
            }
        }

        int len = map.size();
        System.out.println(len);
        double[][] matrix = new double[len][len];
        for(int i = 0;i<equations.length;i++){
            matrix[map.get(equations[i][0])][map.get(equations[i][1])] = values[i] ;
            if(values[i]!=0) {
                matrix[map.get(equations[i][1])][map.get(equations[i][0])] = 1.0 / values[i];
            }
        }
        double[] res = new double[queries.length];
        for(int i = 0;i<queries.length;i++){
            String[] query = queries[i];
            if(map.containsKey(query[0]) && map.containsKey(query[1])) {

                int[] tuple = {map.get(query[0]), map.get(query[1])};
                res[i] = getpathLen(matrix, tuple);
            }else {
                res[i] = (double)-1;
            }
        }
        return res;
    }

    // 查看是否有连通路径
    double getpathLen(double[][] matrix,int[] tuple){
        int len = matrix.length;
        return len;
    }

    public static void main(String[] args){
        Solution_399 sl = new Solution_399();
        String[][] equations = {{"a","b"},{"b","c"}};
        String[][] queries = {{"a","b"}};
        double[] values = {2.0,3.0};
        sl.calcEquation(equations,values,queries);
    }
}
