package Alogrithm.Alogrithm.LiBaiDajiu;

import java.util.ArrayList;
import java.util.List;

/**
 * 李白大酒 题目解法
 */
public class Solution {

    /**
     * 使用二进制数字进行解题
     */
    public static void printWithNum() {
        // 100000000000000  -  111111111100000
        for (int i = 16384; i < 32736; i++) {
            int sum = 2;// 开始有2斗酒
            int flower = 0;
            int store = 0;
            int tmpI = i;
            int j = 0;
            for (; j < 15; j++) {
                // 1表示花 0表示店 遇店加一倍 遇花喝一斗
                if (tmpI % 2 == 1) {
                    flower++;
                    sum -= 1;
                } else {
                    store++;
                    sum *= 2;
                }
                if (flower > 10 || sum < 0 || store > 5) {
                    break;
                }
                tmpI /= 2;
            }
            if (j == 15 && sum == 0) {
                tmpI = i;
                while (j-- != 0) {
                    if (tmpI % 2 == 1) {
                        System.out.print("b");
                    } else {
                        System.out.print("a");
                    }
                    tmpI /= 2;
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        printWithNum();
        List<Integer[]> list = new ArrayList<Integer[]>();
        Integer a[] = new Integer[2147483647];
    }
}
