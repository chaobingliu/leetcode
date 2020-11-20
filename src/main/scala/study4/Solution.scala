package study4

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution {

  def main(args: Array[String]): Unit = {
    //    println(slidingPuzzle(Array(Array(3, 2, 4), Array(1, 5, 0))))
    //    corpFlightBookings(Array(Array(1, 2, 10), Array(2, 3, 20), Array(2, 5, 25)), 5).foreach(println)
    //    println(pancakeSort(Array(3, 2, 4, 1)))
    //    println('a' | ' ')
    //    println('A' | ' ')
    //    println('b' & '_')
    //    println('B' & '_')
    //    println('d' ^ ' ')
    //    println('D' ^ ' ')
    println(multiply("123", "45"))

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

  def pancakeSort(cakes: Array[Int]): List[Int] = {
    val res = new ListBuffer[Int]()

    def sort(n: Int): Unit = {
      if (n == 1) return

      var maxCake, maxCakeIndex = 0
      for (i <- 0 until n) {
        if (cakes(i) > cakes(maxCakeIndex)) {
          maxCake = cakes(i)
          maxCakeIndex = i
        }
      }

      // 第一次翻转，将最大饼翻到最上面
      reverse(0, maxCakeIndex)
      res.append(maxCakeIndex + 1)
      // 第二次翻转，将最大饼翻到最下面
      reverse(0, n - 1)
      res.append(n)

      // 递归调用
      sort(n - 1)
    }

    def reverse(_i: Int, _j: Int): Unit = {
      var i = _i
      var j = _j
      while (i < j) {
        val temp = cakes(i)
        cakes(i) = cakes(j)
        cakes(j) = temp
        i += 1
        j -= 1
      }
    }

    sort(cakes.length)
    res.toList
  }

  /*
  191. 位1的个数
编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。



提示：

请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。


进阶：

如果多次调用这个函数，你将如何优化你的算法？


示例 1：

输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
示例 2：

输入：00000000000000000000000010000000
输出：1
解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
示例 3：

输入：11111111111111111111111111111101
输出：31
解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。


提示：

输入必须是长度为 32 的 二进制串 。
   */
  def hammingWeight(_n: Int): Int = {
    var n = _n
    var res = 0
    while (n != 0) {
      n &= (n - 1)
      res += 1
    }
    res
  }

  /*
  43. 字符串相乘
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
   */
  def multiply(num1: String, num2: String): String = {
    val m = num1.length
    val n = num2.length

    val res = new Array[Int](m + n)

    for (i <- Range(m - 1, -1, -1)) {
      for (j <- Range(n - 1, -1, -1)) {
        val mul = (num1(i) - '0') * (num2(j) - '0')
        val p1 = i + j
        val p2 = i + j + 1
        val sum = mul + res(p2)
        res(p2) = sum % 10
        res(p1) += sum / 10
      }
    }
    var i = 0
    while (i < m + n && res(i) == 0) i += 1
    if (i == m + n) "0" else res.slice(i, m + n).mkString
  }
}
