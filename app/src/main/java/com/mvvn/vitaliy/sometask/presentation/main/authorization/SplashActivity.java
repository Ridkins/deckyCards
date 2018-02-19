package com.mvvn.vitaliy.sometask.presentation.main.authorization;

import android.os.Bundle;
import android.os.Handler;

import com.mvvn.vitaliy.sometask.R;
import com.mvvn.vitaliy.sometask.databinding.SplashScreenActivityBinding;
import com.mvvn.vitaliy.sometask.presentation.base.ActivityNavigator;
import com.mvvn.vitaliy.sometask.presentation.base.MvvmActivity;
import com.mvvn.vitaliy.sometask.presentation.main.MainNavigationActivity;

import javax.inject.Inject;

public class SplashActivity extends MvvmActivity<SplashScreenActivityBinding, SplashActivityViewModel> {

    @Inject
    ActivityNavigator activityNavigator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAndBindContentView(this, savedInstanceState, R.layout.splash_screen_activity);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startLoginScreen();
            }
        }, 1000);

    }

    private void startLoginScreen() {
        activityNavigator.startActivity(MainNavigationActivity.class);
        activityNavigator.finishActivity();
    }


}