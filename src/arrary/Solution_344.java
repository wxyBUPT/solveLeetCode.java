package arrary;

/**
 * Created by xiyuanbupt on 9/5/16.
 Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".
 */
public class Solution_344 {
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
