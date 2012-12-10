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
    
    // Base units
    println(AtomicUnit.second.toBaseUnit)
    println(AtomicUnit.minute.toBaseUnit)
    println(AtomicUnit.hour.toBaseUnit)
    
    // Blabla 1
  }

}