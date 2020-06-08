package com.atuguigu.scalaSeq

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object ImmuList {
  def main(args: Array[String]): Unit = {

    //序列 seq
    //默认Scala提供的集合都是不可变的
    val list: List[Int] = List(1, 2, 3, 4)
    val listb: List[Int] = List(5, 6, 7, 8)
    //索引获取数据
    println(list(0))


    //增加数据
    val list1: List[Int] = list :+ 1
    println(list1.mkString(","))

    val list2: List[Int] = 1 +: list
    println(list2.mkString(","))

    val combinerList: List[Int] = list.++(listb)
    // 上面的++() 可以简化写成 list ++ listb
    println(combinerList.mkString(","))

    //::运算符从右到左计算
    //val list3: List[Int] = list.::(9)
    val list3: List[Int] = 7 :: 8 :: 9 :: list
    println(list3.mkString(","))

    val list4 = 9 :: list :: listb
    println(list4.mkString(","))

    val list5: List[Int] = 9 :: list ::: listb
    println(list5.mkString(","))

    //特殊集合
    println(List())
    println(Nil)
    val nil: List[Int] = 1 :: 2 :: 3 :: Nil
    println(nil.mkString("==="))

    //修改
    val list6: List[Int] = list.updated(2, 5)
    println(list6.mkString(","))

    //删除
    val list8: List[Int] = list.drop(2)
    list8.foreach(print)
    println()
    //查询
    list.foreach(print)

    println()


    //TODO 以下是可变集合
    val listBuffer: ListBuffer[Int] = ListBuffer(1, 2, 3, 4)
    //    listBuffer.insert()
    //    listBuffer.update()
    //    listBuffer.drop()
    //    listBuffer.remove()
    //集合的属性
    //集合的头
    println(listBuffer.head)
    //集合的尾(除了头都是尾)
    println(listBuffer.tail)
    //集合的最后一个
    println(listBuffer.last)
    //除了最后一个之外的
    println(listBuffer.init)

    //队列 一定可变
    val q: mutable.Queue[Int] = mutable.Queue(1, 2, 3, 4)
    println("add Before"+q)
    //放数据
    q.enqueue(5)
    println("add after"+q)
    //取数据
    q.dequeue()
    println("delete after"+q)
    //队列删除遵循先进先出
    q.dequeue()
    q.dequeue()
    println(q)


  }
}
