package com.demo.example.ecommertialapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class VariantsVO implements Parcelable
{
    @SerializedName("id")
    public String _variantId;

    @SerializedName("color")
    public String _variantColor;

    @SerializedName("size")
    public String _variantSize;


    @SerializedName("price")
    public String _variantPrice;


    public String getVariantId()
    {
        return _variantId;
    }

    public String getVariantColor()
    {
        return _variantColor;
    }

    public String getVariantSize()
    {
        return _variantSize;
    }

    public String getVariantPrice()
    {
        return _variantPrice;
    }


    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this._variantId);
        dest.writeString(this._variantColor);
        dest.writeString(this._variantSize);
        dest.writeString(this._variantPrice);
    }


    private VariantsVO(Parcel in)
    {
        this._variantId = in.readString();
        this._variantColor = in.readString();
        this._variantSize = in.readString();
        this._variantPrice = in.readString();
    }

    public VariantsVO()
    {

    }

    public static final Creator<VariantsVO> CREATOR = new Creator<VariantsVO>()
    {
        public VariantsVO createFromParcel(Parcel source)
        {
            return new VariantsVO(source);
        }

        public VariantsVO[] newArray(int size)
        {
            return new VariantsVO[size];
        }
    };
}
