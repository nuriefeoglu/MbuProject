package com.nuriefeoglu.mbuproject.home;

import android.content.Intent;

import com.google.android.material.button.MaterialButton;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;
import com.nuriefeoglu.mbuproject.branchingandconnectioncurrent.BranchingAndConnectionCurrentActivity;
import com.nuriefeoglu.mbuproject.calculateEconomicDiameterOfThePipe.CalculateEconomicDiameterOfThePipeActivity;
import com.nuriefeoglu.mbuproject.calculateexpandingconic.CalculateExpandingConicActivity;
import com.nuriefeoglu.mbuproject.calculateofloadloses.CalculateOfLoadLosesActivity;
import com.nuriefeoglu.mbuproject.circularroutescalculateofchargeloadsoft.CircularRoutesCalculateOfChargeLoadSoftActivity;
import com.nuriefeoglu.mbuproject.circularroutescalculateofloadloseshard.CircularRoutesCalculateOfLoadLosesHardActivity;
import com.nuriefeoglu.mbuproject.darcyweisbachmethod.DarcyWeisbachMethodActivity;
import com.nuriefeoglu.mbuproject.darcyweisbachmethodfullstack.DarcyWeisbachMethodFullStackActivity;
import com.nuriefeoglu.mbuproject.suddencontraction.SuddenContractionActivity;
import com.nuriefeoglu.mbuproject.turbulancecurrent.TurbulanceCurrentActivitiy;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainActivityPresenter.MainActivityView {

    //1)TÜRBÜLANS AKIMI HESAPLAMA
    //2)BORUNUN EKONOMİK ÇAPINI HESAPLAMA
    //3)YÜK KAYIPLARINI HESAPLAMA
    //4)DAİRESEL DÖNÜŞLÜ YÜK KAYBI HESABI (soft)
    //5)KESKİN DÖNÜŞLÜ YÜK KAYBI HESAPLAMA
    //6)GİDİŞ İSTİKAMETİNDE DALLANNAN VE BAĞLANAN BORULARIN YÜK KAYIPLARINI HESAPLAMA
    //7)AÇILAN KONUKLERDE YÜK KAYBI HESAPLAMA
    //8)ÇAPTA ANİ DEĞİŞİMLERDE BORUNUN YÜK KAYBINI HESAPLAMA
    //9)TAM DOLU BORULARDA YÜK KAYBI HESAPLAMA (DARCY-WEİSBACH)
    //10)KISMEN DOLU BORULARDAKİ YÜK KAYBI HESAPLAMA (DARCY-WEİSBACH)
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
    @BindView(R.id.btnCircularRoutesCalculateOfChargeLoadHard)
    MaterialButton btnCircularRoutesCalculateOfChargeLoadHard;
    @BindView(R.id.btnBranchingAndConnectionCurrent)
    MaterialButton btnBranchingAndConnectionCurrent;
    @BindView(R.id.btnCalculateExpandingConic)
    MaterialButton btnCalculateExpandingConic;
    @BindView(R.id.btnSuddenContraction)
    MaterialButton btnSuddenContraction;
    @BindView(R.id.btnDarcyWeisbachMethod)
    MaterialButton btnDarcyWeisbachMethod;
    @BindView(R.id.btnDarcyWeisbachMethodFullStack)
    MaterialButton btnDarcyWeisbachMethodFullStack;

    private MainActivityPresenter presenter;

    @Override
    protected void viewDidLoad() {
        presenter = new MainActivityPresenter(this, this);
        setupListeners();

    }

    private void setupListeners() {

        btnCalculateTurbulance.setOnClickListener(v -> presenter.navigate(TurbulanceCurrentActivitiy.class));

        btnCalculateEconomicDiameter.setOnClickListener(v -> presenter.navigate(CalculateEconomicDiameterOfThePipeActivity.class));

        btnCalculateOfLoadLoses.setOnClickListener(v -> presenter.navigate(CalculateOfLoadLosesActivity.class));

        btnCircularRoutesCalculateOfChargeLoadSoft.setOnClickListener(v -> presenter.navigate(CircularRoutesCalculateOfChargeLoadSoftActivity.class));

        btnCircularRoutesCalculateOfChargeLoadHard.setOnClickListener(v -> presenter.navigate(CircularRoutesCalculateOfLoadLosesHardActivity.class));

        btnBranchingAndConnectionCurrent.setOnClickListener(v -> presenter.navigate(BranchingAndConnectionCurrentActivity.class));

        btnCalculateExpandingConic.setOnClickListener(v -> presenter.navigate(CalculateExpandingConicActivity.class));

        btnSuddenContraction.setOnClickListener(v -> presenter.navigate(SuddenContractionActivity.class));

        btnDarcyWeisbachMethod.setOnClickListener(v -> presenter.navigate(DarcyWeisbachMethodActivity.class));

        btnDarcyWeisbachMethodFullStack.setOnClickListener(v -> presenter.navigate(DarcyWeisbachMethodFullStackActivity.class));

    }

    @Override
    public void navigate(Intent intent) {
        startActivity(intent);
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
