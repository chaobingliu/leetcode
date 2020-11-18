package study3

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

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {
  def main(args: Array[String]): Unit = {
    val arr = Array(Array('5', '3', '.', '.', '7', '.', '.', '.', '.'), Array('6', '.', '.', '1', '9', '5', '.', '.', '.'), Array('.', '9', '8', '.', '.', '.', '.', '6', '.'), Array('8', '.', '.', '.', '6', '.', '.', '.', '3'), Array('4', '.', '.', '8', '.', '3', '.', '.', '1'), Array('7', '.', '.', '.', '2', '.', '.', '.', '6'), Array('.', '6', '.', '.', '.', '.', '2', '8', '.'), Array('.', '.', '.', '4', '1', '9', '.', '.', '5'), Array('.', '.', '.', '.', '8', '.', '.', '7', '9'))
    solveSudoku(arr)
    for (i <- 0 until 9) {
      arr(i).foreach(x => print(x + " "))
      println
    }
  }

  def subsets(nums: Array[Int]): List[List[Int]] = {
    val res = new ListBuffer[List[Int]]()

    def backtrack(start: Int, track: ListBuffer[Int]): Unit = {
      res.append(track.toList)
      for (i <- start until nums.size) {
        track.append((nums(i)))
        backtrack(i + 1, track)
        track.remove(track.length - 1)
      }
    }

    backtrack(0, new ListBuffer[Int]())
    res.toList
  }

  def combine(n: Int, k: Int): List[List[Int]] = {
    val res = new ListBuffer[List[Int]]()

    def backtrack(start: Int, track: ListBuffer[Int]): Unit = {
      if (track.length == k) {
        res.append(track.toList)
        return
      }
      for (i <- start to n) {
        track.append(i)
        backtrack(i + 1, track)
        track.remove(track.length - 1)
      }
    }

    backtrack(1, new ListBuffer[Int]())
    res.toList
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
    val res = new ListBuffer[List[Int]]()
    val n = nums.length

    def backtrack(track: ListBuffer[Int]): Unit = {
      if (track.length == n) {
        res.append(track.toList)
        return
      }
      for (i <- 0 until n) {
        if (!track.contains(nums(i))) {
          track.append(nums(i))
          backtrack(track)
          track.remove(track.length - 1)
        }

      }
    }

    backtrack(new ListBuffer[Int]())
    res.toList
  }

  /*
  37. 解数独
编写一个程序，通过填充空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。



一个数独。



答案被标成红色。

提示：

给定的数独序列只包含数字 1-9 和字符 '.' 。
你可以假设给定的数独只有唯一解。
给定数独永远是 9x9 形式的。

   */
  def solveSudoku(board: Array[Array[Char]]): Unit = {

    def isValid(r: Int, c: Int, n: Int): Boolean = {
      for (i <- 0 until 9) {
        if (board(r)(i) == n) return false
        if (board(i)(c) == n) return false
        if (board((r / 3) * 3 + i / 3)((c / 3) * 3 + i % 3) == n) return false
      }
      true
    }

    val m, n = 9

    def backtrack(i: Int, j: Int): Boolean = {
      if (j == 9) {
        return backtrack(i + 1, 0)
      }
      if (i == m) return true

      if (board(i)(j) != '.') {
        return backtrack(i, j + 1)
      }

      for (ch <- '1' to '9') {
        if (isValid(i, j, ch)) {
          board(i)(j) = ch
          if (backtrack(i, j + 1)) {
            return true
          }
          board(i)(j) = '.'

        }
      }
      false
    }

    backtrack(0, 0)
  }


}

