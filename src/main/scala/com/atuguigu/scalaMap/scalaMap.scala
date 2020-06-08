package com.atuguigu.scalaMap

import scala.collection.mutable


object scalaMap {
  def main(args: Array[String]): Unit = {

    //Map集合 K-V对  java中 HashMap map = new HashMap；map.put()
    //Scala中kv对采取特殊的方式声明
    //Map集合默认不可变的 immutable
    val map: Map[String, Int] = Map("a" -> 1, "b" -> 2, "c" -> 3)
    println(map.mkString(","))

    val map1: Map[String, Int] = map.+("d" -> 4)
    println(map1.mkString(","))

    (map + ("a" -> 9, "d" -> 4)).foreach(print)
    println(map == map1) //两者不相等 以上的是不可变集合

    //Scala为了防止出现空指针异常，提供了一个特殊的类：Option，有两个特殊对象 Some ，None
    //如果确实没有获取到数据 Option类提供了有默认值的方法
    //println(map.get("f").get)
    println(map.get("a").getOrElse(0))
    println(map.get("f").getOrElse(0))//有就取值 没有就返回0
    //可变Map集合
    val map2: mutable.Map[String, Int] = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
    map2.foreach(print)
    println()

  }
}
