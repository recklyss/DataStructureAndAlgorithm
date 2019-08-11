package Alogrithm.Alogrithm.nQueensII;

/** @Author zhangjiaheng @Description N皇后问题 */
public class Solution {
  /** 总记录数 */
  private int total = 0;
  /** N皇后 */
  private int N;
  /** 判断当前位置的左对角线是否存放了棋子 */
  private int[] left = new int[15];
  /** 判断当前位置的右对角线是否存放了棋子 */
  private int[] right = new int[15];
  /** 判断当前位置的列是否存放了棋子 */
  private int[] curn;

  public int totalNQueens(int n) {
    this.N = n;
    curn = new int[n];
    left = new int[2 * n - 1];
    right = new int[2 * n - 1];
    calResult(0);
    return total;
  }

  private void calResult(int i) {
    // 棋盘第i行 遍历判断第j列
    for (int j = 0; j < N; j++) {
      // 开始判断第i行第j列
      // 判断第j列是否已经有棋子；判断(i,j)的左对角线是否有棋子；判断右对角线是否有棋子
      if (curn[j] == 0 && left[i + j] == 0 && right[N - 1 + i - j] == 0) {
        // 没有棋子 就可以在(i,j)放置棋子
        curn[j] = left[i + j] = right[N - 1 + i - j] = 1;
        // 如果N行都放置了棋子 total就加1 否则继续放置下一行
        if (i < N - 1) {
          calResult(i + 1);
        } else {
          total++;
        }
        // 放置完成之后 (i,j)位置棋子去掉，然后重新走下一步 进行深度优先搜索
        curn[j] = left[i + j] = right[N - 1 + i - j] = 0;
      }
    }
  }

  public static void main(String[] args) {
    final Solution solution = new Solution();
    solution.totalNQueens(8);
    System.out.println("total = " + solution.total);
  }
}
