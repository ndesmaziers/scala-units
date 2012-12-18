package com.blaasoft.units



abstract class Unit {
	def * (other:Unit):Unit
	def / (other:Unit):Unit = this * (other ^ -1)
	def ^ (power:Integer):Unit
	def toBaseUnit():Value;
	def dimension:Dimension;
	
	def convert(other:Unit): Double => Double = {
	  val factor:Value = toBaseUnit / other.toBaseUnit;

	  factor.value
	}
}