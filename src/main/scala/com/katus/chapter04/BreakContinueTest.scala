package com.katus.chapter04

import scala.util.control.Breaks._

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-18
 */
object BreakContinueTest {
  def main(args: Array[String]): Unit = {
    var i = 0
    // 替代break
    breakable {
      while (i < 100) {
        if (i == 10) break() else println(s"i = $i")
        i += 1
      }
    }
    // 替代continue
    for (j <- 0 until 20) {
      breakable {
        if (j % 3 == 0) break() else println(s"j = $j")
      }
    }
  }
}
