package com.katus.chapter08.patterns.cor

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
trait SVHandler extends Handler {
  println("SVHandler Con!")
  override def handle(data: String): Unit = {
    println(s"SV Handled: $data")
    super.handle(data)
  }
}
