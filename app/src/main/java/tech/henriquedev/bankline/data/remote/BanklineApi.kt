package tech.henriquedev.bankline.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import tech.henriquedev.bankline.domain.Movimentacao

interface BanklineApi {

    @GET("movimentacoes/{id}")
    suspend fun findBankStatement(@Path("id") accountHolderId: Int): List<Movimentacao>
}