package xyz.thanhnamitit.test.di.module

import xyz.thanhnamitit.test.screen.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(
        modules = [FragmentModule::class]
    )
    abstract fun contribute(): MainActivity
}
