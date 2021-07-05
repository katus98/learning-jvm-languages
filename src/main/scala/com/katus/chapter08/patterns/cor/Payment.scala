package com.katus.chapter08.patterns.cor

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
/*
先执行父类构造器 然后从左到右执行特质构造器 如果有父特质则先执行父特质构造器 最后执行子类构造器
* */
class Payment extends SupPayment with DVHandler with SVHandler {   // 职责链 设计模式 执行顺序 从子到父 从右到左
  println("Payment Con!")
  def pay(data: String): Unit = {
    println("Prepared to pay!")
    super.handle(data)
  }
}
