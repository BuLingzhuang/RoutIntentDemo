package com.example.router.exception;

import java.util.Locale;

/**
 * Created by bulingzhuang
 * on 2016/12/19
 * E-mail:bulingzhuang@foxmail.com
 */

public class NotRouteException extends RuntimeException {

    public NotRouteException(String name, String pattern) {
        super(String.format(Locale.CHINESE, "类型：%s，对应%s的页面找不到", name, pattern));
    }
}
