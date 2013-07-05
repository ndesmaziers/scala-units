/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blaasoft.units

class UnitParser {
  def parse(expression:String):Option[BUnit] = {
    expression match {
      case "year" => Some(AtomicUnit.year)
      case "month" => Some(AtomicUnit.month)
      case "day" => Some(AtomicUnit.day)
      case "hour" => Some(AtomicUnit.hour)
      case "minute" => Some(AtomicUnit.minute)
      case "second" => Some(AtomicUnit.second)
        
      case _ => None
    }
  }
}
