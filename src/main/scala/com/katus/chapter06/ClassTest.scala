package com.katus.chapter06

import java.util.Date

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
object ClassTest {
  def main(args: Array[String]): Unit = {
    test9()
  }

  def test1(): Unit = {
    //    val p = new Person   如果是空参构造器可以省略括号
    val p = new Person()
    p.age = 23
    println(p)
  }

  def test2(): Unit = {
    val c = new Customer
    c.printHello("Hello, my name is God!")
  }

  def test3(): Unit = {
    val p1 = new Person_02()
    val p2 = new Person_02("Sam", 16)
    val p3 = new Person_02(age = 500)
    println(p1, p2, p3)
  }

  def test4(): Unit = {
    val c1 = new Customer_02("Tom", "Beijing")
    val c2 = new Customer_02(Array("Sam", "Dalian"))
    println(c1, c2)
  }

  def test5(): Unit = {
    println(Dog.leg_num)   // 单例对象可以通过类名.方法/成员调用方法/成员
    Dog.printSplitter()
  }

  def test6(): Unit = {
    val g = new Generals
    g.printWar()
  }

  def test7(): Unit = {
    println(Generals.getDesc(new Generals()))
  }

  def test8(): Unit = {
    val p = Person_03("Tom", 15)   // 免new构造 需要伴生对象实现apply方法
    println(p)
  }

  def test9(): Unit = {
    println(DateUtils.date2String(new Date(), "yyyy-MM-dd"))
  }
}
