package com.katus.chapter10

import scala.collection.mutable.ArrayBuffer

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-20
 */
object ArrayTest {
  def main(args: Array[String]): Unit = {
    test5()
  }

  def test1(): Unit = {
    val arr1 = new Array[Int](10)   // 定长数组
    arr1(0) = 1
    println(arr1(0))
    val arr2 = Array("Java", "Scala", "Python")
    println(arr2(1))
  }

  def test2(): Unit = {
    val arr1 = ArrayBuffer[Int]()   // 变长数组
    val arr2 = ArrayBuffer("Hadoop", "Storm", "Spark")
    println(s"arr1 = $arr1, arr2 = $arr2")
  }

  def test3(): Unit = {
    val arr = ArrayBuffer("Hadoop", "Spark", "Flink")
    arr += "Flume"   // 增加元素
    arr -= "Hadoop"   // 去除元素
    arr ++= ArrayBuffer("Hive", "Sqoop")   // 批量增加元素
    arr --= ArrayBuffer("Sqoop", "Spark")   // 批量移除元素
    println(s"arr = $arr")
  }

  def test4(): Unit = {
    val arr = Array(1, 2, 3, 4, 5)
    for (i <- arr.indices) println(arr(i))
    for (ele <- arr) println(ele)
  }

  def test5(): Unit = {
    val arr = Array(4, 1, 6, 5, 2, 3)
    println(arr.sum)
    println(arr.max)
    println(arr.min)
    println(arr.sorted.mkString("Array(", ", ", ")"))
    println(arr.reverse.mkString("Array(", ", ", ")"))
  }
}
