package com.nuriefeoglu.mbuproject.hazenwilliamsmethodfull;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;

public class HazenWilliamsMethodFullActivity extends BaseActivity implements HazenWilliamsMethodFullPresenter.IView{

    @BindView(R.id.edt_hazen_williams_puruzluluk_katsayisi)
    TextInputEditText edtHazenWilliamsPuruzlulukKatsayisi;
    @BindView(R.id.edt_akiskan_hizi)
    TextInputEditText edtAkiskanHizi;
    @BindView(R.id.edt_boru_ic_cap)
    TextInputEditText edtBoruIcCap;

    @BindView(R.id.btn_hesapla)
    MaterialButton btnHesapla;
    @BindView(R.id.txt_sonuc)
    TextView txtSonuc;

    private HazenWilliamsMethodFullPresenter presenter;


    @Override
    protected void viewDidLoad() {
        presenter = new HazenWilliamsMethodFullPresenter(this);
        btnHesapla.setOnClickListener(v -> {
            //noinspection ConstantConditions
            presenter.validate(edtHazenWilliamsPuruzlulukKatsayisi.getText().toString(),
                    edtAkiskanHizi.getText().toString(),
                    edtBoruIcCap.getText().toString());
        });

    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_hazen_williams_method_full;
    }

    @Override
    public String setHeaderText() {
        return getStringResource(R.string.hazen_williams_method);
    }

    @Override
    public void setError() {
        showToast(getStringResource(R.string.empty_field));
    }

    @Override
    public void setResult(String result) {
        txtSonuc.setText(String.format("Sonuç : %s",result));
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
