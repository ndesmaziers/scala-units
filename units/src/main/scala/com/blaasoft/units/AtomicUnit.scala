package com.blaasoft.units

object AtomicUnit  {
   val meter = new AtomicUnit("m", "meter", "m", true, null)
}

class AtomicUnit(val code:String, val name:String, val printSymbol:String, val isMetric:Boolean, val value:Value) extends SimpleUnit {
	
  override def toString() = code
  
}