package com.mvvn.vitaliy.sometask.presentation.base;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import com.mvvn.vitaliy.sometask.utils.PlainConsumer;

import javax.inject.Inject;




public class ActivityNavigator implements Navigator {

    public static final String FRAGMENT_TAG = "content";

    private final FragmentActivity activity;

    @Inject
    public ActivityNavigator(FragmentActivity activity) {
        this.activity = activity;
    }


    @Override
    public void finishActivity() {
        activity.finish();
    }

    public FragmentActivity getActivity() {
        return activity;
    }


    @Override
    public final void startActivity(@NonNull Intent intent) {
        activity.startActivity(intent);
    }



    @Override
    public final void startActivity(@NonNull Class<? extends Activity> activityClass) {
        startActivityInternal(activityClass, null, null);
    }

    private void startActivityInternal(Class<? extends Activity> activityClass, PlainConsumer<Intent> setArgsAction, Integer requestCode) {
        Intent intent = new Intent(activity, activityClass);
        if (setArgsAction != null) {
            setArgsAction.accept(intent);
        }

        if (requestCode != null) {
            activity.startActivityForResult(intent, requestCode);
        } else {
            activity.startActivity(intent);
        }
    }




}
