package com.atuguigu.base

import scala.io.StdIn

object StdInTest {
  def main(args: Array[String]): Unit = {
    var x = 4
    var y = 1
   var result = if (x > 2) {
      if (y > 2)
        println(x + y)
        println("223")
        println("123")
    } else
      println("x is " + x)
    println(result)

    for (i <- 0 to 9){
      println(i+"Hello,Scala")
    }
    for (i <- 0 until 9){
      println(i)
    }
    for (i <- 1 to 3 if i!=2){
      println(i)
    }
    for (i <- 1 to 9){
      for (j <- 1 to i){
        print(j+"*"+i+"="+(i*j)+'\t')
      }
      println()
    }

    def sum(n1:Int,n2:Double):Double={
      val n3 = n1.toDouble
      n3 + n2
    }
    println(sum(1,2))

    def f1 = "venassa"
    println(f1) //

    def eq2(s1: String)(s2: String): Boolean = {
      s1.toLowerCase == s2.toLowerCase
    }
    println(eq2("ASDFG")("ASDFG"))


  }




}
