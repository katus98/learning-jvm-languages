package com.katus.chapter01

import scala.util.control.Breaks

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-14
 */
object AgeJudgement {
  def main(args: Array[String]): Unit = {
    var age = 22
    while (age > 0) {
      if (age < 20) {
        println("kids: " + age)
      } else if (age < 35) {
        println("young: " + age)
      } else {
        println("old: " + age)
      }
      age -= 1
    }
    do {
      age += 1
    } while (age < 50)
    println("final: " + age)
    for (i <- 1 to 5) {
      println(i)
    }
    for (i <- 1 until 3) {
      println(i)
    }
    val lst = List(1, 5, 7, 4, 0)
    for (a <- lst) {
      println(a)
    }
    val inner, outer = new Breaks
    outer.breakable {
      for (i <- 1 to 5) {
        inner.breakable {
          for (j <- 1 to 5) {
            println(i + " " + j)
            if (j == 4) {
              inner.break()
            }
          }
        }
        if (i == 3) {
          outer.break()
        }
      }
    }
  }
}
