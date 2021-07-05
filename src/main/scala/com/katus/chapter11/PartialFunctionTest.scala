package com.katus.chapter11

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-20
 */
object PartialFunctionTest {
  def main(args: Array[String]): Unit = {
    test2()
  }

  def test1(): Unit = {
    val pf: PartialFunction[Int, String] = {
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case 4 => "four"
      case _ => "others"
    }
    println(pf(4))
  }

  def test2(): Unit = {
    val lst = (1 to 10).toList
    val lst2 = lst.map{
      case x if x >= 1 && x <= 3 => "[1-3]"
      case x if x >= 4 && x <= 7 => "[4-7]"
      case x if x >= 8 => "[8-*]"
    }
    println(lst2)
  }
}
