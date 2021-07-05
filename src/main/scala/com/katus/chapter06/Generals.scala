package com.katus.chapter06

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
class Generals(private var desc: String = "haha") {   // 伴生类 必须同名 可以访问伴生对象的私有成员
  def printWar(): Unit = {
    println(s"Use my ${Generals.armName}")
  }
  private[this] val dd = "DD"   // 仅允许本类使用 即使是伴生类/伴生对象也不行
}

object Generals {   // 伴生对象 必须同名 类似于类中的static成员部分
  private val armName = "gun"

  def getDesc(p: Generals): String = p.desc

  def test(p: Generals): Unit = {
    // p.dd   // 禁止访问
  }
}
