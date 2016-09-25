package main.java.bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 9/5/16.
 Write a function that takes a main.java.bupt.wxy.string as input and returns the main.java.bupt.wxy.string reversed.

 Example:
 Given s = "hello", return "olleh".
 */
public class Solution_344 {
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
