package com.blaasoft.units

import scala.math._

object Measure2D {
  val zero:Measure2D = new Measure2D(0.0, 0.0, AtomicUnit.one)
}

case class Measure2D(val x1:Double, val x2:Double, _unit:BUnit) extends AbstractMeasure(_unit) {
  type T = Measure2D
  
  def +(other:AbstractMeasure):T = {
    new Measure2D(x1 + other.asInstanceOf[Measure2D].x1, x2 + other.asInstanceOf[Measure2D].x2, unit)
  }
  
  def -(other:AbstractMeasure):T = {
    new Measure2D(x1 - other.asInstanceOf[Measure2D].x1, x2 - other.asInstanceOf[Measure2D].x2, unit)
  }
  
  def *(scalar:Double):Measure2D = {
    new Measure2D(x1 * scalar, x2 * scalar, unit)
  }
  
  def /(scalar:Double):Measure2D = {
    new Measure2D(x1 / scalar, x2 / scalar, unit)
  }
  
  override def norm():Measure = {
    new Measure(sqrt(x1 * x1 + x2 * x2), unit)
  }

  def zero():Measure2D = Measure2D.zero

  
   override def toString():String = {
     return "(" + x1.toString() + ", " + x2.toString() + ")"
  }
}