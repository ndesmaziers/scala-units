package com.blaasoft.units



abstract class Unit {
	def * (other:Unit):Unit
	def / (other:Unit):Unit = this * (other ^ -1)
	def ^ (power:Integer):Unit
	def toBaseValue():Value;
	def dimension:Dimension;
	
	def convert(other:Unit): Double => Double = {
	  val factor:Value = toBaseValue / other.toBaseValue;

	  factor.value
	}
}