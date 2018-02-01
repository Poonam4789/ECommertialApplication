package com.demo.example.ecommertialapplication.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.example.ecommertialapplication.R;
import com.demo.example.ecommertialapplication.model.ProductsVO;

import java.util.ArrayList;

public class ProductPageAdapter extends RecyclerView.Adapter<ProductPageAdapter.ViewHolder>//RecyclerView.Adapter<AbsArticleHolder>
{
    private ArrayList<ProductsVO> _productsList;

    public ProductPageAdapter(ArrayList<ProductsVO> list)
    {
        _productsList = list;
    }

    @Override
    public ProductPageAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_view_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductPageAdapter.ViewHolder holder, int position)
    {
        holder._productId.setText(_productsList.get(position).getProductId());
        holder._productName.setText(_productsList.get(position).getProductName());
        holder._productAddDate.setText(_productsList.get(position).getProductAddedDate());

        holder._productName.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView _productId, _productName, _productAddDate;

        public ViewHolder(View view)
        {
            super(view);

            _productId = (TextView) view.findViewById(R.id.product_Id);
            _productName = (TextView) view.findViewById(R.id.product_name);
            _productAddDate = (TextView) view.findViewById(R.id.product_add_date);

        }
    }

    @Override
    public int getItemCount()
    {
        return _productsList.size();
    }

}
