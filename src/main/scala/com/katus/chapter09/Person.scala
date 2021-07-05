package com.katus.chapter09

import com.katus.chapter09.gender.{Gender, Male}

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-20
 */
// 样例类 默认会重写几个方法 apply() unapply() toString() equals() hashCode() copy()
case class Person(name: String = "Zhang", var age: Int = 23, sex:Gender = Male)   // 默认是val
