package com.katus.chapter02

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-18
 */
object ValTest {
  def main(args: Array[String]): Unit = {
    val name1:String = "Tom"
    // name1 = "Jim"   // 错误 val不可重新赋值
    var name2:String = "Tom"
    name2 = "Jim"   // var允许重新赋值
    val age = 23   // 类型自动推断
    val sex = "male"
    val str = s"name = $name1, age = $age, sex = $sex."
    val bigStr =
      """Hello,
        |my name is Sun.
        |I am glad to see you.
        |   Ha!""".stripMargin
    println(str)
    println(name1, name1.length)
    println(bigStr)
  }

  def test1(): Unit = {
    lazy val str = "123456789abcdefghi"   // lazy 惰性赋值 只有在用到变量的时候才会加载到内存
    println(str)
  }

  def test2(): Unit = {
    val num = 5 + 2.21.toInt   // toXxx 强制类型转换
    println(s"num = $num")
  }

  def test3(): Unit = {
    val n = 3
    val str:String = n.toString   // n + ""
    val m:Int = str.toInt
    println(s"str = $str, m = $m")
  }
}
