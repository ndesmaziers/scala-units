package com.blaasoft.units

object ProductUnit {
  def append(item: Annotated, list: List[Annotated]): List[Annotated] = {
    list match {
      case List() => List(item)
      case x :: xs => {
        if (x.unit != item.unit)
          x :: append(item, xs)
        else {
          val mergeValue = x * item
          if (mergeValue == null) xs else append(x * item, xs)
        }
      }
    }
  }

  def concat(list1: List[Annotated], list2: List[Annotated]): List[Annotated] = {
    list2 match {
      case List() => list1
      case x :: xs => concat(append(x, list1), xs)
    }
  }

  def inverseProductList(product: List[Annotated]): List[Annotated] = {
    product match {
      case List() => List()
      case annotated :: xs => annotated.inverse() :: inverseProductList(xs)
    }
  }
}

class ProductUnit(val product: List[Annotated], val dimension:Dimension) extends BUnit {

  def this(su: SimpleUnit, power: Integer = 1) = this(List(new Annotated(su, power)), su.dimension)

  def *(other: BUnit) = {
    other match {
      case su: SimpleUnit => new ProductUnit(ProductUnit.append(new Annotated(su, 1), product), dimension * su.dimension)
      case pu: ProductUnit => new ProductUnit(ProductUnit.concat(product, pu.product), dimension * pu.dimension)
    }
  }  
  
  def ^ (power:Integer):BUnit = {
    new ProductUnit(
    	for(annotaded <- product) yield annotaded.power(power),
    	dimension ^ power)
  }

  def inverse(): BUnit = {
    new ProductUnit(ProductUnit.inverseProductList(product), dimension ^ (-1))
  }
  
  def *(other: Double) = {
    new ProductUnit(product, dimension)
  }
  
  override def toBaseValue(): Value = {
    var _product:List[Annotated] = List()
    var _factor:AffineFunction = new AffineFunction(1.0, 0.0)
    for(annotated <- product) {
    	val value:Value = (annotated.unit.toBaseValue ^ annotated.power);
    	_product = ProductUnit.concat(_product, value.unit.product)
    	_factor *= (value.value ^ annotated.power)
    }
    
    new Value(new ProductUnit(_product, dimension), _factor)
  }

  override def toString(): String = {
    val builder: StringBuilder = new StringBuilder();

    var firstIteration: Boolean = true
    for (item: Annotated <- product) {
      if (!firstIteration) {
        builder.append("*")
      }
      builder.append(item.toString());
      firstIteration = false
    }

    builder.toString()
  }
}

class Annotated(val unit: SimpleUnit, val power: Integer) { 
  override def toString(): String = {
    if (power == 1) unit.toString() else unit.toString() + "^" + power;
  }

  def inverse(): Annotated = new Annotated(unit, -power)
  
  def power(value:Integer): Annotated = new Annotated(unit, power * value)

  // merging two annotated with the same unit
  def *(other: Annotated): Annotated = {
    if (power + other.power != 0) new Annotated(unit, power + other.power) else null
  }
}