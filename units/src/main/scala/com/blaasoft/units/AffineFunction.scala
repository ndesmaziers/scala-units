package com.blaasoft.units

class AffineFunction(val a:Double, val b:Double) extends Function[Double, Double]{
  override def apply(x:Double):Double = a * x + b;
}