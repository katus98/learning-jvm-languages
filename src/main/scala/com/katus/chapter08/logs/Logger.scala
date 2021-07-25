package com.katus.chapter08.logs

/**
 * @author Keran Sun (katus)
 * @version 1.0, 2020-08-19
 */
trait Logger {   // 特质只有一个无参默认构造器
  def log(msg: String)
}
