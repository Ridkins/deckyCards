package com.mvvn.vitaliy.sometask.di;

import android.app.Application;

import com.mvvn.vitaliy.sometask.DeckyApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;



@Singleton
@Component(modules = {AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuildersModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application app);
        AppComponent build();
    }

    void inject(DeckyApp deckyApp);
}
