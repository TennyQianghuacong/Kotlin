package com.example.lesson.entity

/**
 * @author qhc
 * @time 2020/4/26
 */
data class Lesson constructor(var date: String?, var content: String?, var state: State?) {

    constructor():this(null, null, null)

    enum class State {
        PLAYBACK {
            override fun stateName(): String {
                return "有回放"
            }
        },
        LIVE {
            override fun stateName(): String {
                return "正在直播"
            }
        },
        WAIT {
            override fun stateName(): String {
                return "等待中"
            }
        };

        abstract fun stateName(): String?
    }

}