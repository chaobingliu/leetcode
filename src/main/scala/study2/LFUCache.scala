package study2

import scala.collection.mutable

/*
460. LFU 缓存
请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。

实现 LFUCache 类：

LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。
void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。
注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。



进阶：

你是否可以在 O(1) 时间复杂度内执行两项操作？


示例：

输入：
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
输出：
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

解释：
LFUCache lFUCache = new LFUCache(2);
lFUCache.put(1, 1);
lFUCache.put(2, 2);
lFUCache.get(1);      // 返回 1
lFUCache.put(3, 3);   // 去除键 2
lFUCache.get(2);      // 返回 -1（未找到）
lFUCache.get(3);      // 返回 3
lFUCache.put(4, 4);   // 去除键 1
lFUCache.get(1);      // 返回 -1（未找到）
lFUCache.get(3);      // 返回 3
lFUCache.get(4);      // 返回 4


提示：

0 <= capacity, key, value <= 104
最多调用 105 次 get 和 put 方法
 */

class LFUCache(_capacity: Int) {
  val capacity = _capacity
  val keyToVal = mutable.Map[Int, Int]()
  val keyToFreq = mutable.Map[Int, Int]()
  val freqToKeys = mutable.Map[Int, mutable.LinkedHashSet[Int]]()
  var minFreq = 0

  def get(key: Int): Int = {
    if (!keyToVal.contains(key)) return -1
    increaseFreq(key)
    keyToVal(key)
  }

  def put(key: Int, value: Int) {
    if (capacity <= 0) return
    if (keyToVal.contains(key)) {
      increaseFreq(key)
      keyToVal(key) = value
    } else {
      if (keyToVal.size == capacity) {
        removeMinFreqKey()
      }
      keyToVal(key) = value
      keyToFreq(key) = 1
      if (!freqToKeys.contains(1)) freqToKeys(1) = new mutable.LinkedHashSet[Int]()
      freqToKeys(1).add(key)
      minFreq = 1
    }

  }

  def increaseFreq(key: Int): Unit = {
    var freq = keyToFreq(key)
    val keyList = freqToKeys(freq)
    keyList.remove(key)
    if (keyList.isEmpty) {
      freqToKeys.remove(freq)
      if (minFreq == freq) {
        minFreq += 1
      }
    }

    freq += 1
    keyToFreq(key) = freq
    if (!freqToKeys.contains(freq)) freqToKeys(freq) = new mutable.LinkedHashSet[Int]()
    freqToKeys(freq).add(key)
  }

  def removeMinFreqKey(): Unit = {
    val keyList = freqToKeys(minFreq)
    val key = keyList.iterator.next()
    keyToVal.remove(key)
    keyToFreq.remove(key)
    keyList.remove(key)
    if (keyList.isEmpty) {
      freqToKeys.remove(minFreq)
    }
  }
}

object T {
  def main(args: Array[String]): Unit = {
    //[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
    val lFUCache = new LFUCache(2);
    lFUCache.get(2)
    lFUCache.put(2, 6);
    println(lFUCache.get(1))
    lFUCache.put(1, 5)
    lFUCache.put(1, 2)
    println(lFUCache.get(1))
    println(lFUCache.get(2))
  }

}