package com.mvvn.vitaliy.sometask.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.mvvn.vitaliy.sometask.presentation.base.DealerAppViewModelFactory;
import com.mvvn.vitaliy.sometask.presentation.main.MainNavigationActivityViewModel;
import com.mvvn.vitaliy.sometask.presentation.main.SettingsActivityViewModel;
import com.mvvn.vitaliy.sometask.presentation.main.authorization.SplashActivityViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;



@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashActivityViewModel.class)
    abstract ViewModel bindSplashActivityViewModel(SplashActivityViewModel splashActivityViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MainNavigationActivityViewModel.class)
    abstract ViewModel bindMainNavigationActivityViewModel(MainNavigationActivityViewModel mainNavigationActivityViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(SettingsActivityViewModel.class)
    abstract ViewModel bindSettingsActivityViewModel(SettingsActivityViewModel settingsActivityViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(DealerAppViewModelFactory viewModelFactory);
}
