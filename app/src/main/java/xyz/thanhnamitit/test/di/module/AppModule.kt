package xyz.thanhnamitit.test.di.module

import android.content.Context
import xyz.thanhnamitit.test.App
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    abstract fun bindContext(app: App): Context
}