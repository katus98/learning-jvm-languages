package com.katus.chapter10

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-20
 */
object IteratorTest {
  def main(args: Array[String]): Unit = {
    test1()
  }

  def test1(): Unit = {
    val lst = List(1, 2, 3, 4, 5, 6)
    val it = lst.iterator
    while (it.hasNext) {
      println(it.next())
    }
  }
}
