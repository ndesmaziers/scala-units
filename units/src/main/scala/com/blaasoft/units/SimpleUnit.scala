package com.blaasoft.units

class SimpleUnit extends Unit {
  def *(other: Unit): Unit = {
     new ProductUnit(this) * other;
  }

  override def inverse(): Unit = {
    new ProductUnit(this, -1)
  }

  override def toBaseUnit(): ProductUnit = {
    null
  }
}