package study2

import scala.collection.mutable

class MyStack {
  val q = mutable.Queue[Int]()
  var topElem = 0;

  def push(x: Int): Unit = {
    q.enqueue(x)
    topElem = q.front
  }

  def top(): Int = {
    topElem
  }

  def pop(): Int = {
    var size = q.size
    while (size > 2) {
      q.enqueue(q.dequeue())
      size -= 1
    }
    topElem = q.front
    q.enqueue(q.dequeue())
    q.dequeue()
  }

  def isEmpty(): Boolean = {
    q.isEmpty
  }

}
