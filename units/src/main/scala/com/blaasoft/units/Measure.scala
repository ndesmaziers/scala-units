package com.blaasoft.units

class Measure(val value:Double, val unit:Unit) {
  
  override def toString() = {
    value.toString() + unit.toString()
  }
}