package com.katus.chapter06

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
class Customer {
  private var name: String = _
  protected var gender: String = _
  var desc: String = _   // 默认public

  def printHello(msg: String): Unit = println(msg)

  def setName(name: String): Unit = this.name = name

  def getName(): String = name
}
