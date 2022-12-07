package com.example.daggermvvm.testing

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier





// RETENTION - DEFINE TIMELINE OF THE ANNOTATION

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class MessageQualifier {
}