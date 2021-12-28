package com.android.activity;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityController {
    private static ActivityController instance = null;
    private final List<Activity> activities = new ArrayList<>();

    public static ActivityController getInstance() {
        if (instance == null) {
            synchronized (ActivityController.class) {
                if (instance == null) {
                    instance = new ActivityController();
                }
            }
        }
        return instance;
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        this.activities.remove(activity);
    }

    public void finishAllActivities() {
        for (Activity activity : this.activities) {
            // 此方法用于判断 Activity 是否正在销毁中
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
