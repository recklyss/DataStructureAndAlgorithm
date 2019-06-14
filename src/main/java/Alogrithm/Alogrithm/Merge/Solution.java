package Alogrithm.Alogrithm.Merge;

import com.alibaba.fastjson.JSON;

/**
 * @Author zhangjiaheng
 * @Description 合并两个有序数组
 **/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            int t = nums2[i];
            int k = j;
            while (t > nums1[k] && k < m){
                k++;
                j = k;
            }
            // 把 t 插入数组nums1[]的第k处
            while(k < nums1.length){
                int tmp = nums1[k];
                nums1[k] = t;
                t = tmp;
                k++;
            }
            m++;
        }
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 0, 0, 0};
        int[] a2 = {2, 5, 6};
        final Solution test = new Solution();
        test.merge(a1, 3, a2, 3);
        System.out.println(JSON.toJSONString(a1));
        System.out.println(JSON.toJSONString(a2));
    }
}
