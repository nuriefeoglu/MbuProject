package com.nuriefeoglu.mbuproject.home;

import android.content.Intent;

import com.google.android.material.button.MaterialButton;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;
import com.nuriefeoglu.mbuproject.calculateEconomicDiameterOfThePipe.CalculateEconomicDiameterOfThePipeActivity;
import com.nuriefeoglu.mbuproject.calculateofloadloses.CalculateOfLoadLosesActivity;
import com.nuriefeoglu.mbuproject.circularroutescalculateofchargeloadsoft.CircularRoutesCalculateOfChargeLoadSoftActivity;
import com.nuriefeoglu.mbuproject.turbulancecurrent.TurbulanceCurrentActivitiy;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    //1)TÜRBÜLANS AKIMI HESAPLAMA
    //2)BORUNUN EKONOMİK ÇAPINI HESAPLAMA
    //3)YÜK KAYIPLARINI HESAPLAMA
    //4)DAİRESEL DÖNÜŞLÜ YÜK KAYBI HESABI (soft)
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
    @BindView(R.id.btnCalculateEconomicDiameter)
    MaterialButton btnCalculateEconomicDiameter;
    @BindView(R.id.btnCalculateOfLoadLoses)
    MaterialButton btnCalculateOfLoadLoses;
    @BindView(R.id.btnCircularRoutesCalculateOfChargeLoadSoft)
    MaterialButton btnCircularRoutesCalculateOfChargeLoadSoft;


    @Override
    protected void viewDidLoad() {

        setupListeners();

    }

    private void setupListeners() {

        btnCalculateTurbulance.setOnClickListener(v -> {

            Intent intent = new Intent(this, TurbulanceCurrentActivitiy.class);
            startActivity(intent);

        });

        btnCalculateEconomicDiameter.setOnClickListener(v -> {

            Intent intent = new Intent(this, CalculateEconomicDiameterOfThePipeActivity.class);
            startActivity(intent);
        });

        btnCalculateOfLoadLoses.setOnClickListener(v -> {

            Intent intent = new Intent(this, CalculateOfLoadLosesActivity.class);
            startActivity(intent);
        });

        btnCircularRoutesCalculateOfChargeLoadSoft.setOnClickListener(v -> {
            Intent intent = new Intent(this, CircularRoutesCalculateOfChargeLoadSoftActivity.class);
            startActivity(intent);
        });


    }


    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public String setHeaderText() {
        return null;
    }
}
