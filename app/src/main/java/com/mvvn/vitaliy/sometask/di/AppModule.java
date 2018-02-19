package com.mvvn.vitaliy.sometask.di;

import android.app.Application;
import android.content.res.Resources;

import com.mvvn.vitaliy.sometask.presentation.main.MainNavigationActivityViewModel;
import com.mvvn.vitaliy.sometask.presentation.main.SettingsActivityViewModel;
import com.mvvn.vitaliy.sometask.presentation.main.authorization.SplashActivityViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;



@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    Resources provideResources(Application application) {
        return application.getResources();
    }


    @Provides
    Class<SplashActivityViewModel> provideSplashActivityViewModelClass() {
        return SplashActivityViewModel.class;
    }

    @Provides
    Class<MainNavigationActivityViewModel> provideMainNavigationActivityViewModelClass() {
        return MainNavigationActivityViewModel.class;
    }

    @Provides
    Class<SettingsActivityViewModel> provideSettingsActivityViewModelClass(){
        return SettingsActivityViewModel.class;
    }


}
