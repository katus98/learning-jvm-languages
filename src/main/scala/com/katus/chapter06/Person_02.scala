package com.katus.chapter06

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
class Person_02(val name: String = "Tom", val age: Int = 23) {
  // 类中除了方法和属性变量之外的全部内容均为主构造器代码
  println("主构造器已调用")

  override def toString = s"Person_02(name=$name, age=$age)"
}
