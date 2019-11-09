package com.nuriefeoglu.mbuproject.base;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.nuriefeoglu.mbuproject.R;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements IView {


    public Unbinder unbinder;
    @BindView(R.id.incHeader)
    View includeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutRes());
        unbinder = ButterKnife.bind(this);
        setupHeader();
        viewDidLoad();
    }


    static class HeaderLayout {
        @BindView(R.id.txtHeader)
        TextView txtHeader;
        @BindView(R.id.btnHeaderBack)
        MaterialButton btnBack;
    }

    @Override
    public void setupHeader() {
        HeaderLayout headerLayout = new HeaderLayout();
        ButterKnife.bind(headerLayout, includeLayout);
        headerLayout.txtHeader.setText(setHeaderText());
        headerLayout.btnBack.setOnClickListener(v -> onBackPressed());
    }

    protected abstract void viewDidLoad();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }


    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public String getStringResource(@StringRes int resId) {
        return getResources().getString(resId);
    }

    @LayoutRes
    protected abstract int layoutRes();

}
