package study2

import scala.collection.mutable

/*
295. 数据流的中位数
中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例：

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2
进阶:

如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
class MedianFinder {
  val small = mutable.PriorityQueue[Int]()(Ordering.Int.reverse)
  val large = mutable.PriorityQueue[Int]()(Ordering.Int)

  def addNum(num: Int) {
    if (large.size <= small.size) {
      small.enqueue(num)
      large.enqueue(small.dequeue())
    } else {
      large.enqueue(num)
      small.enqueue(large.dequeue())
    }
  }

  def findMedian(): Double = {
    if (large.size < small.size) {
      small.head
    } else if (large.size > small.size) {
      large.head
    } else {
      (large.head + small.head) / 2.0
    }
  }

}

object TTT {
  def main(args: Array[String]): Unit = {
    val t = new MedianFinder()
    t.addNum(1)
    t.addNum((2))
    println(t.findMedian())
    t.addNum(3)
    println(t.findMedian())
  }
}
