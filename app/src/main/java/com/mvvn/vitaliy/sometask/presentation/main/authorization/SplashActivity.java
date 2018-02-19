package com.mvvn.vitaliy.sometask.presentation.main.authorization;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

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