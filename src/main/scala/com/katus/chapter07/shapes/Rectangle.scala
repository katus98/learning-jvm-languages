package com.katus.chapter07.shapes

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
class Rectangle(var a: Double, var b: Double) extends Shape {
  override val name: String = "Rectangle"

  override def getArea: Double = a * b
}
