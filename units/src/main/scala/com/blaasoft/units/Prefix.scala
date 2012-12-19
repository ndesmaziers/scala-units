package com.blaasoft.units

object Prefix {
  val yotta = new Prefix("Y", "yotta", "Y", 24)
  val zetta = new Prefix("Z", "zetta", "Z", 21)
  val exa = new Prefix("E", "exa", "Z", 18)
  val peta = new Prefix("P", "peta", "P", 15)
  val tera = new Prefix("T", "tera", "T", 12)
  val giga = new Prefix("G", "giga", "G", 9)
  val mega = new Prefix("M", "mega", "M", 6)
  val kilo = new Prefix("k", "kilo", "k", 3)
  val hecto = new Prefix("h", "hecto", "h", 2)
  val deka = new Prefix("da", "deka", "da", 1)
  val deci = new Prefix("d", "deci", "d", -1)
  val centi = new Prefix("c", "centi", "c", -2)
  val milli = new Prefix("m", "milli", "m", -3)
  val micro = new Prefix("u", "micro", "μ", -6)
  val nano = new Prefix("n", "nano", "n", -9)
  val pico = new Prefix("p", "pico", "p", -12)
  val femto = new Prefix("f", "femto", "f", -15)
  val atto = new Prefix("a", "atto", "a", -18)
  val zepto = new Prefix("z", "zepto", "z", -21)
  val yocto = new Prefix("y", "yocto", "y", -24)
}

class Prefix(val code:String, val name:String, val printSymbol:String, val exponent:Integer) {
  
	def doubleValue:Double = Math.pow(10.0, exponent.doubleValue())
  
	override def toString() = printSymbol
}