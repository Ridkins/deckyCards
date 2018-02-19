package com.mvvn.vitaliy.sometask.presentation.main;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.mvvn.vitaliy.sometask.R;
import com.mvvn.vitaliy.sometask.databinding.SettingsBinding;
import com.mvvn.vitaliy.sometask.presentation.base.ActivityNavigator;
import com.mvvn.vitaliy.sometask.presentation.base.MvvmActivity;

import javax.inject.Inject;

/**
 * Created by Rud on 1/11/18.
 */

public class SettingsActivity extends MvvmActivity<SettingsBinding, SettingsActivityViewModel>
       implements View.OnClickListener {

    @Inject
    ActivityNavigator activityNavigator;

    public final static String OVERLAY ="overlay";
    public final static String ELEVATION ="elevation";
    public final static String MAXCOUNT ="maxcount";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAndBindContentView(this, savedInstanceState, R.layout.settings);
        binding.btnSave.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save:
                Bundle bundle = new Bundle();
                bundle.putString(OVERLAY, !binding.overlay.getText().toString().equals("")?binding.overlay.getText().toString():"0");
                bundle.putString(ELEVATION, !binding.elevation.getText().toString().equals("")?binding.elevation.getText().toString():"0");
                bundle.putString(MAXCOUNT,  !binding.maxCount.getText().toString().equals("")?binding.maxCount.getText().toString():"100");
                Intent intent = new Intent(getApplicationContext(), MainNavigationActivity.class);
                intent.putExtras(bundle);
                activityNavigator.startActivity(intent);
                finish();
                break;
        }
    }

}