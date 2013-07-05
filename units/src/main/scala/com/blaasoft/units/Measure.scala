package com.blaasoft.units

object Measure {
  val zero:Measure = new Measure(0.0, AtomicUnit.one)
  
  private val parser = new UnitParser()
  
  def apply(n:Int, unit:BUnit) = new Measure(n, unit)
  def apply(n:Int, unit:String) = new Measure(n, parser.parse(unit).get)
}

case class Measure(val x:Double, _unit:BUnit) extends AbstractMeasure(_unit) with Ordered[Measure] {
  
  type T = Measure
  
  def +(other:AbstractMeasure):T = {
    new Measure(x + other.asInstanceOf[Measure].x, unit)
  }
  
  def -(other:AbstractMeasure):T = {
    new Measure(x - other.asInstanceOf[Measure].x, unit)
  }
  
  def *(scalar:Double):T = {
    new Measure(x * scalar, unit)
  }
  
  def /(scalar:Double):T = {
    new Measure(x / scalar, unit)
  }
  
  override def norm():Measure = {
    this
  }
  
  override def compare (that : Measure) : Int = {
    x.compare(that.x)
  }
  
  def zero():Measure = Measure.zero
  
  def to(otherUnit:BUnit) = {    
    val converter = unit.convert(otherUnit)
    new Measure(converter(x), otherUnit)
  }
  
  override def toString() = {
    x.toString() + unit.toString()
  }
  
  
}