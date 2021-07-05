package com.katus.chapter04

import scala.io.StdIn
import scala.util.control.Breaks._

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-18
 */
object ForTest {
  def main(args: Array[String]): Unit = {
    loginTest()
  }

  def test1(): Unit = {
    for (i <- 1 to 10) {
      println(s"Circle number: $i")
    }
  }

  def printStar(row: Int, col: Int): Unit = {
    for (_ <- 1 to row; j <- 1 to col) {   // 双层循环合并 外循环;内循环
      if (j == col) {
        println("*")
      } else {
        print("*")
      }
    }
  }

  def printMod(max: Int, a: Int): Unit = {
    for (i <- 1 to max if i % a == 0) {   // 守卫 循环参数只有满足if后的条件才能进入循环体
      println(i)
    }
  }

  def test2(): Unit = {
    val nums = for (i <- 1 to 10) yield i * 10   // 推导式 yield 将结果合并为集合返回
    println(nums)
  }

  def printMultiplicationTable(): Unit = {
    for (i <- 1 to 9; j <- 1 to 9 if i >= j) {
      if (i == j) {
        println(s"$j * $i = ${i*j}")
      } else {
        print(s"$j * $i = ${i*j}\t")
      }
    }
  }

  def loginTest(): Unit = {
    var name = ""
    var password = ""
    var flag = false
    breakable {
      for (i <- 1 to 3) {
        print("Name: ")
        name = StdIn.readLine()
        print("Password: ")
        password = StdIn.readLine()
        if (name == "laoWang" && password == "itat") {
          flag = true
          break()
        } else {
          println("Error")
        }
      }
    }
    if (flag) {
      println("Login!")
    } else {
      println("Prohibited!")
    }
  }
}
