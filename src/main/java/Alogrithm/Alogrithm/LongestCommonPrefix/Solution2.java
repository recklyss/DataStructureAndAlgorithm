package Alogrithm.Alogrithm.LongestCommonPrefix;

public class Solution2 {

    public static String longestCommonPrefix(String[] strs){
        if (strs.length == 0) {
            return "";
        }
        String longestSameStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(longestSameStr) != 0){
                longestSameStr = longestSameStr.substring(0, longestSameStr.length()-1);
            }
        }
        return longestSameStr;
    }

    public static void main(String[] args){
        String[] strs = {"abciuahfda","abcijhagsd","abciuhjasgdfas","abciuo"};
        System.out.println("longestCommonPrefix(strs) = " + longestCommonPrefix(strs));
    }
}
