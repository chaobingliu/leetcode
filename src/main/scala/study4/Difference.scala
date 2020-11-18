package study4

class Difference(nums: Array[Int]) {
  val n = nums.length
  val diff = new Array[Int](n)
  diff(0) = nums(0)
  for (i <- 1 until n) {
    diff(i) = nums(i) - nums(i - 1)
  }

  def increment(i: Int, j: Int, value: Int): Unit = {
    diff(i) += value
    if (j + 1 < n) {
      diff(j + 1) -= value
    }
  }

  def result(): Array[Int] = {
    val res = new Array[Int](n)
    res(0) = diff(0)
    for (i <- 1 until n) {
      res(i) = diff(i) + res(i - 1)
    }
    res
  }
}
