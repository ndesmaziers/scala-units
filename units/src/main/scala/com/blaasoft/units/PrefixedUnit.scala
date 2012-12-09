package com.blaasoft.units

class PrefixedUnit(val prefix:Prefix, val unit:AtomicUnit) extends SimpleUnit {

  override def * (other:Unit):Unit = {
    other match {
      case pu:PrefixedUnit => new ProductUnit(this) * pu
      case _ => null
    }
  }
  
  
  	override def toBaseUnit():ProductUnit = {
  	  null
  	}
  
  override def toString() = prefix.toString() + unit.toString()
}