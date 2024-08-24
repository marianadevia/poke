package com.example.pokemon.data.datasource.remote.retrofit

data class DomainError(
    val type: String? = null,
    val statusCode: String? = null,
    val name: String? = null,
    val message: String? = null
)

fun RemoteError.toDomainError(): DomainError {
    return when (this) {
        is ApiError          -> {
            DomainError(
                exceptionError.type,
                exceptionError.statusCode,
                exceptionError.name,
                exceptionError.message
            )
        }
        is ConnectionError   -> DomainError(message = message)
        is UnauthorizedError ->
            DomainError(
                exceptionError.type,
                exceptionError.statusCode,
                exceptionError.name,
                exceptionError.message
            )
        is UnknownError      ->
            DomainError(
                message = message
            )
        is UnexpectedNullBodyError ->
            DomainError(message = message)
    }
}