package com.example.app.entity

/**
 * @author qhc
 * @time 2020/4/24
 */
data class User constructor(var username: String?, var password: String?, var code: String?) {

    constructor() : this(null, null, null)

    operator fun plus(user: User): User{
        var (username1, password1, code1) = user

        return User(username1 + this.username, password1 + this.password, code1 + this.code)
    }

    override fun toString(): String {
        return "User(username=$username, password=$password, code=$code)"
    }

}