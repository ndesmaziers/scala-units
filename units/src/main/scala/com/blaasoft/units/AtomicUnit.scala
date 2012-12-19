package com.blaasoft.units

object AtomicUnit  {
   val meter = new AtomicUnit("m", "meter", "m", true, Dimension.L, null)
   val second = new AtomicUnit("s", "second", "s", true, Dimension.T ,null)
   val Kelvin = new AtomicUnit("K", "Kelvin", "K", true, Dimension.C , null)

   
   val minute = new AtomicUnit("min", "minute", "min", false, Dimension.T, new Value(60.0, second))
   val hour = new AtomicUnit("h", "hour", "h", false, Dimension.T, new Value(60.0, minute))
   
   // Intcust units
   val n_mi = new AtomicUnit("[nmi_i]", "nautical mile", "n.mi", false, Dimension.T, new Value(1852, meter))
   val knot = new AtomicUnit("[kn_i]", "knot", "knot", false, Dimension.L/Dimension.T , new Value(1.0, n_mi / hour))

   val degree_Celsius = new AtomicUnit("Cel", "degree Celsius", "°C", false, Dimension.C , new Value(1.0, 273.15, Kelvin))
   val degree_Fahrenheit = new AtomicUnit("[degF]", "degree Fahrenheit", "°F", false, Dimension.C , new Value(5.0/9.0, 459.67 * (5.0/9.0), Kelvin))
}

class AtomicUnit(val code:String, val name:String, val printSymbol:String, val isBaseUnit:Boolean, val dimension:Dimension, val value:Value) extends SimpleUnit {
  
  override def toBaseValue(): Value = {
    if(isBaseUnit)
      new Value(1.0, new ProductUnit(this))
    else {
      val baseUnitValue:Value = value.unit.toBaseValue()
      new Value(baseUnitValue.unit, value.value * baseUnitValue.value)
    }
      
  }
  
  override def toString() = printSymbol
  
}