package Alogrithm.sort;

/**
 * @Author zhangjiaheng
 * @Description
 **/
public class SwapUtil {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}
