package com.atuguigu.scalaListMethod

import scala.io.Source

object WorldCountFile {
  def main(args: Array[String]): Unit = {

    // 从文件中获取数据，统计数量
    val iterator: Iterator[String] = Source.fromFile("in/word.txt").getLines()
    val list: List[String] = iterator.toList
    println(list)
    //接下来就是wordCount3的案例了...
  }
}
