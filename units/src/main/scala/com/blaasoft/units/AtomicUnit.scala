package com.blaasoft.units

object AtomicUnit  {
   val meter = new AtomicUnit("m", "meter", "m", true, null)
   val second = new AtomicUnit("s", "second", "s", true, null)
   
   val minute = new AtomicUnit("min", "minute", "min", false, new Value(new ProductUnit(second, 1), 60))
   val hour = new AtomicUnit("h", "hour", "h", false, new Value(new ProductUnit(minute, 1), 60))
}

class AtomicUnit(val code:String, val name:String, val printSymbol:String, val isBaseUnit:Boolean, val value:Value) extends SimpleUnit {

  override def toBaseUnit(): ProductUnit = {
    null
  }
  
  override def toString() = code
  
}