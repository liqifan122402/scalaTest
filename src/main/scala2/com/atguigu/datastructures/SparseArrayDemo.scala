package com.atguigu.datastructures

import scala.collection.mutable.ArrayBuffer

//TODO 稀疏数组
object SparseArrayDemo {
  def main(args: Array[String]): Unit = {
    //先使用二维数组映射棋盘
    val rows = 11
    val cols = 11
    val chessMap1: Array[Array[Int]] = Array.ofDim[Int](rows, cols) //11行11列的二维数组

    //初始化
    chessMap1(1)(2) = 1 //表示黑子
    chessMap1(2)(3) = 2 //2表示蓝子
    chessMap1(2)(2) = 1
    chessMap1(2)(1) = 2
    //打印原始棋盘
    println("原始棋盘")
    for (row <- chessMap1) {
      for (item <- row) {
        printf("%d ", item)
      }
      println()
    }
    //TODO 对原始的二维数组进行压缩
    //1.创建一个ArrayBuffer ，可以动态添加数据
    //2.使用Node对象 ，表示一行数据 （row：？，col：？，val：？）
    val sparseArray: ArrayBuffer[Node] = ArrayBuffer[Node]()
    //先将第一行数据放入
    sparseArray.append(new Node(rows, cols, 0))
    //将原始棋盘的有效数据放入sparseArray中
    for (i <- chessMap1.indices) {
      for (j <- chessMap1(i).indices) {
        //有效的数据
        if (chessMap1(i)(j) != 0) {
          sparseArray.append(new Node(i, j, chessMap1(i)(j)))
        }
      }
    }
    //打印稀疏数组
    println("稀疏数组的存储结果")
    for (elem <- sparseArray) {
      printf("%d %d %d", elem.row, elem.col, elem.value)
      println()
    }

    //将稀疏数组恢复成原始的棋盘
    //创建一个二维数组容器做棋盘
    val chessMap2: Array[Array[Int]] = Array.ofDim[Int](sparseArray(0).row, sparseArray(0).col)
    //把稀疏数组中的数据恢复到棋盘中
    for (i <- 1 until sparseArray.length) {
      chessMap2(sparseArray(i).row)(sparseArray(i).col) = sparseArray(i).value
    }
    //读盘
    println("读盘")
    for (row <- chessMap2) {
      for (elem <- row) {
        printf("%d ", elem)
      }
      println()
    }
  }
}

class Node(val row: Int, val col: Int, val value: Int)
