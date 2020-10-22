import scala.collection.mutable

/*
146. LRU缓存机制
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。



进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？



示例:

LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得关键字 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得关键字 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4
 */
class LRUCache(_capacity: Int) {
  val capacity = _capacity
  val head: DLink = new DLink()
  val tail: DLink = new DLink()
  val map: mutable.Map[Int, DLink] = mutable.Map[Int, DLink]()
  head.next = tail
  tail.pre = head
  var size: Int = 0


  def get(key: Int): Int = {
    if (map.contains(key)) {
      val dLink = map(key)
      dLink.pre.next = dLink.next
      dLink.next.pre = dLink.pre

      dLink.next = head.next
      head.next.pre = dLink
      head.next = dLink
      dLink.pre = head

      dLink.value
    } else {
      -1
    }
  }

  def put(key: Int, value: Int) {

    if (map.contains(key)) {
      val link = map(key)
      link.pre.next = link.next
      link.next.pre = link.pre
      link.value = value

      link.next = head.next
      head.next.pre = link
      head.next = link
      link.pre = head
    } else {
      if (size == capacity) {
        val lastLink = tail.pre
        tail.pre = lastLink.pre
        lastLink.pre.next = tail
        map.remove(lastLink.key)
      } else {
        size += 1
      }
      val newDLink = new DLink(key, value)
      val firstLink = head.next
      newDLink.next = firstLink
      newDLink.pre = head
      firstLink.pre = newDLink
      head.next = newDLink
      map.put(key, newDLink)
    }
  }

}

class DLink(_key: Int = 0, _value: Int = -1) {
  val key: Int = _key
  var value: Int = _value
  var pre: DLink = _
  var next: DLink = _
}

object TestDLink {
  def main(args: Array[String]): Unit = {
    val cache: LRUCache = new LRUCache(10)
    cache.put(10, 13)
    cache.put(3, 17)
    cache.put(6, 11)
    cache.put(10, 5)
    cache.put(9, 10)
    println(cache.get(13))
    cache.put(2, 19)
    println(cache.get(2))
    println(cache.get(3))
    cache.put(5, 25)
    println(cache.get(8))
    cache.put(9, 22)
    cache.put(5, 5)
    cache.put(1, 30)
    println(cache.get(11))
    cache.put(9, 12)
    println(cache.get(7))
    println(cache.get(5))
    println(cache.get(8))
    println(cache.get(9))
    cache.put(4, 30)
    cache.put(9, 3)
    println(cache.get(9))
    println(cache.get(10))

    //    println(cache.get(1))
    //    println(cache.put(3, 3)) // 该操作会使得关键字 2 作废
    //    println(cache.get(2)) // 返回 -1 (未找到)
    //    println(cache.put(4, 4)) // 该操作会使得关键字 1 作废
    //    println(cache.get(1)) // 返回 -1 (未找到)
    //    println(cache.get(3)) // 返回  3
    //    println(cache.get(4))


  }
}