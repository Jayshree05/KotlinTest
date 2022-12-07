package com.example.kotlintest.mvvm_dragger.module.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlintest.mvvm_dragger.module.repository.ProductRepository
import dagger.Provides
import javax.inject.Inject
import javax.inject.Provider


//used for create the viewmodel object
/*
class MainViewModelFactory @Inject constructor(private val repository: ProductRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}*/

/*class MainViewModelFactory @Inject constructor(
    private val repository: ProductRepository, private val randmize: Randmize
    ): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository, randmize) as T
    }
}*/


// for dagger create the object of mainviewmodel -- bcoz we add inject with filed construtor
class MainViewModelFactory @Inject constructor(private val mainViewModel: MainViewModel): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return (mainViewModel) as T
    }
}


// for using default generic factory --- use 1 factory with whole project
//class MainViewModelFactory @Inject constructor(private val map: Map<Class<*>, @JvmSuppressWildcards ViewModel>): ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return map[modelClass] as T
//    }
//}
//
//class MainViewModelFactory @Inject constructor(private val map: Map<String, @JvmSuppressWildcards ViewModel>): ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        println("model class $modelClass")
//        return map.keys as T
//    }
//}
