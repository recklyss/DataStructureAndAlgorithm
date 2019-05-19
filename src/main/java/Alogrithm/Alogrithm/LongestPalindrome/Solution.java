package Alogrithm.Alogrithm.LongestPalindrome;

public class Solution {

    public String longestPalindrome(String s) {

        String maxLStr = "";
        if (!("".equals(s) || null == s)) {
            for (int i = 0; i < s.length(); i++) {
                String str = getLengthestStr(s, i);
                maxLStr = str.length() > maxLStr.length() ? str : maxLStr;
            }

        }
        return maxLStr;

    }

    private String getLengthestStr(String s, int index) {
        char c = s.charAt(index);
        int left = index - 1;
        int right = index + 1;
        boolean flag = false;
        int tI = index;
        while (right < s.length() && s.charAt(tI + 1) == c) {
            right++;
            tI++;
            flag = true;
        }
        for (; ; ) {
            if (left < 0 || right > s.length() - 1) {
                break;
            }
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("asassssssawq"));
    }

}
