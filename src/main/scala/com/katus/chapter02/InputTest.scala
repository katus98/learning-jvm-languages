package com.katus.chapter02

import scala.io.StdIn

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-18
 */
object InputTest {
  def main(args: Array[String]): Unit = {
    sayHello()
  }

  def test1(): Unit = {
    println("请输入一个字符串: ")
    val str = StdIn.readLine()
    println("您刚刚输入的字符串是: " + str)
  }

  def test2(): Unit = {
    println("请输入一个整数: ")
    println("您刚刚输入的整数是: " + StdIn.readInt())
  }

  def sayHello(): Unit = {
    println("Please type in your name:")
    val name = StdIn.readLine()
    println("Please type in your age:")
    val age = StdIn.readInt()
    println(s"name = $name, age = $age")
  }
}
