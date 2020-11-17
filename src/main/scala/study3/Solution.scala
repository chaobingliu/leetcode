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

}

