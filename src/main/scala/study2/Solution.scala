package study2

import java.util

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

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {
  def main(args: Array[String]): Unit = {
    val n1 = new ListNode(1)
    val n2 = new ListNode(2)
    val n3 = new ListNode(3)
    val n4 = new ListNode(4)
    val n5 = new ListNode(5)
    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5
    //    reverseKGroup(n1, 2)
    val a = new TreeNode(2)
    val b = new TreeNode(1)
    val c = new TreeNode(2)
    a.left = b
    a.right = c
    //    println(isValidBST(a))
    //    println(equationsPossible(Array("a==b", "b!=a")))
    //    println(nextGreaterElement(Array(2, 4), Array(1, 2, 3, 4)).foreach(println))
    //    nextGreaterElements(Array(1, 2, 1)).foreach(println)
    println(maxSlidingWindow(Array(1, 3, -1, -3, 5, 3, 6, 7), 3))
  }

  /*
  92. 反转链表 II
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
   */
  def reverseBetween(head: ListNode, m: Int, n: Int): ListNode = {
    var newNextNode: ListNode = null //后驱节点
    def reverseN(head: ListNode, n: Int): ListNode = {
      if (n == 1) {
        newNextNode = head.next
        return head
      }
      val last = reverseN(head.next, n - 1)
      head.next.next = head
      head.next = newNextNode
      last
    }

    if (m == 1) {
      return reverseN(head, n)
    }
    head.next = reverseBetween(head.next, m - 1, n - 1)
    head
  }

  def reverse(head: ListNode): ListNode = {
    var pre: ListNode = null
    var cur, nxt = head
    while (cur != null) {
      nxt = cur.next
      cur.next = pre
      pre = cur
      cur = nxt
    }
    pre
  }


  def reverse(a: ListNode, b: ListNode): ListNode = {
    var pre: ListNode = null
    var cur, nxt = a
    while (cur != b) {
      nxt = cur.next
      cur.next = pre
      pre = cur
      cur = nxt
    }
    pre
  }

  /*
  25. K 个一组翻转链表
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。



示例：

给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5



说明：

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
   */
  def reverseKGroup(head: ListNode, k: Int): ListNode = {
    if (head == null) return null
    var a, b = head
    for (i <- 0 until k) {
      if (b == null) return head
      b = b.next
    }

    val newHead = reverse(a, b)
    a.next = reverseKGroup(b, k)
    newHead
  }

  /*
  234. 回文链表
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
   */
  def isPalindrome_normal(head: ListNode): Boolean = {
    var left = head

    def traverse(head: ListNode): Boolean = {
      if (head == null) return true
      var res = traverse(head.next)
      res = res && left.x == head.x
      left = left.next
      res
    }

    traverse(head)
  }

  def isPalindrome(head: ListNode): Boolean = {
    var slow, fast = head
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
    }
    if (fast != null) slow = slow.next
    var left = head
    var right = reverse(slow)
    while (right != null) {
      if (left.x != right.x) return false
      left = left.next
      right = right.next
    }
    true
  }

  /*
  230. 二叉搜索树中第K小的元素
给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3
进阶：
如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
   */
  def kthSmallest(root: TreeNode, k: Int): Int = {
    var rank = 0
    var res = 0

    def traverse(root: TreeNode) {
      if (root == null) return
      traverse(root.left)
      rank += 1
      if (rank == k) {
        res = root.value
        return
      }
      traverse(root.right)
    }

    traverse(root)
    res
  }

  /*
  538. 把二叉搜索树转换为累加树
给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。

提醒一下，二叉搜索树满足下列约束条件：

节点的左子树仅包含键 小于 节点键的节点。
节点的右子树仅包含键 大于 节点键的节点。
左右子树也必须是二叉搜索树。
注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同



示例 1：



输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
示例 2：

输入：root = [0,null,1]
输出：[1,null,1]
示例 3：

输入：root = [1,0,2]
输出：[3,3,2]
示例 4：

输入：root = [3,2,4,1]
输出：[7,9,4,10]


提示：

树中的节点数介于 0 和 104 之间。
每个节点的值介于 -104 和 104 之间。
树中的所有值 互不相同 。
给定的树为二叉搜索树。
   */
  def convertBST(root: TreeNode): TreeNode = {
    var sum = 0

    def traverse(root: TreeNode): Unit = {
      if (root == null) return

      traverse(root.right)
      sum += root.value
      root.value = sum
      traverse(root.left)
    }

    traverse(root)
    root
  }

  /*
  98. 验证二叉搜索树
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
   */
  def isValidBST(root: TreeNode): Boolean = {
    def isValidBST(root: TreeNode, min: TreeNode, max: TreeNode): Boolean = {
      if (root == null) return true
      if (min != null && root.value <= min.value) return false
      if (max != null && root.value >= max.value) return false

      isValidBST(root.left, min, root) && isValidBST(root.right, root, max)
    }

    isValidBST(root, null, null)
  }

  /*
  700. 二叉搜索树中的搜索
给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。

例如，

给定二叉搜索树:

        4
       / \
      2   7
     / \
    1   3

和值: 2
你应该返回如下子树:

      2
     / \
    1   3
在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
   */
  def searchBST(root: TreeNode, `val`: Int): TreeNode = {
    if (root == null) return null
    if (root.value == `val`) {
      return root
    } else if (root.value > `val`) {
      return searchBST(root.left, `val`)
    } else {
      return searchBST(root.right, `val`)
    }
  }

  /*
  701. 二叉搜索树中的插入操作
给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。

注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。



示例 1：


输入：root = [4,2,7,1,3], val = 5
输出：[4,2,7,1,3,5]
解释：另一个满足题目要求可以通过的树是：

示例 2：

输入：root = [40,20,60,10,30,50,70], val = 25
输出：[40,20,60,10,30,50,70,null,null,25]
示例 3：

输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
输出：[4,2,7,1,3,5]




提示：

给定的树上的节点数介于 0 和 10^4 之间
每个节点都有一个唯一整数值，取值范围从 0 到 10^8
-10^8 <= val <= 10^8
新值和原始二叉搜索树中的任意节点值都不同
   */
  def insertIntoBST(root: TreeNode, `val`: Int): TreeNode = {
    if (root == null) return new TreeNode(`val`)
    if (root.value > `val`) {
      root.left = insertIntoBST(root.left, `val`)
    } else if (root.value < `val`) {
      root.right = insertIntoBST(root.right, `val`)
    }
    root
  }

  /*
  450. 删除二叉搜索树中的节点
给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。
说明： 要求算法时间复杂度为 O(h)，h 为树的高度。

示例:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。

一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。

    5
   / \
  4   6
 /     \
2       7

另一个正确答案是 [5,2,6,null,4,null,7]。

    5
   / \
  2   6
   \   \
    4   7
   */
  def deleteNode(root: TreeNode, key: Int): TreeNode = {
    if (root == null) return null
    if (root.value == key) {
      if (root.left == null) return root.right
      if (root.right == null) return root.left

      val minValue = getMin(root.right)
      root.value = minValue
      root.right = deleteNode(root.right, minValue)
    } else if (root.value < key) {
      root.right = deleteNode(root.right, key)
    } else {
      root.left = deleteNode(root.left, key)
    }
    root
  }

  def getMin(_root: TreeNode): Int = {
    var root = _root
    while (root.left != null) {
      root = root.left
    }
    root.value
  }

  /*
  236. 二叉树的最近公共祖先
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]





示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。


说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。
   */
  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    if (root == null) return null
    if (root == p || root == q) return root
    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)

    if (left != null && right != null) {
      root
    } else if (left == null && right == null) {
      null
    } else {
      if (left != null) left else right
    }
  }

  /*
  222. 完全二叉树的节点个数
给出一个完全二叉树，求出该树的节点个数。

说明：

完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。

示例:

输入:
    1
   / \
  2   3
 / \  /
4  5 6

输出: 6
   */
  def countNodes(root: TreeNode): Int = {
    if (root == null) return 0

    var l, r = root
    var hl, hr = 0

    while (l != null) {
      l = l.left
      hl += 1
    }
    while (r != null) {
      r = r.right
      hr += 1
    }

    if (hl == hr) {
      return Math.pow(2, hl).toInt - 1
    }
    countNodes(root.left) + countNodes(root.right) + 1
  }

  /*
  130. 被围绕的区域
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
解释:

被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
   */
  def solve(board: Array[Array[Char]]): Unit = {
    if (board.length == 0) return

    val m = board.length
    val n = board(0).length
    val uf = new UF(m * n + 1)
    val dummy = m * n
    // 将首列和未列的 O 与dummyh连通
    for (i <- 0 until m) {
      if (board(i)(0) == 'O') uf.union(i * n, dummy)
      if (board(i)(n - 1) == 'O') uf.union(i * n + n - 1, dummy)
    }
    // 将首行和未行的 O 与dummy连通
    for (j <- 0 until n) {
      if (board(0)(j) == 'O') uf.union(j, dummy)
      if (board(m - 1)(j) == 'O') uf.union((m - 1) * n + j, dummy)
    }
    // 方向数组 d 是上下左右搜索的常用手法
    val d = Array(Array(1, 0), Array(0, 1), Array(0, -1), Array(-1, 0))
    for (i <- 1 until m - 1) {
      for (j <- 1 until n - 1) {
        if (board(i)(j) == 'O') {
          for (k <- 0 until 4) {
            val x = i + d(k)(0)
            val y = j + d(k)(1)
            if (board(x)(y) == 'O') {
              uf.union(x * n + y, i * n + j)
            }
          }
        }
      }
    }

    // 所有不和dummy连通的O, 都要被替换
    for (i <- 1 until m - 1) {
      for (j <- 1 until n - 1) {
        if (!uf.connected(dummy, i * n + j)) board(i)(j) = 'X'
      }
    }
  }

  /*
  990. 等式方程的可满足性
给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。

只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。



示例 1：

输入：["a==b","b!=a"]
输出：false
解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
示例 2：

输入：["b==a","a==b"]
输出：true
解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
示例 3：

输入：["a==b","b==c","a==c"]
输出：true
示例 4：

输入：["a==b","b!=c","c==a"]
输出：false
示例 5：

输入：["c==c","b==d","x!=z"]
输出：true


提示：

1 <= equations.length <= 500
equations[i].length == 4
equations[i][0] 和 equations[i][3] 是小写字母
equations[i][1] 要么是 '='，要么是 '!'
equations[i][2] 是 '='
   */
  def equationsPossible(equations: Array[String]): Boolean = {
    val uf = new UF(26)

    for (eq <- equations) {
      if (eq(1) == '=') {
        val x = eq(0)
        val y = eq(3)
        uf.union(x - 'a', y - 'a')
      }
    }

    for (eq <- equations) {
      if (eq(1) == '!') {
        val x = eq(0)
        val y = eq(3)
        if (uf.connected(x - 'a', y - 'a')) {
          return false
        }
      }
    }
    return true
  }

  /*
  496. 下一个更大元素 I
给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。

nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。



示例 1:

输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
输出: [-1,3,-1]
解释:
    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
示例 2:

输入: nums1 = [2,4], nums2 = [1,2,3,4].
输出: [3,-1]
解释:
    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。


提示：

nums1和nums2中所有元素是唯一的。
nums1和nums2 的数组大小都不超过1000。
   */
  def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val res = new Array[Int](nums1.length)
    val map = mutable.Map[Int, Int]()
    val s = mutable.Stack[Int]()

    for (i <- Range(nums2.length - 1, -1, -1)) {
      while (!s.isEmpty && s.top <= nums2(i)) {
        s.pop()
      }
      map(nums2(i)) = if (s.isEmpty) -1 else s.top
      s.push(nums2(i))
    }
    for (i <- 0 until nums1.length) {
      res(i) = map(nums1(i))
    }
    res
  }

  /*
  503. 下一个更大元素 II
给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。

示例 1:

输入: [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数；
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
注意: 输入数组的长度不会超过 10000。
   */
  def nextGreaterElements(nums: Array[Int]): Array[Int] = {
    val n = nums.length
    val s = mutable.Stack[Int]()
    val res = new Array[Int](n)
    for (i <- Range(2 * n - 1, -1, -1)) {
      val j = i % n
      while (!s.isEmpty && s.top <= nums(j)) {
        s.pop()
      }
      res(j) = if (s.isEmpty) -1 else s.top
      s.push(nums(j))
    }
    res
  }

  /*
  239. 滑动窗口最大值
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。



进阶：

你能在线性时间复杂度内解决此题吗？



示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7


提示：

1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length
   */
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    val window = new MonotonicQueue()
    val res = ListBuffer[Int]()

    for (i <- 0 until nums.length) {
      if (i < k - 1) {
        window.push(nums(i))
      } else {
        window.push(nums(i))
        res.append(window.max)
        window.pop(nums(i - k + 1))
      }
    }
    res.toArray
  }

  class MonotonicQueue {
    val q = new util.LinkedList[Int]()

    def push(n: Int): Unit = {
      while (!q.isEmpty && q.getLast < n) {
        q.pollLast()
      }
      q.addLast(n)
    }

    def max(): Int = {
      q.getFirst
    }

    def pop(n: Int): Unit = {
      if (n == q.getFirst) {
        q.pollFirst()
      }
    }
  }

}

