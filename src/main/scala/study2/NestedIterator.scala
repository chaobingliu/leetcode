package study2

import scala.collection.mutable


class NestedInteger {
  var value: Int = 0
  var list: List[NestedInteger] = null

  def this(_value: Int) {
    this()
    this.value = _value
  }

  def this(_list: List[NestedInteger]) {
    this()
    this.list = _list
  }


  // Return true if this NestedInteger holds a single integer, rather than a nested list.
  def isInteger: Boolean = {
    value != null
  }

  // Return the single integer that this NestedInteger holds, if it holds a single integer
  def getInteger: Int = {
    this.value
  }

  // Set this NestedInteger to hold a single integer.
  def setInteger(i: Int) = {
    value = i
  }

  // Return the nested list that this NestedInteger holds, if it holds a nested list
  def getList = {
    this.list
  }

  // Set this NestedInteger to hold a nested list and adds a nested integer to it.
  def add(ni: NestedInteger) = {}
}

class NestedIterator(_nestedList: List[NestedInteger]) {

  var buffer = mutable.ListBuffer[Int]()
  for (nl <- _nestedList) {
    traverse(nl)
  }
  val it = buffer.toIterator

  def traverse(nestedInteger: NestedInteger): Unit = {
    if (nestedInteger.isInteger) {
      buffer.append(nestedInteger.getInteger)
    } else {
      for (child <- nestedInteger.list) {
        traverse(child)
      }
    }
  }

  val nestedList = _nestedList

  def next(): Int = {
    it.next()
  }

  def hasNext(): Boolean = {
    it.hasNext

  }
}

class NestedIteratorLazy(_nestedList: List[NestedInteger]) {
  val buffer: mutable.Buffer[NestedInteger] = _nestedList.toBuffer

  def next(): Int = {
    buffer.remove(0).getInteger
  }

  def hasNext(): Boolean = {
    while (!buffer.isEmpty && !buffer(0).isInteger) {
      val list = buffer.remove(0).getList
      for (i <- Range(list.length - 1, -1, -1)) {
        buffer.insert(0, list(i))
      }
    }
    !buffer.isEmpty
  }

}
