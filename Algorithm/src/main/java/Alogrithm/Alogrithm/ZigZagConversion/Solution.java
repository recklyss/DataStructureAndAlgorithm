package Alogrithm.Alogrithm.ZigZagConversion;
/**
 * @Author zhangjiaheng
 * @Description Z形排列字符串 并按行输出
 **/
public class Solution {

    public static void main(String[] args) {
        String s = "LEETCODEISHIRJGASYDJQBHVJGHFQKB";
        int n = 3;
        System.out.println(new Solution().convert(s, n));
        System.out.println(new Solution().arrPrint(s, n));
    }

    /**
     * 通过规律解
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chars = new char[s.length()];
        int index = 0;
        int charsl = 0;
        while (charsl < numRows) {
            boolean flag = true;
            int dynIndex = charsl;
            while (dynIndex < s.length()) {
                chars[index++] = s.charAt(dynIndex);
                int plusIndex;
                if (charsl == 0 || charsl == numRows - 1) {
                    plusIndex = 2 * (numRows - 1);
                } else {
                    if (flag) {
                        plusIndex = 2 * (numRows - charsl - 1);
                    } else {
                        plusIndex = 2 * charsl;
                    }
                }
                dynIndex += plusIndex;
                flag = !flag;
            }
            charsl++;
        }
        return new String(chars);
    }

    /**
     * 构造二维数组解
     */
    private String arrPrint(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int col = getColNum(s, numRows);
        char[][] arr = new char[numRows][col];
        int sIndex = 0;
        int hIndex = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            arr[sIndex][hIndex] = s.charAt(i);
            if (sIndex + 1 >= arr.length) {
                flag = false;
            }
            if (sIndex - 1 < 0) {
                flag = true;
            }
            if (flag) {
                sIndex++;
            } else {
                sIndex--;
                hIndex++;
            }
        }
        char[] chars = new char[s.length()];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (0 == arr[i][j]) {
                    continue;
                }
                chars[index++] = arr[i][j];
            }
        }
        return new String(chars);
    }

    /**
     * 计算二维数组列数
     */
    private static int getColNum(String s, int n) {
        int x = s.length() / (2 * n - 2);
        int y = s.length() % (2 * n - 2);
        int l = x + 1 + x * (n - 2);
        if (y >= n) {
            l = l + 1 + y % n;
        }
        return l;
    }
}
