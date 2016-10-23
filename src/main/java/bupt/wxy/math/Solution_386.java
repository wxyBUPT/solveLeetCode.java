package bupt.wxy.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 10/23/16.
 Given an integer n, return 1 - n in lexicographical order.

 For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

 Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.

 */
public class Solution_386 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int curr = 1;
        for(int i = 0;i<n;i++){
            res.add(curr);
            if(curr*10<=n){
                curr*=10;
            }else if(curr%10!=9 &&curr+1<=n){
                curr++;
            }else{
                while ((curr/10)%10==9){
                    curr /=10;
                }
                curr=curr/10+1;
            }
        }
        return res;
    }

    // dfs 解法
    public List<Integer> dfslexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1;i<10;i++){
            lexicalOrder(res,i,n);
        }
        return res;
    }

    private void lexicalOrder(List<Integer> res,int curr,int n){
        if(curr>n)return;
        else {
            res.add(curr);
            for(int i = 0;i<10;i++){
                if(10*curr + i >n)return ;
                lexicalOrder(res,10*curr + i,n);
            }
        }
    }

}
