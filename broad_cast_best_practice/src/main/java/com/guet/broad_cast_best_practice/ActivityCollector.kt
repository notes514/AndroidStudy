package com.guet.broad_cast_best_practice

import android.app.Activity

/**
 * Activity 收集器
 *
 * @author dhxstart
 * @date 2022/7/10 17:57
 */
object ActivityCollector {

    private val activities = ArrayList<Activity>()

    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    fun finishAll() {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
        activities.clear()
    }
}