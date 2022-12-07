package com.example.kotlintest.dragger

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class UserRepositoryModule {

//    @Provides
//    fun getFirebaseRepository(): UserRepository {
//        return FirebaseUserRepository()
//    }


    // If we use @binds then function & class name must be abstract
    @Binds
    abstract fun getFirebaseRepository(sqlUserRepository: SQLUserRepository): UserRepository


}