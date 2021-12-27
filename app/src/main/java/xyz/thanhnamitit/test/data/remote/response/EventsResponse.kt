package xyz.thanhnamitit.test.data.remote.response

import com.google.gson.annotations.SerializedName

class EventsResponse(
    @SerializedName("events")
    val events: List<EventResponse>
)