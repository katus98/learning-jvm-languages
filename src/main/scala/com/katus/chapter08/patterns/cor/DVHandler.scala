package com.katus.chapter08.patterns.cor

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
trait DVHandler extends Handler {
  println("DVHandler Con!")
  override def handle(data: String): Unit = {
    println(s"DV handled: $data")
    super.handle(data)
  }
}
