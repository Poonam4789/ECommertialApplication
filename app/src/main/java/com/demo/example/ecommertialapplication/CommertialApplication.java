package com.demo.example.ecommertialapplication;

import android.app.Application;
import android.content.Context;

import com.demo.example.ecommertialapplication.network.NetworkChangeReceiver;
import com.demo.example.ecommertialapplication.network.RestApiClient;
import com.demo.example.ecommertialapplication.network.RestApiInterface;

public class CommertialApplication extends Application
{
    private static CommertialApplication _commertialApplication;
    private static RestApiInterface _restApiClientInterface;
    public static final String DEVELOPMENT_BUILD = "development", PRODUCTION_BUILD = "production";

    public static CommertialApplication getApplicationInstance()
    {
        return _commertialApplication;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        _commertialApplication = this;
        _restApiClientInterface = RestApiClient.getRestInstance().getRetrofitApiInstance();
        NetworkChangeReceiver.initNetworkChange(getApplicationContext());
    }

    public static RestApiInterface getRestApiClientInterface()
    {
        if (_restApiClientInterface == null)
        {
            return _restApiClientInterface = RestApiClient.getRestInstance().getRetrofitApiInstance();
        }
        return _restApiClientInterface;
    }

    public Context getApplicationContext()
    {
        return this;
    }
}
