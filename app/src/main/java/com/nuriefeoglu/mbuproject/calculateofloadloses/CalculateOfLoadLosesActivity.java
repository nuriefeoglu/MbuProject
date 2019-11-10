package com.nuriefeoglu.mbuproject.calculateofloadloses;

import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nuriefeoglu.mbuproject.Formulas;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;

import butterknife.BindView;

public class CalculateOfLoadLosesActivity extends BaseActivity implements ICalculateOfLoadLoses {

    @BindView(R.id.edt_akiskan_yogunlugu)
    TextInputEditText edtAkiskanYogunlugu;
    @BindView(R.id.edt_yercekimi_ivmesi)
    TextInputEditText edtYercekimiIvmesi;
    @BindView(R.id.edt_yatay_duzlem_konumu)
    TextInputEditText edtAkiskaninYatayDuzlemeGoreKonumu;
    @BindView(R.id.edt_basinc_degeri)
    TextInputEditText edtBasincDegeri;
    @BindView(R.id.edt_akiskan_hizi)
    TextInputEditText edtAkiskanHizi;

    @BindView(R.id.btn_hesapla)
    MaterialButton btnHesapla;

    @BindView(R.id.txt_sonuc)
    TextView txtSonuc;

    @Override
    protected void viewDidLoad() {

        setupButtonListener();

    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_calculate_of_load_loses;
    }

    @Override
    public String setHeaderText() {
        return getStringResource(R.string.calculate_of_load_loses);
    }

    @Override
    public void setupButtonListener() {
        btnHesapla.setOnClickListener(v -> {
            if (!edtAkiskanYogunlugu.getText().toString().matches("")&&
            !edtYercekimiIvmesi.getText().toString().matches("")&&
            !edtAkiskaninYatayDuzlemeGoreKonumu.getText().toString().matches("")&&
            !edtBasincDegeri.getText().toString().matches("")&&
            !edtAkiskanHizi.getText().toString().matches("")){
                Double result = Formulas.calculateOfLoadLoses(
                        Double.parseDouble(edtAkiskanYogunlugu.getText().toString()),
                        Double.parseDouble(edtYercekimiIvmesi.getText().toString()),
                        Double.parseDouble(edtAkiskaninYatayDuzlemeGoreKonumu.getText().toString()),
                        Double.parseDouble(edtBasincDegeri.getText().toString()),
                        Double.parseDouble(edtAkiskanHizi.getText().toString())
                );
                txtSonuc.setText(String.format("Sonuç : %s",result));
            }else {
                showToast(getStringResource(R.string.empty_field));
            }
        });

    }
}
