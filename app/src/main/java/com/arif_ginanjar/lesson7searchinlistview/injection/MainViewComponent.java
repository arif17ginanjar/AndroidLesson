package com.arif_ginanjar.lesson7searchinlistview.injection;

import com.arif_ginanjar.lesson7searchinlistview.view.impl.MainActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = MainViewModule.class)
public interface MainViewComponent {
    void inject(MainActivity activity);
}