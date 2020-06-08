package com.atuguigu.scalaObject

object ScalaExtends{
  def main(args: Array[String]): Unit = {
     val user = new User1()
    user.test()
    user.test1()
    val user1 : Person = new User1()
    user1.test1()
  }
}

abstract  class Person {
  var name : String = _

  def test()

  def test1(): Unit ={
    println("父类的方法")
  }
}

class User1 extends Person {
  def test(): Unit = {
    println("xxxxx")
  }

  override def test1(): Unit = {
    println("子类重写的方法")
  }

}
