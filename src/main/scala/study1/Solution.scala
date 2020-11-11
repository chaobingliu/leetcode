package study1

import scala.collection.mutable

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

class Node(var _value: Int) {
  var value: Int = _value
  var left: Node = null
  var right: Node = null
  var next: Node = null
}

object Solution {
  def main(args: Array[String]): Unit = {
    //    println(findTargetSumWays_backtrack(Array(0, 0, 0, 0, 0, 0, 0, 0, 1), 1))
    //    println(minDistance("intention", "execution"))
//    println(maxEnvelopes(Array(Array(5, 4), Array(6, 4), Array(6, 7), Array(2, 3))))
    println(longestPalindromeSubseq("bbbab"))

  }

  /*
  494. 目标和
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。



示例：

输入：nums: [1, 1, 1, 1, 1], S: 3
输出：5
解释：

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。


提示：

数组非空，且长度不会超过 20 。
初始的数组的和不会超过 1000 。
保证返回的最终结果能被 32 位整数存下。
   */
  def findTargetSumWays_backtrack(nums: Array[Int], S: Int): Int = {
    val n = nums.length
    if (n == 0) {
      return 0
    }

    var result = 0

    def backtrack(idx: Int, _rest: Int) {
      var rest = _rest
      if (idx == n) {
        if (rest == 0) result += 1
        return
      }

      // 选择-号
      rest -= nums(idx)
      backtrack(idx + 1, rest)
      rest += nums(idx)
      // 选择+号
      rest += nums(idx)
      backtrack(idx + 1, rest)
      rest -= nums(idx)
    }

    backtrack(0, S)
    result
  }

  def findTargetSumWays_normal(nums: Array[Int], S: Int): Int = {
    var sum = nums.sum
    if ((sum + S) % 2 == 1 || sum < S)
      return 0
    sum = (sum + S) / 2

    val n = nums.length
    val dp = Array.ofDim[Int](n + 1, sum + 1)
    for (i <- 0 to n) {
      dp(i)(0) = 1
    }

    for (i <- 1 to nums.length) {
      for (j <- Range(sum, -1, -1)) {
        if (j >= nums(i - 1)) {
          dp(i)(j) = dp(i - 1)(j) + dp(i - 1)(j - nums(i - 1))
        } else {
          dp(i)(j) = dp(i - 1)(j)
        }
      }
    }
    dp(n)(sum)
  }

  def findTargetSumWays(nums: Array[Int], S: Int): Int = {
    var sum = nums.sum
    if ((sum + S) % 2 == 1 || sum < S)
      return 0
    sum = (sum + S) / 2

    val dp = new Array[Int](sum + 1)
    dp(0) = 1

    for (i <- 1 to nums.length) {
      for (j <- Range(sum, -1, -1); if (j >= nums(i - 1))) {
        dp(j) = dp(j) + dp(j - nums(i - 1))
      }
    }
    dp(sum)
  }

  /*
  72. 编辑距离
给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符


示例 1：

输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2：

输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')


提示：

0 <= word1.length, word2.length <= 500
word1 和 word2 由小写英文字母组成
   */
  def minDistance_dp(word1: String, word2: String): Int = {
    val dict = mutable.Map[(Int, Int), Int]()

    def dp(i: Int, j: Int): Int = {
      if (i == -1) return j + 1
      if (j == -1) return i + 1
      if (dict.contains((i, j))) return dict((i, j))

      if (word1.charAt(i) == word2.charAt(j)) {
        return dp(i - 1, j - 1)
      } else {
        val A = dp(i, j - 1) + 1 // 插入字符
        val B = dp(i - 1, j) + 1 // 删除字符
        val C = dp(i - 1, j - 1) + 1 // 替换字符
        val result = Math.min(Math.min(A, B), C)
        dict((i, j)) = result
        result
      }
    }

    dp(word1.length - 1, word2.length - 1)
  }

  object OpTypeEnum extends Enumeration {
    val opTypeEnum = Value
    val ADD, DELETE, REPLACE = Value
  }

  case class OpNode(value: Int, op: OpTypeEnum.Value = null, idx: (Int, Int) = (0, 0))

  def minDistance_step(word1: String, word2: String): Int = {
    val m = word1.length
    val n = word2.length

    val dp = Array.ofDim[OpNode](m + 1, n + 1)
    for (i <- 0 to m) {
      dp(i)(0) = OpNode(i)
    }

    for (j <- 0 to n) {
      dp(0)(j) = OpNode(j)
    }

    for (i <- 1 to m) {
      for (j <- 1 to n) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp(i)(j) = dp(i - 1)(j - 1)
        } else {
          // 插入
          val A = OpNode(dp(i)(j - 1).value + 1, OpTypeEnum.ADD, (i, j - 1))
          // 删除
          val B = OpNode(dp(i - 1)(j).value + 1, OpTypeEnum.DELETE, (i - 1, j))
          // 替换
          val C = OpNode(dp(i - 1)(j - 1).value + 1, OpTypeEnum.REPLACE, (i - 1, j - 1))
          if (A.value < B.value) {
            dp(i)(j) = if (A.value < C.value) A else C
          } else {
            dp(i)(j) = if (B.value < C.value) B else C
          }
        }
      }
    }
    var ops = m
    var ope = n
    val builder: mutable.StringBuilder = new mutable.StringBuilder("")
    while (ops != 0 && ope != 0) {
      val temp = dp(ops)(ope)
      builder.append(s"(${ops} ${ope}) ${temp.op} ->")
      ops = temp.idx._1
      ope = temp.idx._2
    }
    println(builder)
    dp(m)(n).value
  }

  def minDistance(word1: String, word2: String): Int = {
    val m = word1.length
    val n = word2.length

    val dp = Array.ofDim[Int](m + 1, n + 1)
    for (i <- 0 to m) {
      dp(i)(0) = i
    }

    for (j <- 0 to n) {
      dp(0)(j) = j
    }

    for (i <- 1 to m) {
      for (j <- 1 to n) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp(i)(j) = dp(i - 1)(j - 1)
        } else {
          dp(i)(j) = Math.min(Math.min(dp(i)(j - 1), dp(i - 1)(j)), dp(i - 1)(j - 1)) + 1
        }
      }
    }
    dp(m)(n)
  }

  /*
  354. 俄罗斯套娃信封问题
给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。

说明:
不允许旋转信封。

示例:

输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
输出: 3
解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
   */
  def maxEnvelopes(envelopes: Array[Array[Int]]): Int = {
    val sorted = envelopes.sortBy(r => (r(0), r(1)))(Ordering.Tuple2(Ordering.Int, Ordering.Int.reverse))
    val n = envelopes.length

    def lengthOfLIS(nums: Array[Int]): Int = {
      var piles = 0
      val n = nums.length
      val top = new Array[Int](n)
      for (i <- 0 until n) {
        val poker = nums(i)
        var left = 0
        var right = piles
        while (left < right) {
          val mid = (left + right) / 2
          if (top(mid) >= poker) {
            right = mid
          } else {
            left = mid + 1
          }
        }
        if (left == piles) piles += 1
        top(left) = poker
      }
      return piles
    }

    val height: Array[Int] = new Array[Int](n)
    for (i <- 0 until n) {
      height(i) = sorted(i)(1)
    }

    lengthOfLIS(height)
  }

  /*
  53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
   */
  def maxSubArray(nums: Array[Int]): Int = {
    val n = nums.length
    if (n == 0) return 0

    var pre = nums(0)
    var maxSum = nums(0)
    for (i <- 1 until n) {
      pre = Math.max(nums(i), pre + nums(i))
      maxSum = Math.max(maxSum, pre)
    }
    maxSum
  }

  /*
  516. 最长回文子序列
给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。



示例 1:
输入:

"bbbab"
输出:

4
一个可能的最长回文子序列为 "bbbb"。

示例 2:
输入:

"cbbd"
输出:

2
一个可能的最长回文子序列为 "bb"。



提示：

1 <= s.length <= 1000
s 只包含小写英文字母
   */
  def longestPalindromeSubseq(s: String): Int = {
    val n = s.length
    if (n == 1) return 1
    val dp = Array.ofDim[Int](n, n)

    for (i <- Range(n - 1, -1, -1)) {
      for (j <- i until n) {
        if (i == j) {
          dp(i)(j) = 1
        } else {
          if (s.charAt(i) == s.charAt(j)) {
            dp(i)(j) = dp(i + 1)(j - 1) + 2
          } else {
            dp(i)(j) = Math.max(dp(i)(j - 1), dp(i + 1)(j))
          }
        }
      }
    }
    dp(0)(n - 1)
  }
}
