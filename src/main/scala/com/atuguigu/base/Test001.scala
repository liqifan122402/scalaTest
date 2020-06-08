package com.atuguigu.base

object Test001 {
  def main(args: Array[String]): Unit = {
    val name = "ApacheCN"
    val age = 1
    val url = "www.atguigu.com"

    var root = "200220202"
    root = "111"

    var s:Short = 5
    s = (s-2).toShort

    var b : Byte = 3
    b = (b+4).toByte//b=(Byte)(b+4)

    val s1 = new String("123")
    val aaa = s1.toInt
    println(aaa-23)


    /**@
      * 第一个是类似java的输出
      * 第二个是类似C语言的输出
      * 第三个是类似PHP的输出
      */
    println("name="+name+"age="+age+"url="+url)//java
    printf("name=%s,age=%d,url=%s \n",name,age,url)//c
    println(s"name=$name,age=$age,url=$url")//PHP
    println("root="+root.charAt(1));
  }
}//E:\IDEA\scala001\src\main\scala\com\atuguigu\base\Test001.scala
