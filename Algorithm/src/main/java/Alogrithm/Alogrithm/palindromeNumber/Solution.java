package Alogrithm.Alogrithm.palindromeNumber;

public class Solution {
    public boolean isPalindrome(int x) {
        if(x >= 0){
            int t = x;
            int f = 0;
            while(t > 0){
                f = f*10 + (t - t/10*10);
                t/=10;
            }
            if((f ^ x) == 0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(186262681));
    }
}
