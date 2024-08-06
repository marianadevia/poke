package com.example.pokemon.data.datasource.remote.retrofit

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

suspend inline fun <T> executeCall(
    ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    nullableBody: Boolean = true,
    crossinline retrofitCall: suspend () -> Response<T>
): Either<RemoteError, Response<T>> {
    return withContext(ioDispatcher) {
        try {
            retrofitCall().processRemoteResponse(nullableBody)
        } catch (e: Exception) {
            return@withContext Either.Error(e.processRemoteException())
        }
    }
}
