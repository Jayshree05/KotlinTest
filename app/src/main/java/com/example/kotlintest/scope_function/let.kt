package com.example.codetesting.kotlintest.scope_function

/*property of let
- Refer to context object by using 'it'
- The return value is "lamda result"*/

fun main(){

    // let function use to "avoid null pointer exception"

    val name: String? = null
//    println(name!!.reversed())  // Exception in thread "main" java.lang.NullPointerException -- bcoz "name" is null
//    to avoid this exception we use "let" function


    // let function use along with Safe call operator "?." , without safe call we got exception
    name?.let {
        println(it!!.reversed())
    }


    val name1: String? = "Hii"
    // return lamda function
    val namelength = name1?.let {
        it.length
    }
    println(namelength)
}