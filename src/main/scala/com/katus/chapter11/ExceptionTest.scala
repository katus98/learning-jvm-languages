package com.katus.chapter11

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-21
 */
object ExceptionTest {
  def main(args: Array[String]): Unit = {
    test1()
  }

  def test1(): Unit = {
    try {
      val result = 5 / 0
    } catch {
      case ex:ArithmeticException => ex.printStackTrace()
    } finally {
      println("finally")
    }
    println("Go on!")
  }
}
