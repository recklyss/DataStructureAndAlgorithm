package Alogrithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * @Author zhangjiaheng
 * @Description 选择排序
 **/
public class ChooseSort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 2, 7, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            // 向后寻找一个最小的 选择出来和i位置的交换
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                SwapUtil.swap(arr, i, minIndex);
            }
        }

        System.out.println(JSON.toJSONString(arr));
    }
}
