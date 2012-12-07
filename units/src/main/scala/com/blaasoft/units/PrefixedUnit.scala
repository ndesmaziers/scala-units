package com.blaasoft.units

class PrefixedUnit(val prefix:Prefix, val unit:AtomicUnit) {
	override def toString() = prefix.toString() + unit.toString()
}