package study2

import scala.collection.mutable

class MyQueue {
  val s1 = mutable.Stack[Int]()
  val s2 = mutable.Stack[Int]()

  def push(x: Int): Unit = {
    s1.push(x)
  }

  def peek(): Int = {
    if (s2.isEmpty) {
      while (!s1.isEmpty) {
        s2.push(s1.pop)
      }
    }
    s2.top
  }

  def pop(): Int = {
    peek()
    s2.pop()
  }

  def isEmpty(): Boolean = {
    s1.isEmpty && s2.isEmpty
  }

}
