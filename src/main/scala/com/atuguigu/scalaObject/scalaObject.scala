package com.atuguigu.scalaObject

object scalaObject {
  def main(args: Array[String]): Unit = {
    val user = new User()
    println(user)
    user.username = "zhangsan"
    println(user.username)
  }
}

