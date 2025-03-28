package com.romesh.loginsample2025.network

sealed class ResultCallBack<out T> {
    object Loading : ResultCallBack<Nothing>()
    data class Success<out T>(val data: T) : ResultCallBack<T>()
    data class Error(val message: String) : ResultCallBack<Nothing>()
}