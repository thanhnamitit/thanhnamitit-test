package xyz.thanhnamitit.test.screen.home

import com.airbnb.epoxy.EpoxyController
import xyz.thanhnamitit.test.domain.model.Async
import xyz.thanhnamitit.test.domain.model.Event
import xyz.thanhnamitit.test.error
import xyz.thanhnamitit.test.eventItem
import xyz.thanhnamitit.test.loading

class HomeController(private val viewModel: HomeViewModel) : EpoxyController() {
    var events: Async<List<Event>> = Async.Loading()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        val viewModel = viewModel
        when (events) {
            is Async.Fail -> error {
                id("error")
                onClick { _ ->
                    viewModel.getEvents()
                }
            }
            is Async.Loading -> loading { id("loading") }
            is Async.Success -> (events as Async.Success<List<Event>>).data.forEachIndexed { index, event ->
                eventItem {
                    id(index)
                    event(event)
                }
            }
        }
    }
}