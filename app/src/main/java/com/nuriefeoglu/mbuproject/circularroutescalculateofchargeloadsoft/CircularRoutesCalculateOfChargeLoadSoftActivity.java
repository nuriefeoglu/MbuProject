package com.nuriefeoglu.mbuproject.circularroutescalculateofchargeloadsoft;

import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nuriefeoglu.mbuproject.Formulas;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;

import butterknife.BindView;

public class CircularRoutesCalculateOfChargeLoadSoftActivity extends BaseActivity implements ICircularRoutesCalculateOfChargeLoadSoftView {

    @BindView(R.id.edt_boru_ic_cap)
    TextInputEditText edtBoruIcCap;
    @BindView(R.id.edt_aci)
    TextInputEditText edtAci;
    @BindView(R.id.edt_kivrim_yaricap)
    TextInputEditText edtKivrimYaricap;
    @BindView(R.id.edt_akiskan_hizi)
    TextInputEditText edtAkiskanHizi;
    @BindView(R.id.edt_yercekimi_ivmesi)
    TextInputEditText edtYercekimiIvmesi;

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
        return R.layout.activity_circular_routes_calculate_of_charge_load_soft;
    }

    @Override
    public String setHeaderText() {
        return getStringResource(R.string.circular_routes_calculate_of_charge_load_soft);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void setupButtonListener() {

        btnHesapla.setOnClickListener(v -> {
            if (!edtBoruIcCap.getText().toString().matches("") &&
                    !edtAci.getText().toString().matches("") &&
                    !edtKivrimYaricap.getText().toString().matches("") &&
                    !edtAkiskanHizi.getText().toString().matches("") &&
                    !edtYercekimiIvmesi.getText().toString().matches("")) {

                Double result = Formulas.circularRoutesCalculateOfChargeLoadSoft(
                        Double.parseDouble(edtBoruIcCap.getText().toString()),
                        Double.parseDouble(edtAci.getText().toString()),
                        Double.parseDouble(edtKivrimYaricap.getText().toString()),
                        Double.parseDouble(edtAkiskanHizi.getText().toString()),
                        Double.parseDouble(edtYercekimiIvmesi.getText().toString())
                );
                txtSonuc.setText(String.format("Sonuc : %s", result));
            } else {
                showToast(getStringResource(R.string.empty_field));
            }
        });

    }
}
