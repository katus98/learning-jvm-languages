package com.katus.chapter06

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
class Person {   // 如果是空类 可以省略{}
  val name: String = ""   // 可以省略类型 用类型推断来实现
  var age:Int = _   // 使用默认值对var变量进行初始化 不能省略类型 仅针对var类型变量 0/null/false
}
