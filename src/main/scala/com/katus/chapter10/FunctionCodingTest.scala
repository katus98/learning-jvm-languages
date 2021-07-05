package com.katus.chapter10

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-20
 */
object FunctionCodingTest {
  def main(args: Array[String]): Unit = {
    test0()
  }

  def test1(): Unit = {
    val lst = List(1, 2, 3, 4)
    // foreach((参数表) => {函数体 不能有返回值}) 本身也没有返回值
    lst.foreach(x => println(x))
    // 如果参数在函数体中只出现了一次并且不涉及嵌套等复杂操作 可以通过_代替参数
    lst.foreach(println(_))
  }

  def test2(): Unit = {
    val lst = List(1, 2, 3, 4)
    // map[结果元素类型 可省略]((参数表) => {函数体 有返回值 返回值为新列表的元素}) 本身返回新列表
    val ll = lst.map(x => "*" * x)
    val lll = lst.map("*" * _)
    println(ll, lll)
  }

  def test3(): Unit = {
    val lst = List("hello my name is sun", "what is your name", "i am not sure")
    // flatMap[结果元素类型 可省略]((参数表) => {函数体 有返回值 返回值为序列}) 本身返回扁平化新列表
    val ll = lst.flatMap(x => x.split(" "))
    val lll = lst.flatMap(_.split(" "))
    println(ll, lll)
  }

  def test4(): Unit = {
    val lst = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    // filter[结果元素类型 可省略]((参数表) => {函数体 有返回值 返回值为布尔}) 本身返回满足条件新列表
    val ll = lst.filter(x => x%2 == 0)
    val lll = lst.filter(_%2 == 0)
    println(ll, lll)
  }

  def test5(): Unit = {
    val lst = List(4, 1, 3, 8, 5, 7)
    val ll = lst.sorted   // 自然排序 升序
    val lll = ll.reverse
    println(ll, lll)
  }

  def test6(): Unit = {
    val lst = List("05 hadoop", "04 scala", "01 java", "09 python")
    // sortBy 函数返回需要自然排序的字段
    val ll = lst.sortBy(x => x.split(" ")(0).toInt)
    val lll = lst.sortBy(_.split(" ")(0).toInt)
    println(ll, lll)
  }

  def test7(): Unit = {
    val lst = List(2, 3, 1, 6, 4, 5)
    // sortWith 函数根据顺序返回真假
    val ll = lst.sortWith((x1, x2) => x1 > x2)
    // 下划线顺序与参数表顺序一致
    val lll = lst.sortWith(_ > _)
    println(ll, lll)
  }

  def test8(): Unit = {
    val lst = List("Zhang"->"female", "Sun"->"male", "Wan"->"male", "Fu"->"female")
    // groupBy 函数返回用来分组的key
    val l1 = lst.groupBy(_._2)
    val l2 = l1.map(x => x._1 -> x._2.size)
    println(l2)
  }

  def test9(): Unit = {
    val lst = (1 to 10).toList
    // reduce/reduceLeft 两两作为参数进行函数运算 从左到右选取
    val s = lst.reduce((x1, x2) => x1-x2)
    val s0 = lst.reduceLeft(_ - _)
    // reduceRight 从右向左选取
    val s2 = lst.reduceRight((x1, x2) => x2-x1)
    println(s, s0, s2)
  }

  def test10(): Unit = {
    val lst = (1 to 3).toList
    // fold/foldLeft 指定初始化值放在首位 与reduce方法一致
    val s = lst.fold(100)(_-_)
    val s0 = lst.foldLeft(10)((x1, x2) => x1+x2)
    // foldRight 指定初始化值放在末尾 与reduceRight方法一致
    val s1 = lst.foldRight(100)((x1, x2) => x1-x2)
    println(s, s0, s1)
  }

  def test0(): Unit = {
    val lst = List(("Zhang", 98, 76, 89), ("Lin", 58, 78, 59), ("Sun", 98, 99, 100), ("Zhao", 68, 48, 88))
    val r1 = lst.filter(_._2 > 70)
    val r2 = lst.map(x => x._1 -> (x._2 + x._3 + x._4))
    val r3 = lst.sortWith((x1, x2) => (x1._2 + x1._3 + x1._4) > (x2._2 + x2._3 + x2._4))
    println(r1.mkString("\n"), r2.mkString("\n"), r3.mkString("\n"))
  }
}
