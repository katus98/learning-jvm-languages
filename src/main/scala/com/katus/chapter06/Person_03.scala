package com.katus.chapter06

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
class Person_03(var name: String, var age: Int) {
  override def toString = s"Person_03(name=$name, age=$age)"
}

object Person_03 {
  def apply(name: String, age: Int): Person_03 = new Person_03(name, age)   // apply方法可以在构造类时免new
}
