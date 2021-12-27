package xyz.thanhnamitit.test.data.remote.response

import com.google.gson.annotations.SerializedName

data class EventResponse(
    @SerializedName("name")
    val name: String?,
    @SerializedName("date")
    val date: String?,
    @SerializedName("available_seats")
    val availableSeats: Int?,
    @SerializedName("price")
    val price: Int?,
    @SerializedName("venue")
    val venue: String?,
    @SerializedName("labels")
    val labels: List<String>?
)