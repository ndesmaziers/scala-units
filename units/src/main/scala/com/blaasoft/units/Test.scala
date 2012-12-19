package com.blaasoft.units

object Test {

  def main(args: Array[String]): scala.Unit = {
    
    println(new Measure(20, AtomicUnit.degree_Celsius).to(AtomicUnit.degree_Fahrenheit))

       
    println("Printing simple units")
    println("km        = " + CommonUnits.kilometer)
    println("s         = " + AtomicUnit.second)
    println("min       = " + AtomicUnit.minute)
    println("h         = " + AtomicUnit.hour)
    
    println("Multiplication tests")
    println("m*s       = " + AtomicUnit.meter* AtomicUnit.second)
    println("m^2       = " + AtomicUnit.meter* AtomicUnit.meter)
    println("m^2*s     = " + AtomicUnit.meter* AtomicUnit.meter * AtomicUnit.second)
    println("m^2*s     = " + AtomicUnit.meter* AtomicUnit.second * AtomicUnit.meter)
    println()
    
    println("Division tests")
    println(AtomicUnit.meter / AtomicUnit.second)
    println(AtomicUnit.meter / AtomicUnit.meter)
    println()
    
    println("Tests with prefixed units")
    println("km^2 = " + CommonUnits.kilometer * CommonUnits.kilometer)
    println("ONE = " + CommonUnits.kilometer / CommonUnits.kilometer)
    println()
 
    
    // Test on power
    println(AtomicUnit.meter ^ 2)
    println(AtomicUnit.knot ^ 2)
    println(CommonUnits.meter_per_second ^ 2)
    println()
    
    println("Get base units")
    println(AtomicUnit.second.toBaseValue)
    println(AtomicUnit.minute.toBaseValue)
    println(AtomicUnit.hour.toBaseValue)
    println(AtomicUnit.knot.toBaseValue)
    println(CommonUnits.kilometer.toBaseValue)
    println()
  
    
    // Measure conversions
    println(new Measure(20, AtomicUnit.knot))
    println(new Measure(20, AtomicUnit.knot).to(CommonUnits.kilometer_per_hour))
    
    
    println(AtomicUnit.degree_Celsius.toBaseValue)
    println(new Measure(20, AtomicUnit.degree_Celsius).to(AtomicUnit.Kelvin))
    println(new Measure(20, AtomicUnit.degree_Celsius).to(AtomicUnit.degree_Fahrenheit))
  }

}