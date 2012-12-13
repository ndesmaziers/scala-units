package com.blaasoft.units

object AtomicUnit  {
   val meter = new AtomicUnit("m", "meter", "m", true, Dimension.L, null)
   val second = new AtomicUnit("s", "second", "s", true, Dimension.T ,null)
   
   val minute = new AtomicUnit("min", "minute", "min", false, Dimension.T, new ProductUnit(second, 1, 60))
   val hour = new AtomicUnit("h", "hour", "h", false, Dimension.T, new ProductUnit(minute, 1, 60))
   
   // Intcust units
   val n_mi = new AtomicUnit("[nmi_i]", "nautical mile", "n.mi", false, Dimension.T, new ProductUnit(meter, 1, 1852))
   val knot = new AtomicUnit("[kn_i]", "knot", "knot", false, Dimension.L/Dimension.T , n_mi / hour)
}

class AtomicUnit(val code:String, val name:String, val printSymbol:String, val isBaseUnit:Boolean, val dimension:Dimension, val value:ProductUnit) extends SimpleUnit {
  
  def this(code:String, name:String, printSymbol:String, isBaseUnit:Boolean, dimension:Dimension, value:Unit) = 
    this(code, name, printSymbol, isBaseUnit, dimension, value match {
      case pu:ProductUnit => pu
      case su:SimpleUnit => new ProductUnit(su)
    })
    
  override def toBaseUnit(): ProductUnit = {
    if(isBaseUnit)
      new ProductUnit(this)
    else
      value.toBaseUnit()
  }
  
  override def toString() = printSymbol
  
}