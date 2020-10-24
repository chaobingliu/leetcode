import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks

/*
208. 实现 Trie (前缀树)
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。
 */
class Trie {
  val head: TreeListNode = new TreeListNode()

  /** Initialize your data structure here. */


  /** Inserts a word into the trie. */
  def insert(word: String) {
    if (word == null || word.isEmpty) {
      return
    }
    var temp = head
    for (i <- 0 until word.length) {
      val next = temp.links
      if (next != null) {
        val loop = new Breaks
        loop.breakable {
          for (j <- 0 to next.length) {
            if (next(j).value == word.charAt(i)) {
              temp = next(j)
              loop.break()
            }
            if (j == next.length - 1) {
              val newTree = new TreeListNode(word.charAt(i))
              temp.links.append(newTree)
              temp = newTree
            }
          }
        }
      } else {
        temp.links = new ListBuffer[TreeListNode]()
        val newTree = new TreeListNode(word.charAt(i))
        temp.links.append(newTree)
        temp = newTree
      }
    }
    temp.isEnd = true
  }

  /** Returns if the word is in the trie. */
  def search(word: String): Boolean = {
    var temp = head
    for (i <- 0 until word.length) {
      val next = temp.links
      if (next != null) {
        val loop = new Breaks
        loop.breakable {
          for (j <- 0 until next.length) {
            if (next(j).value == word.charAt(i)) {
              temp = next(j)
              loop.break()
            }
          }
          return false
        }
      } else {
        return false
      }
    }
    temp.isEnd

  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  def startsWith(prefix: String): Boolean = {
    var temp = head
    if (head.links == null) {
      return prefix.isEmpty
    }
    for (i <- 0 until prefix.length) {
      val next = temp.links
      if (next != null) {
        val loop = new Breaks
        loop.breakable {
          for (t <- next) {
            if (t.value == prefix.charAt(i)) {
              temp = t
              loop.break()
            }
          }
          return false
        }
      } else {
        return false
      }
    }
    true
  }
}

class TreeListNode(val _c: Char = ' ') {
  val value = _c
  var isEnd = false
  var links: ListBuffer[TreeListNode] = _
}

object testtree {
  def main(args: Array[String]): Unit = {
    val obj = new Trie
    //    obj.insert("apple")
    //    obj.insert("apk")
    //    println(obj.search("apple"))
    //    println(obj.search("app"))
    //    println(obj.search("apk"))
    //    println(obj.startsWith("ap"))
    println(obj.startsWith("a"))
  }
}