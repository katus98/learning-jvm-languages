package com.katus.chapter07.shapes

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
class Circle(var r: Double = 0) extends Shape {
  override val name: String = "Circle"   // 重写成员变量

  override def getArea: Double = Math.PI * r * r   // 重写方法
}
