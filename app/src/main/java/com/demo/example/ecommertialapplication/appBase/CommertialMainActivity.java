package com.demo.example.ecommertialapplication.appBase;

import android.os.Bundle;

import com.demo.example.ecommertialapplication.Fragments.CategoryPageFragment;
import com.demo.example.ecommertialapplication.R;
import com.demo.example.ecommertialapplication.network.NetworkStatus;


public class CommertialMainActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commertial_main);
        CategoryPageFragment pagerFragment = new CategoryPageFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contentlayout, pagerFragment, "CategoryPager").commit();
    }

    @Override
    protected void onNetworkChange(boolean isNetworkConnected)
    {
        showNoNetworkBar(isNetworkConnected);
    }
}
