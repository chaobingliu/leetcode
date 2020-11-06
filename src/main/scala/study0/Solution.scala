package study0

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def main(args: Array[String]): Unit = {
    //    println(fib(20))
    //    println(coinChange(Array(2), 3))
    //    println(permute(Array(1, 2, 3)))
    //    println(solveNQueens(4))
    //    println(openLock(Array("0000"), "8888"))
    //    searchRange(Array(2, 2), 6).foreach(println)
    //    println(minWindow("ADOBECODEBANC", "ABC"))
    //    println(checkInclusion("ab", "eidboaoo"))
    //    println(findAnagrams("abab", "ab"))
    //    println(lengthOfLongestSubstring("pwwkew"))
    //    println(maxProfit_with_cool(Array(1, 2, 3, 0, 2)))
    //    println(maxProfit_k_any(1, Array(1, 2)))
    println(rob_2(Array(1, 2, 3, 1)))
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

  /*
  111. 二叉树的最小深度
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明：叶子节点是指没有子节点的节点。



示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：2
示例 2：

输入：root = [2,null,3,null,4,null,5,null,6]
输出：5


提示：

树中节点数的范围在 [0, 105] 内
-1000 <= Node.val <= 1000
   */
  def minDepth(root: TreeNode): Int = {
    if (root == null)
      return 0
    val queue: mutable.Queue[TreeNode] = mutable.Queue[TreeNode]()
    queue.enqueue(root)
    var depth = 1
    while (!queue.isEmpty) {
      for (i <- 0 until queue.size) {
        val node = queue.dequeue()
        if (node.left == null && node.right == null) {
          return depth
        }
        if (node.left != null) {
          queue.enqueue(node.left)
        }
        if (node.right != null) {
          queue.enqueue(node.right)
        }
      }
      depth += 1
    }
    depth
  }

  /*
  752. 打开转盘锁
你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。



示例 1:

输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
输出：6
解释：
可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
因为当拨动到 "0102" 时这个锁就会被锁定。
示例 2:

输入: deadends = ["8888"], target = "0009"
输出：1
解释：
把最后一位反向旋转一次即可 "0000" -> "0009"。
示例 3:

输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
输出：-1
解释：
无法旋转到目标数字且不被锁定。
示例 4:

输入: deadends = ["0000"], target = "8888"
输出：-1


提示：

死亡列表 deadends 的长度范围为 [1, 500]。
目标数字 target 不会在 deadends 之中。
每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
   */
  def openLock(deadends: Array[String], target: String): Int = {
    if (deadends.contains("0000"))
      return -1
    var q1: mutable.HashSet[String] = mutable.HashSet[String]()
    var q2: mutable.HashSet[String] = mutable.HashSet[String]()
    val visited: mutable.HashSet[String] = mutable.HashSet[String]()
    for (str <- deadends) {
      visited.add(str)
    }

    q1.add("0000")
    q2.add(target)
    var step = 0
    while (!q1.isEmpty && !q2.isEmpty) {
      val temp: mutable.HashSet[String] = mutable.HashSet[String]()
      for (curStr <- q1) {
        if (q2.contains(curStr)) {
          return step
        }
        visited.add(curStr)
        for (i <- 0 to 3) {
          val plusStr = plusOne(curStr, i)
          if (!visited.contains(plusStr)) {
            temp.add(plusStr)
          }
          val minusStr = minusOne(curStr, i)
          if (!visited.contains(minusStr)) {
            temp.add(minusStr)
          }
        }
      }
      step += 1
      // 选择少的集合优先扩散
      if (temp.size > q2.size) {
        q1 = q2
        q2 = temp
      } else {
        q1 = temp
      }
    }
    -1
  }

  def openLock2(deadends: Array[String], target: String): Int = {
    if (deadends.contains("0000"))
      return -1
    val visited: mutable.HashSet[String] = mutable.HashSet[String]()
    for (str <- deadends) {
      visited.add(str)
    }

    val queue: mutable.Queue[String] = mutable.Queue[String]()
    visited.add("0000")
    queue.enqueue("0000")
    var step = 0
    while (!queue.isEmpty) {
      for (i <- 0 until queue.size) {
        val curStr = queue.dequeue()
        if (curStr == target) {
          return step
        }
        for (i <- 0 to 3) {
          val plusStr = plusOne(curStr, i)
          if (!visited.contains(plusStr)) {
            queue.enqueue(plusStr)
            visited.add(plusStr)
          }
          val minusStr = minusOne(curStr, i)
          if (!visited.contains(minusStr)) {
            queue.enqueue(minusStr)
            visited.add(minusStr)
          }
        }
      }
      step += 1
    }
    -1
  }

  def plusOne(str: String, idx: Int): String = {
    val strArr = str.toCharArray
    if (strArr(idx) == '9') {
      strArr(idx) = '0'
    } else {
      strArr(idx) = (strArr(idx) + 1).toChar
    }
    strArr.mkString("")
  }

  def minusOne(str: String, idx: Int): String = {
    val strArr = str.toCharArray
    if (strArr(idx) == '0') {
      strArr(idx) = '9'
    } else {
      strArr(idx) = (strArr(idx) - 1).toChar
    }
    strArr.mkString("")
  }

  /*
704. 二分查找
给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。


示例 1:

输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
示例 2:

输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1


提示：

你可以假设 nums 中的所有元素是不重复的。
n 将在 [1, 10000]之间。
nums 的每个元素都将在 [-9999, 9999]之间。

   */
  def search(nums: Array[Int], target: Int): Int = {
    if (nums == null)
      return -1
    var left = 0
    var right = nums.length - 1
    while (left <= right) {
      val mid = left + (right - left) / 2
      if (nums(mid) == target) {
        return mid
      } else if (nums(mid) < target) {
        left = mid + 1
      } else {
        right = mid - 1
      }
    }
    -1
  }

  /*
  34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
   */
  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    if (nums == null)
      return Array(-1, -1)
    var left = 0
    var right = nums.length - 1
    while (left <= right) {
      val mid = left + (right - left) / 2
      if (nums(mid) < target) {
        left = mid + 1
      } else if (nums(mid) > target) {
        right = mid - 1
      } else {
        if (nums(left) < target) {
          left += 1
        }
        if (nums(right) > target) {
          right -= 1
        }
        if (nums(left) == target && nums(right) == target) {
          return Array(left, right)
        }
      }
    }
    return Array(-1, -1)
  }

  /*
  76. 最小覆盖子串
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。



示例 1：

输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
示例 2：

输入：s = "a", t = "a"
输出："a"


提示：

1 <= s.length, t.length <= 105
s 和 t 由英文字母组成


进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
   */
  def minWindow(s: String, t: String): String = {
    val need, window: mutable.Map[Char, Int] = mutable.Map[Char, Int]()
    for (c <- t) {
      need(c) = need.getOrElse(c, 0) + 1
    }
    var left, right = 0
    var valid = 0
    var start = 0
    var maxLen = Int.MaxValue
    while (right < s.length) {
      val ch = s.charAt(right)
      right += 1
      if (need.contains(ch)) {
        window(ch) = window.getOrElse(ch, 0) + 1
        if (window(ch) == need(ch)) {
          valid += 1
        }
      }
      while (valid == need.size) {
        if (right - left < maxLen) {
          maxLen = right - left
          start = left
        }
        val leftCh = s.charAt(left)
        left += 1
        if (need.contains(leftCh)) {
          if (need(leftCh) == window(leftCh)) {
            valid -= 1
          }
          window(leftCh) -= 1
        }
      }
    }
    if (maxLen == Int.MaxValue) "" else s.substring(start, start + maxLen)
  }

  /*
  567. 字符串的排列
给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

示例1:

输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").


示例2:

输入: s1= "ab" s2 = "eidboaoo"
输出: False


注意：

输入的字符串只包含小写字母
两个字符串的长度都在 [1, 10,000] 之间
   */
  def checkInclusion(s1: String, s2: String): Boolean = {
    val need, window = mutable.Map[Char, Int]()
    for (c <- s1) {
      need(c) = need.getOrElse(c, 0) + 1
    }

    var left, right, valid = 0
    while (right < s2.length) {
      val ch = s2.charAt(right)
      right += 1
      if (need.contains(ch)) {
        window(ch) = window.getOrElse(ch, 0) + 1
        if (need(ch) == window(ch)) {
          valid += 1
        }
      }

      while (right - left == s1.length) {
        if (valid == need.size) {
          return true
        }
        val leftCh = s2.charAt(left)
        left += 1
        if (need.contains(leftCh)) {
          if (need(leftCh) == window(leftCh)) {
            valid -= 1
          }
          window(leftCh) -= 1
        }
      }
    }
    false
  }

  /*
  438. 找到字符串中所有字母异位词
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
示例 1:

输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 示例 2:

输入:
s: "abab" p: "ab"

输出:
[0, 1, 2]

解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
   */
  def findAnagrams(s: String, p: String): List[Int] = {
    val need, window = mutable.Map[Char, Int]()
    for (c <- p) {
      need(c) = need.getOrElse(c, 0) + 1
    }
    var left, right, valid = 0
    val buffer: ListBuffer[Int] = new ListBuffer[Int]()
    while (right < s.length) {
      val ch = s.charAt(right)
      right += 1
      if (need.contains(ch)) {
        window(ch) = window.getOrElse(ch, 0) + 1
        if (need(ch) == window(ch)) {
          valid += 1
        }
      }
      while (right - left == p.length) {
        if (valid == need.size) {
          buffer.append(left)
        }
        val leftCh = s.charAt(left)
        left += 1
        if (need.contains(leftCh)) {
          if (need(leftCh) == window(leftCh)) {
            valid -= 1
          }
          window(leftCh) -= 1
        }
      }
    }
    buffer.toList
  }

  /*
  3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
   */
  def lengthOfLongestSubstring(s: String): Int = {
    val window = mutable.Map[Char, Int]()
    var left, right = 0
    var maxLen = 0
    while (right < s.length) {
      val ch = s.charAt(right)
      right += 1
      window(ch) = window.getOrElse(ch, 0) + 1
      while (window(ch) > 1) {
        val leftCh = s.charAt(left)
        left += 1
        window(leftCh) -= 1
      }
      maxLen = Math.max(maxLen, right - left)
    }
    maxLen
  }

  /*
  121. 买卖股票的最佳时机
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

注意：你不能在买入股票前卖出股票。



示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
   */
  /*
dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
            = max(dp[i-1][1][1], -prices[i])
解释：k = 0 的 base case，所以 dp[i-1][0][0] = 0。

现在发现 k 都是 1，不会改变，即 k 对状态转移已经没有影响了。
可以进行进一步化简去掉所有 k：
dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
dp[i][1] = max(dp[i-1][1], -prices[i])
   */
  def maxProfit_k_1(prices: Array[Int]): Int = {
    var dp_i_0 = 0
    var dp_i_1 = Int.MinValue
    for (p <- prices) {
      dp_i_0 = Math.max(dp_i_0, dp_i_1 + p)
      dp_i_1 = Math.max(dp_i_1, -p)
    }
    dp_i_0
  }

  /*
  122. 买卖股票的最佳时机 II
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。



示例 1:

输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
示例 2:

输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
示例 3:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。


提示：

1 <= prices.length <= 3 * 10 ^ 4
0 <= prices[i] <= 10 ^ 4
   */
  /*
如果 k 为正无穷，那么就可以认为 k 和 k - 1 是一样的。可以这样改写框架：
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
            = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])

我们发现数组中的 k 已经不会改变了，也就是说不需要记录 k 这个状态了：
dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
   */
  def maxProfit_k_inf(prices: Array[Int]): Int = {
    var dp_i_0 = 0
    var dp_i_1 = Int.MinValue
    for (p <- prices) {
      val temp = dp_i_0
      dp_i_0 = Math.max(dp_i_0, dp_i_1 + p)
      dp_i_1 = Math.max(dp_i_1, temp - p)
    }
    dp_i_0
  }

  /*
  309. 最佳买卖股票时机含冷冻期
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
   */
  /*
每次 sell 之后要等一天才能继续交易。只要把这个特点融入上一题的状态转移方程即可：
dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
   */
  def maxProfit_with_cool(prices: Array[Int]): Int = {
    var dp_i_0, dp_i_0_pre = 0
    var dp_i_1 = Int.MinValue
    for (p <- prices) {
      val temp = dp_i_0
      dp_i_0 = Math.max(dp_i_0, dp_i_1 + p)
      dp_i_1 = Math.max(dp_i_1, dp_i_0_pre - p)
      dp_i_0_pre = temp
    }
    dp_i_0
  }

  /*
  714. 买卖股票的最佳时机含手续费
给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。

你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

返回获得利润的最大值。

注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

示例 1:

输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
输出: 8
解释: 能够达到的最大利润:
在此处买入 prices[0] = 1
在此处卖出 prices[3] = 8
在此处买入 prices[4] = 4
在此处卖出 prices[5] = 9
总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
注意:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.
   */
  /*
每次交易要支付手续费，只要把手续费从利润中减去即可。改写方程：
dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
解释：相当于买入股票的价格升高了。
在第一个式子里减也是一样的，相当于卖出股票的价格减小了。
   */
  def maxProfit_with_fee(prices: Array[Int], fee: Int): Int = {
    var dp_i_0 = 0
    var dp_i_1 = Int.MinValue
    for (p <- prices) {
      val temp = dp_i_0
      dp_i_0 = Math.max(dp_i_0, dp_i_1 + p)
      dp_i_1 = Math.max(dp_i_1, temp - p - fee)
    }
    dp_i_0
  }

  /*
  123. 买卖股票的最佳时机 III
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [3,3,5,0,0,3,1,4]
输出: 6
解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
示例 2:

输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
示例 3:

输入: [7,6,4,3,1]
输出: 0
解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
   */
  /*
k = 2 和前面题目的情况稍微不同，因为上面的情况都和 k 的关系不太大。要么 k 是正无穷，状态转移和 k 没关系了；要么 k = 1，跟 k = 0 这个 base case 挨得近，最后也没有存在感。
这道题 k = 2 和后面要讲的 k 是任意正整数的情况中，对 k 的处理就凸显出来了。我们直接写代码，边写边分析原因。
原始的动态转移方程，没有可化简的地方
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
按照之前的代码，我们可能想当然这样写代码（错误的）：
int k = 2;
int[][][] dp = new int[n][k + 1][2];
for (int i = 0; i < n; i++)
    if (i - 1 == -1) { /* 处理一下 base case*/ }
    dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
    dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
}
return dp[n - 1][k][0];
为什么错误？我这不是照着状态转移方程写的吗？
还记得前面总结的「穷举框架」吗？就是说我们必须穷举所有状态。其实我们之前的解法，都在穷举所有状态，只是之前的题目中 k 都被化简掉了。比如说第一题，k = 1：
「代码截图」
这道题由于没有消掉 k 的影响，所以必须要对 k 进行穷举：
int max_k = 2;
int[][][] dp = new int[n][max_k + 1][2];
for (int i = 0; i < n; i++) {
    for (int k = max_k; k >= 1; k--) {
        if (i - 1 == -1) { /*处理 base case */ }
        dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
        dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
    }
}
// 穷举了 n × max_k × 2 个状态，正确。
return dp[n - 1][max_k][0];
如果你不理解，可以返回第一点「穷举框架」重新阅读体会一下。
这里 k 取值范围比较小，所以可以不用 for 循环，直接把 k = 1 和 2 的情况全部列举出来也可以：
dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
dp[i][1][1] = max(dp[i-1][1][1], -prices[i])
   */
  def maxProfit_k_2(prices: Array[Int]): Int = {
    var dp_i_2_0, dp_i_1_0 = 0
    var dp_i_2_1, dp_i_1_1 = Int.MinValue
    for (p <- prices) {
      dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + p)
      dp_i_2_1 = Math.max(dp_i_2_1, dp_i_1_0 - p)
      dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + p)
      dp_i_1_1 = Math.max(dp_i_1_1, -p)
    }
    dp_i_2_0
  }

  /*
  188. 买卖股票的最佳时机 IV
给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。



示例 1：

输入：k = 2, prices = [2,4,1]
输出：2
解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
示例 2：

输入：k = 2, prices = [3,2,6,5,0,3]
输出：7
解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。


提示：

0 <= k <= 109
0 <= prices.length <= 104
0 <= prices[i] <= 1000
   */
  /*
有了上一题 k = 2 的铺垫，这题应该和上一题的第一个解法没啥区别。但是出现了一个超内存的错误，原来是传入的 k 值会非常大，dp 数组太大了。现在想想，交易次数 k 最多有多大呢？
一次交易由买入和卖出构成，至少需要两天。所以说有效的限制 k 应该不超过 n/2，如果超过，就没有约束作用了，相当于 k = +infinity。这种情况是之前解决过的。
   */
  def maxProfit_k_any(k: Int, prices: Array[Int]): Int = {
    val n = prices.length
    if (k > n / 2)
      return maxProfit_k_inf(prices)
    val dp = Array.ofDim[Int](n, k + 1, 2)
    for (i <- 0 until n) {
      for (j <- Range(k, 0, -1)) {
        if (i - 1 < 0) {
          dp(i)(j)(0) = 0
          dp(i)(j)(1) = -prices(i)
        } else {
          dp(i)(j)(0) = Math.max(dp(i - 1)(j)(0), dp(i - 1)(j)(1) + prices(i))
          dp(i)(j)(1) = Math.max(dp(i - 1)(j)(1), dp(i - 1)(j - 1)(0) - prices(i))
        }
      }
    }
    dp(n - 1)(k)(0)
  }

  /*
  198. 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。



示例 1：

输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 2：

输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。


提示：

0 <= nums.length <= 100
0 <= nums[i] <= 400
   */
  def rob_1(nums: Array[Int]): Int = {
    var dp_i, dp_i_1, dp_i_2 = 0
    for (n <- nums) {
      dp_i = Math.max(dp_i_1, n + dp_i_2)
      dp_i_2 = dp_i_1
      dp_i_1 = dp_i
    }
    dp_i
  }

  /*
  213. 打家劫舍 II
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。



示例 1：

输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2：

输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 3：

输入：nums = [0]
输出：0


提示：

1 <= nums.length <= 100
0 <= nums[i] <= 1000
   */
  def rob_2(nums: Array[Int]): Int = {
    val n = nums.length
    if (n == 1)
      return nums(0)

    def robRange(start: Int, end: Int): Int = {
      var dp_i, dp_i_1, dp_i_2 = 0
      for (i <- start to end) {
        dp_i = Math.max(dp_i_1, dp_i_2 + nums(i))
        dp_i_2 = dp_i_1
        dp_i_1 = dp_i
      }
      dp_i
    }

    Math.max(robRange(0, n - 2), robRange(1, n - 1))
  }

  /*
  337. 打家劫舍 III
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:

输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

输出: 7
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
示例 2:

输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

输出: 9
解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
   */
  def rob(root: TreeNode): Int = {
    // 返回值：第一位代表抢， 第二位代表不抢
    def dp(root: TreeNode): (Int, Int) = {
      if (root == null)
        return (0, 0)

      val (left_do, left_dont) = dp(root.left)
      val (right_do, right_dont) = dp(root.right)

      // 当前节点被抢时，子节点不能抢
      val doRob = root.value + left_dont + right_dont
      // 当前节点不抢时，子节点可抢，可不抢，取最大值
      val notRob = Math.max(left_do, left_dont) + Math.max(right_do, right_dont)
      (doRob, notRob)
    }

    val res = dp(root)
    Math.max(res._1, res._2)
  }
}
