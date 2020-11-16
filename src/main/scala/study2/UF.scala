package study2

class UF(_count: Int) {
  var count = _count
  val parent = new Array[Int](_count)
  val size = new Array[Int](_count)

  for (i <- 0 until _count) {
    parent(i) = i
    size(i) = 1
  }

  def union(p: Int, q: Int): Unit = {
    val rootP = find(p)
    val rootQ = find(q)
    if (rootP == rootQ) return

    if (size(rootP) > size(rootQ)) {
      parent(rootQ) = rootP
      size(rootP) += size(rootQ)
    } else {
      parent(rootP) = rootQ
      size(rootQ) += size(rootP)
    }
    count -= 1
  }

  def connected(p: Int, q: Int): Boolean = {
    val rootP = find(p)
    val rootQ = find(q)
    rootP == rootQ
  }

  def find(_x: Int): Int = {
    var x = _x
    while (parent(x) != x) {
      // 进行路径压缩
      parent(x) = parent(parent(x))
      x = parent(x)
    }
    x
  }

}
