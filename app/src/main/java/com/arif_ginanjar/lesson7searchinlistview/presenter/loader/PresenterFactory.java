package com.arif_ginanjar.lesson7searchinlistview.presenter.loader;

import android.support.annotation.NonNull;

import com.arif_ginanjar.lesson7searchinlistview.presenter.BasePresenter;

/**
 * Factory to implement to create a presenter
 */
public interface PresenterFactory<T extends BasePresenter> {
    @NonNull
    T create();
}
