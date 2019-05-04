@file:Suppress("DEPRECATED_JAVA_ANNOTATION")

package jp.co.proc.notebook.presentation.di

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.RUNTIME
import javax.inject.Scope

@Scope
@Retention(RUNTIME)
annotation class PerActivity
