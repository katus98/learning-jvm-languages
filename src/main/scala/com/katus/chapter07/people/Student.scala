package com.katus.chapter07.people

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
class Student extends Person {
  override val desc: String = "This is a Student Class"   // 重写父类成员 仅限val
  override def eat(): Unit = {   // 重写父类方法
    super.eat()
    println("Student need to eat.")
  }

  def doHomework(): Unit = {
    println("Homework has been finished!")
  }
}
