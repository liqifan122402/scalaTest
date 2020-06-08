package com.atuguigu.scalaListMethod

object scalaMethod2 {

  def main(args: Array[String]): Unit = {

    //TODO 过滤
    var list: List[Int] = List(1, 2, 3, 4)
    val res: List[Int] = list.filter(i=>{(i>2)})
    println(res.mkString(","))

    //TODO 拉链
    val list1 = List(1,2,3)
    val list2 = List(4,5,6,7)
    val tuples: List[(Int, Int)] = list1.zip(list2)
    for (elem <- tuples.iterator) {
      print(elem+",")
    }
    println()

    //TODO 并集
    val unionList: List[Int] = list1.union(list2)
    println(unionList.mkString(","))

    //TODO 交集
    println(list.intersect(list2).mkString(","))

    //TODO 差集 保留谁 谁就是函数的调用者
    println(list2.diff(list).mkString(","))



  }

}
