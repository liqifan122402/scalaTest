package com.atguigu.queue

import scala.io.StdIn

object QueueDemo2 {
  def main(args: Array[String]): Unit = {
    val queue2 = new ArrayQueue2(4)
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
        case "show" => queue2.show()
        case "add" =>
          println("请输入数字：")
          val num = StdIn.readInt()
          queue2.add(num)
        case "get" =>
          val res = queue2.get()
          if (res.isInstanceOf[Exception]) {
            println(res.asInstanceOf[Exception].getMessage)
          } else {
            printf("get到的值是：%d", res)
          }
        case "peek" =>
          val res = queue2.peek()
          if (res.isInstanceOf[Exception]){
            println(res.asInstanceOf[Exception].getMessage)
          }else{
            printf("头元素是：%d",res)
          }
        case "exit" => System.exit(0);
      }
    }
  }
}

class ArrayQueue2(arrayMaxSize: Int) {
  val maxSize: Int = arrayMaxSize
  val queue2 = new Array[Int](maxSize)
  var front = 0 //指向队列首个元素
  var rear = 0 //指向队列尾部元素的下一个
  //判断空
  def isEmpty(): Boolean = {
    rear == front
  }

  //判断满
  def isFull(): Boolean = {
    (rear + 1) % maxSize == front //true则满了
  }

  //查看头元素
  def peek(): Any = {
    if (isEmpty()) {
      return new Exception("队列空")
    } else {
      return queue2(front)
    }
  }

  //队列有效元素个数
  def size(): Int = {
    return (rear + maxSize - front) % maxSize
  }

  //遍历队列
  def show(): Any = {
    if (isEmpty()) {
      val message = new String("队列空")
      return message
    }
    //因为环形队列 尾部指针有可能会在front前面 所以不能从front to rear
    //思路：看有多少个有效元素
    for (i <- front until front + size()) {
      printf("arr(%d)=%d \t", (i % maxSize), queue2(i % maxSize))
    }
  }

  //添加元素
  def add(num: Int): Unit = {
    //判断是否满
    if (isFull()) {
      println("队列满")
      return
    }
    //先添加 再将rear后移
    queue2(rear) = num
    rear = (rear + 1) % maxSize
  }

  //获取元素
  def get(): Any = {
    //判断是否空
    if (isEmpty()) {
      return new Exception("队列空")
    } else {
      //先获取 再将front后移
      val res = queue2(front)
      front = (front + 1) % maxSize
      return res
    }
  }
}
