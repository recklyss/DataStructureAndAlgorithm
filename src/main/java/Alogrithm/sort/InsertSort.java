package Alogrithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * @Author zhangjiaheng
 * @Description 插入排序
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 2, 7, 4, 8, 9, 1};
        for (int i = 0; i < arr.length - 1; i++) {
            int end = i;
            int tmp = arr[i + 1];
            while (end >= 0 && arr[end] > tmp) {
                arr[end + 1] = arr[end];
                end--;
            }
            arr[end + 1] = tmp;
        }
        System.out.println(JSON.toJSONString(arr));
    }
}
