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
  val root: TrieNode = new TrieNode()
  /** Initialize your data structure here. */

  /** Inserts a word into the trie. */
  def insert(word: String) {
    var tempNode = root
    for (c <- word) {
      if (!tempNode.contais(c)) {
        tempNode.put(c, new TrieNode(c))
      }
      tempNode = tempNode.get(c)
    }
    tempNode.isEnd = true
  }

  def searchPrefix(prefix: String): TrieNode = {
    var tempNode = root
    for (c <- prefix) {
      if (tempNode.contais(c)) {
        tempNode = tempNode.get(c)
      } else {
        return null
      }
    }
    tempNode
  }

  /** Returns if the word is in the trie. */
  def search(word: String): Boolean = {
    val ret = searchPrefix(word)
    ret != null && ret.isEnd
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  def startsWith(prefix: String): Boolean = {
    val ret = searchPrefix(prefix)
    ret != null
  }
}

class TrieNode(val _c: Char = ' ') {
  val value = _c
  var isEnd = false
  var links: Array[TrieNode] = new Array[TrieNode](26)

  def contais(c: Char): Boolean = {
    links(c - 'a') != null
  }

  def get(c: Char): TrieNode = {
    links(c - 'a')
  }

  def put(c: Char, node: TrieNode): Unit = {
    links(c - 'a') = node
  }
}

object testtree {
  def main(args: Array[String]): Unit = {
    val obj = new Trie
    //        obj.insert("apple")
    //        obj.insert("apk")
    //        println(obj.search("apple"))
    //        println(obj.search("app"))
    //        println(obj.search("apk"))
    //        println(obj.startsWith("ap"))
    println(obj.startsWith("a"))
  }
}