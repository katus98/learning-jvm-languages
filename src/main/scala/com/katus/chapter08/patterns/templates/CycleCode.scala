package com.katus.chapter08.patterns.templates

import scala.util.control.Breaks._

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
class CycleCode extends Template {
  override def code(): Unit = {
    var count = 0
    for (i <- 3 to 1000000) {
      breakable {
        for (j <- 2 to Math.sqrt(i).toInt) {
          if (i % j == 0) {
            count += 1
            break()
          }
        }
      }
    }
  }
}
