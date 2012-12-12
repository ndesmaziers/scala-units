package com.blaasoft.units

abstract class SimpleUnit extends Unit {
  def *(other: Unit): Unit = {
     new ProductUnit(this) * other;
  }
  
  def ^ (power:Integer):Unit = {
    new ProductUnit(this) ^ power
  }

  override def inverse(): Unit = {
    new ProductUnit(this, -1)
  }
}