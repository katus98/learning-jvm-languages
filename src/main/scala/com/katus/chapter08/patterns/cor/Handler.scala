package com.katus.chapter08.patterns.cor

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
trait Handler {   // 特质可以继承class
  println("Handler Con!")
  def handle(data: String): Unit = {
    println(s"Handle: $data")
  }
}
