package com.blaasoft.units

class Value(val unit:ProductUnit, val b:Double = 0.0) {

  
  def this(a:Double, unit:Unit, b:Double = 0.0) = {
    this(unit match {
      case pu:ProductUnit => pu * a
      case su:SimpleUnit => new ProductUnit(su,1,a)
    }, b)
  }
  
}