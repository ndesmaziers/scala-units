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

class ProductUnit(val product: List[Annotated], val factor: Double = 1.0) extends Unit {

  def this(su: SimpleUnit, power: Integer = 1, factor: Double = 1.0) = this(List(new Annotated(su, power)), factor)

  def *(other: Unit) = {
    other match {
      case su: SimpleUnit => new ProductUnit(ProductUnit.append(new Annotated(su, 1), product))
      case pu: ProductUnit => new ProductUnit(ProductUnit.concat(product, pu.product), factor * pu.factor)
    }
  }
  
  def ^ (power:Integer):Unit = {
    new ProductUnit(
    	for(annotaded <- product) yield annotaded.power(power),
    	Math.pow(factor, power.doubleValue())
    	)
  }

  def inverse(): Unit = {
    new ProductUnit(ProductUnit.inverseProductList(product), 1.0 / factor)
  }
  
  def *(other: Double) = {
    new ProductUnit(product, factor * other)
  }

  override def toBaseUnit(): ProductUnit = {
    var _product:List[Annotated] = List()
    var _factor = this.factor;
    for(annotated <- product) { // should not loose power here
    	val equivalentUnit:ProductUnit = (annotated.unit.toBaseUnit ^ annotated.power).asInstanceOf[ProductUnit];
    	_product = ProductUnit.concat(_product, equivalentUnit.product)
    	_factor *= equivalentUnit.factor
    }
    
    new ProductUnit(_product, _factor)
  }

  override def toString(): String = {
    val builder: StringBuilder = new StringBuilder();

    if (factor != 1.0 || product == List()) builder.append(factor)

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