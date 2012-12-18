package com.blaasoft.units

class Value(val unit:ProductUnit, val value:AffineFunction) {

  def this(unit:Unit, value:AffineFunction) = {
    this(unit match {
      case pu:ProductUnit => pu
      case su:SimpleUnit => new ProductUnit(su,1,1)
    }, value)
  }
  
  def this(a:Double, unit:Unit) = {
    this(unit, new AffineFunction(a, 0))
  }
  
  def this(a:Double, b:Double, unit:Unit) = {
    this(unit, new AffineFunction(a, b))
  }
}