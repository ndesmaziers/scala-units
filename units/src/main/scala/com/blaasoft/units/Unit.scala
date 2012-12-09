package com.blaasoft.units



abstract class Unit {
	def * (other:Unit):Unit
	def / (other:Unit):Unit = this * other.inverse()
	def inverse():Unit
	def toBaseUnit():ProductUnit;
}