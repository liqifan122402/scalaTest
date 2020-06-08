package com.atguigu.queue

import scala.io.StdIn

object QueueDemo {
  def main(args: Array[String]): Unit = {
    val queue: ArrayQueue = new ArrayQueue(3)
    //菜单演示
    var key = ""
    while (true) {
      println("请选择菜单")
      println("show：显示队列")
      println("add ：添加队列")
      println("get ：获取数据")
      println("peek：获取头部")
      println("exit：退出程序")
      key = StdIn.readLine()
      key match {
        case "show" => queue.showQueue()
        case "add" =>
          println("请输入一个数：")
          val num = StdIn.readInt()
          queue.addQueue(num)
        case "get" =>
          //对取回的值进行判断
          val res = queue.getQueue()
          if (res.isInstanceOf[Exception]) {
            println(res.asInstanceOf[Exception].getMessage)
          } else {
            printf("队列取出的值=%d", res)
          }
        case "peek" =>
          val res = queue.peek()
          if (res.isInstanceOf[Exception]) {
            println(res.asInstanceOf[Exception].getMessage)
          } else {
            printf("头元素是：%d", res)
          }
      }
      println()
    }
  }
}

//编写一个数据结构的基本思路 创建---遍历---修改---删除
class ArrayQueue(arrayMaxSize: Int) {

  val maxSize = arrayMaxSize //指定队列大小
  val arr = new Array[Int](maxSize) //队列中的数据存放在数组 数组模拟队列
  var front = -1 //初始化为-1 表示队列头 但不包含队列首元素
  var rear = -1 //初始化为-1 表示队列尾 且包含队列尾元素

  //判断队列是否满
  def isFull(): Boolean = {
    rear == maxSize - 1
  }

  //判断队列是否空
  def isEmpty(): Boolean = {
    front == rear
  }

  //查看头元素 不取出
  def peek(): Any = {
    if (isEmpty()) {
      return new Exception("队列空 无数据")
    }
    return arr(front + 1)
  }

  //添加 向队列中添加数据
  def addQueue(num: Int): Unit = {
    if (isFull()) {
      println("队列满，不能加入")
      return
    }
    //将rear后移
    rear += 1
    arr(rear) = num
  }

  //遍历
  def showQueue(): Unit = {
    if (isEmpty()) {
      println("队列空")
      return
    }
    println("队列数据情况：")
    for (i <- front + 1 to rear) {
      printf("arr(%d)=%d \t", i, arr(i))
    }
  }

  //取值
  def getQueue(): Any = {
    if (isEmpty()) {
      return new Exception("队列空")
    }
    //取值前将front后移
    front += 1
    return arr(front)
  }


}
