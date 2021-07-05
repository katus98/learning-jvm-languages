package com.katus.chapter09

import com.katus.chapter09.gender.{Female, Male}

import scala.io.{StdIn => stdin}
import scala.util.{DynamicVariable => _, _}   // 引入其中除了DynamicVariable之外所有的内容

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
object PackageTest {
  private[chapter09] val name: String = "Scala"   // []中的包内允许访问

  def main(args: Array[String]): Unit = {
    test4()
  }

  def test1(): Unit = {
    println(pack.name)
    pack.printHello()
  }

  def test2(): Unit = {
    stdin.readLine()
  }

  def test3(): Unit = {
    val p = new Person
    println(s"Before: name = ${p.name}, age = ${p.age}")
    p.age = 24
    println(s"After: name = ${p.name}, age = ${p.age}")
  }

  def test4(): Unit = {
    // apply()
    val p1 = Person("Yu", 51, Male)
    // toString()
    println(p1)
    // equals()
    val p2 = Person("Yu", 51, Male)
    println(p1 == p2)
    // hashCode()
    println(p1.hashCode())
    println(p2.hashCode())
    // copy()
    val p3 = p2.copy()
    val p4 = p1.copy(age = 46, sex = Female)
    println(p3)
    println(p4)
  }
}
