package com.blaasoft.units

class PrefixedUnit(val prefix: Prefix, val unit: AtomicUnit) extends SimpleUnit {
  override def toBaseUnit(): ProductUnit = {
    unit.toBaseUnit * prefix.doubleValue
  }
  
  def dimension:Dimension = unit.dimension

  override def toString() = prefix.toString() + unit.toString()
}