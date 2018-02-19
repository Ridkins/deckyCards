package com.mvvn.vitaliy.sometask.presentation.base;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;



public interface Navigator {

    String EXTRA_ARG = "_args";
    String BACKSTACK_TAG = "_backstackTag";

    void finishActivity();
    void startActivity(@NonNull Intent intent);
    void startActivity(@NonNull Class<? extends Activity> activityClass);






}
