package study1

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
    println(findTargetSumWays_backtrack(Array(0, 0, 0, 0, 0, 0, 0, 0, 1), 1))

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
}
