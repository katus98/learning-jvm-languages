package com.katus.chapter11

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-21
 */
class Student(var name:String, var age: Int) {

}

object Student {
  def apply(name: String, age: Int): Student = new Student(name, age)
  // 提取器 match方法的必须
  def unapply(arg: Student): Option[(String, Int)] = if (arg != null) Some(arg.name, arg.age) else None
}
