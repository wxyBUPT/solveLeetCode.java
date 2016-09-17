package learn.util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by xiyuanbupt on 9/17/16.
 */
public class LArrays {

    private int[] arrays = new int[10];
    private void foo(){
        System.out.println(Arrays.asList(arrays));
    }

    public static void main(String[] args){
        int low = 0;
        int high = 12;
        int mid = (low + high) >>> 1;
        System.out.println(mid);

        int[] a = {1,2,3,4};
        int[] b = a;
        int[] c = {1,2,3,4};
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(Arrays.binarySearch(c,1));
        System.out.println(Arrays.equals(a,b));
        Arrays.sort(b);
        /**
         * 通过上述代码可以得出结论,"=="是指的内存相等
         */
        int[] d = new int[100];
        Arrays.fill(d,100);
        int[] e = Arrays.copyOf(d,10);
        System.out.println(Arrays.toString(e));
        ArrayList<Integer> arrayList = new ArrayList<>(19);
    }

}
