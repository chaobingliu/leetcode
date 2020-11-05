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
    println(lengthOfLongestSubstring("pwwkew"))
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
}
