package com.blaasoft.units

class Value(val unit:ProductUnit, val value:AffineFunction) {

  def this(unit:Unit, value:AffineFunction) = {
    this(unit match {
      case pu:ProductUnit => pu
      case su:SimpleUnit => new ProductUnit(su)
    }, value)
  }
  
  def this(a:Double, unit:Unit) = {
    this(unit, new AffineFunction(a, 0))
  }
  
  def this(a:Double, b:Double, unit:Unit) = {
    this(unit, new AffineFunction(a, b))
  }
  
  def * (other:Value):Value = {
    new Value(unit * other.unit, value * other.value)
  }
  
  def / (other:Value):Value = {
    new Value(unit / other.unit, value / other.value)
  }
  
  def * (a:Double) = {
    new Value(unit, value * a)
  }
  
  def ^ (power:Integer) = {
    new Value(unit ^ power, value)
  }
  
  override def toString() = value.toString + unit.toString
}