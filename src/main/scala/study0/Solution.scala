package study0

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

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
    //    println(rob_2(Array(1, 2, 3, 1)))
    //    println(removeCoveredIntervals(Array(Array(1, 2), Array(1, 3), Array(3, 2), Array(2, 4))))
    //    println(merge(Array(Array())))
    //    println(threeSum(Array(0, 0, 0)))
    //    println(fourSum(Array(1, 0, -1, 0, -2, 2), 0))
    //    println(superEggDrop(4, 5000))
    //    println(constructMaximumBinaryTree(Array(3, 2, 1, 6, 0, 5)))
    //    println(buildTree_with_pre_in(Array(3, 9, 20, 15, 7), Array(9, 3, 15, 20, 7)))
    //    println(canPartition(Array(1, 1)))
    //    println(eraseOverlapIntervals(Array(Array(1, 100), Array(11, 22), Array(1, 11), Array(2, 12))))
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
    val dp: Array[Int] = Array.fill(amount + 1)(amount + 1)
    dp(0) = 0
    for (i <- 1 to amount) {
      for (coin <- coins; if (i - coin) >= 0) {
        dp(i) = Math.min(dp(i), dp(i - coin) + 1)
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

  /*
  1288. 删除被覆盖区间
给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。

只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。

在完成所有删除操作后，请你返回列表中剩余区间的数目。



示例：

输入：intervals = [[1,4],[3,6],[2,8]]
输出：2
解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。


提示：​​​​​​

1 <= intervals.length <= 1000
0 <= intervals[i][0] < intervals[i][1] <= 10^5
对于所有的 i != j：intervals[i] != intervals[j]
   */
  def removeCoveredIntervals(intervals: Array[Array[Int]]): Int = {
    val sortedIntervals = intervals.sortBy(r => (r(0), r(1)))(Ordering.Tuple2(Ordering.Int, Ordering.Int.reverse))
    var left = sortedIntervals(0)(0)
    var right = sortedIntervals(0)(1)
    var res = 0

    for (i <- 1 until sortedIntervals.length) {
      val n = sortedIntervals(i)
      if (left <= n(0) && right >= n(1)) {
        res += 1
      } else if (right >= n(0) && right < n(1)) {
        right = n(1)
      } else if (n(0) > right) {
        left = n(0)
        right = n(1)
      }
    }
    intervals.length - res
  }

  /*
  56. 合并区间
给出一个区间的集合，请合并所有重叠的区间。



示例 1:

输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: intervals = [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。



提示：

intervals[i][0] <= intervals[i][1]
   */
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    if (intervals == null || intervals.isEmpty)
      return Array()
    val sortedIntervals = intervals.sortBy(r => (r(0), r(1)))(Ordering.Tuple2(Ordering.Int, Ordering.Int.reverse))

    val buffer = new ListBuffer[Array[Int]]()
    buffer.append(sortedIntervals(0))

    for (i <- 1 until sortedIntervals.length) {
      val last: Array[Int] = buffer.last
      val n = sortedIntervals(i)
      if (n(0) <= last(1)) {
        last(1) = Math.max(last(1), n(1))
      } else {
        buffer.append(n)
      }
    }
    buffer.toArray
  }

  /*
  986. 区间列表的交集
给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。

返回这两个区间列表的交集。

（形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）



示例：



输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]


提示：

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
   */
  def intervalIntersection(A: Array[Array[Int]], B: Array[Array[Int]]): Array[Array[Int]] = {
    val sortedA = A.sortBy(r => (r(0), r(1)))(Ordering.Tuple2(Ordering.Int, Ordering.Int.reverse))
    val sortedB = B.sortBy(r => (r(0), r(1)))(Ordering.Tuple2(Ordering.Int, Ordering.Int.reverse))
    var i, j = 0
    val buffer = new ListBuffer[Array[Int]]()
    while (i < sortedA.length && j < sortedB.length) {
      val a = sortedA(i)
      val b = sortedB(j)
      if (a(1) >= b(0) && b(1) >= a(0)) {
        buffer.append(Array(Math.max(a(0), b(0)), Math.min(a(1), b(1))))
      }
      if (a(1) < b(1)) {
        i += 1
      } else {
        j += 1
      }
    }
    buffer.toArray
  }

  def nSum(nums: Array[Int], n: Int, start: Int, target: Int): ListBuffer[List[Int]] = {
    val res = new ListBuffer[List[Int]]()
    if (nums.length < n || n < 2)
      return res
    if (n == 2) {
      var lo = start
      var hi = nums.length - 1
      while (lo < hi) {
        val left = nums(lo)
        val right = nums(hi)
        val sum = left + right
        if (sum < target) {
          while (lo < hi && nums(lo) == left) lo += 1
        } else if (sum > target) {
          while (lo < hi && nums(hi) == right) hi -= 1
        } else {
          res.append(List(left, right))
          while (lo < hi && nums(lo) == left) lo += 1
          while (lo < hi && nums(hi) == right) hi -= 1
        }
      }
    } else {
      var i = start
      while (i < nums.length) {
        val buffer = nSum(nums, n - 1, i + 1, target - nums(i))
        for (arr <- buffer) {
          res.append(nums(i) +: arr)
        }
        while (i < nums.length - 1 && nums(i) == nums(i + 1)) i += 1
        i += 1
      }
    }
    res
  }

  /*
  15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。



示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
   */
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    if (nums == null || nums.isEmpty)
      return List[List[Int]]()
    nSum(nums.sorted, 3, 0, 0).toList
  }

  /*
  18. 四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
   */
  def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {
    if (nums == null || nums.isEmpty) {
      return List[List[Int]]()
    }
    nSum(nums.sorted, 4, 0, target).toList
  }

  /*
  887. 鸡蛋掉落
你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。

每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。

你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。

每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。

你的目标是确切地知道 F 的值是多少。

无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？



示例 1：

输入：K = 1, N = 2
输出：2
解释：
鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
如果它没碎，那么我们肯定知道 F = 2 。
因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
示例 2：

输入：K = 2, N = 6
输出：3
示例 3：

输入：K = 3, N = 14
输出：4


提示：

1 <= K <= 100
1 <= N <= 10000
   */
  /*
我们在第i层楼扔了鸡蛋之后，可能出现两种情况：鸡蛋碎了，鸡蛋没碎。注意，这时候状态转移就来了：

如果鸡蛋碎了，那么鸡蛋的个数K应该减一，搜索的楼层区间应该从[1..N]变为[1..i-1]共i-1层楼；

如果鸡蛋没碎，那么鸡蛋的个数K不变，搜索的楼层区间应该从 [1..N]变为[i+1..N]共N-i层楼。
   */
  def superEggDrop2(K: Int, N: Int): Int = {
    val map = mutable.Map[(Int, Int), Int]()

    def dp(K: Int, N: Int): Int = {
      if (K == 1) return N
      if (N == 0) return 0
      if (map.contains((K, N)))
        return map((K, N))
      var res = N
      for (i <- 1 to N) {
        res = Math.min(res, Math.max(dp(K, N - i), dp(K - 1, i - 1)) + 1)
      }
      map((K, N)) = res
      res
    }

    dp(K, N)
  }

  /*
dp[k][m] = dp[k][m-1] + dp[k-1][m-1] + 1

dp[k][m - 1]就是楼上的楼层数，因为鸡蛋个数k不变，也就是鸡蛋没碎，扔鸡蛋次数m减一；

dp[k - 1][m - 1]就是楼下的楼层数，因为鸡蛋个数k减一，也就是鸡蛋碎了，同时扔鸡蛋次数m减一。
   */
  def superEggDrop(K: Int, N: Int): Int = {
    val dp = Array.ofDim[Int](K + 1, N + 1)

    var m = 0
    while (dp(K)(m) < N) {
      m += 1
      for (i <- 1 to K) {
        dp(i)(m) = dp(i)(m - 1) + dp(i - 1)(m - 1) + 1
      }
    }
    m
  }

  /*
226. 翻转二叉树
翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
备注:
这个问题是受到 Max Howell 的 原问题 启发的 ：

谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
   */
  def invertTree(root: TreeNode): TreeNode = {
    if (root == null) {
      return null
    }
    val temp = root.left
    root.left = root.right
    root.right = temp

    invertTree(root.left)
    invertTree(root.right)
    root
  }

  /*
  116. 填充每个节点的下一个右侧节点指针
给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。



示例：



输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}

解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。


提示：

你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
   */
  def connect(root: Node): Node = {
    def connectTwoNode(node1: Node, node2: Node) {
      if (node1 == null || node2 == null)
        return

      node1.next = node2

      connectTwoNode(node1.left, node1.right)
      connectTwoNode(node2.left, node2.right)
      connectTwoNode(node1.right, node2.left)
    }

    if (root == null)
      return null
    connectTwoNode(root.left, root.right)
    root
  }

  /*
  114. 二叉树展开为链表
给定一个二叉树，原地将它展开为一个单链表。



例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
   */
  def flatten(root: TreeNode): Unit = {
    if (root == null)
      return

    flatten(root.left)
    flatten(root.right)

    val left = root.left
    val right = root.right
    root.left = null
    root.right = left

    var p = root
    while (p.right != null) {
      p = p.right
    }
    p.right = right
  }

  /*
  654. 最大二叉树
给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

二叉树的根是数组中的最大元素。
左子树是通过数组中最大值左边部分构造出的最大二叉树。
右子树是通过数组中最大值右边部分构造出的最大二叉树。
通过给定的数组构建最大二叉树，并且输出这个树的根节点。



示例 ：

输入：[3,2,1,6,0,5]
输出：返回下面这棵树的根节点：

      6
    /   \
   3     5
    \    /
     2  0
       \
        1


提示：

给定的数组的大小在 [1, 1000] 之间。
   */
  def constructMaximumBinaryTree(nums: Array[Int]): TreeNode = {
    if (nums == null || nums.isEmpty) {
      return null
    }
    var maxIdx = 0
    for (i <- 1 until nums.length) {
      if (nums(i) > nums(maxIdx)) {
        maxIdx = i
      }
    }

    val root = new TreeNode(nums(maxIdx))
    root.left = constructMaximumBinaryTree(nums.slice(0, maxIdx))
    root.right = constructMaximumBinaryTree(nums.slice(maxIdx + 1, nums.length))
    root
  }

  /*
  105. 从前序与中序遍历序列构造二叉树
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   */
  def buildTree_with_pre_in(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    val map = mutable.Map[Int, Int]()
    for (i <- 0 until inorder.length) {
      map(inorder(i)) = i
    }

    def build(preStart: Int, preEnd: Int, inStart: Int, inEnd: Int): TreeNode = {
      if (preStart > preEnd)
        return null

      val root = new TreeNode(preorder(preStart))
      val rootIndex = map(root.value)

      val leftSize = rootIndex - inStart
      root.left = build(preStart + 1, preStart + leftSize, inStart, rootIndex - 1)
      root.right = build(preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd)
      root

    }

    build(0, preorder.length - 1, 0, inorder.length - 1)
  }

  /*
  106. 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
   */
  def buildTree_with_post_in(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
    val map = mutable.Map[Int, Int]()
    for (i <- 0 until inorder.length) {
      map(inorder(i)) = i
    }

    def build(inStart: Int, inEnd: Int, postStart: Int, postEnd: Int): TreeNode = {
      if (postStart > postEnd)
        return null

      val root = new TreeNode(postorder(postEnd))
      val rootIndex = map(root.value)

      val leftSize = rootIndex - inStart
      root.left = build(inStart, rootIndex - 1, postStart, postStart + leftSize - 1)
      root.right = build(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1)
      root
    }

    build(0, inorder.length - 1, 0, postorder.length - 1)
  }

  /*
  652. 寻找重复的子树
给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。

两棵树重复是指它们具有相同的结构以及相同的结点值。

示例 1：

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
下面是两个重复的子树：

      2
     /
    4
和

    4
因此，你需要以列表的形式返回上述重复子树的根结点。
   */
  def findDuplicateSubtrees(root: TreeNode): List[TreeNode] = {
    val buffer = new ListBuffer[TreeNode]()
    val map = mutable.Map[String, Int]()

    def traverse(root: TreeNode): String = {
      if (root == null) return "#"

      val left = traverse(root.left)
      val right = traverse(root.right)

      val rootStr = left + "," + right + "," + root.value
      map(rootStr) = map.getOrElse(rootStr, 0) + 1
      if (map(rootStr) == 2) {
        buffer.append(root)
      }
      rootStr
    }

    traverse(root)
    buffer.toList
  }

  /*
  416. 分割等和子集
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].


示例 2:

输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子集.
   */
  def canPartition_normal(nums: Array[Int]): Boolean = {
    var sum = nums.sum
    if (sum % 2 == 1)
      return false
    sum = sum / 2

    val n = nums.length
    val dp = Array.ofDim[Boolean](n + 1, sum + 1)
    for (i <- 0 to n) {
      dp(i)(0) = true
    }

    for (i <- 1 to n) {
      for (j <- Range(sum, 1, -1)) {
        if (j - nums(i - 1) < 0) {
          dp(i)(j) = dp(i - 1)(j)
        } else {
          dp(i)(j) = dp(i - 1)(j - nums(i - 1)) || dp(i - 1)(j)
        }
      }
    }
    dp(n)(sum)
  }

  def canPartition(nums: Array[Int]): Boolean = {
    var sum = nums.sum
    if (sum % 2 == 1)
      return false
    sum = sum / 2

    val dp = new Array[Boolean](sum + 1)
    dp(0) = true

    for (i <- 0 until nums.length) {
      for (j <- Range(sum, -1, -1); if (j - nums(i) >= 0)) {
        dp(j) = dp(j) || dp(j - nums(i))
      }
    }
    dp(sum)
  }

  /*
  518. 零钱兑换 II
给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。



示例 1:

输入: amount = 5, coins = [1, 2, 5]
输出: 4
解释: 有四种方式可以凑成总金额:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
示例 2:

输入: amount = 3, coins = [2]
输出: 0
解释: 只用面额2的硬币不能凑成总金额3。
示例 3:

输入: amount = 10, coins = [10]
输出: 1


注意:

你可以假设：

0 <= amount (总金额) <= 5000
1 <= coin (硬币面额) <= 5000
硬币种类不超过 500 种
结果符合 32 位符号整数
   */
  def change_normal(amount: Int, coins: Array[Int]): Int = {
    val n = coins.length
    val dp = Array.ofDim[Int](n + 1, amount + 1)
    for (i <- 0 to n) {
      dp(i)(0) = 1
    }

    for (i <- 1 to n) {
      for (j <- 1 to amount) {
        if (j - coins(i - 1) >= 0) {
          dp(i)(j) = dp(i - 1)(j) + dp(i)(j - coins(i - 1))
        } else {
          dp(i)(j) = dp(i - 1)(j)
        }
      }
    }
    dp(n)(amount)
  }

  def change(amount: Int, coins: Array[Int]): Int = {
    val dp = new Array[Int](amount + 1)
    dp(0) = 1

    for (i <- 0 until coins.length) {
      for (j <- 1 to amount; if (j - coins(i) >= 0)) {
        dp(j) = dp(j) + dp(j - coins(i))
      }
    }
    dp(amount)
  }

  /*
  435. 无重叠区间
给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

注意:

可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
示例 1:

输入: [ [1,2], [2,3], [3,4], [1,3] ]

输出: 1

解释: 移除 [1,3] 后，剩下的区间没有重叠。
示例 2:

输入: [ [1,2], [1,2], [1,2] ]

输出: 2

解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
示例 3:

输入: [ [1,2], [2,3] ]

输出: 0

解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
   */
  def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
    if (intervals.length == 0)
      return 0
    val sorted = intervals.sortBy(r => (r(1)))(Ordering.Int)

    var count = 1
    var pre_end = sorted(0)(1)
    for (arr <- sorted) {
      if (arr(0) >= pre_end) {
        count += 1
        pre_end = arr(1)
      }
    }
    sorted.length - count
  }

  /*
  452. 用最少数量的箭引爆气球
在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。

一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。

给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。


示例 1：

输入：points = [[10,16],[2,8],[1,6],[7,12]]
输出：2
解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
示例 2：

输入：points = [[1,2],[3,4],[5,6],[7,8]]
输出：4
示例 3：

输入：points = [[1,2],[2,3],[3,4],[4,5]]
输出：2
示例 4：

输入：points = [[1,2]]
输出：1
示例 5：

输入：points = [[2,3],[2,3]]
输出：1


提示：

0 <= points.length <= 104
points[i].length == 2
-231 <= xstart < xend <= 231 - 1
   */
  def findMinArrowShots(points: Array[Array[Int]]): Int = {
    if (points.length == 0)
      return 0
    val sorted = points.sortBy(r => (r(1)))(Ordering.Int)
    var count = 1
    var pre_end = sorted(0)(1)
    for (p <- sorted) {
      if (p(0) > pre_end) {
        count += 1
        pre_end = p(1)
      }
    }
    count
  }
}
