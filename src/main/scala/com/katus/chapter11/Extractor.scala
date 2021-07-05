package com.katus.chapter11

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-21
 */
object Extractor {
  def main(args: Array[String]): Unit = {
    test()
  }

  def test(): Unit = {
    val st = Student("Zhang", 23)
    st match {
      case Student(name, age) => println(name, age)
      case _ => println("others")
    }
  }
}
