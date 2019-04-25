package Alogrithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * @Author zhangjiaheng
 * @Description 快速排序
 **/
public class QuickSort {


    /**
     * @param a    待排序数组
     * @param from 待排序起始下标
     * @param to   待排序结束下标
     * @return
     */
    public static void QuickSort(int[] a, int from, int to) {
        if(from >= to){
            return;
        }
        int index = (to - from) / 2;
        while (from <  to) {
            // 从前往后找到一个比基准元素大的 从后往前找到一个比基准元素小的 停下来 然后交换
            while (from <  to && a[from] < a[index]) from++;
            SwapUtil.swap(a, from, to);
            while (from <  to && a[to] > a[index]) to--;
            SwapUtil.swap(a, from, to);
        }
        QuickSort(a, from, index - 1);
        QuickSort(a, index + 1, to);
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 2, 7, 4, 8, 9, 1};
        QuickSort(arr, 0, arr.length - 1);
        System.out.println(JSON.toJSONString(arr));
    }
}
