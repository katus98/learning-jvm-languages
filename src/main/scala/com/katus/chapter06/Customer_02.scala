package com.katus.chapter06

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
class Customer_02(val name: String, val address: String) {
  def this(arr: Array[String]) {   // 辅助构造器 名字必须是this
    this(arr(0), arr(1))   // 辅助构造器的第一行必须调用其他构造器
  }

  override def toString = s"Customer_02(name=$name, address=$address)"
}
