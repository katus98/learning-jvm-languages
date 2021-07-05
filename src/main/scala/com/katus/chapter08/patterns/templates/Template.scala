package com.katus.chapter08.patterns.templates

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
abstract class Template {
  def code()

  def getRunTime(): Long = {
    val start = System.currentTimeMillis()
    code()
    val end = System.currentTimeMillis()
    `end` - start
  }
}
