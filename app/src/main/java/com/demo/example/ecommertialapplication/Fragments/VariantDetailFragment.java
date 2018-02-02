package com.demo.example.ecommertialapplication.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.demo.example.ecommertialapplication.R;
import com.demo.example.ecommertialapplication.model.VariantsVO;

import java.util.ArrayList;

public class VariantDetailFragment extends DialogFragment
{
    private final String TAG = "VariantDetailFragment";
    public static final String PROCUCT_NAME = "product_name";
    public static final String POSITION = "position";
    View view;
    int _position = 0;
    public Toolbar _dialogToolbar;
    private TextView _toolbarTextView;
    private TextView _dialogDismissCross;
    private ArrayList<VariantsVO> _variantList;
    private String _dialogTitle;
    private TextView _variant_id, _variant_color, _variant_size, _variant_price;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.variant_item_dialog, null, false);

        _dialogDismissCross = (TextView) view.findViewById(R.id.dialog_dismiss_cross);
        _dialogToolbar = (Toolbar) view.findViewById(R.id.dialog_toolbar);
        _toolbarTextView = (TextView) view.findViewById(R.id.toolbar_title);

        _variant_id = view.findViewById(R.id.variant_id);
        _variant_color = view.findViewById(R.id.variant_color);
        _variant_size = view.findViewById(R.id.variant_size);
        _variant_price = view.findViewById(R.id.variant_price);


        if (_dialogDismissCross != null)
        {
            _dialogDismissCross.setVisibility(View.VISIBLE);
            _dialogDismissCross.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    dismiss();
                }
            });
        }
        _variantList = getArguments().getParcelableArrayList(ProductsCoverFragment.VARIANT_LIST);
        _dialogTitle = getArguments().getString(PROCUCT_NAME);
        _position = getArguments().getInt(POSITION);
        Log.d(TAG, "no of Products" + _variantList.size());
        return view;
    }

    private void setVariantData()
    {
        setToolbarTitle(_dialogTitle);
        _variant_id.setText("Id : " + _variantList.get(_position).variantId);
        _variant_color.setText("Color : " + _variantList.get(_position).variantColor);
        _variant_size.setText("Size : " + _variantList.get(_position).variantSize);
        _variant_price.setText("Price : " + _variantList.get(_position).variantPrice);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onViewCreated(view, savedInstanceState);
        setVariantData();
    }

    @Override
    public void onStart()
    {
        super.onStart();
        int height = getResources().getDimensionPixelSize(R.dimen.dialog_fragment_height);
        int width = getResources().getDimensionPixelSize(R.dimen.dialog_fragment_width);
        getDialog().getWindow().setLayout(width, height);
    }

    public void setToolbarTitle(String title)
    {
        if (_toolbarTextView != null)
        {
            _toolbarTextView.setText(title);
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog)
    {
        super.onDismiss(dialog);
        if (getActivity() instanceof DialogInterface.OnDismissListener)
        {
            ((DialogInterface.OnDismissListener) getActivity()).onDismiss(dialog);
        }
    }
}
