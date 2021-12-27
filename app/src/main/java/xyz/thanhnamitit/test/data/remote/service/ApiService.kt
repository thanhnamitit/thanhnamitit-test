package xyz.thanhnamitit.test.data.remote.service

import retrofit2.http.GET
import xyz.thanhnamitit.test.data.remote.response.EventsResponse

interface ApiService {
    @GET("/bridj-coding-challenge/events.json")
    suspend fun getEvents(): EventsResponse
}
