package com.example.router;

import android.content.Context;

import com.example.router.exception.NotRouteException;
import com.example.router.rule.ActivityRule;
import com.example.router.rule.Rule;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by bulingzhuang
 * on 2016/12/19
 * E-mail:bulingzhuang@foxmail.com
 */

class RouterInternal {

    private static RouterInternal sInternal;

    //路由规则
    private HashMap<String, Rule> mRuleMap;

    private RouterInternal() {
        mRuleMap = new HashMap<>();
        initDefaultRouter();
    }

    static RouterInternal getInternal() {
        if (sInternal == null) {
            synchronized (RouterInternal.class) {
                if (sInternal == null) {
                    sInternal = new RouterInternal();
                }
            }
        }
        return sInternal;
    }

    /**
     * 添加默认的路由
     */
    private void initDefaultRouter() {
        //目前添加了一条Activity对应的规则
        addRule(ActivityRule.ACTIVITY_SCHEME, new ActivityRule());
    }

    /**
     * 对外开放，可以后续自定义添加路由规则
     *
     * @param scheme 路由类型（Activity,Service...）
     * @param rule   路由规则
     * @return Router 真是调用的类
     */
    public final RouterInternal addRule(String scheme, Rule rule) {
        mRuleMap.put(scheme, rule);
        return this;
    }

    /**
     * 获取规则
     *
     * @param pattern
     * @return
     */
    private <T, V> Rule<T, V> getRule(String pattern) {
        HashMap<String, Rule> ruleMap = mRuleMap;
        Set<String> keySet = ruleMap.keySet();
        Rule<T, V> rule = null;
        for (String scheme : keySet) {
            if (pattern.startsWith(scheme)) {
                rule = ruleMap.get(scheme);
                break;
            }
        }

        return rule;
    }

    /**
     * 添加路由
     *
     * @param pattern 路由Uri
     * @param tClass  路由Class
     * @param <T>
     * @return Router真是调用类
     */
    public final <T> RouterInternal router(String pattern, Class<T> tClass) {
        Rule<T, ?> rule = getRule(pattern);
        if (rule == null) {
            throw new NotRouteException("unknown", pattern);
        }

        rule.router(pattern, tClass);
        return this;
    }

    final <V> V invoke(Context context, String pattern) {
        Rule<?, V> rule = getRule(pattern);
        if (rule == null) {
            throw new NotRouteException("unknown", pattern);
        }
        return rule.invoke(context, pattern);
    }
}
