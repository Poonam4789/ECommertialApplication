package com.demo.example.ecommertialapplication;

import com.demo.example.ecommertialapplication.model.CategoriesVO;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CommercialProductsResponse implements Serializable
{
    @SerializedName("categories")
    private List<CategoriesVO> _categories;

    public List<CategoriesVO> getCategoriesList()
    {
        return _categories;
    }
}
