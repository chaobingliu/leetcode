package study2

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks

class Twitter {
  /** Initialize your data structure here. */

  val userMap = mutable.Map[Int, User]()


  /** Compose a new tweet. */
  def postTweet(userId: Int, tweetId: Int) {
    // 若 userId不存在，则新建
    if (!userMap.contains(userId)) userMap(userId) = new User(userId)
    val u = userMap(userId)
    userMap(userId) = u
    u.post(tweetId)

  }

  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  def getNewsFeed(userId: Int): List[Int] = {
    val res = ListBuffer[Int]()
    if (!userMap.contains(userId)) return res.toList
    // 关注列表的用户 Id
    val users = userMap(userId).followed
    val pq = mutable.PriorityQueue.empty[Tweet](Ordering.by(_.time))

    for (id <- users) {
      val twt = userMap(id).head
      if (twt != null) pq.enqueue(twt)
    }
    val loop = new Breaks
    loop.breakable {
      while (!pq.isEmpty) {
        if (res.size == 10) loop.break()
        // 弹出time值最大的（最近发表的）
        val twt = pq.dequeue()
        res.append(twt.id)
        // 将下一篇 Tweet  插入进行排序
        if (twt.next != null) {
          pq.enqueue(twt.next)
        }
      }
    }
    res.toList
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  def follow(followerId: Int, followeeId: Int) {
    // 若follow不存在，则新建
    if (!userMap.contains(followerId)) {
      val u = new User(followerId)
      userMap(followerId) = u
    }
    // 若followee 不存在，则新建
    if (!userMap.contains(followeeId)) {
      val u = new User(followeeId)
      userMap(followeeId) = u
    }
    userMap(followerId).follow(followeeId)

  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  def unfollow(followerId: Int, followeeId: Int) {
    if (userMap.contains(followerId)) {
      val flwer = userMap(followerId)
      flwer.unfollow(followeeId)
    }

  }

}

object Twitter {
  var timestamp = 0
}

case class Tweet(id: Int, time: Int, var next: Tweet = null)

class User(_id: Int) {
  val id: Int = _id
  val followed = mutable.Set[Int](id)
  var head: Tweet = null

  def follow(userId: Int): Unit = {
    followed.add(userId)
  }

  def unfollow(userId: Int): Unit = {
    if (userId != id) {
      followed.remove(userId)
    }
  }

  def post(tweetId: Int): Unit = {
    val twt = Tweet(tweetId, Twitter.timestamp)
    Twitter.timestamp += 1
    twt.next = head
    head = twt
  }

}