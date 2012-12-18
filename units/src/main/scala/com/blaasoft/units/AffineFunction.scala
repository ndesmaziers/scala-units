package com.blaasoft.units

class AffineFunction(val a:Double, val b:Double) extends Function[Double, Double]{
  override def apply(x:Double):Double = a * x + b;
  
  def * (factor:Double) = new AffineFunction(a * factor, b * factor)
  def * (other:AffineFunction) = new AffineFunction(a * other.a, a * other.b + b)
  def / (other:AffineFunction) = other.inverse() * this
  def ^ (power:Integer) = new AffineFunction(Math.pow(a, power.doubleValue()), 0)
  
  def inverse() = new AffineFunction(1.0 / a, - b / a)
  
  override def toString():String = {
    if(b != 0.0) {
      "(" + a.toString + "x+" + b.toString + ")"
    }
    else {
      a.toString
    }
  }
}