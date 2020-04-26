package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.utils.Utils
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author qhc
 * @time 2020/4/26
 */
class LessonPresenter constructor(val activity: LessonActivity) {

    private val LESSON_PATH = "lessons";

    private var lessons: List<Lesson> = ArrayList()

    private val type = object : TypeToken<List<Lesson>>() {}.type

    fun fetchData(){
        HttpClient.get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(entity: List<Lesson>) {
                lessons = entity
                activity.runOnUiThread{
                    activity.showResult(lessons)
                }
            }

            override fun onFailure(message: String) {
                Utils.toast(message)
            }

        })
    }

    fun showPlayback(){
        activity.showResult(lessons.filter {
            it.state == Lesson.State.PLAYBACK
        })
    }
}