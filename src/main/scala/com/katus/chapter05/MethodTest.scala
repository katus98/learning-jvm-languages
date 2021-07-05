package com.katus.chapter05

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
object MethodTest {
  def main(args: Array[String]): Unit = {
    println(getMax(5, 15))
    println(fact())
    lazy val n = fact(8)   // 调用惰性方法
    println(n)   // 此时才开始执行fact(8)
    println(getMinus(b = 4))   // 带名参数
    println(getSum(1, 2, 3, 7, 10))

    // 后缀调用法
    // 对象名.方法名(参数)
    Math.abs(-10)
    // 中缀调用法
    // 对象名 方法名 (参数, ...)
    Math abs -10
    Math abs (-10)
    MethodTest getMinus (1, 2)
    1 + 5
    1 until 20
    // 花括号调用法
    // 仅限方法只需要一个参数的情况
    MethodTest fact {
      println("some codes...")
      5
    }
    // 无括号调用法
    // 仅针对不需要参数的方法
    MethodTest printSth
  }

  def getMax(a: Int, b: Int) = {   // 返回类型可以省略 依靠推断 递归方法不可以!
    if (a >= b) a else b   // 省略return
  }

  def fact(a: Int = 5): Int = {   // 默认参数 如果不传参 则赋值为默认值
    if (a <= 0) 1 else a * fact(a-1)
  }

  def getMinus(a: Int = 10, b: Int = 20): Int = a - b

  def getSum(nums: Int*): Int = nums.sum   // 变长参数 0至多个值 每个方法最多一个变长参数 只能放在参数表最后

  def printSth(): Unit = println("Something")

  def saySth() {println("Sth")}   // 无返回值的方法称为过程 可以省略等号 但是不能省略大括号
}
