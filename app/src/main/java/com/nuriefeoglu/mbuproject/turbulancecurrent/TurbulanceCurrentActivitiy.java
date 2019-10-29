package com.nuriefeoglu.mbuproject.turbulancecurrent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nuriefeoglu.mbuproject.Formulas;
import com.nuriefeoglu.mbuproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TurbulanceCurrentActivitiy extends AppCompatActivity {

    String[] temperatureArr = {"0", "10", "20", "30", "40", "50", "60"};
    String[] temperatureOutputArr = {"1.79", "1.31", "1.01", "0.804", "0.661", "0.556", "0.447"};

    Double temperatureOutput = 0.0;

    ArrayAdapter<String> temperatureArrAdapter;
    private Unbinder unbinder;

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
    @BindView(R.id.incHeader)
    View includeLayout;

    static class HeaderLayout {
        @BindView(R.id.txtHeader)
        TextView txtHeader;
        @BindView(R.id.btnHeaderBack)
        MaterialButton btnBack;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_turbulancecurrent);
        unbinder = ButterKnife.bind(this);

        setupHeader();
        setupSpinner();
        setupButtonListener();

    }

    //Header i kur
    private void setupHeader() {
        HeaderLayout headerLayout = new HeaderLayout();
        ButterKnife.bind(headerLayout, includeLayout);
        headerLayout.txtHeader.setText(getResources().getString(R.string.calculate_turbulance_current));
        headerLayout.btnBack.setOnClickListener(v -> onBackPressed());
    }

    //buttonu dinle
    private void setupButtonListener() {
        btnHesapla.setOnClickListener(v -> {
            if (edtAkiskanHizi.getText() != null && edtBoruIcCap.getText() != null) {
                Double result = Formulas.turbulanceCurrent
                        (Double.parseDouble(edtAkiskanHizi.getText().toString()),
                                Double.parseDouble(edtBoruIcCap.getText().toString()),
                                temperatureOutput);
                txtSonuc.setText(String.format("Sonuç : %s", result));
            }
        });
    }

    //spinneri kur ve dinle
    private void setupSpinner() {
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

    //OnDestroy
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }
}
