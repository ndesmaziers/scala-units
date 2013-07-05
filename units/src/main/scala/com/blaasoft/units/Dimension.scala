package com.blaasoft.units

object Dimension {
  val ZERO = new Dimension(0,0,0,0,0,0,0)
  val L = new Dimension(1,0,0,0,0,0,0)
  val T = new Dimension(0,1,0,0,0,0,0)
  val M = new Dimension(0,0,1,0,0,0,0)
  val A = new Dimension(0,0,0,1,0,0,0)
  val C = new Dimension(0,0,0,0,1,0,0)
  val Q = new Dimension(0,0,0,0,0,1,0)
  val F = new Dimension(0,0,0,0,0,0,1)
}

class Dimension(val length:Integer, val time:Integer, val mass:Integer, val angle:Integer, val temperature:Integer, val electricCharge:Integer, val luminousIntensity:Integer) {
	def * (other:Dimension) = new Dimension(length+other.length, time+other.time, mass+other.mass, angle+other.angle, temperature+other.temperature, electricCharge+other.electricCharge, luminousIntensity+other.luminousIntensity)
	def / (other:Dimension) = new Dimension(length-other.length, time-other.time, mass-other.mass, angle-other.angle, temperature-other.temperature, electricCharge-other.electricCharge, luminousIntensity-other.luminousIntensity)
	def ^ (power:Integer) = new Dimension(length * power, time * power, mass * power, angle * power, temperature * power, electricCharge * power, luminousIntensity * power)
	
	override def equals(obj:Any):Boolean = {
	  obj match  {
	    case dim:Dimension => length == dim.length && time == dim.time && mass == dim.mass && angle == dim.angle && temperature == dim.temperature && electricCharge == dim.electricCharge && luminousIntensity == dim.luminousIntensity
	    case _ => false
	  }
	}
	
	override def toString() = {
	  "(" +
	  (if(length != 0) ("L=" + length + " ") else "") +
	  (if(time != 0) ("T=" + time + " ") else "") +
	  (if(mass != 0) ("M=" + mass + " ") else "") +
	  (if(angle != 0) ("A=" + angle + " ") else "") +
	  (if(temperature != 0) ("C=" + temperature + " ") else "") +
	  (if(electricCharge != 0) ("Q=" + electricCharge + " ") else "") +
	  (if(luminousIntensity != 0) ("F=" + luminousIntensity + " ") else "") + 
	  ")"
	}
}