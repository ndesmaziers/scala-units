package com.blaasoft.units

abstract class AbstractMeasure(val unit:BUnit) {
  type T <: AbstractMeasure
  
  def +(other:AbstractMeasure):T;
  def -(other:AbstractMeasure):T;
  
  def *(scalar:Double):T
  def /(scalar:Double):T

  def norm():Measure
  def zero():T
}