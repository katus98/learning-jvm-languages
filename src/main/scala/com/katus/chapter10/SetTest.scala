package com.katus.chapter10

import scala.collection.mutable

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-20
 */
object SetTest {
  def main(args: Array[String]): Unit = {
    test3()
  }

  def test1(): Unit = {
    val st = Set[Int]()
    val s = Set(1, 1, 3, 2, 4, 8)
    println(st)
    println(s)
  }

  def test2(): Unit = {
    val set = Set(1, 1, 2, 3, 4, 5)
    println(set.size)
    for (ele <- set) println(ele)
    val s1 = set - 1   // 还有+
    println(s1)
    val s2 = set ++ Set(6, 7, 8)   // 还有++
    println(s2)
    val s3 = set ++ List(6, 7, 8, 9)   // 还有++
    println(s3)
  }

  def test3(): Unit = {
    val set = mutable.Set(1, 2, 3, 4)   // 可变集
    set += 5
    set ++= Set(6, 7, 8)
    set -= 1
    set --= Set(3, 5, 7)
    println(set)
  }
}
