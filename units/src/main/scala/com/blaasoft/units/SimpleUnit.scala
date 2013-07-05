package com.blaasoft.units

abstract class SimpleUnit extends BUnit {
  def *(other: BUnit): BUnit = {
     new ProductUnit(this) * other;
  }
  
  def ^ (power:Integer):BUnit = {
    new ProductUnit(this) ^ power
  }
}