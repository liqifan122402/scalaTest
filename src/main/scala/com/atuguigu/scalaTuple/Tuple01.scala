package com.atuguigu.scalaTuple

object Tuple01 {
  def main(args: Array[String]): Unit = {

    //Tuple 元组
    //Map( k -> v )
    //将无关的数据当作整体来使用：empid , email ,ordernum
    //使用小括号()将数据关联在一起，形成一个整体
    val tuple: (String, Int, String) = ("zhangsan", 1111, "xxxxxx")
    //访问元组中的数据
    //元组中最多放22个数据
    println(tuple._1)
    println(tuple._2)
    println(tuple._3)

    //元组循环遍历
    /*    for (elem <- tuple.productIterator) {
          println(elem)
        }*/

    //元组中只有2个元素 称之为对偶，类似于Map中的键值对
    val tuple1: (Int, String) = (1, "张三")
    val tupleMap: Map[Int, String] = Map(tuple1)
    tupleMap.foreach(t=>{println(t._1+","+t._2)})


  }
}

class User {

  var username: String = _
  var age: Int = _

}
