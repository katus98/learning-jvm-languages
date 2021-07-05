package com.katus.chapter08.heros

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
trait Hero {
  var name: String = _
  var age: Int = _
  var desc: String

  def eat(): Unit = {
    println("Eat sth.")
  }

  def info()
}
