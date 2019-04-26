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
        if (from >= to) {
            return;
        }
        System.out.println("-----");
        int sortedIndex = getSortedIndex(a, from, to);
        QuickSort(a, from, sortedIndex - 1);
        QuickSort(a, sortedIndex + 1, to);
    }

    /**
     * 选出基准值 并且将大数放在右边 小数放在左边
     */
    public static int getSortedIndex(int[] a, int from, int to) {
        // 取待排序数组段第一个数字为基准元素
        int comp = a[from];
        while (from < to) {
            // 从前向后遍历 如果小于基准元素 就放着不变 否则向后遍历
            while (from < to && a[from] < comp) ++from;
            while (from < to && a[to] > comp) --to;
            // 找到需要交换的交换
            SwapUtil.swap(a, from, to);
        }
        return from;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, -2, 9, 2, 1};
        QuickSort(arr, 0, arr.length - 1);
        System.out.println(JSON.toJSONString(arr));
    }
}
