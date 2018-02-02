package com.demo.example.ecommertialapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class VariantsVO implements Parcelable
{
    @SerializedName("id")
    public String variantId;

    @SerializedName("color")
    public String variantColor;

    @SerializedName("size")
    public String variantSize;


    @SerializedName("price")
    public String variantPrice;


    public String getVariantId()
    {
        return variantId;
    }

    public String getVariantColor()
    {
        return variantColor;
    }

    public String getVariantSize()
    {
        return variantSize;
    }

    public String getVariantPrice()
    {
        return variantPrice;
    }


    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.variantId);
        dest.writeString(this.variantColor);
        dest.writeString(this.variantSize);
        dest.writeString(this.variantPrice);
    }


    private VariantsVO(Parcel in)
    {
        this.variantId = in.readString();
        this.variantColor = in.readString();
        this.variantSize = in.readString();
        this.variantPrice = in.readString();
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
