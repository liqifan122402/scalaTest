package com.atuguigu.scalaListMethod

object WorldCount {
  def main(args: Array[String]): Unit = {
    //TODO WorldCount
    // 按照结果的出现次数降序排列，取前三名
    val WCList: List[String] = List("Hello","Scala","Hello","World","Hbase",
      "Hadoop","Kafka","Scala","World")
    //1.先转换形态----> （单词,1）的K,V形式
    val res1: Seq[(String, Int)] = WCList.map(s=>{(s,1)})
    println(res1.mkString(","))
    //2.按照单词分组
    val res2: Map[String, Seq[(String, Int)]] = res1.groupBy(t=>{t._1})
    println(res2.mkString(","))
    //3.再次转换形态----> (单词，出现的次数(v的size))
    val res3: Map[String, Int] = res2.map(t=>{(t._1,t._2.size)})
    for (elem <- res3.iterator) {
      print(elem+",")
    }
    println()
    //4.按照次数进行排序 降序
    val res4 = res3.toList.sortWith((left,right)=>{left._2>right._2})
    for (elem <- res4.iterator) {
      print(elem+",")
    }
    println()
    //5.取前三名
    val finalRes: List[(String, Int)] = res4.take(3)
    println(finalRes.mkString(","))
  }
}
