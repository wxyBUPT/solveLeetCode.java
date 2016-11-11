package bupt.wxy.bitManipulation;

/**
 * Created by xiyuanbupt on 11/11/16.
 在这里学习java 里面的位操作
 */

public class BitOpera {

    public void op(){
        System.out.println("左移位 << ");
        System.out.println(1<<31);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-1<<3);

        System.out.println("右移位 >>");
        System.out.println(5 >> 2);
        System.out.println(4 >> 2);
        System.out.println(-4 >> 2);

        System.out.println("无符号右移位 >>>");
        /**
         * 正数右移，高位用0补，负数右移，高位用1补，当负数使用无符号右移时，用0进行部位(自然而然的，就由负数变成了正数了)

         注意：笔者在这里说的是右移，高位补位的情况。正数或者负数左移，低位都是用0补。(自行测试)
         */
        System.out.println(-5 >>> 3);

        System.out.println("位与 &");
        System.out.println(5 & 3);

        System.out.println("位或 |");
        System.out.println(5 | 3);

        System.out.println("位异或 ^");
        System.out.println(5 ^ 3);

        System.out.println("位非 ~");
        System.out.println(~5);
        /**
         5转换为二进制：0000 0000 0000 0000 0000 0000 0000 0101
         -------------------------------------------------------------------------------------
         -6转换为二进制：1111 1111 1111 1111 1111 1111 1111 1010

         位非：操作数的第n位为1，那么结果的第n位为0，反之。
         */


    }

    public static void main(String[] args){
        BitOpera bitOpera = new BitOpera();
        bitOpera.op();
    }
}
