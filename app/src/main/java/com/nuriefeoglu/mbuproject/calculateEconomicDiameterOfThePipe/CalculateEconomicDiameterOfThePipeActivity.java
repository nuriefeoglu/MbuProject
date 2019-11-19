package com.nuriefeoglu.mbuproject.calculateEconomicDiameterOfThePipe;

import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;

import butterknife.BindView;


public class CalculateEconomicDiameterOfThePipeActivity extends BaseActivity implements CalculateEconomicDiameterOfThePipePresenter.IView {

    @BindView(R.id.edt_gunluk_calisma_saati)
    TextInputEditText edtGunlukCalismaSaati;
    @BindView(R.id.edt_kw_saat_fiyati)
    TextInputEditText edtKwSaatFiyati;
    @BindView(R.id.edt_birim_boy_fiyati)
    TextInputEditText edtBirimBoyFiyati;
    @BindView(R.id.edt_debi_degeri)
    TextInputEditText edtDebiDegeri;

    @BindView(R.id.btn_hesapla)
    MaterialButton btnHesapla;
    @BindView(R.id.txt_sonuc)
    TextView txtSonuc;

    private CalculateEconomicDiameterOfThePipePresenter presenter;


    @Override
    protected int layoutRes() {
        return R.layout.activity_calculate_economic_diameter_of_the_pipe;
    }

    @Override
    public String setHeaderText() {
        return getStringResource(R.string.calculate_economic_diameter_of_the_pipe);
    }


    @Override
    protected void viewDidLoad() {

        presenter = new CalculateEconomicDiameterOfThePipePresenter(this);
        btnHesapla.setOnClickListener(v -> {
            //noinspection ConstantConditions
            presenter.validate(edtGunlukCalismaSaati.getText().toString(),
                    edtKwSaatFiyati.getText().toString(),
                    edtBirimBoyFiyati.getText().toString(),
                    edtDebiDegeri.getText().toString());
        });
    }


    @Override
    public void setError() {
        showToast(getStringResource(R.string.empty_field));
    }

    @Override
    public void setResult(String result) {
        txtSonuc.setText(String.format("Sonuç : %s", result));
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
