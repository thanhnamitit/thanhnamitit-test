package xyz.thanhnamitit.test.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import xyz.thanhnamitit.test.domain.model.Async
import xyz.thanhnamitit.test.domain.model.Event
import xyz.thanhnamitit.test.domain.usecase.GetEventsUseCase
import xyz.thanhnamitit.test.ext.execute
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase,
) : ViewModel() {

    private val _events = MutableLiveData<Async<List<Event>>>()

    val events: LiveData<Async<List<Event>>>
        get() = _events

    fun getEvents() = execute(executor = { getEventsUseCase() }) {
        _events.postValue(it)
    }
}