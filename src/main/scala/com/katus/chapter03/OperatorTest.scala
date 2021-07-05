package com.katus.chapter03

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-18
 */
object OperatorTest {
  def main(args: Array[String]): Unit = {
    swap()
    swap2()
  }

  def test1(): Unit = {
    println("Worship Lee!" * 3)   // 字符串重复
    // 没有++ -- 没有三目运算符
  }

  def test2(): Unit = {
    val str1 = "hello"
    val str2 = str1 + ""
    println(str1 == str2)
    println(str1.eq(str2))
  }

  def swap(): Unit = {
    var a = 3
    var b = 5
    println(s"a = $a, b = $b")
    a = a + b
    b = a - b
    a = a - b
    println(s"a = $a, b = $b")
  }

  def swap2(): Unit = {
    var a = 30
    var b = 50
    println(s"a = $a, b = $b")
    val temp = a ^ b
    a = a ^ temp
    b = b ^ temp
    println(s"a = $a, b = $b")
  }
}
