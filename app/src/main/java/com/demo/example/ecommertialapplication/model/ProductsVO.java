package com.demo.example.ecommertialapplication.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductsVO implements Parcelable
{
    @SerializedName("id")
    public String productId;

    @SerializedName("name")
    public String productName;


    @SerializedName("date_added")
    public String productAddedDate;

    @SerializedName("variants")
    public ArrayList<VariantsVO> variants;

    @SerializedName("tax")
    public TaxVO tax;

    public String getProductId()
    {
        return productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public String getProductAddedDate()
    {
        return productAddedDate;
    }

    public ArrayList<VariantsVO> getVariants()
    {
        return variants;
    }

    public TaxVO getTax()
    {
        return tax;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.productId);
        dest.writeString(this.productName);
        dest.writeString(this.productAddedDate);
        dest.writeTypedList(this.variants);
        dest.writeTypedObject(this.tax, flags);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private ProductsVO(Parcel in)
    {
        this.productId = in.readString();
        this.productName = in.readString();
        this.productAddedDate = in.readString();
        variants = new ArrayList<>();
        in.readTypedList(variants, VariantsVO.CREATOR);
        this.tax = new TaxVO();
        in.readTypedObject(TaxVO.CREATOR);
    }

    public ProductsVO()
    {

    }

    public static final Creator<ProductsVO> CREATOR = new Creator<ProductsVO>()
    {
        @RequiresApi(api = Build.VERSION_CODES.M)
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
