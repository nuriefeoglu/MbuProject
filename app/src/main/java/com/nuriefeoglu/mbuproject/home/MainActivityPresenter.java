package com.nuriefeoglu.mbuproject.home;

import android.content.Context;
import android.content.Intent;

import com.nuriefeoglu.mbuproject.base.BaseActivity;

class MainActivityPresenter {

    private Context context;
    private MainActivityView view;

    MainActivityPresenter(Context context, MainActivityView view) {
        this.context = context;
        this.view = view;
    }

    void navigate(Class<? extends BaseActivity> routeActivity) {
        try {

            Intent intent = new Intent(context, routeActivity);
            view.navigate(intent);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public interface MainActivityView {

        void navigate(Intent intent);

    }


}
