package com.atuguigu.scalaListMethod

object WorldCount3 {
  def main(args: Array[String]): Unit = {

    val lineList: List[(String, Int)] = List(("Hello Scala World", 4), ("Hello World", 3), ("Hello Hadoop", 2), ("Hello Hbase", 1))

    //1.扁平化操作
    //List((Hello,4), (Scala,4), (World,4), (Hello,3), (World,3), (Hello,2), (Hadoop,2), (Hello,1), (Hbase,1))
    val flatMapList: List[(String, Int)] = lineList.flatMap(x => {
      val world: Array[String] = x._1.split(" ")
      println(world.mkString(" "))
      world.map(y => {
        (y, x._2)
      })
    })
    println(flatMapList)

    //2.分组
    //Hbase -> List((Hbase,1)),Scala -> List((Scala,4)),Hello -> List((Hello,4), (Hello,3), (Hello,2), (Hello,1)),Hadoop -> List((Hadoop,2)),World -> List((World,4), (World,3))
    val groupByMap: Map[String, List[(String, Int)]] = flatMapList.groupBy(x=>{x._1})
    println(groupByMap.mkString("，"))

    //3.1 计算---转换value格式--->List(4,3,2,1)
    val listMap: Map[String, List[Int]] = groupByMap.map(x => {
      (x._1,
        x._2.map(y => {
          y._2
        }))
    })
    println(listMap.mkString("，"))

    //3.2 计算---求List元素和
    val sumMap: Map[String, Int] = listMap.map(x=>{(x._1,x._2.sum)})
    println(sumMap.mkString("，"))

    //4.排序前转List
    val listResult: List[(String, Int)] = sumMap.toList
    println(listResult)

    //5.降序
    val sortList: List[(String, Int)] = listResult.sortWith((x, y)=>{(x._2>y._2)})
    println(sortList.mkString("，"))

    //6.前三名
    val result: List[(String, Int)] = sortList.take(3)
    println(result)
  }
}
