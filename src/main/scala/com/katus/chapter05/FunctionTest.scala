package com.katus.chapter05

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
object FunctionTest {
  def main(args: Array[String]): Unit = {
    val getSum = (a: Int, b: Int) => a + b   // 函数是在JVM堆内存中的
    val num = getSum(11, 22)
    println(s"num = $num")
    val multi = getMulti _   // 将方法转化为函数赋值给变量
    val num2 = multi(2, 5)
    println(s"num2 = $num2")
    printMT(5)
  }

  def getMulti(a: Int, b: Int): Int = a * b   // 方法是在JVM方法区的 隶属于对象

  def printMT(n: Int): Unit = {
    for (i <- 1 to n; j <- 1 to i) print(s"$j * $i = ${i * j}" + (if (i == j) "\n" else "\t"))
  }
}
