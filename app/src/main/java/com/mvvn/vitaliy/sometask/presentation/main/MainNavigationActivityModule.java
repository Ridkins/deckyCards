package com.mvvn.vitaliy.sometask.presentation.main;

import android.support.v4.app.FragmentActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rud on 1/11/18.
 */

@Module
public class MainNavigationActivityModule {

    @Provides
    FragmentActivity provideActivity(MainNavigationActivity activity) {
        return activity;
    }



}
