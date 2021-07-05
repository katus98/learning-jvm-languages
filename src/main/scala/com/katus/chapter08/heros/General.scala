package com.katus.chapter08.heros

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
class General extends Hero {
  override var desc: String = "This is a general."

  override def info(): Unit = println(name, age, desc)
}
