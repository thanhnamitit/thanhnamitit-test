package xyz.thanhnamitit.test.domain.usecase

import xyz.thanhnamitit.test.data.remote.service.ApiService
import xyz.thanhnamitit.test.domain.model.Event
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

class GetEventsUseCase @Inject constructor(
    private val apiService: ApiService,
) {
    suspend operator fun invoke(): List<Event> {
        return apiService.getEvents().events.map {
            Event(
                name = it.name ?: "",
                availableSeats = it.availableSeats ?: 0,
                date = it.date?.let { date ->
                    val calendar = Calendar.getInstance()
                    calendar.time = simpleDateFormat.parse(date)
                    calendar.timeInMillis
                } ?: 0,
                labels = it.labels.orEmpty(),
                price = it.price ?: 0,
                venue = it.venue.orEmpty()
            )
        }.filter { it.availableSeats != 0 }.sortedBy { it.date }
    }
}