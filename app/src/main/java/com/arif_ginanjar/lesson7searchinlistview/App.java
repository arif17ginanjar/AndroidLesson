package com.arif_ginanjar.lesson7searchinlistview;

import android.app.Application;
import android.support.annotation.NonNull;

import com.arif_ginanjar.lesson7searchinlistview.injection.AppComponent;
import com.arif_ginanjar.lesson7searchinlistview.injection.AppModule;
import com.arif_ginanjar.lesson7searchinlistview.injection.DaggerAppComponent;

public final class App extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    @NonNull
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}