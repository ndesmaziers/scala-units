package com.blaasoft.units

object Prefix {
  val yotta = new Prefix("Y", "yotta", "Y", 24)
  val zetta = new Prefix("Z", "zetta", "Z", 21)
  val exa = new Prefix("E", "exa", "Z", 18)
  //....
  val kilo = new Prefix("k", "kilo", "k", 3)
}

class Prefix(val code:String, val name:String, val printSymbol:String, val exponent:Integer) {
  
	def doubleValue:Double = Math.pow(10.0, exponent.doubleValue())
  
	override def toString() = printSymbol
}