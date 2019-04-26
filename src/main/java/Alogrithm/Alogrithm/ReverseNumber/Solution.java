package Alogrithm.Alogrithm.ReverseNumber;

/**
 * @Author zhangjiaheng
 * @Description
 **/
public class Solution {

    public int reverse(int x) {
        int a = 1;
        if (x < 0) {
            x = -x;
            a = -1;
        }
        Long n = 0L;
        while (x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
            if(n > Integer.MAX_VALUE || -n > Integer.MAX_VALUE){
                return 0;
            }
        }
        n *= a;
        return Integer.valueOf(n+"");
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-123456789));
    }
}
