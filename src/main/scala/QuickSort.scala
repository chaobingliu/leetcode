import scala.util.Random

object QuickSort {
  def main(args: Array[String]): Unit = {
    val arr = Array(3, 2, 3, 1, 2, 4, 5, 5, 6)
    //    println(findKthLargest(arr, 2))
    quicksort(arr, 0, arr.length - 1)
    arr.map(println)

  }

  def findKthLargest(arr: Array[Int], k: Int): Int = {
    quickselect(arr, 0, arr.length - 1, arr.length - k)
  }

  def quicksort(arr: Array[Int], left: Int, right: Int) {
    if (left >= right) {
      return
    }
    val q = randomPartition(arr, left, right)
    quicksort(arr, left, q - 1)
    quicksort(arr, q + 1, right)
  }

  def quickselect(arr: Array[Int], left: Int, right: Int, index: Int): Int = {
    val q = randomPartition(arr, left, right)
    if (q == index) {
      arr(index)
    } else if (q < index) {
      quickselect(arr, q + 1, right, index)
    } else {
      quickselect(arr, left, q - 1, index)
    }
  }

  def randomPartition(arr: Array[Int], left: Int, right: Int): Int = {
    val randomIdx = Random.nextInt(right - left + 1) + left
    swap(arr, randomIdx, right)
    val x = arr(right)
    var i: Int = left - 1
    for (j <- left until right) {
      if (arr(j) <= x) {
        i += 1
        swap(arr, i, j)
      }
    }
    swap(arr, i + 1, right)
    i + 1
  }

  def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    if (i != j) {
      val temp = arr(i)
      arr(i) = arr(j)
      arr(j) = temp
    }
  }
}
