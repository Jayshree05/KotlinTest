package com.example.codetesting.kotlintest.scope_function

/*property of apply
- Refer to context object by using 'this'
- The return value is "context object"*/


//if you want to initialize object
class Person1{
        var name: String = "";
        var age: Int = 0;
    }

fun main(){

    // with function context using 'this' **** (To assign the value)
    var person = Person1().apply {
        name = "Jaya"
        age = 10
    }

    println(person.age) // normal we can print object variable

    // persone object print "with" scope
    with(person){
        println(this.name)  // you can remove this keyword
        println(name)
    }
}