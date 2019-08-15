package Alogrithm.Alogrithm.LongestCommonPrefix;

public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs.length == 2) {
            String s = "";
            int i = 0;
            while (i < strs[0].length() && i < strs[1].length()) {
                char c1 = strs[0].charAt(i);
                char c2 = strs[1].charAt(i);
                if (c1 != c2) {
                    break;
                }
                s += c1;
                i++;
            }
            return s;
        }
        String[] newS = new String[2];
        newS[0] = strs[0];
        String[] tmpS = new String[strs.length - 1];
        System.arraycopy(strs, 1, tmpS, 0, strs.length - 1);
        newS[1] = longestCommonPrefix(tmpS);
        return longestCommonPrefix(newS);
    }

    public static void main(String[] args) {
        String[] strs = {"qwerasfasggagd", "qweasfsff", "qwesaeqq"};
        System.out.println("longestCommonPrefix(strs) = " + longestCommonPrefix(strs));
    }
}