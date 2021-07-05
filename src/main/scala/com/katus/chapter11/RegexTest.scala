package com.katus.chapter11

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-20
 */
object RegexTest {
  def main(args: Array[String]): Unit = {
    test3()
  }

  def test1(): Unit = {
    val email = "sunkeran@126.com"
    val regex = """.+@.+\..+""".r
    if (regex.findAllMatchIn(email).nonEmpty) {
      println(s"$email is good!")
    } else {
      println(s"$email is bad!")
    }
  }

  def test2(): Unit = {
    val emails = List("sunkeran@126.com", "skrskr@qq.com", "sun|fox.com")
    val regex = """.+@.+\..+""".r
    val goodEmails = emails.filter(regex.findAllMatchIn(_).nonEmpty)
    println(goodEmails)
  }

  def test3(): Unit = {
    val emails = List("sunkeran@126.com", "skrskr@qq.com", "sun|fox.com")
    val regex = """.+@(.+)\..+""".r
    val goodEmails = emails.map{
      case x @ regex(company) => x -> company   // 匹配分支 括号内即为限定()内的内容 其余为固定格式
      case x => x -> "Not correct!"
    }
    println(goodEmails)
  }
}
