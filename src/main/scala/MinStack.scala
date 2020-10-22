import scala.collection.mutable

/*
155. 最小栈
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。


示例:

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 */
class MinStack() {
  val stack: mutable.Stack[Int] = new mutable.Stack[Int]()
  val minStack: mutable.Stack[Int] = new mutable.Stack[Int]()

  /** initialize your data structure here. */


  def push(x: Int) {
    stack.push(x)
    if (minStack.isEmpty) {
      minStack.push(x)
    } else {
      minStack.push(Math.min(x, minStack.top))
    }
  }

  def pop(): Unit = {
    stack.pop()
    minStack.pop()
  }

  def top(): Int = {
    stack.top
  }

  def getMin(): Int = {
    minStack.top
  }

}

object testX {
  def main(args: Array[String]): Unit = {
    val minStack = new MinStack
    minStack.push(512)
    minStack.push(-1024)
    minStack.push(-1024)
    minStack.push(512)
    println(minStack.pop)
    println(minStack.getMin())
    println(minStack.pop)
    println(minStack.getMin())
    println(minStack.pop)
    println(minStack.getMin())
  }
}
