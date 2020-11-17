package study2

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random

/*
380. 常数时间插入、删除和获取随机元素
设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。

insert(val)：当元素 val 不存在时，向集合中插入该项。
remove(val)：元素 val 存在时，从集合中移除该项。
getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
示例 :

// 初始化一个空的集合。
RandomizedSet randomSet = new RandomizedSet();

// 向集合中插入 1 。返回 true 表示 1 被成功地插入。
randomSet.insert(1);

// 返回 false ，表示集合中不存在 2 。
randomSet.remove(2);

// 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
randomSet.insert(2);

// getRandom 应随机返回 1 或 2 。
randomSet.getRandom();

// 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
randomSet.remove(1);

// 2 已在集合中，所以返回 false 。
randomSet.insert(2);

// 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
randomSet.getRandom();
 */
class RandomizedSet {
  val nums = ListBuffer[Int]()
  val valToIndex = mutable.Map[Int, Int]()
  /** Initialize your data structure here. */


  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  def insert(`val`: Int): Boolean = {
    if (valToIndex.contains(`val`)) return false
    valToIndex(`val`) = nums.length
    nums.append(`val`)
    true
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  def remove(`val`: Int): Boolean = {
    if (!valToIndex.contains(`val`)) return false
    val idx = valToIndex(`val`)
    nums(idx) = nums.last
    valToIndex(nums.last) = idx
    nums.remove(nums.length - 1)
    valToIndex.remove(`val`)
    true
  }

  /** Get a random element from the set. */
  def getRandom(): Int = {
    nums(Random.nextInt(nums.size))
  }

}

object RandomizedSet {
  def main(args: Array[String]): Unit = {
    val r =new RandomizedSet()
    r.insert(1)
    r.remove(2)
    r.insert(2)
    println(r.getRandom())
    r.remove(1)
    r.insert(2)
    println(r.getRandom())
  }
}
