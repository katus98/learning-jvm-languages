package com.katus.chapter06

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
object Dog {   // 单例对象 类似于static 内存中只有一份
  val leg_num = 4

  def printSplitter(): Unit = {
    println("-" * 15)
  }
}
