package com.example.router.exception;

/**
 * Created by bulingzhuang
 * on 2016/12/19
 * E-mail:bulingzhuang@foxmail.com
 */

public class ActivityNotRouteException extends NotRouteException {
    public ActivityNotRouteException(String pattern) {
        super("Activity", pattern);
    }
}
