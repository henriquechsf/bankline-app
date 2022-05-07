package tech.henriquedev.bankline.data

import android.util.Log
import androidx.lifecycle.liveData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.henriquedev.bankline.data.remote.BanklineApi

object BanklineRepository {

    private val TAG = javaClass.simpleName

    private val restApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://localhost:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BanklineApi::class.java)
    }

    fun findBankStatement(accountHolderId: Int) = liveData {
        emit(State.Wait)
        try {
            emit(State.Success(data = restApi.findBankStatement(accountHolderId)))
        } catch (e: Exception) {
            Log.e(TAG, e.message, e)
            emit(State.Error(e.message))
        }
    }
}