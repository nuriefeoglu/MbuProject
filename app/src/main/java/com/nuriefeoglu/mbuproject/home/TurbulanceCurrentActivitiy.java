package com.nuriefeoglu.mbuproject.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.nuriefeoglu.mbuproject.Formulas;
import com.nuriefeoglu.mbuproject.R;

public class TurbulanceCurrentActivitiy extends AppCompatActivity {

    TextView kvValue, header, kvName, dName, vName, resultText;
    Button calculate;
    Spinner spinnerkv;
    EditText vValue, dValue;

    String[] temperature = {"0", "10", "20", "30", "40", "50", "60"};

    ArrayAdapter<String> dataAdapterForkv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_turbulancecurrent);

        //textview id tanımlama
        kvValue = findViewById(R.id.tur_cur_kv_value);
        header = findViewById(R.id.tur_cur_header);
        kvName = findViewById(R.id.tur_cur_kvname);
        dName = findViewById(R.id.tur_cur_dname);
        vName = findViewById(R.id.tur_cur_vname);
        resultText = findViewById(R.id.tur_cur_result);

        //buton
        calculate = findViewById(R.id.tur_cur_calculate);

        //edittext için id tanımlama
        vValue = findViewById(R.id.tur_cur_v);
        dValue = findViewById(R.id.tur_cur_d);

        //spinner için id tanımı
        spinnerkv = findViewById(R.id.tur_cur_kv_spinner);

        dataAdapterForkv = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temperature);

        spinnerkv.setAdapter(dataAdapterForkv);


        spinnerkv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] tempvalue = {"1.79", "1.31", "1.01", "0.804", "0.661", "0.556", "0.447"};
                for (int i = 0; i <= 6; i++)
                    if (parent.getSelectedItem().toString().equals(temperature[i])) {
                        kvValue.setText(tempvalue[i]);
                    }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double result;
                result = Formulas.turbulanceCurrent
                        (Double.parseDouble(vValue.getText().toString()),
                                Double.parseDouble(dValue.getText().toString()),
                                Double.parseDouble(kvValue.getText().toString()));
                String resulttostring = String.valueOf(result);
                resultText.setText(resulttostring);
            }
        });

    }

}
