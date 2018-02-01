package com.demo.example.ecommertialapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ProductsVO implements Parcelable
{
    @SerializedName("id")
    public String _productId;

    @SerializedName("name")
    public String _productName;


    @SerializedName("date_added")
    public String _productAddedDate;


    public String getProductId()
    {
        return _productId;
    }

    public String getProductName()
    {
        return _productName;
    }

    public String getProductAddedDate()
    {
        return _productAddedDate;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this._productId);
        dest.writeString(this._productName);
        dest.writeString(this._productAddedDate);
    }


    private ProductsVO(Parcel in)
    {
        this._productId = in.readString();
        this._productName = in.readString();
        this._productAddedDate = in.readString();
    }

    public ProductsVO()
    {

    }

    public static final Creator<ProductsVO> CREATOR = new Creator<ProductsVO>()
    {
        public ProductsVO createFromParcel(Parcel source)
        {
            return new ProductsVO(source);
        }

        public ProductsVO[] newArray(int size)
        {
            return new ProductsVO[size];
        }
    };
}
