package com.nuriefeoglu.mbuproject.suddencontraction;

import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;

import butterknife.BindView;

public class SuddenContractionActivity extends BaseActivity implements SuddenContractionPresenter.IView {

    @BindView(R.id.edt_daralma_sonrasi_hiz)
    TextInputEditText edtDaramlaSonrasiHiz;
    @BindView(R.id.edt_yuk_kaybi_katsayisi)
    TextInputEditText edtYukKaybiKatsayisi;
    @BindView(R.id.edt_yercekimi_ivmesi)
    TextInputEditText edtYercekimiIvmesi;

    @BindView(R.id.btn_hesapla)
    MaterialButton btnHesapla;
    @BindView(R.id.txt_sonuc)
    TextView txtSonuc;

    private SuddenContractionPresenter presenter;

    @Override
    protected void viewDidLoad() {

        presenter = new SuddenContractionPresenter(this);
        btnHesapla.setOnClickListener(v -> {
            //noinspection ConstantConditions
            presenter.validate(edtDaramlaSonrasiHiz.getText().toString(),
                    edtYukKaybiKatsayisi.getText().toString(),
                    edtYercekimiIvmesi.getText().toString());
        });

    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_sudden_contraction;
    }

    @Override
    public String setHeaderText() {
        return getStringResource(R.string.sudden_contraction);
    }

    @Override
    public void setError() {
        showToast(getStringResource(R.string.empty_field));
    }

    @Override
    public void setResult(String result) {
        txtSonuc.setText(String.format("Sonuç: %s (m)", result));
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
