package com.blaasoft.units



abstract class Unit {
	def * (other:Unit):Unit
	def / (other:Unit):Unit = this * other.inverse()
	def ^ (power:Integer):Unit
	def inverse():Unit
	def toBaseUnit():ProductUnit;
	def dimension:Dimension;
	
	def convert(other:Unit): Double => Double = {
	  val factor:Double = (this.toBaseUnit / other.toBaseUnit).asInstanceOf[ProductUnit].factor;

	  x => factor * x
	}
}