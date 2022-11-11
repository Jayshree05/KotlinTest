package com.example.codetesting.kotlintest.scope_function

/*property of also
- Refer to context object by using 'it'
- The return value is "Context object"*/


// Also use when you perform some extra operation

fun main() {
    val numberList: MutableList<Int> = mutableListOf(1, 2, 3)

    // operation on the numberList  **** it use
    numberList.also {
        it.add(3, 5)
        println("after add $numberList")
        it.remove(1)
        println("after remove 1st index $numberList")
    }

    var duplicatelist = numberList.also {
        it.add(3, 5)
        println("after add $numberList")
        it.remove(1)
        println("after remove 1st index $numberList")
    }

    println(numberList)
    println(duplicatelist)
}