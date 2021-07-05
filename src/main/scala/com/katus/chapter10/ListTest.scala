package com.katus.chapter10

import scala.collection.mutable.ListBuffer

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-20
 */
object ListTest {
  def main(args: Array[String]): Unit = {
    test8()
  }

  def test1(): Unit = {
    val l1 = List(1, 2, 3, 4, "45")
    val l2 = Nil
    val l3 = -1 :: -2 :: "String" :: Nil
    println(l1, l2, l3)
  }

  def test2(): Unit = {
    val l1 = ListBuffer[Int]()
    val l2 = ListBuffer(1, 2, 3, "String")
    println(l1, l2)
  }

  def test3(): Unit = {
    val lst = ListBuffer(1, 2, 3)
    println(lst(2))
    lst += 4
    lst ++= List(5, 6, 7)
    lst -= 7
    lst --= List(3, 4)
    val fixed = lst.toList
    val arr = lst.toArray
    println(lst)
    println(fixed)
    println(arr.mkString("Array(", ", ", ")"))
  }

  def test4(): Unit = {
    val l1 = List(1, 2, 3, 4)
    val l2 = List(4, 5, 6)
    println(l1.isEmpty)   // 判断是否为空
    println(l1 ++ l2)   // 连接列表
    println(l1.head)   // 返回首位元素
    println(l1.tail)   // 返回除首位之外的列表
    println(l1.reverse)   // 反转
    println(l1.take(2))   // 前缀几个
    println(l1.take(2))   // 后缀几个
  }

  def test5(): Unit = {
    val lst = List(List(1, 2), List(3), List(4, 5))
    println(lst)
    val l2 = lst.flatten   // 列表扁平化
    println(l2)
  }

  def test6(): Unit = {
    val lst1 = List("Zhang", "Li", "Sun")
    val lst2 = List(23, 24, 22)
    val lst = lst1.zip(lst2)
    println(lst)
    val tuple = lst.unzip
    println(tuple)
  }

  def test7(): Unit = {
    val lst = List(1, 2, 3, 4)
    println(lst.toString())
    println(lst.mkString)   // 缺省时没有分隔符
    println(lst.mkString(", "))
  }

  def test8(): Unit = {
    val lst1 = List(1, 2, 3, 4)
    val lst2 = List(3, 4, 5, 6)
    val lst = lst1.union(lst2)   // 并集 不去重
    println(lst)
    println(lst.distinct)   // 去重
    println(lst1.intersect(lst2))   // 交集 去重
    println(lst1.diff(lst2))   // 差集
  }
}
