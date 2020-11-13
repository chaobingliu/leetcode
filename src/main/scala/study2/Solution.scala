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
    reverseKGroup(n1, 2)

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
}
