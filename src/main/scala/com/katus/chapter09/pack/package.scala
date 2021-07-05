package com.katus.chapter09

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
package object pack {   // 每个包都有个包对象 与包平级
  val name: String = "Sun"
  def printHello(): Unit = println("This is a package object!")
}
