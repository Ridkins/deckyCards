package com.mvvn.vitaliy.sometask.presentation.main;


import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.mvvn.vitaliy.sometask.R;
import com.mvvn.vitaliy.sometask.databinding.MainNavigationActivityLayoutBinding;
import com.mvvn.vitaliy.sometask.presentation.base.ActivityNavigator;
import com.mvvn.vitaliy.sometask.presentation.base.MvvmActivity;
import com.mvvn.vitaliy.sometask.presentation.main.decky_cards.SlidingDeckAdapter;
import com.mvvn.vitaliy.sometask.presentation.main.decky_cards.SlidingDeckModel;

import javax.inject.Inject;

import static com.mvvn.vitaliy.sometask.presentation.main.SettingsActivity.ELEVATION;
import static com.mvvn.vitaliy.sometask.presentation.main.SettingsActivity.MAXCOUNT;
import static com.mvvn.vitaliy.sometask.presentation.main.SettingsActivity.OVERLAY;



public class MainNavigationActivity extends MvvmActivity<MainNavigationActivityLayoutBinding, MainNavigationActivityViewModel>
        implements  View.OnClickListener {

    @Inject
    ActivityNavigator activityNavigator;
    private SlidingDeckAdapter slidingAdapter;
    private int itemCount = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAndBindContentView(this, savedInstanceState, R.layout.main_navigation_activity_layout);
        binding.btnSettings.setOnClickListener(this);
        binding.btnAdd.setOnClickListener(this);
        binding.btnRemove.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
       getBundle();
        if(!viewModel.isExpanded()){
            binding.slidingDeck.performReleaseTouch();
        }else{
            binding.slidingDeck.performVerticalSwipe();
        }


    }

    private void getBundle(){
        Bundle mBundle = this.getIntent().getExtras();
        if (mBundle != null) {
            itemCount =Integer.valueOf(mBundle.getString(MAXCOUNT));
            binding.slidingDeck.setMaximumViewsOnScreen(Integer.valueOf(mBundle.getString(MAXCOUNT))+ 10);
            binding.slidingDeck.setItemsMarginTop(Integer.valueOf(mBundle.getString(OVERLAY)));
            initializeSlidingDeck(Integer.valueOf(mBundle.getString(ELEVATION)));
        }else {
            binding.slidingDeck.setMaximumViewsOnScreen(10);
            binding.slidingDeck.setItemsMarginTop(30);
            initializeSlidingDeck(6);
        }


    }

    private void initializeSlidingDeck(int elevation) {

        slidingAdapter = new SlidingDeckAdapter(this,elevation);
        for (int i = 0; i < itemCount; i++) {
            slidingAdapter.add(new SlidingDeckModel());
        }
        binding.slidingDeck.setAdapter(slidingAdapter);
    }


    @Override
    public void onDestroy() {
        viewModel.setExpanded(binding.slidingDeck.isExpanded());
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                slidingAdapter.add(new SlidingDeckModel());
                slidingAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_settings:
                activityNavigator.startActivity(SettingsActivity.class);
                break;
            case R.id.btn_remove:
                if (slidingAdapter.getCount() != 0) {
                    slidingAdapter.remove(slidingAdapter.getItem(0));
                    slidingAdapter.notifyDataSetChanged();
                }
                break;
        }
    }

}