package Alogrithm.Alogrithm.MinNDigByK;

/**
 * @Author zhangjiaheng
 * @Description 找到能被K整除的最小的全为1组成的数字N 返回N的长度 没找到返回-1
 **/
public class Solution {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 != 0 && K % 5 != 0) {
            int n = -1;
            for (int i = 1; i % K != 0; n++) {
                // 下一行代码可以防止i过大 超过int范围
                i %= K;
                i = i * 10 + 1;
                System.out.println(i);
            }
            return n;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().smallestRepunitDivByK(31));
    }
}
