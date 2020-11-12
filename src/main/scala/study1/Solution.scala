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
    //    println(longestPalindromeSubseq("bbbab"))
    //    println(longestCommonSubsequence_bottom("abcde", "ace"))
    //    println("abc".substring(0, 0))
    //    println(jump(Array(2, 3, 1, 1, 4)))
    //    println(stoneGame(Array(5, 3, 4, 5)))
    //    println(maxA(7))
    //    println(isMatch("aab", "c*a*b"))
    println(maxCoins(Array(3, 1, 5, 8)))
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

  /*
  1143. 最长公共子序列
给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

若这两个字符串没有公共子序列，则返回 0。



示例 1:

输入：text1 = "abcde", text2 = "ace"
输出：3
解释：最长公共子序列是 "ace"，它的长度为 3。
示例 2:

输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc"，它的长度为 3。
示例 3:

输入：text1 = "abc", text2 = "def"
输出：0
解释：两个字符串没有公共子序列，返回 0。


提示:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
输入的字符串只含有小写英文字符。
   */
  def longestCommonSubsequence_top(text1: String, text2: String): Int = {
    val dict = mutable.Map[(Int, Int), Int]()

    def dp(i: Int, j: Int): Int = {
      if (i == text1.length || j == text2.length) return 0
      if (dict.contains((i, j))) return dict((i, j))

      if (text1.charAt(i) == text2.charAt(j)) {
        val res = dp(i + 1, j + 1) + 1
        dict((i, j)) = res
        res
      } else {
        val res = Math.max(dp(i, j + 1), dp(i + 1, j))
        dict((i, j)) = res
        res
      }
    }

    dp(0, 0)
  }

  def longestCommonSubsequence_bottom(text1: String, text2: String): Int = {
    val m = text1.length
    val n = text2.length
    val dp = Array.ofDim[Int](m + 1, n + 1)

    for (i <- 1 to m) {
      for (j <- 1 to n) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp(i)(j) = dp(i - 1)(j - 1) + 1
        } else {
          dp(i)(j) = Math.max(dp(i)(j - 1), dp(i - 1)(j))
        }
      }
    }
    dp(m)(n)
  }

  /*
  583. 两个字符串的删除操作
给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。



示例：

输入: "sea", "eat"
输出: 2
解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"


提示：

给定单词的长度不超过500。
给定单词中的字符只含有小写字母。
   */
  def minStrDistance(word1: String, word2: String): Int = {
    val t = longestCommonSubsequence_bottom(word1, word2)
    val m = word1.length
    val n = word2.length
    m - t + n - t
  }

  /*
  712. 两个字符串的最小ASCII删除和
给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。

示例 1:

输入: s1 = "sea", s2 = "eat"
输出: 231
解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
在 "eat" 中删除 "t" 并将 116 加入总和。
结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
示例 2:

输入: s1 = "delete", s2 = "leet"
输出: 403
解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
注意:

0 < s1.length, s2.length <= 1000。
所有字符串中的字符ASCII值在[97, 122]之间。
   */
  def minimumDeleteSum_top(s1: String, s2: String): Int = {
    val m = s1.length
    val n = s2.length
    val dict = mutable.Map[(Int, Int), Int]()

    def dp(i: Int, j: Int): Int = {
      if (i == m) return s2.substring(j, n).sum
      if (j == n) return s1.substring(i, m).sum

      if (dict.contains((i, j))) return dict((i, j))
      if (s1.charAt(i) == s2.charAt(j)) {
        return dp(i + 1, j + 1)
      } else {
        val t = Math.min(s1.charAt(i) + dp(i + 1, j), s2.charAt(j) + dp(i, j + 1))
        dict((i, j)) = t
        t
      }
    }

    dp(0, 0)
  }

  def minimumDeleteSum_bottom(s1: String, s2: String): Int = {
    val m = s1.length
    val n = s2.length
    val dp = Array.ofDim[Int](m + 1, n + 1)
    for (i <- 1 to m) {
      dp(i)(0) = dp(i - 1)(0) + s1.charAt(i - 1)
    }
    for (j <- 1 to n) {
      dp(0)(j) = dp(0)(j - 1) + s2.charAt(j - 1)
    }

    for (i <- 1 to m) {
      for (j <- 1 to n) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp(i)(j) = dp(i - 1)(j - 1)
        } else {
          dp(i)(j) = Math.min(s1.charAt(i - 1) + dp(i - 1)(j), s2.charAt(j - 1) + dp(i)(j - 1))
        }
      }
    }
    dp(m)(n)
  }

  /*
55. 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
   */
  def canJump(nums: Array[Int]): Boolean = {
    var farthest = 0
    for (i <- 0 until nums.length - 1) {
      farthest = Math.max(farthest, i + nums(i))
      if (farthest <= i) return false
    }
    farthest >= nums.length - 1
  }

  /*
  45. 跳跃游戏 II
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
说明:

假设你总是可以到达数组的最后一个位置。
   */
  def jump_normal(nums: Array[Int]): Int = {
    val n = nums.length
    val memo = Array.fill[Int](n)(n)

    def dp(p: Int): Int = {
      if (p >= n - 1)
        return 0

      if (memo(p) != n) return memo(p)
      val step = nums(p)
      for (i <- 1 to step) {
        memo(p) = Math.min(memo(p), dp(p + i) + 1)
      }
      memo(p)
    }

    dp(0)
  }

  def jump(nums: Array[Int]): Int = {
    var jump, end, farthest = 0
    for (i <- 0 until nums.length - 1) {
      farthest = Math.max(farthest, i + nums(i))
      if (i == end) {
        jump += 1
        end = farthest
      }
    }
    jump
  }

  /*
  877. 石子游戏
亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。

游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。

亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。

假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。



示例：

输入：[5,3,4,5]
输出：true
解释：
亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。


提示：

2 <= piles.length <= 500
piles.length 是偶数。
1 <= piles[i] <= 500
sum(piles) 是奇数。
   */
  /*
dp[i][j].fir 表示，对于 piles[i...j] 这部分石头堆，先手能获得的最高分数。
dp[i][j].sec 表示，对于 piles[i...j] 这部分石头堆，后手能获得的最高分数。

举例理解一下，假设 piles = [3, 9, 1, 2]，索引从 0 开始
dp[0][1].fir = 9 意味着：面对石头堆 [3, 9]，先手最终能够获得 9 分。
dp[1][3].sec = 2 意味着：面对石头堆 [9, 1, 2]，后手最终能够获得 2 分。
   */
  def stoneGame_normal(piles: Array[Int]): Boolean = {
    val n = piles.length
    val dp = Array.ofDim[(Int, Int)](n, n)

    for (i <- Range(n - 1, -1, -1)) {
      for (j <- i until n) {
        if (i == j) {
          dp(i)(j) = (piles(i), 0)
        } else {
          val left = piles(i) + dp(i + 1)(j)._2
          val right = piles(j) + dp(i)(j - 1)._2
          if (left > right) {
            dp(i)(j) = (left, dp(i + 1)(j)._1)
          } else {
            dp(i)(j) = (right, dp(i)(j - 1)._1)
          }
        }
      }
    }
    dp(0)(n - 1)._1 > dp(0)(n - 1)._2
  }

  def stoneGame_normal2(piles: Array[Int]): Boolean = {
    val n = piles.length
    val dp = new Array[(Int, Int)](n)

    for (i <- Range(n - 1, -1, -1)) {
      for (j <- i until n) {
        if (i == j) {
          dp(j) = (piles(i), 0)
        } else {
          val left = piles(i) + dp(j)._2
          val right = piles(j) + dp(j - 1)._2
          if (left > right) {
            dp(j) = (left, dp(j)._1)
          } else {
            dp(j) = (right, dp(j - 1)._1)
          }
        }
      }
    }
    dp(n - 1)._1 > dp(n - 1)._2
  }

  /*
定义二维数组 \textit{dp}dp，其行数和列数都等于石子的堆数，\textit{dp}[i][j]dp[i][j] 表示当剩下的石子堆为下标 ii 到下标 jj 时，当前玩家与另一个玩家的石子数量之差的最大值，注意当前玩家不一定是先手 \text{Alex}Alex。

只有当 i \le ji≤j 时，剩下的石子堆才有意义，因此当 i>ji>j 时，\textit{dp}[i][j]=0dp[i][j]=0。

当 i=ji=j 时，只剩下一堆石子，当前玩家只能取走这堆石子，因此对于所有 0 \le i < \textit{nums}.\text{length}0≤i<nums.length，都有 \textit{dp}[i][i]=\textit{piles}[i]dp[i][i]=piles[i]。

当 i<ji<j 时，当前玩家可以选择取走 \textit{piles}[i]piles[i] 或 \textit{piles}[j]piles[j]，然后轮到另一个玩家在剩下的石子堆中取走石子。在两种方案中，当前玩家会选择最优的方案，使得自己的石子数量最大化。因此可以得到如下状态转移方程：

\textit{dp}[i][j]=\max(\textit{piles}[i] - \textit{dp}[i + 1][j], \textit{piles}[j] - \textit{dp}[i][j - 1])
dp[i][j]=max(piles[i]−dp[i+1][j],piles[j]−dp[i][j−1])

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/stone-game/solution/shi-zi-you-xi-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  def stoneGame_normal3(piles: Array[Int]): Boolean = {
    val n = piles.length
    val dp = Array.ofDim[Int](n, n)

    for (i <- Range(n - 1, -1, -1)) {
      for (j <- i until n) {
        if (i == j) {
          dp(i)(j) = piles(i)
        } else {
          dp(i)(j) = Math.max(piles(i) - dp(i + 1)(j), piles(j) - dp(i)(j - 1))
        }
      }
    }
    dp(0)(n - 1) > 0
  }

  def stoneGame(piles: Array[Int]): Boolean = {
    val n = piles.length
    val dp = new Array[Int](n)

    for (i <- Range(n - 1, -1, -1)) {
      for (j <- i until n) {
        if (i == j) {
          dp(j) = piles(i)
        } else {
          dp(j) = Math.max(piles(i) - dp(j), piles(j) - dp(j - 1))
        }
      }
    }
    dp(n - 1) > 0
  }

  def maxA_normal(N: Int): Int = {
    val dict = mutable.Map[(Int, Int, Int), Int]()

    def dp(n: Int, aNum: Int, copy: Int): Int = {
      if (n <= 0) return aNum
      if (dict.contains((n, aNum, copy))) return dict((n, aNum, copy))

      // 在屏幕写字母A
      val A = dp(n - 1, aNum + 1, copy)
      // 按下Ctrl-V 粘贴
      val B = dp(n - 1, aNum + copy, copy)
      // 按下选中+复制
      val C = dp(n - 2, aNum, aNum)
      val temp = max(A, B, C)
      dict((n, aNum, copy)) = temp
      temp
    }

    dp(N, 0, 0)
  }

  def maxA(N: Int): Int = {
    val dp = new Array[Int](N + 1)
    for (i <- 1 to N) {
      dp(i) = dp(i - 1) + 1
      if (i > 2) {
        for (j <- 2 to i) {
          dp(i) = Math.max(dp(i), dp(j - 2) * (i - j + 1))
        }
      }
    }
    dp(N)

  }

  def max(a: Int, b: Int, c: Int): Int = {
    Math.max(a, Math.max(b, c))
  }

  /*
  10. 正则表达式匹配
给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。


示例 1：

输入：s = "aa" p = "a"
输出：false
解释："a" 无法匹配 "aa" 整个字符串。
示例 2:

输入：s = "aa" p = "a*"
输出：true
解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3：

输入：s = "ab" p = ".*"
输出：true
解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
示例 4：

输入：s = "aab" p = "c*a*b"
输出：true
解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5：

输入：s = "mississippi" p = "mis*is*p*."
输出：false


提示：

0 <= s.length <= 20
0 <= p.length <= 30
s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
保证每次出现字符 * 时，前面都匹配到有效的字符
   */
  def isMatch_normal(s: String, p: String): Boolean = {
    val dict = mutable.Map[(String, String), Boolean]()

    def dp(s: String, p: String): Boolean = {
      if (p.isEmpty) return s.isEmpty
      if (dict.contains((s, p))) return dict((s, p))

      val firstMatch: Boolean = !s.isEmpty && (s(0) == p(0) || p(0) == '.')
      if (p.length > 1 && p(1) == '*') {
        val temp = isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p))
        dict((s, p)) = temp
        temp
      } else {
        val temp = firstMatch && isMatch(s.substring(1), p.substring(1))
        dict((s, p)) = temp
        temp
      }
    }

    dp(s, p)
  }

  def isMatch(s: String, p: String): Boolean = {
    val m = s.length
    val n = p.length
    val dict = mutable.Map[(Int, Int), Boolean]()

    def dp(i: Int, j: Int): Boolean = {
      if (j == n) return i == m
      if (dict.contains((i, j))) return dict((i, j))

      val firstMath = i < m && (p(j) == s(i) || p(j) == '.')
      if (j <= n - 2 && p(j + 1) == '*') {
        val temp = dp(i, j + 2) || (firstMath && dp(i + 1, j))
        dict((i, j)) = temp
        temp
      } else {
        val temp = firstMath && dp(i + 1, j + 1)
        dict((i, j)) = temp
        temp
      }
    }

    dp(0, 0)
  }

  /*
  312. 戳气球
有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。

求所能获得硬币的最大数量。

说明:

你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
示例:

输入: [3,1,5,8]
输出: 167
解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
   */
  def maxCoins(nums: Array[Int]): Int = {
    val n = nums.length
    val newNums = new Array[Int](n + 2)
    newNums(0) = 1
    newNums(n + 1) = 1
    for (i <- 1 to n) {
      newNums(i) = nums(i - 1)
    }

    val dp = Array.ofDim[Int](n + 2, n + 2)
    for (i <- Range(n, -1, -1)) {
      for (j <- i + 1 to n + 1) {
        for (k <- i + 1 until j) {
          dp(i)(j) = Math.max(dp(i)(j), dp(i)(k) + dp(k)(j) + newNums(i) * newNums(k) * newNums(j))
        }
      }
    }
    dp(0)(n + 1)

  }

  /*
28. 实现 strStr()
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
  def strStr(haystack: String, needle: String): Int = {
    def kmp(pat: String): Array[Array[Int]] = {
      val m = pat.length
      val dp = Array.ofDim[Int](m, 256)
      dp(0)(pat.charAt(0)) = 1
      var x = 0
      for (j <- 1 until m) {
        for (c <- 0 until 256) {
          if (pat(j) == c) {
            dp(j)(c) = 1
          } else {
            dp(j)(c) = dp(x)(c)
          }
        }
        dp(j)(pat(j)) = j + 1
        x = dp(x)(pat(j))
      }
      dp
    }

    if (needle.isEmpty) {
      return 0
    }
    val dp = kmp(needle)
    val m = haystack.length
    val n = needle.length
    var j = 0
    for (i <- 0 until m) {
      j = dp(j)(haystack(i))
      if (j == n) {
        return i - n + 1
      }
    }
    -1
  }

  /*
  1312. 让字符串成为回文串的最少插入次数
给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。

请你返回让 s 成为回文串的 最少操作次数 。

「回文串」是正读和反读都相同的字符串。



示例 1：

输入：s = "zzazz"
输出：0
解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
示例 2：

输入：s = "mbadm"
输出：2
解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
示例 3：

输入：s = "leetcode"
输出：5
解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
示例 4：

输入：s = "g"
输出：0
示例 5：

输入：s = "no"
输出：1


提示：

1 <= s.length <= 500
s 中所有字符都是小写字母。
   */
  def minInsertions(s: String): Int = {
    val n = s.length
    val dp = Array.ofDim[Int](n, n)
    for (i <- Range(n - 2, -1, -1)) {
      for (j <- i + 1 until n) {
        if (s(i) == s(j)) {
          dp(i)(j) = dp(i + 1)(j - 1)
        } else {
          dp(i)(j) = Math.min(dp(i)(j - 1), dp(i + 1)(j)) + 1
        }
      }
    }
    dp(0)(n - 1)
  }
}
