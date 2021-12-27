package xyz.thanhnamitit.test.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import xyz.thanhnamitit.test.di.viewmodel.ViewModelKey
import xyz.thanhnamitit.test.screen.home.HomeFragment
import xyz.thanhnamitit.test.screen.home.HomeViewModel

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector(
        modules = [
            Binding::class,
        ]
    )
    abstract fun contribute(): HomeFragment
}

@Module
abstract class Binding {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bind(viewModel: HomeViewModel): ViewModel
}
