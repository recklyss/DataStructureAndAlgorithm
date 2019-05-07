package Alogrithm.sort;

/**
 * @Author zhangjiaheng
 * @Description 一个简单的交换数组元素的方法
 **/
public class SwapUtil {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}
