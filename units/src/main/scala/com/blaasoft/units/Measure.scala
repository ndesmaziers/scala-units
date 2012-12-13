package com.blaasoft.units

class Measure(val value:Double, val unit:Unit) {
  
  def to(otherUnit:Unit) = {
    val factor:Double = (unit.toBaseUnit / otherUnit.toBaseUnit).asInstanceOf[ProductUnit].factor;
    
    new Measure(value * factor, otherUnit)
  }
  
  override def toString() = {
    value.toString() + unit.toString()
  }
}