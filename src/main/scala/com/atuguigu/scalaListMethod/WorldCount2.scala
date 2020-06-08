package com.atuguigu.scalaListMethod

object WorldCount2 {
  def main(args: Array[String]): Unit = {

    //TODO map阶段读取的数据是一行一行的 所以。。。
    //TODO 把一个字符串拆成一个一个的个体 这个操作称为 “扁平化”
    val lineList: List[String] = List("Hello World","Hello Scala","Hello Hadoop")
    //1.扁平化 flatMap()函数
    val eachWorld: List[String] = lineList.flatMap(x=>{x.split("")})
    //2.按照单词分组
    val groupWorld: Map[String, List[String]] = eachWorld.groupBy(x=>{x})
    //3.转换value的形态为单词的次数，也即List的size
    val worldCountNoSort: Map[String, Int] = groupWorld.map(t=>{(t._1,t._2.size)})
    //4.降序排序
    val worldCountDESC: List[(String, Int)] = worldCountNoSort.toList.sortWith((a, b)=>{a._2>b._2})
    //5.取前三名
    val finalResult: List[(String, Int)] = worldCountDESC.take(3)
    println(finalResult.mkString(","))


  }
}
