package com.example.bulingzhuang.routintentdemo;

import android.app.Application;

import com.example.router.Router;
import com.example.router.rule.ActivityRule;
import com.example.shopmod.ShopActivity;

/**
 * Created by bulingzhuang
 * on 2016/12/20
 * E-mail:bulingzhuang@foxmail.com
 */

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        registerRouter();
    }

    private void registerRouter() {
        Router.router(ActivityRule.ACTIVITY_SCHEME+"shop.main", ShopActivity.class);
    }
}
