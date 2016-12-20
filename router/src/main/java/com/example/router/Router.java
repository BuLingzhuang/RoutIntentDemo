package com.example.router;

import android.content.Context;

import com.example.router.rule.Rule;

/**
 * Created by bulingzhuang
 * on 2016/12/20
 * E-mail:bulingzhuang@foxmail.com
 * <p>
 * 路由类型(scheme)为（activity://，service://）
 * 路由Uri(pattern)为（activity://main.home，activity://main.my）
 * <p>
 * Step 1. 调用Router.router方法添加路由
 * Step 2. 调用Router.invoke方法根据pattern调用路由
 */

public class Router {

    /**
     * 添加路由规则
     *
     * @param scheme 路由类型（Activity,Service...）
     * @param rule   路由规则
     * @return Router真是调用类
     */
    public static RouterInternal addRule(String scheme, Rule rule) {
        RouterInternal router = RouterInternal.getInternal();
        router.addRule(scheme, rule);
        return router;
    }

    /**
     * 添加路由
     *
     * @param pattern 路由Uri
     * @param tClass  路由class
     * @param <T>
     * @return Router真是调用类
     */
    public static <T> RouterInternal router(String pattern, Class<T> tClass) {
        return RouterInternal.getInternal().router(pattern, tClass);
    }

    /**
     * 路由调用
     *
     * @param context Context
     * @param pattern 路由Uri
     * @param <V>
     * @return 返回对应的Intent
     */
    public static <V> V invoke(Context context, String pattern) {
        return RouterInternal.getInternal().invoke(context, pattern);
    }

}
