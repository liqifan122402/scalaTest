package com.atuguigu.scalaListMethod

import scala.collection.mutable

object scalaMethod3 {
  def main(args: Array[String]): Unit = {

    val list = List(1, 2, 3, 4)
    //TODO reduce()化简 可以实现sum()的功能 也能实现 * / -
    val n: Int = list.reduce(_ + _)
    println(n)
    println(list.reduce(_ * _))
    println(list.reduce(_ - _))
    println(list.reduce(_ / _))

    println(list.reduceLeft(_ + _))
    println(list.reduceRight(_ + _))

    //TODO fold() 折叠
    println(list.fold(1)(_ + _))
    println(list.foldLeft(10)(_ - _))
    println(list.foldRight(10)(_ - _))

    val map1 = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
    val map2 = mutable.Map("a" -> 3, "c" -> 2, "d" -> 1)

    val map3 = map1.foldLeft(map2)((map, t) => {
      map(t._1) = map.getOrElse(t._1, 0) + t._2
      map
    })
    println(map3)

  }
}
