package com.blaasoft.units

object Test {

  def main(args: Array[String]): scala.Unit = {
    println(CommonUnits.kilometer)
    println(AtomicUnit.second)
    println(AtomicUnit.minute)
    println(AtomicUnit.hour)
    println(CommonUnits.meter_per_second)
    
    // Inversion tests
    println(AtomicUnit.meter.inverse())				// AtomicUnit 
    println(CommonUnits.kilometer.inverse())		// Prefixed unit
    
    // Multiplication tests
    println(AtomicUnit.meter* AtomicUnit.second)
    println(AtomicUnit.meter* AtomicUnit.meter)
    println(AtomicUnit.meter* AtomicUnit.meter * AtomicUnit.second)
    println(AtomicUnit.meter* AtomicUnit.second * AtomicUnit.meter)
    
    // Division tests
    println(AtomicUnit.meter / AtomicUnit.second)
    println(AtomicUnit.meter / AtomicUnit.meter)
    
    // Test with prefixed units
    println("km^2 = " + CommonUnits.kilometer * CommonUnits.kilometer)
    println("ONE = " + CommonUnits.kilometer / CommonUnits.kilometer)
    
    // 
    println(AtomicUnit.n_mi.toBaseUnit)
    println(AtomicUnit.n_mi.toBaseUnit / AtomicUnit.meter)
    println(AtomicUnit.knot)
    
    // Test on power
    println(AtomicUnit.meter ^ 2)
    println(AtomicUnit.knot ^ 2)
    println(CommonUnits.meter_per_second ^ 2)
    
    // Base units
    println(AtomicUnit.second.toBaseUnit)
    println(AtomicUnit.minute.toBaseUnit)
    println(AtomicUnit.hour.toBaseUnit)
    println(AtomicUnit.knot.toBaseUnit)
    println(CommonUnits.kilometer.toBaseUnit)
    
    // Other
    println(AtomicUnit.knot.dimension)
    
    // Measure conversions
    println(new Measure(20, AtomicUnit.knot))
    println(new Measure(20, AtomicUnit.knot).to(CommonUnits.kilometer_per_hour))
  }

}