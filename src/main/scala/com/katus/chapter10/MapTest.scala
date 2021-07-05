package com.katus.chapter10

import scala.collection.mutable

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-20
 */
object MapTest {
  def main(args: Array[String]): Unit = {
    test3()
  }

  def test1(): Unit = {
    val m1 = Map("Zhang"->24, "Sun"->18, "Sun"->22)
    val m2 = Map(("K", 16), (15, 12))
    println(m1)
    println(m2)
  }

  def test2(): Unit = {
    val map = mutable.Map("Zhang"->23, "Li"->24)
    map("Zhang") = 30
    println(map)
  }

  def test3(): Unit = {
    val map = Map("Zhang"->23, "Li"->24)
    println(map("Zhang"))
    println(map.keys)
    println(map.values)
    for (ele <- map) println(ele._1 + ": " + ele._2)
    println(map.getOrElse("Wan", -1))
    val mapC = mutable.Map[String, Int]()
    mapC ++= map
    mapC += "Wan"->26
    mapC -= "Zhang"   // 删除的时候只写键
    println(mapC)
  }
}
