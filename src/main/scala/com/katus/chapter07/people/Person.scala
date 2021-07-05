package com.katus.chapter07.people

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
class Person {
  var name: String = _
  var age: Int = _
  val desc: String = "This is a Person Class"

  def eat(): Unit = {
    println("Person need to eat.")
  }

  override def toString = s"Person(name=$name, age=$age)"
}
