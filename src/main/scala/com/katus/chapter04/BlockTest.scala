package com.katus.chapter04

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-18
 */
object BlockTest {
  def main(args: Array[String]): Unit = {
    val a = {
      println("1 + 1")
      1 + 1
    }   // 块表达式的值为其中最后一个表达式的值
    println(s"a = $a")
  }
}
