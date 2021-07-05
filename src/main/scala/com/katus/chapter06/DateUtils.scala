package com.katus.chapter06

import java.text.SimpleDateFormat
import java.util.Date

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-19
 */
object DateUtils {
  private[this] var sdf: SimpleDateFormat = _

  def date2String(date: Date, template: String): String = {
    sdf = new SimpleDateFormat(template)
    sdf.format(date)
  }

  def string2Date(dateString: String, template: String): Date = {
    sdf = new SimpleDateFormat(template)
    sdf.parse(dateString)
  }
}
