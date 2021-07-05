package com.katus.chapter08.messages

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
class MessageWorker extends MessageReceiver with MessageSender {
  override def receive(): Unit = println("Received!")
  override def send(msg: String): Unit = println(s"Send: $msg")
}
