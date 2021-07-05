package com.katus.chapter08.patterns.adapter

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
class GreenHand extends Player {
  override def support(): Unit = println("Support!")
  override def schoolChild(): Unit = println("Sa!")
}
