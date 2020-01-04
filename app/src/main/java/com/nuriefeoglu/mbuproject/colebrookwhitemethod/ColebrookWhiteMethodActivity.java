package com.nuriefeoglu.mbuproject.colebrookwhitemethod;

import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;

import butterknife.BindView;

public class ColebrookWhiteMethodActivity extends BaseActivity implements ColebrookWhiteMethodPresenter.IView {

    @BindView(R.id.edt_epsilon_degeri)
    TextInputEditText edtEpsilonDegeri;
    @BindView(R.id.edt_boru_ic_cap)
    TextInputEditText edtBoruIcCap;
    @BindView(R.id.edt_reynolds_katsayisi)
    TextInputEditText edtReynoldsKatsayisi;

    @BindView(R.id.btn_hesapla)
    MaterialButton btnHesapla;

    @BindView(R.id.txt_sonuc)
    TextView txtSonuc;

    private ColebrookWhiteMethodPresenter presenter;


    @Override
    protected void viewDidLoad() {
        presenter = new ColebrookWhiteMethodPresenter(this);
        btnHesapla.setOnClickListener(v -> {
            //noinspection ConstantConditions
            presenter.validate(edtEpsilonDegeri.getText().toString(),
                    edtBoruIcCap.getText().toString(),
                    edtReynoldsKatsayisi.getText().toString());
        });
    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_colebrook_white_method;
    }

    @Override
    public String setHeaderText() {
        return getStringResource(R.string.colebrook_white_method);
    }

    @Override
    public void setError() {
        showToast(getStringResource(R.string.empty_field));
    }

    @Override
    public void setResult(String result) {
        txtSonuc.setText(String.format("Sonuç: %s",result));
    }

    @Override
    public void setButtonEnabled() {
        btnHesapla.setEnabled(true);
    }

    @Override
    public void setButtonDisabled() {
        btnHesapla.setEnabled(false);
    }
}
