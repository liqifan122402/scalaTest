package com.atuguigu.scalaObject

class scalaInterface {

}

object scalaInterface{

}

trait TestTrait1{
  def aaa():Int
}
trait TestTrait2{

}

class scala2 extends scalaInterface with TestTrait1 with TestTrait2{
  override def aaa(): Int = {
    2
  }
}