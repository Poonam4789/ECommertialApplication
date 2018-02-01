package com.demo.example.ecommertialapplication.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.demo.example.ecommertialapplication.Fragments.ProductsCoverFragment;
import com.demo.example.ecommertialapplication.model.CategoriesVO;

import java.util.List;

public class CategoryPagerAdapter extends FragmentStatePagerAdapter
{
    private List<CategoriesVO> _articleCategoryList;

    public CategoryPagerAdapter(FragmentManager fm, List<CategoriesVO> articleCategoryList,Bundle bundle)
    {
        super(fm);
        _articleCategoryList = articleCategoryList;
    }

    @Override
    public Fragment getItem(int position)
    {
        ProductsCoverFragment pageFragment = new ProductsCoverFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(ProductsCoverFragment.PRODUCT_LIST,_articleCategoryList.get(position)._products);
        pageFragment.setArguments(bundle);
        return pageFragment;
    }

    @Override
    public int getCount()
    {
        return _articleCategoryList.size();
    }
    @Override
    public CharSequence getPageTitle(int position)
    {
        return _articleCategoryList.get(position)._categoryName;
    }
}
