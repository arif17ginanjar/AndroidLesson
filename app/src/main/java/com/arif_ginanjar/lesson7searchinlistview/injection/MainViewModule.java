package com.arif_ginanjar.lesson7searchinlistview.injection;

import android.support.annotation.NonNull;

import com.arif_ginanjar.lesson7searchinlistview.interactor.MainInteractor;
import com.arif_ginanjar.lesson7searchinlistview.interactor.impl.MainInteractorImpl;
import com.arif_ginanjar.lesson7searchinlistview.presenter.loader.PresenterFactory;
import com.arif_ginanjar.lesson7searchinlistview.presenter.MainPresenter;
import com.arif_ginanjar.lesson7searchinlistview.presenter.impl.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public final class MainViewModule {
    @Provides
    public MainInteractor provideInteractor() {
        return new MainInteractorImpl();
    }

    @Provides
    public PresenterFactory<MainPresenter> providePresenterFactory(@NonNull final MainInteractor interactor) {
        return new PresenterFactory<MainPresenter>() {
            @NonNull
            @Override
            public MainPresenter create() {
                return new MainPresenterImpl(interactor);
            }
        };
    }
}
