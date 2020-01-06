package com.nuriefeoglu.mbuproject.calculateexpandingconic;

import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;

import butterknife.BindView;

public class CalculateExpandingConicActivity extends BaseActivity implements CalculateExpandingConicPresenter.IView {

    @BindView(R.id.edt_expanding_conic)
    TextInputEditText edtExpandingConic;
    @BindView(R.id.edt_genisleme_oncesi_boru_capi)
    TextInputEditText edtGenislemeOncesiBoruIcCapi;
    @BindView(R.id.edt_genisleme_sonrasi_boru_ic_capi)
    TextInputEditText edtGenislemeSonrasiBoruIcCapi;
    @BindView(R.id.edt_akiskan_hizi)
    TextInputEditText edtAkiskanHizi;
    @BindView(R.id.edt_yercekimi_ivmesi)
    TextInputEditText edtYercekimiIvmesi;

    @BindView(R.id.btn_hesapla)
    MaterialButton btnHesapla;
    @BindView(R.id.txt_sonuc)
    TextView txtSonuc;

    private CalculateExpandingConicPresenter presenter;

    @Override
    protected void viewDidLoad() {

        presenter = new CalculateExpandingConicPresenter(this);
        btnHesapla.setOnClickListener(v -> {
            //noinspection ConstantConditions
            presenter.validate(edtExpandingConic.getText().toString(),
                    edtGenislemeOncesiBoruIcCapi.getText().toString(),
                    edtGenislemeSonrasiBoruIcCapi.getText().toString(),
                    edtAkiskanHizi.getText().toString(),
                    edtYercekimiIvmesi.getText().toString());
        });

    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_calculate_expanding_conic;
    }

    @Override
    public String setHeaderText() {
        return getStringResource(R.string.calculate_expanding_conic);
    }

    @Override
    public void setError() {
        showToast(getStringResource(R.string.empty_field));
    }

    @Override
    public void setResult(String result) {
        txtSonuc.setText(String.format("Sonuç : %s (k-sbt)", result));
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
