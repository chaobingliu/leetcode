package study4

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution {

  def main(args: Array[String]): Unit = {
    //    println(slidingPuzzle(Array(Array(3, 2, 4), Array(1, 5, 0))))
    corpFlightBookings(Array(Array(1, 2, 10), Array(2, 3, 20), Array(2, 5, 25)), 5).foreach(println)
  }

  /*
  773. 滑动谜题
在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.

一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.

最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。

给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。

示例：

输入：board = [[1,2,3],[4,0,5]]
输出：1
解释：交换 0 和 5 ，1 步完成
输入：board = [[1,2,3],[5,4,0]]
输出：-1
解释：没有办法完成谜板
输入：board = [[4,1,2],[5,0,3]]
输出：5
解释：
最少完成谜板的最少移动次数是 5 ，
一种移动路径:
尚未移动: [[4,1,2],[5,0,3]]
移动 1 次: [[4,1,2],[0,5,3]]
移动 2 次: [[0,1,2],[4,5,3]]
移动 3 次: [[1,0,2],[4,5,3]]
移动 4 次: [[1,2,0],[4,5,3]]
移动 5 次: [[1,2,3],[4,5,0]]
输入：board = [[3,2,4],[1,5,0]]
输出：14
提示：

board 是一个如上所述的 2 x 3 的数组.
board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
   */
  def slidingPuzzle(board: Array[Array[Int]]): Int = {
    val m = 2
    val n = 3
    val target = "123450"
    val sb = new StringBuilder
    for (i <- 0 until m; j <- 0 until n) {
      sb.append(board(i)(j).toString)
    }
    val start = sb.mkString


    val neighbor = getNeighbor(board)

    val q = mutable.Queue[String]()
    val visited = mutable.Set[String]()

    q.enqueue(start)
    visited.add(start)

    var step = 0
    while (!q.isEmpty) {
      val sz = q.size
      for (i <- 0 until sz) {
        val cur = q.dequeue()
        if (cur == target) {
          return step
        }

        var idx = 0
        while (cur(idx) != '0') {
          idx += 1
        }

        for (adj <- neighbor(idx)) {
          val charArr = cur.toCharArray
          val temp = charArr(idx)
          charArr(idx) = charArr(adj)
          charArr(adj) = temp
          val newBoard = charArr.mkString
          if (!visited.contains(newBoard)) {
            q.enqueue(newBoard)
            visited.add(newBoard)
          }
        }
      }
      step += 1
    }
    -1
  }

  def getNeighbor(board: Array[Array[Int]]): List[List[Int]] = {
    val m = board.length
    val n = board(0).length
    val res = new ListBuffer[List[Int]]()
    for (i <- 0 until m) {
      for (j <- 0 until n) {
        val buffer = new ListBuffer[Int]()
        if (i - 1 >= 0) buffer.append((i - 1) * n + j)
        if (j - 1 >= 0) buffer.append((i * n) + (j - 1))
        if (i + 1 < m) buffer.append((i + 1) * n + j)
        if (j + 1 < n) buffer.append(i * n + (j + 1))
        res.append(buffer.toList)
      }
    }
    res.toList
  }

  /*
  560. 和为K的子数组
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

示例 1 :

输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
说明 :

数组的长度为 [1, 20,000]。
数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
   */
  def subarraySum(nums: Array[Int], k: Int): Int = {
    val preSum = mutable.Map[Int, Int]()
    preSum(0) = 1
    var ans, sum0_i = 0
    for (num <- nums) {
      sum0_i += num
      val sum0_j = sum0_i - k
      if (preSum.contains(sum0_j)) ans += preSum(sum0_j)
      preSum(sum0_i) = preSum.getOrElse(sum0_i, 0) + 1
    }
    ans
  }

  /*
  1109. 航班预订统计
这里有 n 个航班，它们分别从 1 到 n 进行编号。

我们这儿有一份航班预订表，表中第 i 条预订记录 bookings[i] = [j, k, l] 意味着我们在从 j 到 k 的每个航班上预订了 l 个座位。

请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。



示例：

输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
输出：[10,55,45,25,25]
   */
  def corpFlightBookings(bookings: Array[Array[Int]], n: Int): Array[Int] = {
    val nums = new Array[Int](n)
    val df = new Difference(nums)
    for (booking <- bookings) {
      df.increment(booking(0) - 1, booking(1) - 1, booking(2))
    }
    df.result()
  }
}
