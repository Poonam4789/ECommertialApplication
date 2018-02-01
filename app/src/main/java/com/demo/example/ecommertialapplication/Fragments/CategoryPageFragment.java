package com.demo.example.ecommertialapplication.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.example.ecommertialapplication.CommercialProductsResponse;
import com.demo.example.ecommertialapplication.CommertialApplication;
import com.demo.example.ecommertialapplication.R;
import com.demo.example.ecommertialapplication.adapters.CategoryPagerAdapter;
import com.demo.example.ecommertialapplication.appBase.CommertialMainActivity;
import com.demo.example.ecommertialapplication.model.CategoriesVO;
import com.demo.example.ecommertialapplication.network.RestApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.demo.example.ecommertialapplication.network.NetworkStatus.STATUS_LOADING;

public class CategoryPageFragment extends Fragment
{
    private static final String TAG = "RESPONSE";
    TabLayout _categoryTabs;
    ViewPager _productsPager;
    CategoryPagerAdapter _categoryPagerAdapter;
    List<CategoriesVO> _categoriesVOList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.category_page_layout, container, false);
        _categoryTabs = view.findViewById(R.id.categories_tabs);
        _productsPager = view.findViewById(R.id.product_pager);
        _categoryTabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        CallWebservice();
        return view;
    }


    private void CallWebservice()
    {
        CommertialMainActivity commertialMainActivity = new CommertialMainActivity();
        commertialMainActivity.showHideProgress(STATUS_LOADING);
        RestApiInterface restApiService = CommertialApplication.getRestApiClientInterface();
        Call<CommercialProductsResponse> call = restApiService.getCommercialProducts();
        call.enqueue(new Callback<CommercialProductsResponse>()
        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onResponse(Call<CommercialProductsResponse> call, Response<CommercialProductsResponse> response)
            {
                if (response.isSuccessful())
                {
                    Log.d(TAG, "Got the body for the file");
                    _categoriesVOList = response.body().getCategoriesList();
                    if (_categoriesVOList != null)
                    {
                        SetTabPagerAdapters(_categoriesVOList);
                        Log.d(TAG, "Response " + response.body().toString());
                        Log.d(TAG, "CategoryList " + response.body().getCategoriesList().get(0)._categoryName);
                    }
                }
                else
                {
                    Log.d(TAG, "Connection failed " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<CommercialProductsResponse> call, Throwable t)
            {
                Log.d("RESPONSE", "Exception " + t.toString());
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void SetTabPagerAdapters(List<CategoriesVO> categoriesList)
    {
        _categoryPagerAdapter = new CategoryPagerAdapter(getChildFragmentManager(), categoriesList, getArguments());
        _categoryTabs.setupWithViewPager(_productsPager);
        _productsPager.setAdapter(_categoryPagerAdapter);
        _productsPager.setCurrentItem(0);
        _productsPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
        {
            @Override
            public void onPageSelected(int position)
            {
                super.onPageSelected(position);
                Log.d(TAG, "PageSelected" + _productsPager.getCurrentItem());
            }

        });
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        _productsPager = null;
        _categoryPagerAdapter = null;
    }
}
