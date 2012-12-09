package com.blaasoft.units

object CommonUnits {
	val kilometer = new PrefixedUnit(Prefix.kilo, AtomicUnit.meter)
	
	// Speed
	val meter_per_second = AtomicUnit.meter / AtomicUnit.second
}