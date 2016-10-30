package bupt.wxy.string;

/**
 * Created by xiyuanbupt on 10/30/16.
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Solution_6 {

    public String convert(String s, int numRows) {
        if(numRows < 2 || numRows >= s.length()) return s;
        StringBuilder sb = new StringBuilder(s.length());
        int origStep = numRows * 2 - 2;
        int step = origStep;
        for(int i = 0; i < numRows; i++){
            step = i == numRows - 1 ? origStep : origStep - i * 2;
            int curr = i;
            while(curr < s.length()){
                sb.append(s.charAt(curr));
                curr += step;
                int temp = Math.abs(step - origStep);
                step = temp == 0 ? origStep : temp; //First/last rows
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Solution_6 sl = new Solution_6();
        System.out.println(sl.convert("ABC",2));
    }
}
