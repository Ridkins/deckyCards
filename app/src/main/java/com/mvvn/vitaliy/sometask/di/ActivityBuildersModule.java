package com.mvvn.vitaliy.sometask.di;

import com.mvvn.vitaliy.sometask.presentation.main.MainNavigationActivity;
import com.mvvn.vitaliy.sometask.presentation.main.MainNavigationActivityModule;
import com.mvvn.vitaliy.sometask.presentation.main.SettingsActivity;
import com.mvvn.vitaliy.sometask.presentation.main.SettingsActivityModule;
import com.mvvn.vitaliy.sometask.presentation.main.authorization.SplashActivity;
import com.mvvn.vitaliy.sometask.presentation.main.authorization.SplashActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {MainNavigationActivityModule.class})
    abstract MainNavigationActivity contributeMainNavigationActivity();

    @ContributesAndroidInjector(modules = {SplashActivityModule.class})
    abstract SplashActivity contributeSplashActivity();

    @ContributesAndroidInjector(modules = {SettingsActivityModule.class})
    abstract SettingsActivity contributeSettingsActivity();



}
