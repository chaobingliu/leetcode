package study0

import scala.collection.mutable.ListBuffer

object Solution {
  def main(args: Array[String]): Unit = {
    //    println(fib(20))
    //    println(coinChange(Array(2), 3))
    //    println(permute(Array(1, 2, 3)))
    println(solveNQueens(4))

  }

  /*
  509. 斐波那契数
斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
给定 N，计算 F(N)。



示例 1：

输入：2
输出：1
解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
示例 2：

输入：3
输出：2
解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
示例 3：

输入：4
输出：3
解释：F(4) = F(3) + F(2) = 2 + 1 = 3.


提示：

0 ≤ N ≤ 30
   */
  def fib(N: Int): Int = {
    if (N < 2)
      return N
    var n0 = 0
    var n1 = 1
    for (i <- 2 to N) {
      val temp = n0 + n1
      n0 = n1
      n1 = temp
    }
    n1
  }

  /*
  322. 零钱兑换
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

你可以认为每种硬币的数量是无限的。



示例 1：

输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1
示例 2：

输入：coins = [2], amount = 3
输出：-1
示例 3：

输入：coins = [1], amount = 0
输出：0
示例 4：

输入：coins = [1], amount = 1
输出：1
示例 5：

输入：coins = [1], amount = 2
输出：2


提示：

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
   */
  def coinChange(coins: Array[Int], amount: Int): Int = {
    val dp: Array[Int] = new Array[Int](amount + 1)
    dp(0) = 0
    for (i <- 1 to amount) {
      dp(i) = i + 1
      for (coin <- coins) {
        if (i - coin >= 0 && dp(i - coin) != (i - coin) + 1) {
          dp(i) = Math.min(dp(i), dp(i - coin) + 1)
        }
      }
    }
    if (dp(amount) == amount + 1) -1 else dp(amount)
  }

  /*
  46. 全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
   */
  def permute(nums: Array[Int]): List[List[Int]] = {
    val buffer: ListBuffer[List[Int]] = new ListBuffer[List[Int]]()
    val used: Array[Boolean] = new Array[Boolean](nums.length)

    def backtrack(list: ListBuffer[Int]) {
      if (list.length == nums.length) {
        buffer.append(list.toList)
        return
      }

      for (i <- 0 until nums.length) {
        if (!used(i)) {
          used(i) = true
          list.append(nums(i))
          backtrack(list)
          list.remove(list.length - 1)
          used(i) = false
        }
      }
    }

    backtrack(new ListBuffer[Int]())
    buffer.toList
  }

  /*
  51. N 皇后
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。



示例：

输入：4
输出：[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。


提示：

皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
   */
  def solveNQueens(n: Int): List[List[String]] = {
    val buffer: ListBuffer[List[String]] = new ListBuffer[List[String]]()
    val board: Array[Array[String]] = Array.fill[String](n, n)(".")

    def backtrack(strBuffer: ListBuffer[String], row: Int): Unit = {
      if (row == n) {
        buffer.append(strBuffer.toList)
        return
      }
      for (col <- 0 until n) {
        if (isValid(row, col)) {
          board(row)(col) = "Q"
          strBuffer.append(board(row).mkString(""))
          backtrack(strBuffer, row + 1)
          strBuffer.remove(strBuffer.length - 1)
          board(row)(col) = "."
        }
      }
    }

    def isValid(row: Int, col: Int): Boolean = {
      // 检查列是否有Q
      for (i <- 0 until n) {
        if (board(i)(col) == "Q") {
          return false
        }
      }
      // 检查左上方是否有Q
      var r = row - 1
      var c = col - 1
      while (r >= 0 && c >= 0) {
        if (board(r)(c) == "Q") {
          return false
        }
        r -= 1
        c -= 1
      }

      // 检查右上方是否有Q
      r = row - 1
      c = col + 1
      while (r >= 0 && c < n) {
        if (board(r)(c) == "Q") {
          return false
        }
        r -= 1
        c += 1
      }
      true
    }

    backtrack(new ListBuffer[String](), 0)
    buffer.toList
  }
}
