package com.atuguigu.base

import java.util.NoSuchElementException

import javax.management.ImmutableDescriptor

import scala.collection.mutable

object Hello {
  def main(args: Array[String]): Unit = {
    /**
      * list集合
      */
    val list1 = List(1, 2, 3, 4)
    val list2 = 5 :: 6 :: 7 :: list1
    println(list2)

    val list3 = list1 :+ 5 :+ 6 :+ 7
    println(list3)

    val list4 = list1 ::: Nil ::: 0 :: list2 ::: 0 :: list3
    println(list4)


    /**
      * 队列queue
      */
    println("=============== 队列 =================")
    val q1 = new mutable.Queue[Int]()
    println(q1)
    q1 += 20;
    println(q1)
    q1 ++= list1;
    println(q1)

    val cat = new Cat
    println(cat.age)
    cat.+=(9)
    println(cat.age)

    q1.dequeue()
    println(q1)
    q1.dequeue()
    println(q1)
    q1.dequeueFirst(_>2)
    println(q1)
    q1.dequeueAll(_%2==0)
    println(q1)
    q1.enqueue(9,8,7)
    println(q1)
    q1.enqueue(1)
    println(q1)
    println(q1.head+","+q1.tail.tail+","+q1.last)

    /**
      * map映射
      */
    //不可变的有序
    val map1 = scala.collection.immutable.Map("alice"->10,"lisi"->"12","wangwu"->14,"zhangsan"->22)
    println(map1)
    for (elem <- map1) {
      println("姓名："+elem._1+",年龄："+elem._2)
    }
    //可变的无序
    val map2 = scala.collection.mutable.Map("alice"->10,"lisi"->"12","wangwu"->14,"zhangsan"->22)
    println(map2)
    for (elem <- map2) {
      println("姓名："+elem._1+",年龄："+elem._2)
    }
    //空映射 提供泛型
    val map3 = new mutable.HashMap[String,Int]()
    println(map3)
    map3.put("asd",1)
    println(map3)
    val map4 = mutable.Map(("a",1),("b",2),("c",3),("d",4))
    println(map4)
    val i: Int = map4("a")+map4("d")
    println(i)

      //println(map4("aa"))


    //抛出 NoSuchElementException
    if(map4.contains("aa")){
      println(map4("aa"))
    }else{
      println("不存在aa")
    }
    if(map4.contains("a")){
      println(map4("a"))
    }



  }
}

class Cat {
  var age: Int = 10

  def +=(n: Int): Unit = {
    this.age += n
    println("xxx")
  }

}
