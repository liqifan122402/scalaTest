package com.atuguigu.scalaObject

class Student {
  private val s:String = "zhangsan"
}

object Student{
  def main(args: Array[String]): Unit = {
    def apply: Student = new Student()
    apply.s
  }
}
