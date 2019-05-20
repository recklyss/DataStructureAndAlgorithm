package Alogrithm.Alogrithm.LengthOfLongestSubstring;

import java.util.HashMap;

/**
 * @Author zhangjiaheng
 * @Description 无重复字符的最长子串
 **/
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        return maxIndexStrLength(s);
    }

    /**
     * 滑动窗口解法
     */
    public int maxIndexStrLength(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果当前元素与滑动窗口中的元素重复：
            if (map.containsKey(c) && map.get(c) >= start) {
                max = Math.max(max, i - start);
                start = map.get(c) + 1;
                //如果当前元素与滑动窗口中的元素不重复，但已经遍历到了最后一个字符：
            } else if (i == s.length() - 1) {
                max = Math.max(max, i - start + 1);
            }
            map.put(c, i);
        }
        return max;
    }

    /**
     * 暴力解法：遍历所有字符串并返回长度
     */
    /*public int maxIndexStrLength(String s) {
        int maxLength = 0;
        for (int index = 0; index < s.length(); index++) {

            int length = 1;
            int i = index + 1;
            for (; ; ) {
                if (i >= s.length()) {
                    break;
                }
                String ts = s.substring(index, i);
                char c = s.charAt(i);
                if (ts.contains(c + "")) {
                    break;
                }
                length++;
                i++;
            }
            maxLength = maxLength > length ? maxLength : length;
        }
        return maxLength;
    }*/
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcbqwer"));
    }

}
