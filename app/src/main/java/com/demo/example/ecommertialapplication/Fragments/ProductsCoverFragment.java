package com.demo.example.ecommertialapplication.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.demo.example.ecommertialapplication.R;
import com.demo.example.ecommertialapplication.adapters.ProductPageAdapter;
import com.demo.example.ecommertialapplication.model.ProductsVO;

import java.util.ArrayList;

public class ProductsCoverFragment extends Fragment
{
    private final String TAG = "ProductCoverFragment";
    public static final String PRODUCT_LIST = "product_list";

    RecyclerView _productCoversListView;
    private ArrayList<ProductsVO> _productList;
    private ProductPageAdapter _productPageAdapter;
    private ProgressBar _progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.page_cover_layout, container, false);

        _progressBar = (ProgressBar) view.findViewById(R.id.page_progress);
        _productCoversListView = (RecyclerView) view.findViewById(R.id.product_view);

        _productCoversListView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        _productCoversListView.setItemAnimator(null);

        _productList = getArguments().getParcelableArrayList(PRODUCT_LIST);
        Log.d(TAG, "no of Products" + _productList.size());

        setProductAdapter();
        return view;
    }

    private void setProductAdapter()
    {
        _productPageAdapter = new ProductPageAdapter(_productList);
        _productCoversListView.setAdapter(_productPageAdapter);
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        _progressBar = null;
        _productCoversListView = null;
        _productPageAdapter = null;
    }

}
