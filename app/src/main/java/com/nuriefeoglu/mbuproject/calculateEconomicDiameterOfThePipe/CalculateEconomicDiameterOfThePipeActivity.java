package com.nuriefeoglu.mbuproject.calculateEconomicDiameterOfThePipe;

import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nuriefeoglu.mbuproject.Formulas;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;

import butterknife.BindView;

public class CalculateEconomicDiameterOfThePipeActivity extends BaseActivity implements ICalculateEconomicDiameterOfThePipeView {

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


    @Override
    protected int layoutRes() {
        return R.layout.activity_calculate_economic_diameter_of_the_pipe;
    }

    @Override
    public String setHeaderText() {
        return getStringResource(R.string.calculate_economic_diameter_of_the_pipe);
    }

    @Override
    public void setupButtonListener() {


    }


    @SuppressWarnings("ConstantConditions")
    @Override
    protected void viewDidLoad() {

        btnHesapla.setOnClickListener(v -> {
            if (!edtGunlukCalismaSaati.getText().toString().matches("") &&
                    !edtKwSaatFiyati.getText().toString().matches("") &&
                    !edtBirimBoyFiyati.getText().toString().matches("") &&
                    !edtDebiDegeri.getText().toString().matches("")) {

                Double result = Formulas.calculateEconomicDiameterOfThePipe(
                        Double.parseDouble(edtGunlukCalismaSaati.getText().toString()),
                        Double.parseDouble(edtKwSaatFiyati.getText().toString()),
                        Double.parseDouble(edtBirimBoyFiyati.getText().toString()),
                        Double.parseDouble(edtDebiDegeri.getText().toString()));
                txtSonuc.setText(String.format("Sonuç : %s", result));

            } else {
                showToast(getStringResource(R.string.empty_field));
            }
        });


    }


}
