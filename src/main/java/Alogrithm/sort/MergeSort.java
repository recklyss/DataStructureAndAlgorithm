package Alogrithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * @Author zhangjiaheng
 * @Description 归并排序
 **/
public class MergeSort {

    /**
     * 归并排序思想：将数组分成左右两部分，对左右数组分别进行排序，然后将两个数组合并成一个有序数组
     */
    public static void mergeSort(int[] a, int start, int end) {
        if (end - start < 1) {
            return;
        }
        if (end - start == 1) {
            if (a[end] < a[start]) {
                SwapUtil.swap(a, start, end);
            }
            return;
        }
        int mid = (end + start) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        // 使用临时数组保存即将排序的数列
        int[] tmp = new int[(end - start) + 1];
        int index = 0;
        int indexL = start;
        int indexR = mid + 1;
        // 开始合并两个有序数组
        while (index < tmp.length && indexL <= mid && indexR <= end) {
            if (a[indexL] < a[indexR]) {
                tmp[index++] = a[indexL++];
            } else {
                tmp[index++] = a[indexR++];
            }
        }
        while (indexL <= mid) {
            tmp[index++] = a[indexL++];
        }
        while (indexR <= end) {
            tmp[index++] = a[indexR++];
        }
        System.arraycopy(tmp, 0, a, start, tmp.length);
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 6, 2, 7, 4, 8, 9, 1};
        mergeSort(a, 0, a.length - 1);
        System.out.println(JSON.toJSONString(a));
    }
}
