package study2

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

    val codec = new Codec
    println(codec.serialize(codec.deserialize_pre("1,2,3,#,#,4,5")))

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
}
