package com.katus.chapter04

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-18
 */
object IfElseTest {
  def main(args: Array[String]): Unit = {
    println(getMax(5, 2, 3))
  }

  def test1(): Unit = {
    val score = 50
    if (score >= 60) {
      println("Pass!")
    }
  }

  def test2(): Unit = {
    val score = 95
    if (score < 60) {
      println("Failed!")
    } else {
      println("Pass!")
    }
  }

  def test3(): Unit = {
    val score = 78
    if (score >= 90) {
      println("Very good!")
    } else if (score >= 80) {
      println("Good!")
    } else if (score >= 70) {
      println("Not bad!")
    } else if (score >= 60) {
      println("So so!")
    } else {
      println("Not good!")
    }
  }

  def test4(): Unit = {
    // Scala中替代三目运算符的写法
    val gender = "male"
    val code = if (gender == "male") 1 else 2
    println(s"code = $code")
  }

  def getMax(a: Int, b: Int, c: Int): Int = {
    if (a >= b) {
      if (a >= c) a else c
    } else {
      if (b >= c) b else c
    }
  }
}
