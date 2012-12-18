package com.blaasoft.units

class Measure(val value:Double, val unit:Unit) {
  
  def to(otherUnit:Unit) = {    
    val converter = unit.convert(otherUnit)
    new Measure(converter(value), otherUnit)
  }
  
  override def toString() = {
    value.toString() + unit.toString()
  }
}