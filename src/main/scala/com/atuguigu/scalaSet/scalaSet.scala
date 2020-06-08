package com.atuguigu.scalaSet

import scala.collection.mutable


object scalaSet {
  def main(args: Array[String]): Unit = {

    //set集合：无序 不可重复
    //默认Scala提供的Set集合是不可变的Immutable
    val set: Set[Int] = Set(1, 2, 3, 4, 1, 5, 6, 7, 8)

    println(set.mkString(","))
    //增加数据
    println(set + 11)
    //删除数据
    println(set - 3)

    set.foreach(println)

    //可变Set集合 mutable
    val mset = mutable.Set(1, 2, 3, 4)



  }
}
