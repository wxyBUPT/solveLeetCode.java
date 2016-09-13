package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 9/13/16.
  Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.   

 Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.

 Note:
 You may assume that both strings contain only lowercase letters.

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true
 */
public class Solution_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> charPos = new HashMap<>();
        int len = ransomNote.length();
        for(int i = 0;i<len;i++){
            Character c = ransomNote.charAt(i);
            Integer pos = charPos.get(c);
            int j ;
            if(pos==null){
                j = magazine.indexOf(c);
            }else {
                j = magazine.indexOf(c,pos+1);
            }
            if(j==-1)return false;
            else {
                charPos.put(c,j);
            }
        }
        return true;
    }
}
