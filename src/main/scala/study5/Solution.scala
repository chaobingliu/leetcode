package study5

import scala.util.Random

object Solution {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  def main(args: Array[String]): Unit = {
    //    println(countPrimes(10))
    println(missingNumber(Array(0, 1, 3)))

  }

  /*
  172. 阶乘后的零
给定一个整数 n，返回 n! 结果尾数中零的数量。

示例 1:

输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。
示例 2:

输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.
   */
  def trailingZeroes(n: Int): Int = {
    var res = 0
    var divisor = 5
    while (divisor <= n) {
      res += n / divisor
      divisor *= 5
    }
    res
  }

  /*
  793. 阶乘函数后K个零
 f(x) 是 x! 末尾是0的数量。（回想一下 x! = 1 * 2 * 3 * ... * x，且0! = 1）

例如， f(3) = 0 ，因为3! = 6的末尾没有0；而 f(11) = 2 ，因为11!= 39916800末端有2个0。给定 K，找出多少个非负整数x ，有 f(x) = K 的性质。

示例 1:
输入:K = 0
输出:5
解释: 0!, 1!, 2!, 3!, and 4! 均符合 K = 0 的条件。

示例 2:
输入:K = 5
输出:0
解释:没有匹配到这样的 x!，符合K = 5 的条件。
注意：

K是范围在 [0, 10^9] 的整数。
   */
  def preimageSizeFZF(K: Int): Int = {
    def trailingZeroes(n: Long): Long = {
      var res: Long = 0
      var divisor: Long = 5
      while (divisor <= n) {
        res += n / divisor
        divisor *= 5
      }
      res
    }

    def left_bound(): Long = {
      var lo: Long = 0
      var hi: Long = Long.MaxValue
      while (lo < hi) {
        val mid: Long = lo + (hi - lo) / 2
        val temp = trailingZeroes(mid)
        if (temp < K) {
          lo = mid + 1
        } else {
          hi = mid
        }
      }
      lo
    }

    def right_bound(): Long = {
      var lo: Long = 0
      var hi: Long = Long.MaxValue
      while (lo < hi) {
        val mid: Long = lo + (hi - lo) / 2
        val temp = trailingZeroes(mid)
        if (temp > K) {
          hi = mid
        } else {
          lo = mid + 1
        }
      }
      lo - 1
    }

    (right_bound() - left_bound() + 1).toInt
  }

  def countPrimes(n: Int): Int = {
    val isPrim = Array.fill[Boolean](n)(true)
    for (i <- 2 until n; if (i * i < n)) {
      if (isPrim(i)) {
        for (j <- Range(i * i, n, i)) {
          isPrim(j) = false
        }
      }
    }

    var count = 0
    for (i <- 2 until n) {
      if (isPrim(i)) count += 1
    }
    count
  }

  /*
  372. 超级次方
你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。



示例 1：

输入：a = 2, b = [3]
输出：8
示例 2：

输入：a = 2, b = [1,0]
输出：1024
示例 3：

输入：a = 1, b = [4,3,3,8,5,2]
输出：1
示例 4：

输入：a = 2147483647, b = [2,0,0]
输出：1198


提示：

1 <= a <= 231 - 1
1 <= b.length <= 2000
0 <= b[i] <= 9
b 不含前导 0
   */
  def superPow(a: Int, b: Array[Int]): Int = {
    val base = 1337

    def mypow(_a: Int, k: Int): Int = {
      var a = _a
      a %= base
      var res = 1
      for (i <- 0 until k) {
        res *= a
        res %= base
      }
      res
    }

    if (b.isEmpty) return 1
    val last = b.last
    val part1 = mypow(a, last)
    val part2 = mypow(superPow(a, b.slice(0, b.length - 1)), 10)
    (part1 * part2) % base
  }

  def superPow2(a: Int, b: Array[Int]): Int = {
    val base = 1337

    def mypow(_a: Int, k: Int): Int = {
      var a = _a
      if (k == 0) return 1
      a %= base

      if (k % 2 == 1) {
        (a * mypow(a, k - 1)) % base
      } else {
        val sub = mypow(a, k / 2)
        (sub * sub) % base
      }
    }

    if (b.isEmpty) return 1
    val last = b.last
    val part1 = mypow(a, last)
    val part2 = mypow(superPow(a, b.slice(0, b.length - 1)), 10)
    (part1 * part2) % base
  }

  /*
  剑指 Offer 53 - II. 0～n-1中缺失的数字
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。



示例 1:

输入: [0,1,3]
输出: 2
示例 2:

输入: [0,1,2,3,4,5,6,7,9]
输出: 8


限制：

1 <= 数组长度 <= 10000
   */
  def missingNumber_normal(nums: Array[Int]): Int = {
    val n = nums.length
    var res = 0
    res ^= n
    for (i <- 0 until n) {
      res ^= (i ^ nums(i))
    }
    res
  }

  def missingNumber_simple(nums: Array[Int]): Int = {
    val n = nums.length
    // 等差数列求和 公式： （首项 + 未项）*项数 / 2
    val expect = (0 + n) * (n + 1) / 2
    val sum = nums.sum
    expect - sum
  }

  def missingNumber(nums: Array[Int]): Int = {
    val n = nums.length
    var res = 0
    res += n - 0
    for (i <- 0 until n) {
      res += i - nums(i)
    }
    res
  }

  /*
  645. 错误的集合
集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。

给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。

示例 1:

输入: nums = [1,2,2,4]
输出: [2,3]
注意:

给定数组的长度范围是 [2, 10000]。
给定的数组是无序的。
   */
  def findErrorNums(nums: Array[Int]): Array[Int] = {
    val n = nums.length
    var dup = -1
    for (i <- 0 until n) {
      val index = Math.abs(nums(i)) - 1
      if (nums(index) < 0) {
        dup = Math.abs(nums(i))
      } else {
        nums(index) *= -1
      }
    }

    var missing = -1
    for (i <- 0 until n) {
      if (nums(i) > 0) missing = i + 1
    }
    Array(dup, missing)
  }

  /*
  382. 链表随机节点
给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。

进阶:
如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？

示例:

// 初始化一个单链表 [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
solution.getRandom();
   */
  def getRandom(head: ListNode): Int = {
    val r = new Random()
    var i, res = 0
    var p = head
    while (p != null) {
      i += 1
      if (r.nextInt(i) == 0) {
        res = p.x
      }
      p = p.next
    }
    res
  }
}
