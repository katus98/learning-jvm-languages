package com.katus.chapter11

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-20
 */
object OptionTest {
  def main(args: Array[String]): Unit = {
    test()
  }

  def divide(a: Double, b: Double): Option[Double] = if (b == 0) None else Some(a/b)

  def test(): Unit = {
    val result = divide(5, 0) match {
      case Some(x) => x
      case None => "By Zero!"
    }
    println(result)
    println(divide(5, 4).getOrElse("By Zero!"))
  }
}
