package com.example.bulingzhuang.routintentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.router.Router;
import com.example.router.rule.ActivityRule;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void btnIntent2Shop(View view) {
        Intent intent = Router.invoke(this, ActivityRule.ACTIVITY_SCHEME+"shop.main");
        startActivity(intent);
    }
}
