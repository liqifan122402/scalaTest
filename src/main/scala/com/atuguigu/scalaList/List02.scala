package com.atuguigu.scalaList

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object List02 {
  def main(args: Array[String]): Unit = {
    //java数组:  int[] ints = new int[3];ints[0]=1;int i = ints[0]

    //Scala 数组: 使用Array对象实现 []里面表示类型
    //Array[String]
    //Scala简化创建数组
    val ints: Array[Int] = Array(1, 2, 3, 4)
    println(ints)
    ints.+("sssss") //数组和字符串拼接

    println(ints.mkString("==="))

    for (elem <- ints) {
      println(elem)
    }

    def printlnXXX(i: Int): Unit = {
      println(i)
    }

    ints.foreach(printlnXXX)

    //ints.foreach((i:Int)=>{println(i)})
    //ints.foreach((i)=>{println(i)})
    //      ints.foreach({println(_)})
    //    ints.foreach(println(_))
    ints.foreach(println) //最简化模式

    //增加元素
    val ints1: Array[Int] = ints :+ (5)
    val ints3: Array[Int] = 5 +: (ints)
    println(ints1.mkString(","))
    println(ints3.mkString(","))
    println(ints == ints1)

    //修改数据
    ints.update(1, 5)
    println(ints.mkString(","))

    //可变数组ArrayBuffer
    val ints4 = ArrayBuffer(1, 2, 3, 4)
    ints4(0) = 9
    println(ints4.mkString(","))
    println(ints4(3))
    ints4.foreach(println)
    //增加数据
    val ints5: ArrayBuffer[Int] = ints4 += (9)
    ints5.foreach(println)

    //删除数据
    val i: Int = ints5.remove(1)
    println("===============")
    println(i)
    println("===============")
    ints5.foreach(println)
    println("===============")
    ints5.remove(0, 1)
    ints5.foreach(println)


    //可变数组和不可变数组之间转换
    val buffer: mutable.Buffer[Int] = ints.toBuffer
    val array: Array[Int] = ints5.toArray


  }
}
