package com.katus.chapter07.shapes

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
abstract class Shape {
  val name: String   // 抽象成员 没有赋值

  def getArea: Double   // 抽象方法 没有方法体

  override def toString = s"Shape(name=$name, getArea=$getArea)"
}
