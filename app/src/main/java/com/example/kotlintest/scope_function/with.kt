package com.example.codetesting.kotlintest.scope_function

/*property of with
- Refer to context object by using 'this'
- The return value is "lamda function"*/

     class Person{
        var name: String = "Jaya";
        var age: Int = 10;
    }

fun main(){

    // Here repeating the same persone object twise, but if we have 20 variable then that time we can call same
   // person object at 20 time, so remove this repeatation we use "with" scope
    var person = Person()
    println(person.name)
    println(person.age)

    // with function context using 'this'
    with(person){
        println(this.name)  // you can remove this keyword
        println(name)
    }

    // with lamda function
    var agecount: Int = with(person){
        age + 5
    }
    print("age after 5 year $agecount")
}