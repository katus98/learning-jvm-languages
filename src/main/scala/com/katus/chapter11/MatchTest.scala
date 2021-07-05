package com.katus.chapter11

import com.katus.chapter11.cases.{Customer, Order}

import scala.io.StdIn

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-20
 */
object MatchTest {
  def main(args: Array[String]): Unit = {
    test8()
  }

  def test1(): Unit = {
    val str = StdIn.readLine()
    val result = str match {   // 简单匹配
      case "hello" => "greeting"
      case "good" => "something"
      case _ => "others"   // 不匹配
    }
    println(result)
  }

  def test2(): Unit = {
    val a:Any = "Scala"
    val result = a match {   // 类型匹配
      case x:String => s"$x is a String"
      case x:Int if x > 50 => s"$x is a Int"   // 守卫 只有当x>50才会执行
      case _:Double => "Double"   // 不用的变量名可以省略
      case _ => "Unknown Type"
    }
    println(result)
  }

  def test3(): Unit = {
    val c:Any = Customer("Zhang", 23)
    val o:Any = Order(10)
    c match {   // 样例类匹配 必须是Any类用来匹配
      case Customer(a, b) => println(a, b)
      case Order(a) => println(a)
      case _ => println("nothing")
    }
  }

  def test4(): Unit = {
    val arr1 = Array(1, 2, 5)
    val arr2 = Array(0)
    val arr3 = Array(1, 2, 5, 7, 9, 45)
    arr3 match {   // 数组匹配
      case Array(1, _, y) => println(s"first $y")
      case Array(0) => println("second")
      case Array(1, _*) => println("third")
      case _ => println("others")
    }
  }

  def test5(): Unit = {
    val lst1 = List(1, 2, 5)
    val lst2 = List(0)
    val lst3 = List(1, 2, 5, 7, 9, 45)
    lst1 match {   // 数组匹配
      case List(1, _, y) => println(s"first $y")
      case List(0) => println("second")
      case List(1, _*) => println("third")
      case _ => println("others")
    }
    lst3 match {   // 数组匹配
      case 1 :: _ :: y :: Nil => println(s"first $y")
      case 0 :: Nil => println("second")
      case 1 :: tail => println(s"third $tail")
      case _ => println("others")
    }
  }

  def test6(): Unit = {
    val tuple1 = (1, 2, 5)
    val tuple2 = (2, 7, 6)
    tuple2 match {   // 匹配元组
      case (1, 2, _) => println("Start with 1, 2")
      case (_, _, 6) => println("End with 6")
      case _ => println("others")
    }
  }

  def test7(): Unit = {
    val arr = (1 to 10).toArray
    val Array(_, x, y, z, _*) = arr
    println(x, y, z)

    val lst = (1 to 10).toList
    val List(_, _, a, b, _*) = lst
    println(a, b)
    val _ :: _ :: c :: d :: tail = lst
    println(c, d)
  }

  def test8(): Unit = {
    val map = Map("Zhang"->23, "Sun"->22, "Yu"->41, "Wan"->22)
    for ((k, 22) <- map) println(k, 22)   // for 模式匹配
  }
}
