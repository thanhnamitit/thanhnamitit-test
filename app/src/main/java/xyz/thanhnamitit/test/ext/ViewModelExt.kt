package xyz.thanhnamitit.test.ext

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.thanhnamitit.test.domain.model.Async

fun <T> ViewModel.execute(executor: suspend () -> T, callBack: (Async<T>) -> Unit) {
    callBack.invoke(Async.Loading())
    viewModelScope.launch {
        try {
            val result = executor()
            callBack(Async.Success(result))
        } catch (e: Exception) {
            callBack(Async.Fail(e))
        }
    }
}