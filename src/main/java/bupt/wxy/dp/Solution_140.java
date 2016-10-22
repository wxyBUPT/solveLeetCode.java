package bupt.wxy.dp;

import java.util.*;

/**
 * Created by xiyuanbupt on 10/21/16.
 Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].
 */
public class Solution_140 {

    // 多次尝试使用dfs
    // 后经过分析,并不是因为dfs时间复杂度好,是因为没有保存计算到的结果,导致过多的计算
    // 经验教训就是dfs 一般要保存结果
    public List<String> wordBreak(String s,Set<String> wordDict){
        return DFS(s,wordDict,new HashMap<String, LinkedList<String>>());
    }

    private List<String> DFS(String s,Set<String> wordDict,HashMap<String,LinkedList<String>> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        LinkedList res = new LinkedList<>();
        if(s.length()==0){
            return res;
        }

        for(String word:wordDict){
            if(s.startsWith(word)){
                List<String> subList = DFS(s.substring(word.length()),wordDict,map);
                for(String sub:subList){
                    res.add(word + (sub.isEmpty() ?"":" ") + sub);
                }
            }
        }
        map.put(s,res);
        return res;
    }


    // 代码同样超时
    public List<String> ywordBreak(String s,Set<String> wordDict){
        List<String> result = new ArrayList<>();

        for(int j = s.length() - 1; j >= 0; j--){
            if(wordDict.contains(s.substring(j)))
                break;
            else{
                if(j == 0)
                    return result;
            }
        }
        for(int i = 0; i < s.length()-1; i++)
        {
            if(wordDict.contains(s.substring(0,i+1)))
            {
                List<String> strs = ywordBreak(s.substring(i+1,s.length()),wordDict);
                if(strs.size() != 0)
                    for(Iterator<String> it = strs.iterator();it.hasNext();)
                    {
                        result.add(s.substring(0,i+1)+" "+it.next());
                    }
            }
        }
        if(wordDict.contains(s)) result.add(s);
        return result;
    }

    // 下面是我的代码版本,可以通过剪枝优化,但是仍然超时
    public List<String> mywordBreak(String s, Set<String> wordDict) {

        List<String> res = new ArrayList<>();
        backtracking(res,s,"",wordDict,0,1);
        return res;
    }

    // 单纯的使用 backtracking 超时,通过查看测试用例知道可以剪纸
    private void backtracking(List<String> res, String s,String curr,
                              Set<String> wordDict,int i,int j){
        if(i == s.length()){
            curr = curr.substring(1);
            res.add(curr);
            return;
        }

        if(j > s.length()){
            return;
        }

        String tmp = s.substring(i,j);
        if(wordDict.contains(tmp)){
            String newCurr = curr + " " + tmp;
            backtracking(res,s,newCurr,wordDict,j,j + 1);
        }
        backtracking(res, s, curr, wordDict, i, j + 1);
    }

    public static void main(String[] args){
        String s = "aaa";
        String b = s.substring(0,1);
        System.out.println(b);
    }
}
