package com.example.kotlintest.dragger;

/*- "car class is not testable" -> bcoz we need engine class object

- "code is not extensible" ->bcoz engine class dependency is hardcoded, if we need some other engine then we should manage it

- "single responsibility" -> car class first make engine class object then call its function drive, if in future engine class have some change
then car class needs to do that changes into own.

- "life time of object" (not resuability) -> in this case when car class object destroy that time only engine class object destroy
but here we own create engine class object so we cant reuse this object into other class.*/

/*public class Carclass {
private val engine: Engine =  Engine()  // this is called Field injection
fun drive(){
    engine.start()
}
}*/


//To resolve that problem we need to do some change ---
//Here we pass the engine object into car class constructor & provide engine object from outside the class

//public class Carclass (private val engine: Engine){    // this is called constructor injection
//fun drive(){
//    engine.start()
//}
//}