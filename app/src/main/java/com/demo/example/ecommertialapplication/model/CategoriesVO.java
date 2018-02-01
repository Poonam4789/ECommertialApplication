package com.demo.example.ecommertialapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CategoriesVO implements Parcelable
{
    @SerializedName("id")
    public String _categoryId;

    @SerializedName("name")
    public String _categoryName;

    @SerializedName("products")
    public ArrayList<ProductsVO> _products;

    @SerializedName("variants")
    public ArrayList<VariantsVO> _variants;

    public String getCategoryId()
    {
        return _categoryId;
    }

    public String getCategoryName()
    {
        return _categoryName;
    }

    public ArrayList<ProductsVO> getProducts()
    {
        return _products;
    }

    public ArrayList<VariantsVO> getVariants()
    {
        return _variants;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this._categoryId);
        dest.writeString(this._categoryName);
        dest.writeTypedList(this._products);
        dest.writeTypedList(this._variants);
    }

    private CategoriesVO(Parcel in)
    {
        this._categoryId = in.readString();
        this._categoryName = in.readString();

        _products = new ArrayList<>();
        in.readTypedList(_products, ProductsVO.CREATOR);

        _variants = new ArrayList<>();
        in.readTypedList(_variants, VariantsVO.CREATOR);
    }

    public CategoriesVO()
    {
    }

    public static final Creator<CategoriesVO> CREATOR = new Creator<CategoriesVO>()
    {
        public CategoriesVO createFromParcel(Parcel source)
        {
            return new CategoriesVO(source);
        }

        public CategoriesVO[] newArray(int size)
        {
            return new CategoriesVO[size];
        }
    };
}
