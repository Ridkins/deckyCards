package com.mvvn.vitaliy.sometask.presentation.main;

import android.support.v4.app.FragmentActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rud on 1/11/18.
 */

@Module
public class SettingsActivityModule {

    @Provides
    FragmentActivity provideActivity(SettingsActivity activity) {
        return activity;
    }


}
