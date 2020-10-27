import Solutions.TreeNode

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

  def sedfs(root: TreeNode, builder: StringBuilder) {
    if (root == null) {
      builder.append("null")
      builder.append(",")
      return

    }
    builder.append(root.value)
    builder.append(",")
    sedfs(root.left, builder)
    sedfs(root.right, builder)
  }

  // Encodes a list of strings to a single string.
  def serialize(root: TreeNode): String = {
    var builder: StringBuilder = new StringBuilder()
    sedfs(root, builder)
    builder.toString()
  }

  def dedfs(buffer: mutable.Buffer[String]): TreeNode = {
    if (buffer(0) == "null") {
      buffer.remove(0)
      return null
    }
    val node: TreeNode = new TreeNode(buffer(0).toInt)
    buffer.remove(0)
    node.left = dedfs(buffer)
    node.right = dedfs(buffer)
    node
  }

  // Decodes a single string to a list of strings.
  def deserialize(data: String): TreeNode = {
    val buffer: mutable.Buffer[String] = data.split(",").toBuffer
    dedfs(buffer)
  }

}

object TestCodec {
  def main(args: Array[String]): Unit = {
    val A = new TreeNode(1)
    val B = new TreeNode(2)
    val C = new TreeNode(3)
    val F = new TreeNode(4)
    val G = new TreeNode(5)
    A.left = B
    A.right = C
    C.left = F
    C.right = G
    var ser = new Codec
    val s = ser.serialize(A)
    val t = ser.deserialize(s)
    println(s == ser.serialize(t))

  }
}
