package com.atuguigu.scalaListMethod

object scalaMethod {
  def main(args: Array[String]): Unit = {

    //scala中集合的常用的方法
    val list = List(1, 2, 3, 4, 1, 2,1,1,3,4,2,5)
    println(list.sum) //计算集合元素值之和
    println(list.max)
    println(list.min)
    println(list.product) //计算集合元素值之乘积
    println(list.reverse)//单纯反转

    //分组 通过指定函数的返回值进行分组
    val intToInts: Map[Int, List[Int]] = list.groupBy(x => x)
    intToInts.foreach(t => {println(t._1 + "," + t._2)})

    val stringList = List("11", "22", "23", "11", "12", "22")
    val map2: Map[String, List[String]] = stringList.groupBy(s => {s.substring(0, 1)})
    map2.foreach(t => {println(t._1 + "," + t._2)})

    val map3: Map[Int, List[Int]] = list.groupBy(x => {x % 2})
    map3.foreach(t=>{println(t._1+","+t._2)})

    //排序 按照指定规则排序
    val sortList1: List[Int] = list.sortBy(x=>x)
    println(sortList1.mkString(","))

    val sortList2: List[String] = stringList.sortBy(s=>{s.charAt(1)})
    println(sortList2.mkString(","))

    //升序，降序
    val swList: List[Int] = list.sortWith((x, y)=>{x<y})
    println(swList.mkString(","))

    val swList2: List[Int] = list.sortWith((x, y)=>{x>y})
    println(swList2.mkString(","))

    println(stringList.sortWith((s1, s2) => {
      (s1.charAt(1)).toInt > s2.charAt(1).toInt
    }).mkString(","))

    //迭代
    for (elem <- stringList.iterator) {
      print(elem+",")
    }
    println()

    //映射 (转换)
    val tupleList: List[(Int, Int)] = list.map(i => {(i, 1)})
    val result: Map[Int, List[(Int, Int)]] = tupleList.groupBy(t=>t._1)
    println(result.mkString(","))
    val result2: Map[Int, Int] = result.map(t=>{(t._1,t._2.size)})
    println(result2.mkString(","))
    for (elem <- result2.iterator) {
      print(elem+",")
    }
    println()

  }
}
