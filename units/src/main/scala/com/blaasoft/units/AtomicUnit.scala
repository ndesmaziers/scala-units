package com.blaasoft.units

object AtomicUnit  {
   val meter = new AtomicUnit("m", "meter", "m", true, Dimension.L, null)
   val second = new AtomicUnit("s", "second", "s", true, Dimension.T ,null)
   
   val minute = new AtomicUnit("min", "minute", "min", false, Dimension.T, new Value(60.0, second))
   val hour = new AtomicUnit("h", "hour", "h", false, Dimension.T, new Value(60.0, minute))
   
   // Intcust units
   val n_mi = new AtomicUnit("[nmi_i]", "nautical mile", "n.mi", false, Dimension.T, new Value(1852, meter))
   val knot = new AtomicUnit("[kn_i]", "knot", "knot", false, Dimension.L/Dimension.T , new Value(1.0, n_mi / hour))

   val degree_Celsius = new AtomicUnit("Cel", "degree Celsius", "°C", false, Dimension.C , null)
}

class AtomicUnit(val code:String, val name:String, val printSymbol:String, val isBaseUnit:Boolean, val dimension:Dimension, val value:Value) extends SimpleUnit {
  /*
  def this(code:String, name:String, printSymbol:String, isBaseUnit:Boolean, dimension:Dimension, value:Unit) = 
    this(code, name, printSymbol, isBaseUnit, dimension, value match {
      case pu:ProductUnit => pu
      case su:SimpleUnit => new ProductUnit(su)
    })*/
    
  override def toBaseUnit(): ProductUnit = {
    if(isBaseUnit)
      new ProductUnit(this)
    else
      value.unit.toBaseUnit()
  }
  
  override def toString() = printSymbol
  
}