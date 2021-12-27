package xyz.thanhnamitit.test.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import xyz.thanhnamitit.test.App
import xyz.thanhnamitit.test.di.module.ActivityModule
import xyz.thanhnamitit.test.di.module.AppModule
import xyz.thanhnamitit.test.di.module.NetworkModule
import xyz.thanhnamitit.test.di.viewmodel.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        NetworkModule::class,
        ViewModelModule::class,
    ]
)
interface ApplicationComponent : AndroidInjector<App> {
    override fun inject(instance: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder
        fun build(): ApplicationComponent
    }
}