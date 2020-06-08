package com.atuguigu.base

object LazyTest {
  def main(args: Array[String]): Unit = {


    def f1(f2 : ()=>Unit) = {
      f2()
    }

    f1(()=>{println("匿名函数")})


  }




}
