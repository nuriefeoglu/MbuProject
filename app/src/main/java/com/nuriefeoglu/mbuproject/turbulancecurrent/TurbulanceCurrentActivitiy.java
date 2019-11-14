package com.nuriefeoglu.mbuproject.turbulancecurrent;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nuriefeoglu.mbuproject.Formulas;
import com.nuriefeoglu.mbuproject.IFormulasView;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;

import androidx.appcompat.widget.AppCompatSpinner;
import butterknife.BindView;

public abstract class TurbulanceCurrentActivitiy extends BaseActivity implements ITurbulanceCurrentView, IFormulasView {

    String[] temperatureArr = {"0", "10", "20", "30", "40", "50", "60"};
    String[] temperatureOutputArr = {"1.79", "1.31", "1.01", "0.804", "0.661", "0.556", "0.447"};

    Double temperatureOutput = 0.0;

    ArrayAdapter<String> temperatureArrAdapter;


    //Bind Views
    @BindView(R.id.edt_akiskan_hizi)
    TextInputEditText edtAkiskanHizi;
    @BindView(R.id.edt_boru_ic_cap)
    TextInputEditText edtBoruIcCap;
    @BindView(R.id.spinner_sicaklik)
    AppCompatSpinner spinnerSicaklik;
    @BindView(R.id.btn_hesapla)
    MaterialButton btnHesapla;
    @BindView(R.id.txt_sonuc)
    TextView txtSonuc;


    @Override
    public String setHeaderText() {
        return getStringResource(R.string.calculate_turbulance_current);
    }


    @Override
    protected int layoutRes() {
        return R.layout.activitiy_turbulancecurrent;
    }

    @Override
    protected void viewDidLoad() {

        setupSpinner();
        setupButtonListener();


    }

    @Override
    public void setupSpinner() {
        temperatureArrAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                temperatureArr);
        spinnerSicaklik.setAdapter(temperatureArrAdapter);
        spinnerSicaklik.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temperatureOutput = Double.parseDouble(temperatureOutputArr[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                temperatureOutput = Double.parseDouble(temperatureOutputArr[0]);
            }
        });
    }

    @Override
    public void setupButtonListener() {
        btnHesapla.setOnClickListener(v -> {

            //noinspection ConstantConditions
            if (!edtAkiskanHizi.getText().toString().matches("") && !edtBoruIcCap.getText().toString().matches("")) {
                Double result = Formulas.turbulanceCurrent(
                        Double.parseDouble(edtAkiskanHizi.getText().toString()),
                        Double.parseDouble(edtBoruIcCap.getText().toString()),
                        temperatureOutput);
                txtSonuc.setText(String.format("Sonuç : %s", result));
            } else {
                showToast(getStringResource(R.string.empty_field));
            }
        });
    }


    @Override
    public Double turbulanceCurrent(Double v, Double d, Double kv) {
        return null;
    }
}
