package com.example.codetesting.kotlintest.scope_function

/*property of let
- Refer to context object by using 'this'
- The return value is "lamda result"
- run is the combination of 'with' and 'let'

*/


fun main(){

    var person: Person? = Person()

    // with lamda function
    var bio = person?.run{
        print(age)
        age + 5
        "Here is my age $age"
    }

    print("bio of person $bio")
}