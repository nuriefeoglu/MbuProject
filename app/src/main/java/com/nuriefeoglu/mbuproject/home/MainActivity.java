package com.nuriefeoglu.mbuproject.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.turbulancecurrent.TurbulanceCurrentActivitiy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    //1)TÜRBÜLANS AKIMI HESAPLAMA
    //2)BORUNUN EKONOMİK ÇAPINI HESAPLAMA
    //3)YÜK KAYIPLARINI HESAPLAMA
    //4)DAİRESEL DÖNÜŞLÜ YÜK KAYBI HESABI
    //5)KESKİN DÖNÜŞLÜ YÜK KAYBI HESAPLAMA
    //6)GİDİŞ İSTİKAMETİNDE DALLANNAN VE BAĞLANAN BORULARIN YÜK KAYIPLARINI HESAPLAMA
    //7)AÇILAN KONUKLERDE YÜK KAYBI HESAPLAMA
    //8)ÇAPTA ANİ DEĞİŞİMLERDE BORUNUN YÜK KAYBINI HESAPLAMA
    //9)TAM DOLU BORULARDA YÜK KAYBI HESAPLAMA (DARCY-WEİSBACH)
    //10)KISMEN DOLU BORULARDAKİ YÜK KAYBI HESAPLAMA (MANNİNG-STRİCKER)
    //11)TAM DOLU BORULARDA YÜK KAYBI HESAPLAMA (MANNİNG-STRİCKER)
    //12)TAM DOLU BORULARDA YÜK KAYBI HESAPLAMA (HAZEN-WİLLİAMS)
    //13)TAM DOLU BORULARDA YÜK KAYBI HESAPLAMA (COLEBROOK-WHİTE)

    @BindView(R.id.btnCalculateTurbulance)
    MaterialButton btnCalculateTurbulance;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        setupListeners();
    }

    private void setupListeners() {

        btnCalculateTurbulance.setOnClickListener(v -> {

            Intent intent = new Intent(this, TurbulanceCurrentActivitiy.class);
            startActivity(intent);

        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }
}
