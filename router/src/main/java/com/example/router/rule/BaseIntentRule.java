package com.example.router.rule;

import android.content.Context;
import android.content.Intent;

import java.util.HashMap;

/**
 * Created by bulingzhuang
 * on 2016/12/19
 * E-mail:bulingzhuang@foxmail.com
 */

public abstract class BaseIntentRule<T> implements Rule<T,Intent> {

    private HashMap<String,Class<T>> mIntentRuleMap;

    public BaseIntentRule() {
        mIntentRuleMap = new HashMap<>();
    }

    @Override
    public void router(String pattern, Class<T> aClass) {
        mIntentRuleMap.put(pattern,aClass);
    }

    @Override
    public Intent invoke(Context context, String pattern) {
        Class<T> tClass = mIntentRuleMap.get(pattern);
        if (tClass == null) {
            throwException(pattern);
        }
        return new Intent(context,tClass);
    }

    /**
     * 找不到路由规则对应的内容时抛出异常
     * @param pattern 路由Uri
     */
    public abstract void throwException(String pattern);
}
