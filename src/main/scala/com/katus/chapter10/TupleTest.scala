package com.katus.chapter10

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-20
 */
object TupleTest {
  def main(args: Array[String]): Unit = {
    test2()
  }

  def test1(): Unit = {
    val t1 = ("Tom", "Spark", 23)   // 元组
    val t2 = "Sam"->50   // 仅限双元素元组
    println(t1, t2)
  }

  def test2(): Unit = {
    val t = ("Hello", "World", "Happy", "Apple", 50, 74.5, true)
    println(t._1, t._7)
    val it = t.productIterator
    for (ele <- it) println(ele)
  }
}
