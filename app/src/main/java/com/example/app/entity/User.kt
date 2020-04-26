package com.example.app.entity

/**
 * @author qhc
 * @time 2020/4/24
 */
data class User constructor(var username: String?, var password: String?, var code: String?) {

    constructor() : this(null, null, null)

}