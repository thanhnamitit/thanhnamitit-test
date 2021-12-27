package xyz.thanhnamitit.test.screen.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.airbnb.epoxy.EpoxyRecyclerView
import dagger.android.support.DaggerFragment
import xyz.thanhnamitit.test.R
import xyz.thanhnamitit.test.di.viewmodel.ViewModelFactory
import javax.inject.Inject

class HomeFragment : DaggerFragment(R.layout.fragment_home) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    val viewModel by viewModels<HomeViewModel> {
        viewModelFactory
    }

    private val recyclerView: EpoxyRecyclerView?
        get() = view?.findViewById(R.id.recycler_view)


    private val controller by lazy { HomeController(viewModel) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView?.setControllerAndBuildModels(controller)
        viewModel.getEvents()
        viewModel.events.observe(this) { controller.events = it }
    }
}