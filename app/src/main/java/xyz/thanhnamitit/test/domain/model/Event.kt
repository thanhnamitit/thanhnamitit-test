package xyz.thanhnamitit.test.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(
    val name: String,
    val date: Long,
    val availableSeats: Int,
    val price: Int,
    val venue: String,
    val labels: List<String>
) : Parcelable