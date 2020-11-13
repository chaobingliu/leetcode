package study2

import scala.collection.mutable

/*
297. 二叉树的序列化与反序列化
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

示例:

你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
class Codec {
  val SEP = ","
  val NULL_STR = "#"

  // Encodes a list of strings to a single string.
  def serialize_pre(root: TreeNode): String = {
    val builder = new StringBuilder()

    def traverse(root: TreeNode): Unit = {
      if (root == null) {
        builder.append(NULL_STR).append(SEP)
        return
      }
      builder.append(root.value).append(SEP)
      traverse(root.left)
      traverse(root.right)
    }

    traverse(root)
    builder.toString()
  }

  // Decodes a single string to a list of strings.
  def deserialize_pre(data: String): TreeNode = {
    val buffer = data.split(SEP).toBuffer

    def traverse(): TreeNode = {
      if (buffer.isEmpty) return null
      val str = buffer.remove(0)
      if (str == NULL_STR) return null
      val root = new TreeNode(str.toInt)
      root.left = traverse()
      root.right = traverse()
      root
    }

    traverse()
  }

  // Encodes a list of strings to a single string.
  def serialize_post(root: TreeNode): String = {
    val builder = new StringBuilder()

    def traverse(root: TreeNode): Unit = {
      if (root == null) {
        builder.append(NULL_STR).append(SEP)
        return
      }
      traverse(root.left)
      traverse(root.right)
      builder.append(root.value).append(SEP)
    }

    traverse(root)
    builder.toString()
  }

  // Decodes a single string to a list of strings.
  def deserialize_post(data: String): TreeNode = {
    val buffer = data.split(SEP).toBuffer

    def traverse(): TreeNode = {
      if (buffer.isEmpty) return null
      val str = buffer.remove(buffer.length - 1)
      if (str == NULL_STR) return null
      val root = new TreeNode(str.toInt)
      root.right = traverse()
      root.left = traverse()
      root
    }

    traverse()
  }

  // Encodes a list of strings to a single string.
  def serialize_layer(root: TreeNode): String = {
    if (root == null) return ""
    val builder = new mutable.StringBuilder()
    val queue = mutable.Queue[TreeNode]()
    queue.enqueue(root)
    while (!queue.isEmpty) {
      val node = queue.dequeue()
      if (node == null) {
        builder.append(NULL_STR).append(SEP)
      } else {
        builder.append(node.value).append(SEP)
        queue.enqueue(node.left)
        queue.enqueue(node.right)
      }
    }
    builder.toString()
  }

  // Decodes a single string to a list of strings.
  def deserialize_layer(data: String): TreeNode = {
    if (data == null || data.isEmpty) return null
    val arr = data.split(SEP)

    val root = new TreeNode(arr(0).toInt)
    val queue = mutable.Queue[TreeNode]()
    queue.enqueue(root)
    var i = 1
    while (i < arr.length) {
      val node = queue.dequeue()
      val left = arr(i)
      i += 1
      if (left != NULL_STR) {
        node.left = new TreeNode(left.toInt)
        queue.enqueue(node.left)
      } else {
        node.left = null
      }
      val right = arr(i)
      i += 1
      if (right != NULL_STR) {
        node.right = new TreeNode(right.toInt)
        queue.enqueue(node.right)
      } else {
        node.right = null
      }
    }
    root
  }
}
