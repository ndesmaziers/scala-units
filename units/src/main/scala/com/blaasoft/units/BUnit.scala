package com.blaasoft.units



abstract class BUnit {
	def * (other:BUnit):BUnit
	def / (other:BUnit):BUnit = this * (other ^ -1)
	def ^ (power:Integer):BUnit
	def toBaseValue():Value;
	def dimension:Dimension;
	
	def convert(other:BUnit): Double => Double = {
	  val factor:Value = toBaseValue / other.toBaseValue;

	  factor.value
	}
}