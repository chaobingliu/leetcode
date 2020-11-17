package study2

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class TwoSum {
  val freq = mutable.Map[Int, Int]()

  def add(number: Int): Unit = {
    freq(number) = freq.getOrElse(number, 0) + 1
  }

  def find(value: Int): Boolean = {
    for (key <- freq.keySet) {
      val other = value - key
      if (other == key && freq(other) > 1) return true
      if (other != key && freq.contains(other)) return true
    }
    false
  }

}

class TwoSum2 {
  val sum = mutable.Set[Int]()
  val nums = new ListBuffer[Int]()

  def add(number: Int): Unit = {
    for (n <- nums) {
      sum.add(n + number)
    }
    nums.append(number)
  }

  def find(value: Int): Boolean = {
    sum.contains(value)
  }

}

object TS {
  def main(args: Array[String]): Unit = {
    val ts = new TwoSum2()
    ts.add(3)
    ts.add(3)
    ts.add(2)
    ts.add(5)
    println(ts.find(8))
  }
}