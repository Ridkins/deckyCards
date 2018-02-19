package com.mvvn.vitaliy.sometask.presentation.base;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mvvn.vitaliy.sometask.BR;

import javax.inject.Inject;




public class MvvmActivity<B extends ViewDataBinding, V extends ViewModel> extends AppCompatActivity {

    @Inject Class<V> viewModelClass;

    protected B binding;
    protected V viewModel;


    @Inject ViewModelProvider.Factory viewModelFactory;


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected final View setAndBindContentView(@NonNull Activity activity, @Nullable Bundle savedInstanceState, @LayoutRes int layoutResID) {
        setContentView(layoutResID);
        binding = DataBindingUtil.setContentView(this ,layoutResID);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass);
        binding.setVariable(BR.vm, viewModel);
        return binding.getRoot();
    }
}
