import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random
import scala.util.control.Breaks


object Solutions {
  def main(args: Array[String]): Unit = {
    //    println("abc".last)
    //    val s = "abc"
    //    println(s.substring(0, s.length-1))
    //    println(isMatch("aab", "c*a**b")) // false
    //    println(isMatch("aa", "*a")) // false
    //    println(isMatch("aaa", "ab*a")) //false
    //    println(isMatch("aaa", "ab*a*c*a")) // true
    //    println(isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s")) // true
    //    println(isMatch("", "c*c*")) // true
    //    println(maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    //    println(letterCombinations("234"))
    //    val node1 = new ListNode(1)
    //    val node2 = new ListNode(2)
    //    val node3 = new ListNode(3)
    //    val node4 = new ListNode(4)
    //    val node5 = new ListNode(5)
    //    node1.next = node2
    //    node3.next = node4
    //    node4.next = node5
    //    var n = removeNthFromEnd(node1, 3)
    //    var n = mergeKLists(Array(node1, node3, node5))
    //    while (n != null) {
    //      println(n.x + " -> ")
    //      n = n.next
    //    }

    //    val arr = Array(-1, 0, 1, 2, -1, -4)
    //    val s = threeSum(arr)
    //    println(s)
    //    println(generateParenthesis(4))

    //        println(longestValidParentheses2("((())))()())))(((()()(())))((()(())()((()))())())())()())))))))(((()(())(()))(()()(()()((()))()(())(()(())))))()(())(()()(((()(()()))))((()()))))))()((()())()()))((())()((((()))()()()((()())))())((())))))))(()()((((((()))(((((((()()))((())()(()())()()()(()())(()())(())))()()))))()(((())(())(()())()))()(()))(())((()))))(())))()))((()((()(())(()()()()()))(())())()))))()(()(((())))()()()(((()((()))(()((((((())((()))(()(())(()))(())())))()()))))())(()((()()())()))((((()(()))()()))(()())))((()))(()((((()(())(())()((()))(()))())))(((()(())))((())()(()(((())))())())()()()())((()()))))))(()))(())()(((()))()()((()))(()))(((()))))))))(()(())())(()((())(()()))((())))(()())((((())))(()(()))())(((()(()((()(())((())())(()))(())))()()(())((()()))((()()((()()())())()))())()))())()))())(()(()))(()))()(())))((((())()())()()())((()())(()())(()()))()(())(())))))()()()((()(())(((()(())()()))(()()((()(((()))))))))(((()((()()((()(((((())((()((()((((((((())()))())((())((()((()(()((())(((()(()))())))))))))))))()((()(())())))()(()))(((()))())()(((()))))((()(())(()())(((()(((()((((())()))))(())((()(((((()((()(()()()()((()((((((((((((())()(()))()()(()())()(()(((()((()(()()()())))((())()))())()()))())(((()(())))))()()()(((())))((()(()(((())(())(()((((()(((()(())(((((())()))())())()()(()())((((()(())))((()())))))))))()(()(())))))))()))()())))((())(()()()()()()()(())(()())))))())((()()))))()))))((())((()(((()))))(((()()))()(()((()()())()))(((()(()((())(()(()(()()))()((()(())))()((())))))(())()(())()))((())(((((()))()())(())))((((()((())())(())))(())))))((())())())((((()((())))()()((()()()))()())())(()())(((()))()()))))(()(())(()))()())(()())(()))(((((((()(()))())()())()())((()(((((()())(((())))()())))(()(()(())()((())()))(())))())()))((((()))())((()))(())))))(()))))))(()))))(())))())()()())()()(())()()(((((()))(((()()))()(()((((()(()(()(())))())))())(()()())()(()))())(()()))(()()((()()))))))(())((()()))(())))())())(())((((()))))()))()))()()()))))((((()((())(()))(()()))(())()())(()())))(()(()(())((()())()((())(()))()))()))))((())))(())(()))()()()()()))((())(((()(())))(((((((()(()))(()))())()((()))(()(())((()((()((())))()()((())))))((((())()())(()()(((()()((()))()()((())))(((()())((((()(())())))())()()()(())()))))))()()((()))())(()(((()()))((())))())())())((((()(((()(())())()())((()((()(()((())()(()))()((())))()(()))))(((()))())())(()((()))))()()(((((()))())))(()(()(())((((())())))((()()())(((((((()(()(()))(())))))()))(()(((((())()))((()()()()((()))()(()()()()))(()))))())())()))()(()()(((())((()))(()())))((()()(((())())))))))(())))((()(()(((())((((()))))(()()()))))(((((((())(()(()))(()(())((())(()(()(()(()())(())()(())(()()(()(()))())(())()()(((()())(())(()(((()()(())()((((()()))())(((()(((((()())()(())))()))))(()(()()(()(()()(((()))()))((()())))()(()(())))))))())((((()()))(()))))()((()))(()))())()))()))))(()(())()()()))(((((()))()())())(()())())))()())))))()()()())))))(())(((()))((())((()()))))()((((()(()(()))))(()(())(((())(()()(((()(())()())(()()(()(()())))()())))(((()()((()())()()((()))()))(((()((((()(((()(((()(()())((()))))()(()())(())()(()(((())((()))(())()(())()(()(())()))())()))()())(()))))()))))((()()()((()(()()(())))())(())()(()()))))))))()((()))((((())))())))((()()()(()(()((((()((()))()()((())((())(()))))(())())(((()()(()))))))(()()))()))((()(()(())()))(((())()))(())(()((((()((()()()))()()))(()()(())())((((((())(())((()())()(()())))()))())(()()(()(()()()(()()()()))(()(()()())())((()()()(((()((()())()()((()()(()((()())()())()((()))(()((()())))))))(())((((())(((((())(((())(()))(((()((()()())()((()(()))()()()(()((((())))(())())))((())))(()(((((()()()((())((((((((()()((((())))())())())))))))(((()())(((()))())))()))((())())())))))))))(()()(((())))))(())()()))((())()))(()(()))((()(()((((()(()(((()))))()))(()(()))())())()()(((())())(((()))))(((()())))()(()())()())()))())())(()()(((()()))(())(((()((())((((())))))((()))))(()((()(())))()(())((()(())((()(()())())))()))))(())())(()())()()()((())))((()()))()()()((((()())))))()))))()))())()((()(())()()(())(((()((()))(()(()()))(()))()))))))))))))(()()))(((())((()(((()()()(()())((((()(()()()))())))())(()())))(()((((()))((()()())(((()))()())(()(()((()(()))))(())()()((()())((()(()(()))((()((()())(((()(((((()()()))(()()(()(((()(()())()()()))((()(()())))())(()(()))(())()())))()()()))()())(()(((((()))()()((((()()()()))()()(()((()))(()))))))))))()))()(()((((((())(()))()((())))(((((())))))(()))))()()(()()()(((((()))()())()((((()()))()(())())))(((()((())))))))))(()()()((()))(()())((())))()()((()())))()()(()))))))))()(((()(()))()())((((((())))(((()(()())())))(())())())()()((((()(()(((())(()()(((((()))(()(())()))))))()))()())))()()(()))(((()))()())))((())(((()()))((((((())))(((())()()(()((()))())(()((()()(((())())()))()()())())(()()((((((((())))()(((())(()))))()()())()(())))(((((()())(((())()()))))()((())())(())()(()(()()((()))()(()(((()))))()()())(())()()()(((()((()()()(()())())(())()(((((()())(())()((((()()()))()((())()((()(()(((()(()))()())())()())()(()()(()(((()))()(())(()())(())((())()((()()())(()))))()(()()))))((())()()((()((()()(()((()()())(())))))())))()))))(((((()(()())(()))((()))()(()())())())))()(()()(()((())))))()()))((())((((()))))())((()))())((())((()(()((()))()()()))()((((((())((((((()((((((((()))(()(((()(((((((((())(())())()())))))))())())))()))(()))))()(()))(())))()()()((()()))(())(()))(()()(()())))()(()()()()())))(())((((()))(((((())(()(((((())((()((((()))(((((()))(()())()))))())()))()(()()))((((()))()())(())))()((())))(((((()()((()()((()))))()((())())()))(((((((((()((())((((())()())))(())())()))())))())()))()(()()(()))(()()()((())((()))())))()(()())()(((((((()))))(()()()((()(())))())()))((())())(()(()(())()()())))))(()()()))())()))()())(((())(())))()(())())))()((()(()(())()()()((()))()))((())((((()((((((()()()))()))())())))))()(())(()())))()(((()())(((())))((())()()))((())())()()(()()())()))())(((()((()(((()())(()(())(((())))()))))))())()((((((()))))))()(()))()))())))())((((())(())()(())()))()))((((((((()()(())())((((())))((((()(())()()(())()))())()))(((()((()))()(((((()()()))))(()(()())))(((()(((()(())())((((())(()((()((()(()()(()()))()))()()))()))))))())()(())())))(((())))((()))((()(())())((())))((()))()))(((()))))(()())()())())()())))())))(())))(())())()((()())()()))((()()())(((((()())))())))()()()((((((())())()((())()))(()))()(()())()())(())()())((()((())(())()()()()((())(()())()()((())))()(((()(()(((((()(())))()(()))()(()))()))())()))()())()(()))))()()())(((())((()((())(()(()))()((()))))))(())(()(())())()()((())((())((((())))))(()()())(()()())(())())(((()()(())(())))()()))(())))))())(())()(((())())))((()(((())))(()((())()))()))((()()())()(((((())((((())))(())()()((()()(()()))(()((()))((())())))))))()())))())())((()(()()()()()))))()))((())(((((()())(()))((())))((()(())))))))))(((())(()(())(()(())((()((()))()((())())()())()((()(())())()(((()()((()(()())))))())((())(((()())(((()(()((())((()(((())(()()((((((()))())))())(()(()(()()())())((()))((())(())(())())))()(()())()))())(())((((())()((())))))(()()((())(((((()))()()))()()())(()(((()))())()()()))(((()()))(()(()((())(())))()()((((()()))()(())()())()()()()()(()()))(((())(((()()()((((((((((()()()(((()))))))())))()(((((((()((((((((()))()(((())())())())((((((()()))(()))()))))(())()())))())(()))(((())()()()((()()((())(()))((()(()())))()(()((()((())()()()()(())()()((())())())()()))()()))))((()()((())(((())(())())))((())())())(()))))())))))()((()(()(()))))()))((((())((())())(()))))()((()))(())((()()))()()((())(())())))(())))))()()(()())((()(())(((()((())))()())))()))()))))(())()(()))((()()()()))(())))(()()(())(((()(((()()))()((()))())()))(()(()))())))))))()((()(()))(((())())(())(()))(())(()((()))))))(()())(()()()(((()(((((()))((()))))(()))(())())(((()(()())(()()()()))())(()((()(()))()))())))(((()(()))))()))(()()((())())(()()())((()))(())))()()))(())))())))(()((())((()))((()))))())()()()((((((())((())()))(()))(())(())())))()())()((())))((()()())(()))(((()))())())))(())(())())()())()))((((()()()()))(())))((((())))(())(()((((()))())()))))))()()()))())))()((())))))((())())))()()(()()(()(()()()())((((())))(())(((())(()(()((((())(()()()(()(()((())(())(()())((((()((()((((((()((((())(((()())()((((()((())()(()(()(()((()()()(()(()())(((()(())(()(())(())(()))()((((((((()()(())))(()()(((())()(()(((((()())((()(())()())(((()(()(())()((((((((())()((()()((((())(((()(()((()((((()((((()(()(())())()(((()()))))))(()(((())()(((()())))((()))))(()()))))(()))))))((())())((())))()()()(()((()))()))()))()()()()()))(((((((()((()))((())()(()(()))()((((((((((((()(())))))(()())))()(()()(()(()()))))(((((()()((())()))())()()()))(())())()())()()((()()(()(()()(()))))))()()))(()()((()))))()((()()()())))(((()(((()()(())(())(()(((())(()((()(()))(()()((())()(()()())()))))))(()()((())((()())))(())(()))()(()))(()))()))()(())()(()())))(()))(()()(((()))))())))))((())())))))()()()))(()))((()())())()()))(((())((()((())()(()))()((()))()(())))))))()()())())))(()()(())(()))(())))))()(()))(()()))))))))((((()()()()()))(()))((()((())))(()())(((()()()(())))))()))()())())(()()()))))))((()())))((())))(())()((()))()(()())())))))(((()()(()(())()())(((((()))((()(())(())))))))()()))))))((()((((()()))()))(()()))(()()(())))))(((()()))(()())))(())()((()((()(((()()()()((()())())(()(((((((()((((())(()((((()()(())))))(()())))))(()())))())(())))((()(()))(()())(((())))((((())))))((()))()(((((((())())())((())))))))(()))))))))()((()()())((())))(())))((()(((()(())(())))()()()()))(())(()(())()())(())))()())((()((()((()()((())())))(()((())()()))()))((()()(()))(((((((()))((())((())((())()()((((((((()())()()()))(()()(((()(())()))()))()))()()(()(((((()))))((())(((()))()((((((((()()()()(()))()(()))()(())))))))()((((()()((()(())()((()))((()()(()()))))))))))(())(()))()()((((())))()((())(()((()((()(())()))()()((((()))))()))())))))())(((()()))()))()(()))(()))()((()((((((())())))()))()((())(()(())))))))()))(()()()())())()))((()))(()((()((()())))))((((())()()())(())())()((()((()())()())()(()))))((()())))()))()()))))()((())))())(()))()))(()((())(()))))()()))(()()((((()()))(((()()())(()(()(((()))())))((((()())()()()(())()()()((()))))((()()(()()))()())))(((((()(())())))))(()))))())))(())())()))))((()))))))(((())(((())()(((())))(()))()())(((()(()(((()))))()(()()(())())))))())())()()((())))()(())((()))((())(()())(()()()(()()())((())())))))((()(()())()()))))(()()(()()()(()()))((((((()))(()())(())(())())((())(()(()))((()()(()))))()))()(())))())))())(()((())))((())(()()()(()))((()((((((()())()()))))()))((()((())()))()((((()()()(((())())))()()()())())())(()())()))()(())(())()))())((()(((((()))(())(((((()))(()())(()(()(())()((()(()(()))()(()))))()(((())(()((((((()))(()(((()()())()())((()())))((()((()())()((((((())()))(()))))(()()()()))())())((((((((())((((()()()))(())()()))(()(()()(()(()))))(()))(()()()(())()()(())(()))())((()()((()(()))()))))())((()())())(((((()(()()))((()()()))()()(()(()(((()())(((((((((()))()())(()(()(())(((((()()))))(()())(()())())(())))))((()))())(((()((((()))()))(()(()(((()()(()(((()()))(())))((((()(()()))))((((()()())()))())()))))((())((((((())()()))()))()(((()((())(()((((()())())((((((((((()(((((()())()()(()))))))()((((())())(((()()((((()()())()(((((())))()))(())())(((()(((())()))()()()()(())))(()(((()(()))())))()(((()()()()()(()(((()(((()))()(())(())()()))()((()))))))()(((((()(()()((())(())((())))()(()())(())))())((())(()(()()(((())((()()(()()((()))))())))()(()))()))))))())())))((((((()())))(())(()))()()))()(())))))))((()))(()()()()))()())()()()()))()()())))))))((())(())))(()))(())((()())))(()(((()))((((())())))(())((())())))))(((()())(())()(())))((()()()((()(()))()))(())))((()(()()((()()()))((()))((()))()))(()())()()(((((((((()(()))()())()((())((((((((()(())()(((()((())()((((((((()))())))(()((()((())())())((()()())))(()(()((((((()))))((((())))((()()(())()())()()())(())(((()(()()(())(((())((((())()()(()()(((())()(())((()(()(((()(()())))()))((()()())(())))))(()(()))()))()(()))))(()((()))()())(())(())(()))((()())()))())()())((((()))))())())(((()))(((()()((()((())(())()()))))(((()((((()(((((((((())()()()(())((()(()()(()()(()()(())()())(((((()))))()(())(((()((((()())(()(((()))))()))())((((()()((()(()))))((())(())(()(()))()()(((()))(((((((((()())))((())()(()(((((((()))))))()()(())(((()(()())()()))((()()))((((()(())())))((()())))))()))))))))()()(((())())((()))())((())((()()))())((((((((())((()((())())))))()()))))))()()(())))))()))()()(((()))))(())((((()()()()))((()((((()()(())(((((()())()))))))())())()((((((((((()))()))((()))(())())(()(()(())((()()(()((())(())((((())(()()(()((()((()(((((()(()()((((())(())())(()()())()())((()(())()(())()))))") )

    //    println(longestValidParentheses2(""))
    //        val arr = Array(5, 4, 7, 5, 3, 2) // 5,5,2,3,4,7
    //        val arr = Array(1, 2, 3) // 1, 3, 2
    //    val arr = Array(1, 3, 2) // 2, 1, 3
    //    val arr = Array(2, 1, 3) // 2,3,1
    //    val arr = Array(2, 2, 7, 5, 4, 3, 2, 2, 1)
    //    println("before: " + arr.mkString(","))
    //    nextPermutation(arr)
    //    println("after: " + arr.mkString(","))
    //    println(isValid(""))
    //    println(search(Array(4, 5, 6, 0, 1, 2, 3), 2))
    //    println(searchRange(Array(2, 2), 1).mkString(" "))
    //    println(combinationSum(Array(2, 3, 6, 7), 7))
    //    println(trap(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    //        println(permute(Array(1, 2, 3)))
    //    val t = Array.ofDim[Int](3, 3)
    //    t(0)(0) = 1
    //    t(0)(1) = 2
    //    t(0)(2) = 3
    //    t(1)(0) = 4
    //    t(1)(1) = 5
    //    t(1)(2) = 6
    //    t(2)(0) = 7
    //    t(2)(1) = 8
    //    t(2)(2) = 9
    //    rotate(t)
    //    for (i <- 0 until t.length) {
    //      println(t(i).mkString(" "))
    //
    //    }
    //    println(groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat")))
    //    println(maxSubArray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    //    println(canJump(Array(1))) // true
    //    println(canJump(Array(0))) // true
    //    println(canJump(Array(2, 0))) // true
    //    println(canJump(Array(3, 2, 1, 0, 4))) // false
    //    println(canJump(Array(1, 2))) // true
    //    println(canJump(Array(3, 2, 1, 0, 4))) // false
    //    println(canJump(Array(0, 2, 3))) // false
    //    println(canJump(Array(2, 0, 0))) // true
    //[[1,3],[2,6],[8,10],[15,18]]
    //    merge(Array(Array(1,3), Array(2,6), Array(8,10), Array(15,18)))
    //    val t = merge(Array(Array(2, 3), Array(4, 5), Array(6, 7), Array(8, 9), Array(1, 10)))
    //    for (a <- t) {
    //      println(a.mkString(" "))
    //    }
    //    println(uniquePaths(3, 7))
    //    println(minPathSum(Array(Array(1,3,1), Array(1,5,1), Array(4,2,1))))
    //    println(climbStairs(3))
    //    println(minDistance("horse", "ros"))
    //    val arr =Array(1,0)
    //    sortColors(arr)
    //    println(arr.mkString(" "))
    //    minWindow("ADOBECODEBANC", "ABC")
    //    subsets(Array(1, 2, 3))
    //    println(minWindow("ADOBECODEBANC", "ABC"))
    //    println(exist(Array(Array('A', 'B', 'C', 'E'), Array('S', 'F', 'C', 'S'), Array('A', 'D', 'E', 'E')), "SEE"))
    //    println(largestRectangleArea(Array(2, 1, 5, 5, 2, 3)))
    //    println(maximalRectangle(Array(Array('1', '0', '1', '0', '0'), Array('1', '0', '1', '1', '1'), Array('1', '1', '1', '1', '1'), Array('1', '0', '0', '1', '0'))))
    //    val list: List[String] = List("a", "b", "a")
    //    //为列表预添加元素
    //    println("A" +: list)
    //    //在列表开头添加元素
    //    println("c" :: list)
    //    //在列表开头添加指定列表的元素
    //    println(List("d", "e") ::: list)
    //    //复制添加元素后列表
    //    println(list :+ "1")

    //    val A = new TreeNode(0)
    //    val B = new TreeNode(2)
    //    val C = new TreeNode(3)
    //    val F = new TreeNode(3)
    //    val G = new TreeNode(4)
    //    val H = new TreeNode(6)
    //        A.left = B
    //        A.right = C
    //    B.left = F
    //    B.right = G
    //    C.right = H

    //
    //    println(inorderTraversal(A))
    //    println(numTrees2(19))
    //    println(isValidBST(A))
    //    buildTree(Array(4,1,2,3), Array(1,2,3,4))
    //    flatten(A)
    //    println(maxProfit(Array(7, 1, 5, 3, 6, 4)))
    //    println(maxPathSum(A))
    //    println(longestConsecutive(Array(0, 0)))
    //    println(singleNumber(Array(4, 1, 2, 1, 2)))
    //    println(wordBreak("penapple", List("pen", "apple")))
    //        val node1 = new ListNode(1)
    //        val node2 = new ListNode(2)
    //        val node3 = new ListNode(2)
    //        val node4 = new ListNode(1)
    //        node1.next = node2
    //        node2.next = node3
    //        node3.next = node4
    //    println(detectCycle(node1).x)
    //    sortList(node1)
    //    println(maxProduct(Array(-2, 3, -4)))
    //    val a = new ListNode(3)
    //    val d = new ListNode(2)
    //    d.next = a
    //    getIntersectionNode(a, a)
    //    println(rob(Array(1, 2, 3, 1)))
    //    println(numIslands(Array(Array('1', '1', '1', '1', '0'), Array('1', '1', '0', '1', '0'), Array('1', '1', '0', '0', '0'), Array('0', '0', '0', '0', '0'))))
    //    val a = new ListNode(3)
    //    val b = new ListNode(2)
    //    val d = new ListNode(1)
    //    a.next = b
    //    b.next = d
    //    println(reverseList(a))
    //    println(canFinish(3, Array(Array(1, 0), Array(2, 1))))
    //    println(findKthLargest(Array(3, 2, 1, 5, 6, 4), 2))
    //    val node1 = new ListNode(1)
    //    val node2 = new ListNode(2)
    //    val node3 = new ListNode(2)
    //    val node4 = new ListNode(1)
    //    val node5 = new ListNode(1)
    //    node1.next = node2
    //    node2.next = node3
    //    node3.next = node4
    //    node4.next = node5
    //    println(isPalindrome(node1))
    //    println(maximalSquare(Array(Array('1', '0', '1', '0', '0'), Array('1', '0', '1', '1', '1'), Array('1', '1', '1', '1', '1'), Array('1', '0', '0', '1', '0'))))

    //
    //    val A = new TreeNode(0)
    //    val B = new TreeNode(2)
    //    val C = new TreeNode(3)
    //    val F = new TreeNode(4)
    //    val G = new TreeNode(5)
    //    val H = new TreeNode(6)
    //    A.left = B
    //    //    A.right = C
    //    //    B.left = F
    //    //    B.right = G
    //    //    C.right = H
    //    println(lowestCommonAncestor2(A, B, A).value)
    //    println(Range(3, -1, -1).map(println))
    //    maxSlidingWindow(Array(1, 3, -1, -3, 5, 3, 6, 7), 2).foreach(println)
    //    println(searchMatrix(Array(Array(1, 4, 7, 11, 15), Array(2, 5, 8, 12, 19), Array(3, 6, 9, 16, 22), Array(10, 13, 14, 17, 24), Array(18, 21, 23, 26, 30)), 5))
    //    println(searchMatrix(Array(Array(-1, 3)), 1))
    //    println(numSquares(7))
    //    println(twoSum(Array(2, 7, 11, 15), 9))
    //    println(longestPalindrome("bb"))
    //    println(lengthOfLIS(Array(4, 10, 4, 3, 8, 9)))
    //    removeInvalidParentheses(")(").foreach(println)
    //    println(findMedianSortedArrays(Array(2), Array()))
    //    println(maxCoins(Array(3, 1, 5, 8)))
    //    println(coinChange(Array(1, 2, 5), 11))
    //    countBits(5).foreach(println)
    //    topKFrequent(Array(4, 1, -1, 2, -1, 2, 3), 2).foreach(println)
    //    println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"))
    //    calcEquation(List(List("a", "b"), List("b", "c")), Array(2.0, 3.0), List(List("a", "c"), List("b", "a"), List("a", "e"), List("a", "a"))).foreach(println)
    //    reconstructQueue(Array(Array(7, 0), Array(4, 4), Array(7, 1), Array(5, 0), Array(6, 1), Array(5, 2)))
    println(canPartition(Array(1, 2, 3, 4)))
    //    pathSum(new TreeNode(1), 1)
    //    println(findAnagrams("baa", "aa"))
    //    println(findDisappearedNumbers(Array(4, 3, 2, 7, 8, 2, 3, 1)))
    //    println(hammingDistance(1, 4))
    //    println(findTargetSumWays(Array(1, 1, 1, 1, 1), 3))
    //    [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
    val a4 = new TreeNode(4)
    val b1 = new TreeNode(1)
    val c6 = new TreeNode(6)
    val d0 = new TreeNode(0)
    val e2 = new TreeNode(2)
    val f5 = new TreeNode(5)
    val g7 = new TreeNode(7)
    val h3 = new TreeNode(3)
    val i8 = new TreeNode(8)
    a4.left = b1
    a4.right = c6
    b1.left = d0
    b1.right = e2
    c6.left = f5
    c6.right = g7
    e2.right = h3
    g7.right = i8
    convertBST(a4)
//    convertBST2(a4)
    //    [5,4,8,11,null,13,4,7,2,null,null,5,1]
    //    val a = new TreeNode(5)
    //    val b = new TreeNode(4)
    //    val c = new TreeNode(8)
    //    val d = new TreeNode(11)
    //    val e = new TreeNode(13)
    //    val f = new TreeNode(4)
    //    val g = new TreeNode(7)
    //    val h = new TreeNode(2)
    //    val i = new TreeNode(5)
    //    val j = new TreeNode(1)
    //    a.left = b
    //    a.right= c
    //    b.left = d
    //    c.left = e
    //    c.right = f
    //    d.left = g
    //    d.right = h
    //    f.left = i
    //    f.right = j
    //    println(pathSum(a, 22))

  }

  /*
1. 两数之和G
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。



示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map: mutable.Map[Int, Int] = mutable.Map[Int, Int]()
    for (i <- 0 until nums.length) {
      if (map.contains(target - nums(i))) {
        return Array(i, map(target - nums(i)))
      }
      map.put(nums(i), i)
    }
    Array[Int]()
  }

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  /*
  2. 两数相加
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
   */
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var node1 = l1
    var node2 = l2
    var retNode: ListNode = null
    var curNode: ListNode = null
    var carry: Int = 0

    while (node1 != null || node2 != null) {
      val x1 = if (node1 == null) 0 else node1.x
      val x2 = if (node2 == null) 0 else node2.x
      val sum = x1 + x2 + carry
      carry = sum / 10
      if (retNode == null) {
        retNode = new ListNode(sum % 10)
        curNode = retNode
      } else {
        curNode.next = new ListNode(sum % 10)
        curNode = curNode.next
      }
      node1 = if (node1 == null) null else node1.next
      node2 = if (node2 == null) null else node2.next
    }
    if (carry > 0) {
      curNode.next = new ListNode(carry)
    }
    retNode
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
    if (s == null)
      return 0
    val set: mutable.Set[Char] = mutable.Set[Char]()
    val len = s.length
    var maxLength = 0
    var rk = 0
    for (i <- 0 until len) {
      if (i != 0) {
        set.remove(s.charAt(i - 1))
      }
      while (rk < len && !set.contains(s.charAt(rk))) {
        set.add(s.charAt(rk))
        rk += 1
      }
      maxLength = Math.max(maxLength, set.size)

    }
    maxLength
  }

  /*
  4. 寻找两个正序数组的中位数
给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。

进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？



示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
示例 3：

输入：nums1 = [0,0], nums2 = [0,0]
输出：0.00000
示例 4：

输入：nums1 = [], nums2 = [1]
输出：1.00000
示例 5：

输入：nums1 = [2], nums2 = []
输出：2.00000


提示：

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

   */
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val m = nums1.length
    val n = nums2.length
    if (m > n) {
      return findMedianSortedArrays(nums2, nums1)
    }

    var left = 0
    var right = m
    var median1, median2 = 0

    while (left <= right) {
      val i = (left + right) / 2
      val j = (m + n + 1) / 2 - i

      val leftMin = if (i == 0) Int.MinValue else nums1(i - 1)
      val leftMax = if (i == m) Int.MaxValue else nums1(i)
      val rightMin = if (j == 0) Int.MinValue else nums2(j - 1)
      val rightMax = if (j == n) Int.MaxValue else nums2(j)

      if (leftMin <= rightMax) {
        median1 = Math.max(leftMin, rightMin)
        median2 = Math.min(leftMax, rightMax)
        left = i + 1
      } else {
        right = i - 1
      }
    }
    if ((m + n) % 2 == 0) (median1 + median2) / 2.0 else median1
  }

  /*
  5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
   */
  def longestPalindrome(s: String): String = {
    val len = s.length
    val dp: Array[Array[Boolean]] = Array.ofDim[Boolean](len, len)
    var maxStr: String = ""
    for (k <- 0 until len) {
      for (i <- 0 until len; if (i + k) < len) {
        val j = k + i
        if (k == 0) {
          dp(i)(j) = true
        } else if (k == 1) {
          dp(i)(j) = s.charAt(i) == s.charAt(j)
        } else {
          dp(i)(j) = s.charAt(i) == s.charAt(j) && dp(i + 1)(j - 1)
        }
        if (dp(i)(j) && (k + 1) > maxStr.length) {
          maxStr = s.substring(i, j + 1)
        }
      }
    }
    maxStr
  }

  /*
  10. 正则表达式匹配
给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false

   */
  def isMatch(s: String, p: String): Boolean = {
    if (s == p || p == ".*" || (p == "." && s.length == 1) || (s.isEmpty && (p.length == 2 && p.last == '*')) || s + "*" == p) {
      return true
    }
    if (p.isEmpty || (s.length == 1 && p.length == 1)) {
      return false
    } else if (s.isEmpty) {
      if (p.last == '*' && p.length > 1) {
        return isMatch(s, p.substring(0, p.length - 2))
      } else {
        return false
      }
    }
    val pl = p.last
    val sl = s.last

    if (sl == pl || pl == '.') {
      isMatch(s.substring(0, s.length - 1), p.substring(0, p.length - 1))
    } else if (pl == '*') {
      val preChar: Char = p.charAt(p.length - 2)
      // 当P为*时，S可能匹配一次，匹配0次，匹配多次
      // isMatch(s, p.substring(0, p.length - 2)) 匹配0次
      // isMatch(s.substring(0, s.length-1), p.substring(0, p.length-2)) 匹配1次
      // isMatch(s.substring(0, s.length - 1), p) 匹配多次
      if (preChar == sl || preChar == '.') {
        isMatch(s, p.substring(0, p.length - 2)) || isMatch(s.substring(0, s.length - 1), p.substring(0, p.length - 2)) || isMatch(s.substring(0, s.length - 1), p)
      } else {
        isMatch(s, p.substring(0, p.length - 2))
      }
    }
    else {
      false
    }
  }

  /*
  给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

 



图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

 

示例：

输入：[1,8,6,2,5,4,8,3,7]
输出：49

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  def maxArea(height: Array[Int]): Int = {
    var head = 0
    var tail = height.length - 1
    var maxA = 0
    while (head < tail) {
      if (height(head) < height(tail)) {
        maxA = Math.max(height(head) * (tail - head), maxA)
        head += 1
      } else {
        maxA = Math.max(height(tail) * (tail - head), maxA)
        tail -= 1
      }
    }
    maxA
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
0 = -4
1 = -1
2 = -1
3 = 0
4 = 1
5 = 2

   */
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val buffer: ListBuffer[List[Int]] = new ListBuffer[List[Int]]()
    val newNums = nums.sorted
    val loop = new Breaks
    for (i <- 0 until newNums.length) {
      if (i == 0 || newNums(i) != newNums(i - 1)) {
        for (j <- i + 1 until newNums.length) {
          if (j == (i + 1) || newNums(j) != newNums(j - 1)) {
            loop.breakable {
              for (k <- Range(newNums.length - 1, j, -1)) {
                val temp = newNums(i) + newNums(j) + newNums(k)
                if (temp < 0) {
                  loop.break()
                }
                if (temp == 0) {
                  buffer.append(List(newNums(i), newNums(j), newNums(k)))
                  loop.break()
                }
              }
            }
          }
        }
      }
    }
    buffer.toList
  }

  /*
  17. 电话号码的字母组合
  给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

  给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



  示例:

  输入："23"
  输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
  说明:
  尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
   */
  def letterCombinations(digits: String): List[String] = {
    val maps = Map[Char, Array[String]](
      '1' -> Array[String]("!", "@", "#"), '2' -> Array[String]("a", "b", "c"), '3' -> Array[String]("d", "e", "f"),
      '4' -> Array[String]("g", "h", "i"), '5' -> Array[String]("j", "k", "l"), '6' -> Array[String]("m", "n", "o"),
      '7' -> Array[String]("p", "q", "r", "s"), '8' -> Array[String]("t", "u", "v"), '9' -> Array[String]("w", "x", "y", "z")
    )

    if (digits.isEmpty) return List[String]()
    val buffer: ListBuffer[Array[String]] = new ListBuffer[Array[String]]()

    for (c <- digits) {
      buffer.append(maps(c))
    }

    buffer.reduce((A, B) => {
      for (a <- A; b <- B) yield {
        a + b
      }
    }).toList
  }

  /*
  19. 删除链表的倒数第N个节点
  给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

  示例：

  给定一个链表: 1->2->3->4->5, 和 n = 2.

  当删除了倒数第二个节点后，链表变为 1->2->3->5.
  说明：

  给定的 n 保证是有效的。

  进阶：

  你能尝试使用一趟扫描实现吗？
   */
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    var node = head
    val buffer: ListBuffer[ListNode] = new ListBuffer[ListNode]()

    while (node != null) {
      buffer.append(node)
      node = node.next
    }
    if (buffer.size == 1 && n == 1) {
      null
    } else if (buffer.size == 2) {
      if (n == 2) {
        buffer(0).next = null
        buffer(1)
      } else {
        buffer(0).next = null
        buffer(0)
      }
    } else {
      if (n == 1) {
        buffer(buffer.size - 2).next = null
      } else if (n == buffer.size) {
        head.next = null
        return buffer(1)
      } else {
        val preNode = buffer(buffer.size - n - 1)
        val nextNode = buffer(buffer.size - n + 1)
        preNode.next = nextNode
      }
      head
    }
  }

  /*
 20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
   */

  def isValid(s: String): Boolean = {
    if (s.length % 2 == 1) {
      return false
    }
    val map = Map((')', '('), (']', '['), ('}', '{'))
    val stack = mutable.Stack[Char]()
    for (c <- s) {
      if (stack.isEmpty) {
        if (map.keySet.contains(c)) {
          return false
        }
        stack.push(c)
      } else {
        if (stack.top == map.getOrElse(c, ' ')) {
          stack.pop()
        } else {
          stack.push(c)
        }
      }
    }
    stack.isEmpty
  }

  /*
  21. 合并两个有序链表
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。



示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
   */
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    var node1 = l1
    var node2 = l2
    var retNode: ListNode = null
    var retCurNode: ListNode = null

    if (node1 == null) {
      node2
    } else if (node2 == null) {
      node1
    } else {
      while (node1 != null && node2 != null) {
        if (retNode == null) {
          retNode = new ListNode()
          retCurNode = retNode
        } else {
          retCurNode.next = new ListNode()
          retCurNode = retCurNode.next
        }
        if (node1.x < node2.x) {
          retCurNode.x = node1.x
          node1 = node1.next
        } else {
          retCurNode.x = node2.x
          node2 = node2.next
        }
      }
      if (node1 != null)
        retCurNode.next = node1
      if (node2 != null)
        retCurNode.next = node2
      retNode
    }
  }

  /*
  22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。



示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
   */
  def generateParenthesis(n: Int): List[String] = {
    if (n == 0) {
      List[String]()
    } else {
      val arr = new Array[ListBuffer[String]](n)
      arr(0) = ListBuffer("()")
      for (i <- 1 until n) {
        val buffer = new ListBuffer[String]()
        buffer.append(arr(i - 1)(0) + "()")
        val preList = arr(i - 1)
        for (str <- preList) {
          for (j <- 0 until str.length) {
            if (str.charAt(j) == ')') {
              var temp = str.substring(0, j) + "()" + str.substring(j)
              if (!buffer.contains(temp)) {
                buffer.append(temp)
              }
            }
          }
        }
        arr(i) = buffer
      }
      arr(n - 1).toList
    }
  }

  /*
  23. 合并K个升序链表
给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。



示例 1：

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
示例 2：

输入：lists = []
输出：[]
示例 3：

输入：lists = [[]]
输出：[]


提示：

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4
   */
  def mergeKLists(lists: Array[ListNode]): ListNode = {
    if (lists.isEmpty || (lists.length == 1 && lists(0) == null))
      return null
    lists.reduce(mergeTwoLists)
  }

  /*
  31. 下一个排列
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

   */
  def nextPermutation(nums: Array[Int]): Unit = {
    if (nums.isEmpty)
      return
    for (i <- Range(nums.length - 1, -1, -1); if (i - 1) >= 0) {
      if (nums(i - 1) < nums(i)) {
        if (i == nums.length - 1) {
          val temp = nums(i - 1)
          nums(i - 1) = nums(i)
          nums(i) = temp
          return
        }
        for (j <- i until nums.length) {
          if (j == nums.length - 1 || nums(i - 1) >= nums(j + 1)) {
            val temp = nums(i - 1)
            nums(i - 1) = nums(j)
            nums(j) = temp
            // 调换顺序后正序排序
            var mh = i
            var mt = nums.length - 1
            while (mh < mt) {
              val t = nums(mh)
              nums(mh) = nums(mt)
              nums(mt) = t
              mh += 1
              mt -= 1
            }
            return
          }
        }
      }
    }
    var head = 0
    var tail = nums.length - 1
    while (head < tail) {
      val temp = nums(head)
      nums(head) = nums(tail)
      nums(tail) = temp
      head += 1
      tail -= 1
    }
  }

  /*
  32. 最长有效括号
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
   */
  // 动态规划法 ，推荐使用
  // 动态转移方程： dp(i) = dp(i-1) + dp(i-di(i-1)-1-1) + 2
  // 该方程的使用条件： 当dp(i)为 ')' 时，判断 dp(i-dp(i-1)-1)的位置是否为'('
  // 同时还需要考虑dp(i-dp(i-1)-1-1 前的最长有效子串
  def longestValidParentheses(s: String): Int = {
    if (s.isEmpty)
      return 0
    val dp: Array[Int] = new Array[Int](s.length)
    for (i <- 1 until dp.length) {
      if (s.charAt(i) == ')') {
        val t = i - dp(i - 1) - 1
        if (t >= 0 && s.charAt(t) == '(') {
          if (t - 1 >= 0) {
            dp(i) = dp(i - 1) + 2 + dp(t - 1)
          } else {
            dp(i) = dp(i - 1) + 2
          }
        }
      }
    }
    dp.max
  }

  // 最传统的方法，效率极差，非常不推荐使用
  def longestValidParentheses2(s: String): Int = {
    var maxValid = 0
    val loop = new Breaks
    for (i <- 0 until s.length; if (s.charAt(i) == '(')) {
      if (maxValid >= s.length - i) {
        return maxValid
      }
      loop.breakable {
        for (j <- Range(s.length, i, -1); if (s.charAt(j - 1) == ')' && (j - i) % 2 == 0)) {
          if (maxValid < j - i) {
            if (isValid(s.substring(i, j))) {
              maxValid = if (maxValid < j - i - 1) j - i else maxValid
              loop.break()
            }
          } else {
            loop.break()
          }
        }
      }
    }
    maxValid
  }

  /*
  33. 搜索旋转排序数组
给你一个升序排列的整数数组 nums ，和一个整数 target 。

假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。

请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。


示例 1：

输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
示例 2：

输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
示例 3：

输入：nums = [1], target = 0
输出：-1


提示：

1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
nums 中的每个值都 独一无二
nums 肯定会在某个点上旋转
-10^4 <= target <= 10^
   */
  def search(nums: Array[Int], target: Int): Int = {
    val len = nums.length
    if (len == 0) {
      return -1
    } else if (len == 1) {
      return if (nums(0) == target) 0 else -1
    } else {
      var head = 0
      var tail = len - 1
      while (head <= tail) {
        val mid = (head + tail) / 2
        if (nums(mid) == target) {
          return mid
        }
        if (nums(0) <= nums(mid)) {
          if (nums(0) <= target && target < nums(mid)) {
            tail = mid - 1
          } else {
            head = mid + 1
          }
        } else {
          if (nums(mid) < target && target <= nums(len - 1)) {
            head = mid + 1
          } else {
            tail = mid - 1
          }
        }
      }
      -1
    }
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
    val len = nums.length
    if (len == 0)
      return Array(-1, -1)
    if (len == 1) {
      return if (nums(0) == target) Array(0, 0) else Array(-1, -1)
    }
    if (target < nums(0) || target > nums(len - 1)) {
      return Array(-1, -1)
    }
    var head = 0
    var tail = len - 1
    while (head <= tail) {
      val mid = (head + tail) / 2
      if (nums(mid) < target) {
        head = mid + 1
      }

      if (nums(mid) > target) {
        tail = mid - 1
      }

      if (nums(head) < target) {
        head += 1
      } else if (nums(tail) > target) {
        tail -= 1
      } else {
        if (target == nums(head) && target == nums(tail)) {
          return Array(head, tail)
        }
      }
    }
    Array(-1, -1)
  }

  /*
  39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。
示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]


提示：

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500
   */

  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    val buffer: ListBuffer[List[Int]] = new ListBuffer[List[Int]]()
    dfs(candidates, target, List(), 0, buffer)
    buffer.toList
  }

  def dfs(candidates: Array[Int], target: Int, combine: List[Int], idx: Int, buffer: ListBuffer[List[Int]]) {
    // 选 idx元素
    val temp = target - candidates(idx)
    if (temp == 0) {
      buffer.append(combine.::(candidates(idx)))
    } else if (temp > 0) {
      dfs(candidates, temp, combine.::(candidates(idx)), idx, buffer)
    }
    if (idx + 1 < candidates.length) {
      dfs(candidates, target, combine, idx + 1, buffer)
    }
  }

  /*
  42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
   */
  def trap(height: Array[Int]): Int = {
    if (height.isEmpty)
      return 0
    val len = height.length
    val leftMaxArr: Array[Int] = new Array[Int](len)
    val rightMaxArr: Array[Int] = new Array[Int](len)

    leftMaxArr(0) = height(0)
    rightMaxArr(len - 1) = height(len - 1)

    for (i <- 1 until len) {
      leftMaxArr(i) = Math.max(leftMaxArr(i - 1), height(i))
      rightMaxArr(len - i - 1) = Math.max(height(len - i - 1), rightMaxArr(len - i))
    }

    var sum = 0
    for (i <- 0 until len) {
      sum += Math.min(leftMaxArr(i), rightMaxArr(i)) - height(i)
    }

    sum
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
    val len = nums.length
    if (len == 0) {
      return List[List[Int]]()
    }
    val list: ListBuffer[Int] = new ListBuffer[Int]()
    val used: Array[Boolean] = new Array[Boolean](len)

    dfs(nums, 0, list, used, buffer)
    buffer.toList
  }

  def dfs(nums: Array[Int], depth: Int, list: ListBuffer[Int], used: Array[Boolean], buffer: ListBuffer[List[Int]]): Unit = {
    if (depth == nums.length) {
      buffer.append(list.toList)
      return
    }
    for (i <- 0 until used.length) {
      if (!used(i)) {
        used(i) = true
        list.append(nums(i))
        dfs(nums, depth + 1, list, used, buffer)
        list.remove(list.length - 1)
        used(i) = false
      }
    }
  }

  /*
  48. 旋转图像
给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:

给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
示例 2:

给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
   */
  def rotate(matrix: Array[Array[Int]]): Unit = {
    val len = matrix.length - 1
    for (i <- 0 until (len + 2) / 2) {
      for (j <- 0 until (len + 1) / 2) {
        val temp = matrix(i)(j)
        matrix(i)(j) = matrix(len - j)(i)
        matrix(len - j)(i) = matrix(len - i)(len - j)
        matrix(len - i)(len - j) = matrix(j)(len - i)
        matrix(j)(len - i) = temp
      }
    }
  }

  /*
  49. 字母异位词分组
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
   */
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    val len = strs.length
    if (len == 0) {
      return List[List[String]]()
    }
    val buffer: ListBuffer[List[String]] = new ListBuffer[List[String]]()
    val map: mutable.Map[String, List[String]] = mutable.Map[String, List[String]]()

    for (str <- strs) {
      val temp = str.sorted
      if (map.contains(temp)) {
        map.put(temp, map.get(temp).get.::(str))
      } else {
        map.put(temp, List(str))
      }
    }
    map.values.map(buffer.append(_))
    buffer.toList
  }

  /*
  53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
   */
  def maxSubArray(nums: Array[Int]): Int = {
    if (nums.isEmpty)
      return 0
    var pre, maxSum = nums(0)

    for (i <- 1 until nums.length) {
      pre = Math.max(pre + nums(i), nums(i))
      maxSum = Math.max(maxSum, pre)
    }
    maxSum
  }

  /*
  55. 跳跃游戏
 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 判断你是否能够到达最后一个位置。

 示例 1:

 输入: [2,3,1,1,4]
 输出: true
 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 示例 2:

 输入: [3,2,1,0,4]
 输出: false
 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
   */
  def canJump(nums: Array[Int]): Boolean = {
    if (nums.length <= 1) {
      return true
    }
    if (nums(0) == 0) {
      return false
    }
    val arr: Array[Int] = new Array[Int](nums.length)
    arr(0) = nums(0)
    var maxIdx = nums(0)
    for (i <- 0 until nums.length - 1) {
      arr(i) = i + nums(i)
      maxIdx = if (maxIdx < arr(i)) arr(i) else maxIdx
      if (nums(i) == 0 && maxIdx <= i)
        return false
      if (arr(i) >= nums.length - 1) {
        return true
      }
    }
    false
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
    val buffer: ListBuffer[Array[Int]] = new ListBuffer[Array[Int]]()
    val loop = new Breaks
    val ccc = intervals.sortWith((A, B) => A(0) < B(0))
    for (arr <- ccc) {
      if (buffer.isEmpty) {
        buffer.append(arr)
      } else {
        loop.breakable {
          for (t <- buffer) {
            if ((arr(0) >= t(0) && arr(0) <= t(1)) || (arr(1) >= t(0) && arr(1) <= t(1)) || (arr(0) < t(0) && arr(1) > t(1))) {
              t(0) = Math.min(t(0), arr(0))
              t(1) = Math.max(t(1), arr(1))
              loop.break()
            }
          }
          buffer.append(arr)
        }
      }
    }
    buffer.toArray
  }

  /*
  62. 不同路径
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？



例如，上图是一个7 x 3 的网格。有多少可能的路径？



示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28
   */
  def uniquePaths(m: Int, n: Int): Int = {
    val dp = Array.ofDim[Int](m, n)
    for (i <- 0 until m) {
      dp(i)(0) = 1
    }

    for (j <- 0 until n) {
      dp(0)(j) = 1
    }
    for (i <- 1 until m; j <- 1 until n) {
      dp(i)(j) = dp(i - 1)(j) + dp(i)(j - 1)
    }
    dp(m - 1)(n - 1)
  }

  /*
  64. 最小路径和
 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

 说明：每次只能向下或者向右移动一步。

 示例:

 输入:
 [
   [1,3,1],
   [1,5,1],
   [4,2,1]
 ]
 输出: 7
 解释: 因为路径 1→3→1→1→1 的总和最小。
   */
  def minPathSum(grid: Array[Array[Int]]): Int = {
    val row = grid.length
    val cel = grid(0).length
    val dp = Array.ofDim[Int](row, cel)
    dp(0)(0) = grid(0)(0)
    for (i <- 1 until row) {
      dp(i)(0) = dp(i - 1)(0) + grid(i)(0)
    }
    for (j <- 1 until cel) {
      dp(0)(j) = dp(0)(j - 1) + grid(0)(j)
    }
    for (i <- 1 until row; j <- 1 until cel) {
      dp(i)(j) = Math.min(dp(i - 1)(j), dp(i)(j - 1)) + grid(i)(j)
    }
    dp(row - 1)(cel - 1)
  }

  /*
  70. 爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
   */
  def climbStairs(n: Int): Int = {
    if (n <= 2)
      return n
    val dp = new Array[Int](n)
    dp(0) = 1
    dp(1) = 2
    for (i <- 2 until n) {
      dp(i) = dp(i - 1) + dp(i - 2)
    }
    dp(n - 1)
  }

  /*
  72. 编辑距离
给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符


示例 1：

输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2：

输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
   */
  def minDistance(word1: String, word2: String): Int = {
    val m = word1.length
    val n = word2.length
    val dp = Array.ofDim[Int](m + 1, n + 1)
    for (i <- 0 to m) {
      dp(i)(0) = i
    }
    for (j <- 0 to n) {
      dp(0)(j) = j
    }
    for (i <- 1 to m; j <- 1 to n) {
      if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
        dp(i)(j) = dp(i - 1)(j - 1)
      } else {
        val A = dp(i - 1)(j) // 在第二个字符串中添加一个字符，使dp(i)(j)个字符串相同，将其抵消
        val B = dp(i)(j - 1) // 在第一个字符串中添加一个字符，使dp(i)(j)个字符串相同，将其抵消
        val C = dp(i - 1)(j - 1) // 在第一个字符串中替换一个字符，使dp(i)(j)个字符串相同，将其抵消
        dp(i)(j) = Math.min(A, Math.min(B, C)) + 1
      }
    }
    dp(m)(n)
  }

  /*
  75. 颜色分类
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
进阶：

一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
你能想出一个仅使用常数空间的一趟扫描算法吗？
   */
  def sortColors(nums: Array[Int]): Unit = {
    var p0 = 0
    var p1 = 0
    for (i <- 0 until nums.length) {
      if (nums(i) == 0) {
        nums(i) = nums(p0)
        nums(p0) = 0
        if (p0 < p1) {
          val temp = nums(p1)
          nums(p1) = nums(i)
          nums(i) = temp
        }
        p0 += 1
        p1 += 1
      } else if (nums(i) == 1) {
        nums(i) = nums(p1)
        nums(p1) = 1
        p1 += 1
      }
    }
  }


  /*
    76. 最小覆盖子串
  给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。



  示例：

  输入：S = "ADOBECODEBANC", T = "ABC"
  输出："BANC"


  提示：

  如果 S 中不存这样的子串，则返回空字符串 ""。
  如果 S 中存在这样的子串，我们保证它是唯一的答案。
     */
  def minWindow(s: String, t: String): String = {
    val sLen = s.length
    val tLen = t.length

    var left, right = 0

    val tArr = new Array[Int](128)
    val sArr = new Array[Int](128)
    for (c <- t) {
      tArr(c) += 1
    }

    var minLen = Int.MaxValue
    var minStr = ""
    var distance = 0 // 通过distance来匹配s子串与t串匹配

    while (right < sLen) {
      val sc = s.charAt(right)
      if (tArr(sc) > 0) {
        if (sArr(sc) < tArr(sc)) {
          distance += 1
        }
        sArr(sc) += 1

        while (distance == tLen) {
          val tempC = s.charAt(left)

          if (tArr(tempC) > 0) {
            if (tArr(tempC) == sArr(tempC)) {
              if (minLen > (right - left + 1)) {
                minLen = right - left + 1
                minStr = s.substring(left, right + 1)
              }
              distance -= 1
            }
            sArr(tempC) -= 1
          }
          left += 1
        }
        right += 1
      } else {
        right += 1
      }
    }
    minStr
  }

  /*
  78. 子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
   */
  def subsets(nums: Array[Int]): List[List[Int]] = {
    val buffer: ListBuffer[List[Int]] = new ListBuffer[List[Int]]()
    backtrack(nums, buffer, new ListBuffer[Int](), 0)
    buffer.toList
  }

  def backtrack(nums: Array[Int], buffer: ListBuffer[List[Int]], list: ListBuffer[Int], start: Int): Unit = {
    buffer.append(list.toList)

    for (i <- start until nums.length) {
      list.append(nums(i))
      backtrack(nums, buffer, list, i + 1)
      list.remove(list.length - 1)

    }
  }

  /*
  79. 单词搜索
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。



示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false


提示：

board 和 word 中只包含大写和小写英文字母。
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
   */
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    if (board.isEmpty) {
      return false
    }
    val row = board.length
    val col = board(0).length
    val used: Array[Array[Boolean]] = Array.ofDim(row, col)

    for (i <- 0 until row; j <- 0 until col) {
      if (dfs(board, i, j, word, 0, used)) {
        return true
      }
    }
    false
  }

  def dfs(board: Array[Array[Char]], rowIdx: Int, colIdx: Int, word: String, idx: Int, used: Array[Array[Boolean]]): Boolean = {
    if (board(rowIdx)(colIdx) != word.charAt(idx)) {
      return false
    } else if (idx == word.length - 1) {
      return true
    }

    val direction: Array[(Int, Int)] = Array((0, 1), (0, -1), (-1, 0), (1, 0))
    used(rowIdx)(colIdx) = true

    for (tp <- direction) {
      val ri = rowIdx + tp._1
      val ci = colIdx + tp._2
      if (ri >= 0 && ri < board.length && ci >= 0 && ci < board(0).length && !used(ri)(ci)) {
        if (dfs(board, ri, ci, word, idx + 1, used)) {
          return true
        }
      }
    }
    used(rowIdx)(colIdx) = false
    false
  }

  /*
  84. 柱状图中最大的矩形
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。





以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。





图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。



示例:

输入: [2,1,5,6,2,3]
输出: 10
   */
  def largestRectangleArea(heights: Array[Int]): Int = {
    var len = heights.length
    if (len == 0)
      return 0
    if (len == 1)
      return heights(0)

    val stack: mutable.Stack[Int] = new mutable.Stack[Int]()
    var max = 0

    val newHeights = new Array[Int](len + 2)
    for (i <- 1 to len) {
      newHeights(i) = heights(i - 1)
    }
    len += 2

    stack.push(0)
    for (i <- 1 until len) {
      while (newHeights(stack.top) > newHeights(i)) {
        val popIdx = stack.pop
        val width = if (stack.isEmpty) i else (i - stack.top - 1)
        max = Math.max(max, newHeights(popIdx) * width)
      }
      stack.push(i)
    }
    max
  }

  /*
  85. 最大矩形
给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

示例:

输入:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
输出: 6
   */
  def maximalRectangle(matrix: Array[Array[Char]]): Int = {
    if (matrix.isEmpty)
      return 0

    var maxArea = 0
    val dp: Array[Array[Int]] = Array.ofDim[Int](matrix.length, matrix(0).length)
    for (i <- 0 until matrix.length; j <- 0 until matrix(0).length) {
      if (matrix(i)(j) == '1') {
        dp(i)(j) = if (j == 0) 1 else dp(i)(j - 1) + 1
      }
      var width = dp(i)(j)
      for (k <- Range(i, -1, -1)) {
        width = Math.min(width, dp(k)(j))
        maxArea = Math.max(maxArea, width * (i - k + 1))
      }
    }
    maxArea
  }

  def maximalRectangle2(matrix: Array[Array[Char]]): Int = {
    if (matrix.isEmpty) {
      return 0
    }
    val heights: Array[Int] = new Array[Int](matrix(0).length)
    var max = 0
    for (i <- 0 until matrix.length) {
      for (j <- 0 until matrix(0).length) {
        if (matrix(i)(j) == '1') {
          heights(j) += 1
        } else {
          heights(j) = 0
        }
      }
      val temp = largestRectangleArea(heights)
      max = if (max < temp) temp else max
    }
    max
  }

  /*
      if (matrix.isEmpty)
      return 0

    var maxArea = 0
    val dp: Array[Array[Int]] = Array.ofDim[Int](matrix.length, matrix(0).length)
    for (i <- 0 until matrix.length; j <- 0 until matrix(0).length) {
      if (matrix(i)(j) == '1') {
        dp(i)(j) = if (j == 0) 1 else dp(i)(j - 1) + 1
      }
      var width = dp(i)(j)
      for (k <- Range(i, -1, -1)) {
        width = Math.min(width, dp(k)(j))
        maxArea = Math.max(maxArea, width * (i - k + 1))
      }
    }
    maxArea
   */

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right

  }

  /*
  94. 二叉树的中序遍历
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
   */
  def inorderTraversal(root: TreeNode): List[Int] = {

    val buffer: ListBuffer[Int] = new ListBuffer[Int]()
    val stack = new mutable.Stack[TreeNode]()
    var curNode = root

    while (curNode != null || !stack.isEmpty) {
      if (curNode != null) {
        stack.push(curNode)
        curNode = curNode.left
      } else {
        curNode = stack.pop()
        buffer.append(curNode.value)
        curNode = curNode.right
      }
    }
    buffer.toList
  }

  def inorderTraversal2(root: TreeNode): List[Int] = {
    if (root == null)
      return List[Int]()

    val buffer: ListBuffer[Int] = new ListBuffer[Int]()
    rec(root, buffer)

    buffer.toList
  }

  def rec(root: TreeNode, buffer: ListBuffer[Int]): Unit = {
    if (root == null) {
      return
    }
    rec(root.left, buffer)
    buffer.append(root.value)
    rec(root.right, buffer)
  }

  /*
  96. 不同的二叉搜索树
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   */

  def numTrees(n: Int): Int = {
    // 推导出的 G(n)函数的值在数学上被称为卡塔兰数
    val g: Array[Int] = new Array[Int](n + 1)
    g(0) = 1
    g(1) = 1
    for (i <- 2 to n) {
      for (j <- 1 to i) {
        g(i) += g(j - 1) * g(i - j)
      }
    }
    g(n)
  }

  def numTrees2(n: Int): Int = {
    var C: Long = 1
    for (i <- 0 until n) {
      C = C * 2 * (2 * i + 1) / (i + 2)
    }
    C.toInt
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
    var curNode = root
    val stack: mutable.Stack[TreeNode] = new mutable.Stack[TreeNode]()
    var inOrder: Double = Double.MinValue

    while (curNode != null || !stack.isEmpty) {
      while (curNode != null) {
        stack.push(curNode)
        curNode = curNode.left
      }

      curNode = stack.pop()
      if (curNode.value <= inOrder) {
        return false
      }
      inOrder = curNode.value
      curNode = curNode.right
    }
    true
  }

  /*
  101. 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。



例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3


但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3


进阶：

你可以运用递归和迭代两种方法解决这个问题吗？
   */
  def isSymmetric(root: TreeNode): Boolean = {
    if (root == null) {
      return true
    }
    rec(root.left, root.right)

  }

  def rec(leftTree: TreeNode, rightTree: TreeNode): Boolean = {
    if (leftTree == null && rightTree == null) {
      true
    } else if (leftTree != null && rightTree != null) {
      if (leftTree.value == rightTree.value) {
        rec(leftTree.left, rightTree.right) && rec(leftTree.right, rightTree.left)
      } else {
        false
      }
    } else {
      false
    }
  }

  /*
  102. 二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。



示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
   */
  def levelOrder(root: TreeNode): List[List[Int]] = {
    val buffer: ListBuffer[List[Int]] = new ListBuffer[List[Int]]()
    val queue: mutable.Queue[TreeNode] = new mutable.Queue[TreeNode]()
    if (root != null) {
      queue.enqueue(root)
    }
    while (!queue.isEmpty) {
      val size = queue.size
      val temp = new ListBuffer[Int]()
      for (i <- 0 until size) {
        val node = queue.dequeue()
        temp.append(node.value)
        if (node.left != null) {
          queue.enqueue(node.left)
        }
        if (node.right != null) {
          queue.enqueue(node.right)
        }
      }
      buffer.append(temp.toList)
    }
    buffer.toList
  }

  /*
  104. 二叉树的最大深度
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
   */
  def maxDepth(root: TreeNode): Int = {
    if (root == null) {
      0
    } else {
      Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
  }

  def maxDepth2(root: TreeNode): Int = {
    if (root == null) {
      return 0
    }
    var curNode: TreeNode = null
    var maxLength = 0
    val queue: mutable.Queue[TreeNode] = new mutable.Queue[TreeNode]()
    queue.enqueue(root)
    while (!queue.isEmpty) {
      for (i <- 0 until queue.size) {
        curNode = queue.dequeue()
        if (curNode.left != null) {
          queue.enqueue(curNode.left)
        }
        if (curNode.right != null) {
          queue.enqueue(curNode.right)
        }
      }
      maxLength += 1
    }
    maxLength
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
     15   7
     */

  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    val n = preorder.length
    if (n == 0) {
      return null
    }
    if (n == 1) {
      return new TreeNode(preorder(0))
    }
    val map: mutable.Map[Int, Int] = mutable.Map[Int, Int]()
    for (i <- 0 until preorder.length) {
      map.put(inorder(i), i)
    }
    myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1, map)
  }

  def myBuildTree(preorder: Array[Int], inorder: Array[Int], pl: Int, pr: Int, il: Int, ir: Int, map: mutable.Map[Int, Int]): TreeNode = {
    if (pl > pr)
      return null

    val root = new TreeNode(preorder(pl))

    val rootIdx = map(preorder(pl))

    val sizeOfLeft = rootIdx - il

    root.left = myBuildTree(preorder, inorder, pl + 1, pl + sizeOfLeft, il, rootIdx - 1, map)

    root.right = myBuildTree(preorder, inorder, pl + sizeOfLeft + 1, pr, rootIdx + 1, ir, map)

    return root

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
    val buffer: ListBuffer[TreeNode] = new ListBuffer[TreeNode]()
    var curNode = root
    preorderRec(root, buffer)
    for (i <- Range(1, buffer.length)) {
      curNode.left = null
      curNode.right = buffer(i)
      curNode = curNode.right
    }

  }

  def preorderRec(node: TreeNode, buffer: ListBuffer[TreeNode]): Unit = {
    if (node != null) {
      buffer.append(node)
      preorderRec(node.left, buffer)
      preorderRec(node.right, buffer)
    }
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
  def maxProfit(prices: Array[Int]): Int = {
    var minPrice = Int.MaxValue
    var maxProfit = 0
    for (price <- prices) {
      if (price < minPrice) {
        minPrice = price
      } else {
        maxProfit = Math.max(maxProfit, (price - minPrice))
      }
    }
    maxProfit
  }

  def maxProfit2(prices: Array[Int]): Int = {
    val len = prices.length
    var maxInt = 0

    for (i <- 0 until len; j <- i + 1 until len) {
      maxInt = Math.max(prices(j) - prices(i), maxInt)
    }
    maxInt
  }

  /*
  124. 二叉树中的最大路径和
给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。



示例 1：

输入：[1,2,3]

       1
      / \
     2   3

输出：6
示例 2：

输入：[-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出：42
   */

  def maxPathSum(root: TreeNode): Int = {
    val maxNode = new TreeNode(Int.MinValue)
    recMaxPathSum(root, maxNode)
    maxNode.value
  }

  def recMaxPathSum(root: TreeNode, maxNode: TreeNode): Int = {
    if (root == null) {
      return 0
    }
    val leftMax = Math.max(recMaxPathSum(root.left, maxNode), 0)
    val rightMax = Math.max(recMaxPathSum(root.right, maxNode), 0)
    maxNode.value = Math.max(leftMax + rightMax + root.value, maxNode.value)

    return root.value + Math.max(leftMax, rightMax)
  }

  /*
  128. 最长连续序列
给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
   */
  def longestConsecutive(nums: Array[Int]): Int = {
    val set: Set[Int] = nums.toSet
    var max = 0
    for (num <- set) {
      if (!set.contains(num - 1)) {
        var currentNumber = num
        var currentLength = 1
        while (set.contains(currentNumber + 1)) {
          currentLength += 1
          currentNumber += 1
        }
        max = Math.max(max, currentLength)
      }
    }
    max
  }

  /*
  136. 只出现一次的数字
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4
   */
  def singleNumber(nums: Array[Int]): Int = {
    nums.reduce(_ ^ _)
  }

  /*
  139. 单词拆分
给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
   */

  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    val dp: Array[Boolean] = new Array[Boolean](s.length + 1)
    dp(0) = true
    for (i <- 1 to s.length) {
      for (j <- 0 until i) {
        val str = s.substring(j, i)
        if (dp(j) && wordDict.contains(str)) {
          dp(i) = true
        }
      }
    }
    dp(s.length)
  }

  /*
  141. 环形链表
给定一个链表，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

如果链表中存在环，则返回 true 。 否则，返回 false 。



进阶：

你能用 O(1)（即，常量）内存解决此问题吗？



示例 1：



输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
示例 2：



输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
示例 3：



输入：head = [1], pos = -1
输出：false
解释：链表中没有环。


提示：

链表中节点的数目范围是 [0, 104]
-105 <= Node.val <= 105
pos 为 -1 或者链表中的一个 有效索引 。
   */
  def hasCycle(head: ListNode): Boolean = {
    if (head == null || head.next == null) {
      return false
    }
    var fast: ListNode = head.next.next
    var slow: ListNode = head.next
    while (fast != slow) {
      if (fast == null || fast.next == null) {
        return false
      }
      fast = fast.next.next
      slow = slow.next
    }
    true
  }

  def hasCycle2(head: ListNode): Boolean = {
    var curNode = head
    val buffer: ListBuffer[ListNode] = new ListBuffer[ListNode]()
    while (curNode != null) {
      if (buffer.contains(curNode))
        return true
      buffer.append(curNode)
      curNode = curNode.next
    }
    false
  }

  /*
  142. 环形链表 II
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。

说明：不允许修改给定的链表。

进阶：

你是否可以使用 O(1) 空间解决此题？


示例 1：



输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。
示例 2：



输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。
示例 3：



输入：head = [1], pos = -1
输出：返回 null
解释：链表中没有环。


提示：

链表中节点的数目范围在范围 [0, 104] 内
-105 <= Node.val <= 105
pos 的值为 -1 或者链表中的一个有效索引

   */
  def detectCycle(head: ListNode): ListNode = {
    if (head == null || head.next == null) {
      return null
    }
    var slow, fast = head
    while (fast != null) {
      slow = slow.next
      if (fast.next != null) {
        fast = fast.next.next
      } else {
        return null
      }
      if (slow == fast) {
        var ptr = head
        var index = 0
        while (ptr != slow) {
          ptr = ptr.next
          slow = slow.next
        }
        return ptr
      }
    }
    null
  }

  /*
  148. 排序链表
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5
   */
  def sortList(head: ListNode): ListNode = {
    if (head == null || head.next == null)
      return head
    var slow = head
    var fast = head.next
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
    }
    val middle = slow.next
    slow.next = null
    var leftNode = sortList(head)
    var rightNode = sortList(middle)
    var curNode: ListNode = new ListNode(0)
    val retNode = curNode
    while (leftNode != null && rightNode != null) {
      if (leftNode.x < rightNode.x) {
        curNode.next = leftNode
        leftNode = leftNode.next
      } else {
        curNode.next = rightNode
        rightNode = rightNode.next
      }
      curNode = curNode.next
    }
    curNode.next = if (leftNode != null) leftNode else rightNode
    retNode.next
  }

  /*
  152. 乘积最大子数组
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。



示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
   */
  def maxProduct(nums: Array[Int]): Int = {
    if (nums.isEmpty)
      return 0
    val len = nums.length
    var maxMul = nums(0)
    val maxDp: Array[Int] = new Array[Int](len)
    val minDp: Array[Int] = new Array[Int](len)
    maxDp(0) = nums(0)
    minDp(0) = nums(0)

    for (i <- 1 until len) {
      maxDp(i) = Math.max(Math.max(maxDp(i - 1) * nums(i), minDp(i - 1) * nums(i)), nums(i))
      minDp(i) = Math.min(Math.min(maxDp(i - 1) * nums(i), minDp(i - 1) * nums(i)), nums(i))
      maxMul = Math.max(maxMul, maxDp(i))
    }
    maxMul
  }

  /*
  160. 相交链表
编写一个程序，找到两个单链表相交的起始节点。

如下面的两个链表：



在节点 c1 开始相交。



示例 1：



输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。


示例 2：



输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Reference of the node with value = 2
输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。


示例 3：



输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
解释：这两个链表不相交，因此返回 null。


注意：

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

   */
  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    if (headA == null || headB == null) {
      return null
    }

    var m = headA
    var n = headB
    while (m != n) {
      m = if (m == null) headB else m.next
      n = if (n == null) headA else n.next
    }
    m
  }

  /*
  169. 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。



示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2
   */
  def majorityElement(nums: Array[Int]): Int = {
    var count = 0
    var candidate: Int = 0
    for (num <- nums) {
      if (count == 0) {
        candidate = num
      }
      count = (if (candidate == num) 1 else -1) + count
    }
    candidate
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
  def rob(nums: Array[Int]): Int = {
    if (nums == null || nums.isEmpty)
      return 0
    val len = nums.length
    if (len == 1) {
      return nums(0)
    }
    val dp: Array[Int] = new Array(len)
    dp(0) = nums(0)
    dp(1) = Math.max(nums(0), nums(1))
    for (i <- 2 until len) {
      dp(i) = Math.max(nums(i) + dp(i - 2), dp(i - 1))
    }
    dp(len - 1)
  }

  /*
  200. 岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。



示例 1：

输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
示例 2：

输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3


提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 的值为 '0' 或 '1'
   */
  def numIslands(grid: Array[Array[Char]]): Int = {
    if (grid == null || grid.isEmpty)
      return 0

    val row = grid.length
    val col = grid(0).length
    var count: Int = 0
    for (i <- 0 until row; j <- 0 until col) {
      if (grid(i)(j) == '1') {
        count += 1
        dfsNumIsLands(grid, i, j, row, col)
      }
    }
    count
  }

  def dfsNumIsLands(g: Array[Array[Char]], r: Int, c: Int, row: Int, col: Int): Unit = {
    if (c < 0 || r < 0 || c >= col || r >= row || g(r)(c) == '0')
      return

    g(r)(c) = '0'
    dfsNumIsLands(g, r - 1, c, row, col)
    dfsNumIsLands(g, r + 1, c, row, col)
    dfsNumIsLands(g, r, c - 1, row, col)
    dfsNumIsLands(g, r, c + 1, row, col)
  }

  /*
  206. 反转链表
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
   */
  def reverseList(head: ListNode): ListNode = {
    if (head == null)
      return null
    var node = head
    val stack: mutable.Stack[ListNode] = new mutable.Stack[ListNode]()
    while (node != null) {
      stack.push(node)
      node = node.next
    }
    val retNode = stack.pop
    var curNode = retNode
    while (!stack.isEmpty) {
      curNode.next = stack.pop()
      curNode = curNode.next
    }
    curNode.next = null
    retNode
  }

  /*
  207. 课程表
你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]

给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？



示例 1:

输入: 2, [[1,0]]
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。


提示：

输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
1 <= numCourses <= 10^5
   */
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    val edges: Array[ListBuffer[Int]] = new Array[ListBuffer[Int]](numCourses)
    val inedge: Array[Int] = new Array[Int](numCourses)
    for (i <- 0 until numCourses) {
      edges(i) = new ListBuffer[Int]()
    }

    for (arr <- prerequisites) {
      edges(arr(1)).append(arr(0))
      inedge(arr(0)) += 1
    }

    val queue: mutable.Queue[Int] = new mutable.Queue[Int]()
    for (i <- 0 until numCourses) {
      if (inedge(i) == 0) {
        queue.enqueue(i)
      }
    }

    var retCount = 0
    while (!queue.isEmpty) {
      val pre = queue.dequeue()
      retCount += 1
      for (ed <- edges(pre)) {
        inedge(ed) -= 1
        if (inedge(ed) == 0) {
          queue.enqueue(ed)
        }
      }
    }
    retCount == numCourses
  }

  /*
  215. 数组中的第K个最大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
   */

  def findKthLargest(nums: Array[Int], k: Int): Int = {
    //    nums.sorted.reverse(k - 1)
    quickSort(nums, 0, nums.length - 1, nums.length - k)
  }

  def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }

  def partition(arr: Array[Int], l: Int, r: Int): Int = {
    val x = arr(r)
    var i = l - 1
    for (j <- l until r) {
      if (arr(j) <= x) {
        i += 1
        swap(arr, i, j)
      }
    }
    swap(arr, i + 1, r)
    i + 1
  }

  def randomPartition(arr: Array[Int], l: Int, r: Int): Int = {
    val i = Random.nextInt(r - l + 1) + l
    swap(arr, i, r)
    partition(arr, l, r)
  }

  def quickSort(arr: Array[Int], l: Int, r: Int, index: Int): Int = {
    val q = randomPartition(arr, l, r)
    if (q == index) {
      arr(q)
    } else if (q > index) {
      quickSort(arr, l, q - 1, index)
    } else {
      quickSort(arr, q + 1, r, index)
    }
  }

  /*
  221. 最大正方形
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4
   */
  def maximalSquare(matrix: Array[Array[Char]]): Int = {
    if (matrix == null || matrix.isEmpty || matrix(0).length == 0)
      return 0

    val row = matrix.length
    val col = matrix(0).length
    val dp: Array[Array[Int]] = Array.ofDim(row, col)
    var maxSide = 0
    for (i <- 0 until row; j <- 0 until col) {
      if (matrix(i)(j) == '1') {
        if (i == 0 || j == 0) {
          dp(i)(j) = 1
        } else {
          dp(i)(j) = Math.min(Math.min(dp(i - 1)(j), dp(i)(j - 1)), dp(i - 1)(j - 1)) + 1
        }
        maxSide = Math.max(dp(i)(j), maxSide)
      }
    }
    maxSide * maxSide
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
    if (root == null)
      return null
    val left = invertTree(root.left)
    val right = invertTree(root.right)
    root.left = right
    root.right = left
    root
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
    if (head == null)
      return true
    val halfNode = findHalf(head)
    var rightNode = reverseListNode(halfNode.next)

    var leftNode = head
    while (rightNode != null) {
      if (leftNode.x != rightNode.x) {
        halfNode.next = reverseListNode(rightNode) // 还原原链表
        return false
      }
      leftNode = leftNode.next
      rightNode = rightNode.next
    }
    halfNode.next = reverseListNode(rightNode)
    true
  }

  def findHalf(node: ListNode): ListNode = {
    var slow: ListNode = node
    var fast: ListNode = node
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next
      fast = fast.next.next
    }
    slow
  }

  def reverseListNode(node: ListNode): ListNode = {
    var preNode: ListNode = null
    var curNode = node
    while (curNode != null) {
      val temp = curNode.next
      curNode.next = preNode
      preNode = curNode
      curNode = temp
    }
    preNode
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
  var retNode: TreeNode = null

  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    dfsparent(root, p, q)
    retNode
  }

  def dfsparent(root: TreeNode, p: TreeNode, q: TreeNode): Boolean = {
    if (root == null)
      return false
    val lson = dfsparent(root.left, p, q)
    val rson = dfsparent(root.right, p, q)

    if ((lson && rson) || (root.value == p.value || root.value == q.value) && (lson || rson)) {
      retNode = root
    }
    return lson || rson || (root.value == p.value || root.value == q.value)

  }


  def lowestCommonAncestor2(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    var vp = p
    var vq = q
    val visitMap: mutable.Map[Int, Boolean] = mutable.Map[Int, Boolean]()
    val parentMap: mutable.Map[Int, TreeNode] = mutable.Map[Int, TreeNode]()
    parentMap.put(root.value, null)
    dfsparent2(root, parentMap)

    while (vp != null) {
      visitMap.put(vp.value, true)
      vp = parentMap(vp.value)
    }
    while (vq != null) {
      if (visitMap.contains(vq.value)) {
        return vq
      }
      vq = parentMap(vq.value)
    }
    null
  }

  def dfsparent2(root: TreeNode, parentMap: mutable.Map[Int, TreeNode]): Unit = {
    if (root.left != null) {
      parentMap.put(root.left.value, root)
      dfsparent2(root.left, parentMap)
    }
    if (root.right != null) {
      parentMap.put(root.right.value, root)
      dfsparent2(root.right, parentMap)
    }
  }

  /*
  238. 除自身以外数组的乘积
给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。



示例:

输入: [1,2,3,4]
输出: [24,12,8,6]


提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

进阶：
   */
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    if (nums == null)
      return null
    val len = nums.length
    val lArr: Array[Int] = new Array[Int](len)
    val rArr: Array[Int] = new Array[Int](len)
    lArr(0) = 1
    for (i <- 1 until len) {
      lArr(i) = lArr(i - 1) * nums(i - 1)
    }
    rArr(len - 1) = 1
    for (j <- Range(len - 2, -1, -1)) {
      rArr(j) = rArr(j + 1) * nums(j + 1)
    }

    val retArr: Array[Int] = new Array[Int](len)
    for (i <- 0 until len) {
      retArr(i) = lArr(i) * rArr(i)
    }
    retArr
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
    if (nums == null) {
      return null
    }
    val len = nums.length
    val leftMax: Array[Int] = new Array[Int](len)
    val rightMax: Array[Int] = new Array[Int](len)
    leftMax(0) = nums(0)
    rightMax(len - 1) = nums(len - 1)

    for (i <- 1 until len) {
      leftMax(i) = if (i % k == 0) nums(i) else Math.max(leftMax(i - 1), nums(i))
      val j = len - i - 1
      rightMax(j) = if ((j + 1) % k == 0) nums(j) else Math.max(rightMax(j + 1), nums(j))
    }

    val retArr: Array[Int] = new Array[Int](len - k + 1)
    retArr(0) = nums.slice(0, k).max
    for (i <- 0 to len - k) {
      retArr(i) = Math.max(leftMax(i + k - 1), rightMax(i))
    }
    retArr
  }

  /*
  240. 搜索二维矩阵 II
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。

   */
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    if (matrix == null || matrix.isEmpty || matrix(0).isEmpty)
      return false
    val len = Math.min(matrix.length, matrix(0).length)
    for (i <- 0 until len) {
      val rowSearch = dfsSearch(matrix, i, target, false)
      val colSearch = dfsSearch(matrix, i, target, true)
      if (rowSearch || colSearch)
        return true
    }
    false
  }

  def dfsSearch(matrix: Array[Array[Int]], idx: Int, target: Int, vertical: Boolean): Boolean = {
    var start = idx
    var end = if (vertical) matrix(0).length - 1 else matrix.length - 1
    while (start <= end) {
      val mid = (start + end) / 2
      if (vertical) {
        if (matrix(idx)(mid) < target) {
          start = mid + 1
        } else if (matrix(idx)(mid) > target) {
          end = mid - 1
        } else {
          return true
        }
      } else {
        if (matrix(mid)(idx) < target) {
          start = mid + 1
        } else if (matrix(mid)(idx) > target) {
          end = mid - 1
        } else {
          return true
        }
      }
    }
    false
  }


  /*
  279. 完全平方数
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.
   */
  def numSquares(n: Int): Int = {
    val dp: Array[Int] = new Array[Int](n + 1)
    for (i <- 1 to n) {
      dp(i) = i
      var j = 1
      while (i - j * j >= 0) {
        dp(i) = Math.min(dp(i), dp(i - j * j) + 1)
        j += 1
      }
    }
    dp(n)
  }

  /*
283. 移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
 */
  def moveZeroes(nums: Array[Int]): Unit = {
    if (nums == null)
      return
    var nonZeroIdx = 0
    for (i <- 0 until nums.length) {
      if (nums(i) != 0) {
        swap(nums, i, nonZeroIdx)
        nonZeroIdx += 1
      }
    }
  }

  /*
  287. 寻找重复数
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

示例 1:

输入: [1,3,4,2,2]
输出: 2
示例 2:

输入: [3,1,3,4,2]
输出: 3
说明：

不能更改原数组（假设数组是只读的）。
只能使用额外的 O(1) 的空间。
时间复杂度小于 O(n2) 。
数组中只有一个重复的数字，但它可能不止重复出现一次。
   */
  def findDuplicate(nums: Array[Int]): Int = {
    var slow: Int = nums(0)
    var fast: Int = nums(nums(0))
    while (slow != fast) {
      slow = nums(slow)
      fast = nums(nums(fast))
    }
    fast = 0
    while (slow != fast) {
      slow = nums(slow)
      fast = nums(fast)
    }
    slow
  }

  /*
  300. 最长上升子序列
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
   */
  def lengthOfLIS(nums: Array[Int]): Int = {
    if (nums == null || nums.isEmpty)
      return 0
    val dp: Array[Int] = new Array[Int](nums.length)
    dp(0) = 1
    var maxLen = 1
    for (i <- 1 until nums.length) {
      dp(i) = 1
      for (j <- 0 until i) {
        if (nums(i) > nums(j)) {
          dp(i) = Math.max(dp(i), dp(j) + 1)
        }
      }
      maxLen = Math.max(maxLen, dp(i))
    }
    maxLen
  }

  /*
    301. 删除无效的括号
  删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。

  说明: 输入可能包含了除 ( 和 ) 以外的字符。

  示例 1:

  输入: "()())()"
  输出: ["()()()", "(())()"]
  示例 2:

  输入: "(a)())()"
  输出: ["(a)()()", "(a())()"]
  示例 3:

  输入: ")("
  输出: [""]
     */
  def removeInvalidParentheses(s: String): List[String] = {
    var left = 0
    var right = 0
    val set: mutable.Set[String] = mutable.Set[String]()
    for (c <- s) {
      if (c == '(') {
        left += 1
      } else if (c == ')') {
        right = if (left == 0) right + 1 else right
        left = if (left > 0) left - 1 else left
      }
    }
    recurse(s, 0, 0, 0, left, right, new mutable.StringBuilder(), set)
    set.toList
  }

  def recurse(s: String, index: Int, leftCount: Int, rightCount: Int, leftRem: Int, rightRem: Int, builder: StringBuilder, set: mutable.Set[String]) {
    if (index == s.length) {
      if (leftRem == 0 && rightRem == 0) {
        set.add(builder.toString())
      }
    } else {

      val c = s.charAt(index)
      val len = builder.length

      if ((c == '(' && leftRem > 0) || (c == ')' && rightRem > 0)) {
        recurse(s, index + 1, leftCount, rightCount, leftRem - (if (c == '(') 1 else 0), rightRem - (if (c == ')') 1 else 0), builder, set)

      }
      builder.append(c)

      if (c != '(' && c != ')') {
        recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem, builder, set)
      } else if (c == '(') {
        recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, builder, set)
      } else if (rightCount < leftCount) {
        recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, builder, set)
      }
      builder.deleteCharAt(len)
    }
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
  def maxProfit3(prices: Array[Int]): Int = {
    if (prices == null || prices.isEmpty)
      return 0
    val len = prices.length
    var arr: Array[Array[Int]] = Array.ofDim(len, 3)
    // arr(i)(0)： 手上持有股票的最大收益
    // arr(i)(1)：手上不持有股票，处于冷冻期的累计最大收益
    // arr(i)(2)：手上不持有股票，不处于冷冻期的累计最大收益
    arr(0)(0) = -prices(0)
    arr(0)(1) = 0
    arr(0)(2) = 0

    for (i <- 1 until len) {
      arr(i)(0) = Math.max(arr(i - 1)(0), arr(i - 1)(2) - prices(i))
      arr(i)(1) = arr(i - 1)(0) + prices(i)
      arr(i)(2) = Math.max(arr(i - 1)(1), arr(i - 1)(2))
    }

    Math.max(arr(len - 1)(0), Math.max(arr(len - 1)(1), arr(len - 1)(2)))
  }

  /*
  312. 戳气球
有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。

求所能获得硬币的最大数量。

说明:

你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
示例:

输入: [3,1,5,8]
输出: 167
解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
   */
  def maxCoins(nums: Array[Int]): Int = {
    if (nums == null || nums.length == 0)
      return 0
    val n = nums.length
    val newNums: Array[Int] = new Array[Int](n + 2)
    newNums(0) = 1
    newNums(n + 1) = 1
    for (i <- 1 to n) {
      newNums(i) = nums(i - 1)
    }

    val dp: Array[Array[Int]] = Array.ofDim[Int](n + 2, n + 2)
    for (i <- Range(n, -1, -1)) {
      for (j <- i + 1 until n + 2) {
        for (k <- i + 1 until j) {
          dp(i)(j) = Math.max(dp(i)(j), dp(i)(k) + dp(k)(j) + newNums(i) * newNums(k) * newNums(j))
        }
      }
    }
    dp(0)(n + 1)
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
    if (amount < 0)
      return 0
    val dp: Array[Int] = Array.fill(amount + 1)(amount + 1)
    dp(0) = 0
    for (i <- 1 to amount) {
      for (j <- 0 until coins.length) {
        if (coins(j) <= i) {
          dp(i) = Math.min(dp(i), dp(i - coins(j)) + 1)
        }
      }
    }
    if (dp(amount) > amount) -1 else dp(amount)
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
    val selectedMap = mutable.Map[TreeNode, Int]()
    val nonselectedMap = mutable.Map[TreeNode, Int]()

    dfs_rob(root: TreeNode, selectedMap, nonselectedMap)
    Math.max(selectedMap.getOrElse(root, 0), nonselectedMap.getOrElse(root, 0))


  }

  def dfs_rob(node: TreeNode, selectedMap: mutable.Map[TreeNode, Int], nonselectedMap: mutable.Map[TreeNode, Int]): Unit = {
    if (node == null)
      return
    dfs_rob(node.left, selectedMap, nonselectedMap)
    dfs_rob(node.right, selectedMap, nonselectedMap)
    selectedMap.put(node, node.value + nonselectedMap.getOrElse(node.left, 0) + nonselectedMap.getOrElse(node.right, 0))
    nonselectedMap.put(node, Math.max(selectedMap.getOrElse(node.left, 0), nonselectedMap.getOrElse(node.left, 0)) +
      Math.max(selectedMap.getOrElse(node.right, 0), nonselectedMap.getOrElse(node.right, 0)))
  }

  /*
  338. 比特位计数
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

示例 1:

输入: 2
输出: [0,1,1]
示例 2:

输入: 5
输出: [0,1,1,2,1,2]
进阶:

给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
要求算法的空间复杂度为O(n)。
你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。

   */
  def countBits(num: Int): Array[Int] = {
    val retArr: Array[Int] = new Array[Int](num + 1)
    retArr(0) = 0
    for (i <- 1 to num) {
      retArr(i) = retArr(i >> 1) + (i & 1)
    }
    retArr
  }

  /*
  347. 前 K 个高频元素
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。



示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]


提示：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。
   */
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
    val map: mutable.Map[Int, Int] = mutable.Map[Int, Int]()
    for (n <- nums) {
      map.put(n, map.getOrElse(n, 0) + 1)
    }

    val retList = map.toList.sortBy(-_._2)
    val retArr: Array[Int] = new Array[Int](k)
    for (i <- 0 until k) {
      retArr(i) = retList(i)._1
    }
    retArr
  }


  /*
    394. 字符串解码
  给定一个经过编码的字符串，返回它解码后的字符串。

  编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

  你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

  此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。



  示例 1：

  输入：s = "3[a]2[bc]"
  输出："aaabcbc"
  示例 2：

  输入：s = "3[a2[c]]"
  输出："accaccacc"
  示例 3：

  输入：s = "2[abc]3[cd]ef"
  输出："abcabccdcdcdef"
  示例 4：

  输入：s = "abc3[cd]xyz"
  输出："abccdcdcdxyz"
     */
  def decodeString(s: String): String = {
    val stack = new mutable.Stack[String]()
    var ptr: Int = 0
    val retStr: StringBuilder = new StringBuilder
    while (ptr < s.length) {
      val c = s.charAt(ptr)
      if (c.isDigit) {
        val lastIdx: Int = getDigitIdx(s, ptr + 1)
        stack.push(s.substring(ptr, lastIdx))
        ptr = lastIdx
      } else if (c.isLetter || c == '[') {
        stack.push(c.toString)
        ptr += 1
      } else {
        val buffer: ListBuffer[String] = new ListBuffer[String]()
        while (stack.top != "[") {
          buffer.append(stack.pop)
        }
        stack.pop()
        val num: Int = stack.pop().toInt
        val arr: Array[String] = Array.fill(num)(buffer.reduce(_ + _))
        stack.push(arr.mkString(""))
        ptr += 1
      }
    }
    getString(stack, 1).reverse
  }

  def getDigitIdx(s: String, idx: Int): Int = {
    for (i <- idx until s.length) {
      if (!s.charAt(i).isDigit) {
        return i
      }
    }
    return s.length
  }

  def getString(stack: mutable.Stack[String], num: Int): String = {
    val builder: StringBuilder = new StringBuilder()
    while (!stack.isEmpty) {
      builder.append(stack.pop())
    }
    val retBuilder: StringBuilder = new StringBuilder()
    for (i <- 0 until num) {
      retBuilder.append(builder)
    }

    retBuilder.toString()
  }

  /*
  399. 除法求值
给出方程式 A / B = k, 其中 A 和 B 均为用字符串表示的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。

输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。



示例 1：

输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
解释：
给定：a / b = 2.0, b / c = 3.0
问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
返回：[6.0, 0.5, -1.0, 1.0, -1.0 ]
示例 2：

输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
输出：[3.75000,0.40000,5.00000,0.20000]
示例 3：

输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
输出：[0.50000,2.00000,-1.00000,-1.00000]


提示：

1 <= equations.length <= 20
equations[i].length == 2
1 <= equations[i][0].length, equations[i][1].length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= queries[i][0].length, queries[i][1].length <= 5
equations[i][0], equations[i][1], queries[i][0], queries[i][1] 由小写英文字母与数字组成
   */
  def calcEquation(equations: List[List[String]], values: Array[Double], queries: List[List[String]]): Array[Double] = {
    val mapP: mutable.Map[String, String] = mutable.Map[String, String]()
    val mapD: mutable.Map[String, Double] = mutable.Map[String, Double]()

    for (list <- equations) {
      val a = list(0)
      val b = list(1)
      mapP(a) = a
      mapP(b) = b
      mapD(a) = 1
      mapD(b) = 1
    }

    for (i <- 0 until equations.length) {
      val a = equations(i)(0)
      val b = equations(i)(1)

      val ra = find(a, mapP, mapD)
      mapP(ra) = b
      mapD(ra) = values(i) / mapD(a)
    }

    val res: Array[Double] = new Array[Double](queries.length)
    for (i <- 0 until queries.length) {
      val a = queries(i)(0)
      val b = queries(i)(1)
      if (!mapP.contains(a) || !mapP.contains(b) || find(a, mapP, mapD) != find(b, mapP, mapD)) {
        res(i) = -1
      } else {
        res(i) = (mapD(a) / mapD(b))
      }
    }
    res
  }

  def find(x: String, mapP: mutable.Map[String, String], mapD: mutable.Map[String, Double]): String = {
    if (mapP(x) != x) {
      val t = find(mapP(x), mapP, mapD)
      mapD(x) *= mapD(mapP(x))
      mapP(x) = t
    }
    mapP(x)
  }

  /*
  406. 根据身高重建队列
假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

注意：
总人数少于1100人。

示例

输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
   */
  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
    val newP = people.sortWith((A, B) => {
      if (A(0) == B(0)) B(1) - A(1) > 0 else A(0) - B(0) > 0
    })
    val retArr = new ListBuffer[Array[Int]]

    for (p <- newP) {
      retArr.insert(p(1), p)
    }
    retArr.toArray
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
  def canPartition(nums: Array[Int]): Boolean = {
    val len = nums.length
    if (len < 2)
      return false
    val maxNum = nums.max
    val sumNum = nums.sum
    val target = sumNum / 2
    if (sumNum % 2 == 1 || maxNum > target)
      return false

    val dp: Array[Array[Boolean]] = Array.ofDim[Boolean](len, target + 1)
    dp(0)(nums(0)) = true

    for (i <- 1 until len) {
      val num = nums(i)
      for (j <- 1 to target) {
        if (num == j) {
          dp(i)(j) = true
        } else if (j > num) {
          dp(i)(j) = dp(i - 1)(j) | dp(i - 1)(j - num)
        }
      }
    }
    dp(len - 1)(target)
  }

  /*
  437. 路径总和 III
给定一个二叉树，它的每个结点都存放着一个整数值。

找出路径和等于给定数值的路径总数。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

示例：

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

返回 3。和等于 8 的路径有:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11
   */
  def pathSum(root: TreeNode, sum: Int): Int = {
    val map: mutable.Map[Int, Int] = mutable.Map[Int, Int]()
    map(0) = 1
    helper(root, map, sum, 0)
  }

  def helper(root: TreeNode, map: mutable.Map[Int, Int], sum: Int, _pathSum: Int): Int = {
    var pathSum = _pathSum
    var res = 0
    if (root == null)
      return 0

    pathSum += root.value

    res = map.getOrElse(pathSum - sum, 0) + res
    map(pathSum) = map.getOrElse(pathSum, 0) + 1
    res = helper(root.left, map, sum, pathSum) + helper(root.right, map, sum, pathSum) + res
    map(pathSum) = map(pathSum) - 1
    res
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
    val needMap: mutable.Map[Char, Int] = mutable.Map[Char, Int]()
    val windowMap: mutable.Map[Char, Int] = mutable.Map[Char, Int]()
    for (c <- p) {
      needMap(c) = needMap.getOrElse(c, 0) + 1
    }

    var left, right = 0
    var valid = 0
    val list: ListBuffer[Int] = new ListBuffer[Int]()
    while (right < s.length) {
      val c = s(right)
      right += 1
      if (needMap.contains(c)) {
        windowMap(c) = windowMap.getOrElse(c, 0) + 1
        if (windowMap(c) == needMap(c))
          valid += 1
      }

      while (right - left >= p.size) {
        if (valid == needMap.size) {
          list.append(left)
        }
        val d = s(left)
        left += 1

        if (needMap.contains(d)) {
          if (windowMap(d) == needMap(d))
            valid -= 1
          windowMap(d) -= 1
        }
      }
    }
    list.toList
  }

  /*
  448. 找到所有数组中消失的数字
给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

示例:

输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6]
   */
  def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
    val buffer: ListBuffer[Int] = new ListBuffer[Int]()
    for (i <- 0 until nums.length) {
      val idx = Math.abs(nums(i)) - 1
      if (nums(idx) > 0) {
        nums(idx) *= -1
      }
    }

    for (i <- 1 to nums.length) {
      if (nums(i - 1) > 0) {
        buffer.append(i)
      }
    }
    buffer.toList
  }

  /*
  461. 汉明距离
两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 x 和 y，计算它们之间的汉明距离。

注意：
0 ≤ x, y < 231.

示例:

输入: x = 1, y = 4

输出: 2

解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

上面的箭头指出了对应二进制位不同的位置。
   */
  def hammingDistance(x: Int, y: Int): Int = {
    Integer.bitCount(x ^ y)
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
  def findTargetSumWays(nums: Array[Int], S: Int): Int = {
    val sum = nums.sum
    if (Math.abs(S) > Math.abs(sum))
      return 0

    val len = nums.length
    val dpLen = sum * 2 + 1
    val dp: Array[Array[Int]] = Array.ofDim[Int](len, dpLen)

    if (nums(0) == 0) {
      dp(0)(sum) = 2
    } else {
      dp(0)(sum + nums(0)) = 1
      dp(0)(sum - nums(0)) = 1
    }

    for (i <- 1 until len) {
      val num = nums(i)
      for (j <- 0 until dpLen) {
        val l = if (j - num > 0) j - num else 0
        val r = if (j + num < dpLen) j + num else 0
        dp(i)(j) = dp(i - 1)(l) + dp(i - 1)(r)
      }
    }
    dp(len - 1)(sum + S)
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
    def dfs(root: TreeNode = root): TreeNode = {
      if (root != null) {
        dfs(root.right)
        sum += root.value
        root.value = sum
        dfs(root.left)
      }
      root
    }
    dfs()
  }

  /*
543. 二叉树的直径
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。



示例 :
给定二叉树

        1
       / \
      2   3
     / \
    4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。



注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
  def diameterOfBinaryTree(root: TreeNode): Int = {
    var ans = 1

    def depth(root: TreeNode): Int = {
      if (root == null)
        return 0
      val L = depth(root.left)
      val R = depth(root.right)
      ans = Math.max(ans, L + R + 1)
      Math.max(L, R) + 1
    }
    depth(root)
    ans - 1
  }
}