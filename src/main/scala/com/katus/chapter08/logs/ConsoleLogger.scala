package com.katus.chapter08.logs

/**
 * @author Keran Sun (katus)
 * @version 1.0, 2020-08-19
 */
object ConsoleLogger extends Logger with Warner {
  override def log(msg: String): Unit = println(s"Log: $msg")
  override def warn(msg: String): Unit = println(s"Warn: $msg")
}
