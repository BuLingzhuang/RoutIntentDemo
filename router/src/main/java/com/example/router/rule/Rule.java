package com.example.router.rule;

import android.content.Context;

/**
 * Created by bulingzhuang
 * on 2016/12/19
 * E-mail:bulingzhuang@foxmail.com
 */

public interface Rule<T,V> {


    /**
     * 添加路由
     * @param pattern 路由Uri
     * @param tClass 路由class
     */
    void router(String pattern,Class<T> tClass);

    /**
     * 路由调用
     * @param context Context
     * @param pattern 路由Uri
     * @return
     */
    V invoke(Context context,String pattern);
}
