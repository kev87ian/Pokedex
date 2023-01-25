package com.example.pokedex.util

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data, null)

    class Error<T>(data: T? = null, message: String) : Resource<T>(null, message)

    class Loading<T> : Resource<T>()
}
