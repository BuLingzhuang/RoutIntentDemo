package com.example.router.rule;

import android.app.Activity;
import android.content.ActivityNotFoundException;

/**
 * Created by bulingzhuang
 * on 2016/12/19
 * E-mail:bulingzhuang@foxmail.com
 */

public class ActivityRule extends BaseIntentRule<Activity> {

    public static final String ACTIVITY_SCHEME = "activity://";

    @Override
    public void throwException(String pattern) {
        throw new ActivityNotFoundException(pattern);
    }
}
