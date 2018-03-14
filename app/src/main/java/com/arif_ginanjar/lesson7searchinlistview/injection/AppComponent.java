package com.arif_ginanjar.lesson7searchinlistview.injection;

import android.content.Context;

import com.arif_ginanjar.lesson7searchinlistview.App;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Context getAppContext();

    App getApp();
}