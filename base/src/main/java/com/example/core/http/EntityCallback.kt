package com.example.core.http

/**
 * @author qhc
 * @time 2020/4/24
 */
interface EntityCallback<T> {

    fun onSuccess(entity:T)

    fun onFailure(message: String)

}