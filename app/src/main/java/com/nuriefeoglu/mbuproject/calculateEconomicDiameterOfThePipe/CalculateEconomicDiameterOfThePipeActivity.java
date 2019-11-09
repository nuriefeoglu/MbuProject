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
    TextInputEditText edtgunlukcalismasaati;
    @BindView(R.id.edt_kw_saat_fiyati)
    TextInputEditText edtkwsaatfiyati;
    @BindView(R.id.edt_birim_boy_fiyati)
    TextInputEditText edtbirimboyfiyati;
    @BindView(R.id.edt_debi_degeri)
    TextInputEditText edtdebidegeri;

    @BindView(R.id.btn_hesapla)
    MaterialButton btnhesapla;
    @BindView(R.id.txt_sonuc)
    TextView txtsonuc;


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

        btnhesapla.setOnClickListener(v -> {
            if (!edtgunlukcalismasaati.getText().toString().matches("") &&
                    !edtkwsaatfiyati.getText().toString().matches("") &&
                    !edtbirimboyfiyati.getText().toString().matches("") &&
                    !edtdebidegeri.getText().toString().matches("")) {

                Double result = Formulas.calculateEconomicDiameterOfThePipe(
                        Double.parseDouble(edtgunlukcalismasaati.getText().toString()),
                        Double.parseDouble(edtkwsaatfiyati.getText().toString()),
                        Double.parseDouble(edtbirimboyfiyati.getText().toString()),
                        Double.parseDouble(edtdebidegeri.getText().toString()));
                txtsonuc.setText(String.format("Sonuç : %s", result));

            } else {
                showToast(getStringResource(R.string.empty_field));
            }
        });


    }


}
