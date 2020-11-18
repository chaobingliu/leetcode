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

  def eatGrape(a: Long, b: Long, c: Long): Long = {
    val nums = Array(a, b, c).sorted
    val sum = nums.sum

    if (nums(0) + nums(1) > nums(2)) return (sum + 2) / 3
    if (2 * (nums(0) + nums(1)) < nums(2)) return (nums(2) + 1) / 2
    (sum + 2) / 3
  }
}
