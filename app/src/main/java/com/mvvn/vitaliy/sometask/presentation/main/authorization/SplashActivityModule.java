package com.mvvn.vitaliy.sometask.presentation.main.authorization;

import android.support.v4.app.FragmentActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rud on 12.12.2017.
 */

@Module
public class SplashActivityModule {

    @Provides
    FragmentActivity provideActivity(SplashActivity activity) {
        return activity;
    }


}
