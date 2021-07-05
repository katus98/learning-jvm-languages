package com.katus.chapter07

import com.katus.chapter07.people.{Person, Student, Teacher}
import com.katus.chapter07.shapes.{Circle, Shape}

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
object ClassTest {
  def main(args: Array[String]): Unit = {
    test5()
  }

  def test1(): Unit = {
    val s = new Student
    s.age = 22
    s.name = "Sun"
    s.eat()
    println(s)
  }

  def test2(): Unit = {
    Teacher.name = "Zhang"
    Teacher.age = 55
    println(Teacher)
  }

  def test3(): Unit = {
    val p: Person = new Student
    p.name = "Sun"
    p.age = 18
    println(p.getClass)
    println(p.isInstanceOf[Person])
    println(p.isInstanceOf[Student])
    if (p.isInstanceOf[Student]) {   // 判断类型 粗略判断 对应类和父类都是true
      val s = p.asInstanceOf[Student]    // 转化类型
      s.doHomework()
    }
    println(p.getClass == classOf[Person])   // 准确判断类型 不包括父类
    println(p.getClass == classOf[Student])
  }

  def test4(): Unit = {
    val c = new Circle(5)
    println(c)
  }

  def test5(): Unit = {
    println(new Shape {   // 匿名内部类
      override val name: String = "Temp Shape"
      override def getArea: Double = 0.0
    }.toString)
  }
}
