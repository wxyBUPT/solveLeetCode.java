package string;

import javax.swing.text.Style;
import java.util.List;

/**
 * Created by xiyuanbupt on 9/13/16.
 Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37
 */
public class Solution_165 {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int i = 0;
        int res ;
        while (i<s1.length&&i<s2.length){
            res = compareString(s1[i],s2[i]);
            if(res!=0)return res;
            i++;
        }
        if(s1.length>i){
            for(;i<s1.length;i++){
                if(str2int(s1[i])!=0){
                    return 1;
                }
            }
            return 0;
        }
        else if(s2.length>i){
            for(;i<s2.length;i++){
                if(str2int(s2[i])!=0)
                    return -1;
            }
            return 0;
        }
        else return 0;
    }

    private int compareString(String s1,String s2){
        int i = str2int(s1) - str2int(s2);
        if(i<0)return -1;
        else  if (i>0)return 1;
        else return 0;
    }

    private int str2int(String str){
        int res = 0;
        for(int i = 0;i<str.length();i++){
            res = 10 * res + (str.charAt(i) - '0');
        }
        return res;
    }

    public static void main(String[] args){
        Solution_165 sl = new Solution_165();
        System.out.println(sl.compareVersion("1.2","1.10"));
        System.out.println(sl.str2int("01"));
        System.out.println(sl.str2int("1"));
    }
}
