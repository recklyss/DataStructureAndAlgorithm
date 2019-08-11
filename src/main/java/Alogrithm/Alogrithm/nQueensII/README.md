### N皇后问题 - [leetcode](https://leetcode-cn.com/problems/n-queens-ii/)

n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

![8皇后示例](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/8-queens.png)

上图为 8 皇后问题的一种解法。

给定一个整数 n，返回 n 皇后不同的解决方案的数量。
示例：

    输入: 4
    输出: 2
    解释: 4 皇后问题存在如下两个不同的解法。
    [
     [".Q..",  // 解法 1
      "...Q",
      "Q...",
      "..Q."],
    
     ["..Q.",  // 解法 2
      "Q...",
      "...Q",
      ".Q.."]
    ]
    
解题思路：使用回溯算法，深度优先搜索，进行遍历查询

深度优先搜索的条件是有能够判断棋盘是否能落子的依据。我这边使用一个长度为N的数组存储第J列是否有棋子，使用两个N*2-1长度的
数组分别存储左对角线和右对角线是否有棋子。

对于左右对角线来说，左对角线的每一个位置i与j的和都相同，右对角线的每一个位置的i与j的差都相同，所以可以用来判断
某个位置的斜线上是否存在棋子，对应对角线的数组标志为有或者没有。

