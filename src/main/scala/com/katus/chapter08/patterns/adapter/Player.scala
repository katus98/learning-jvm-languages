package com.katus.chapter08.patterns.adapter

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
abstract class Player extends PlayLOL {   // 适配器(设计模式)
  override def top(): Unit = {}
  override def mid(): Unit = {}
  override def adc(): Unit = {}
  override def support(): Unit = {}
  override def jungle(): Unit = {}
  override def schoolChild(): Unit = {}
}
