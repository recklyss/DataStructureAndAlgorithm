package Alogrithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * @Author zhangjiaheng
 * @Description 冒泡排序
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 2, 7, 4, 8, 9, 1};
        for (int i = 0; i < arr.length - 1; i++) {
            // 选中一个元素 不断地向后比较 较大则“上浮”
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    SwapUtil.swap(arr, i, j);
                }
            }
        }

        System.out.println(JSON.toJSONString(arr));
    }
}
