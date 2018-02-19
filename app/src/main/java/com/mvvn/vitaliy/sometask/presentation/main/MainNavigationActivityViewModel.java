package com.mvvn.vitaliy.sometask.presentation.main;


import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;



public class MainNavigationActivityViewModel extends ViewModel {

    private boolean isExpanded =false;

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    @Inject
    public MainNavigationActivityViewModel() {
    }

}
