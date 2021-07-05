package com.katus.chapter08

import com.katus.chapter08.heros.General
import com.katus.chapter08.logs.ConsoleLogger
import com.katus.chapter08.messages.MessageWorker
import com.katus.chapter08.patterns.cor.Payment
import com.katus.chapter08.patterns.templates.CycleCode
import com.katus.chapter08.users.{Logger_02, User}

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
object TraitTest {
  def main(args: Array[String]): Unit = {
    test6()
  }

  def test1(): Unit = {
    val w = new MessageWorker
    w.send("hhh, cdd.")
    w.receive()
  }

  def test2(): Unit = {
    ConsoleLogger.log("sth. to log")
    ConsoleLogger.warn("sth. to warn")
  }

  def test3(): Unit = {
    val g = new General
    g.name = "Sun"
    g.age = 22
    g.info()
  }

  def test4(): Unit = {
    val u = new User with Logger_02   // 混入特质
    u.info()
    u.log(s"${u.name}" + "实在" * 8 + "是太神了!")
  }

  def test5(): Unit = {
    val c = new CycleCode
    println(c.getRunTime())
  }

  def test6(): Unit = {
    val p = new Payment
    p.pay("Pay 1000!")
  }
}
