package com.arif_ginanjar.lesson7searchinlistview.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.arif_ginanjar.lesson7searchinlistview.R;
import com.arif_ginanjar.lesson7searchinlistview.view.MainView;
import com.arif_ginanjar.lesson7searchinlistview.presenter.loader.PresenterFactory;
import com.arif_ginanjar.lesson7searchinlistview.presenter.MainPresenter;
import com.arif_ginanjar.lesson7searchinlistview.injection.AppComponent;
import com.arif_ginanjar.lesson7searchinlistview.injection.MainViewModule;
import com.arif_ginanjar.lesson7searchinlistview.injection.DaggerMainViewComponent;

import java.util.ArrayList;
import java.util.Locale;

import javax.inject.Inject;

public final class MainActivity extends BaseActivity<MainPresenter, MainView> implements MainView, SearchView.OnQueryTextListener {
    @Inject
    PresenterFactory<MainPresenter> mPresenterFactory;

    ListView activity_main_lv_listdata;
    SearchView activity_main_sv_cari;
    ArrayList<String> countries;
    ArrayAdapter<String> adapter;


    // Your presenter is available using the mPresenter variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("SearchView");
        getSupportActionBar().setSubtitle("in ListView");

        // Your code here
        // Do not call mPresenter from here, it will be null! Wait for onStart or onPostCreate.
        activity_main_lv_listdata =(ListView)findViewById(R.id.activity_main_lv_listdata);
        activity_main_sv_cari = (SearchView)findViewById(R.id.activity_main_sv_cari);

        String[] locales = Locale.getISOCountries();
        countries = new ArrayList<String>();

        for (String countryCode : locales){
            Locale objectCountry = new Locale("", countryCode);
            countries.add(objectCountry.getDisplayCountry());
        }

        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.country_list, R.id.country_list_name, countries);

        activity_main_lv_listdata.setAdapter(adapter);

        activity_main_sv_cari.setOnQueryTextListener(this);
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerMainViewComponent.builder()
                .appComponent(parentComponent)
                .mainViewModule(new MainViewModule())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    protected PresenterFactory<MainPresenter> getPresenterFactory() {
        return mPresenterFactory;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
    }
}
