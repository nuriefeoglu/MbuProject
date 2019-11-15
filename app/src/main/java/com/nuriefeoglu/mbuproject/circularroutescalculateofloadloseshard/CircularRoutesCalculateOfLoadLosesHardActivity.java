package com.nuriefeoglu.mbuproject.circularroutescalculateofloadloseshard;

import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;

import butterknife.BindView;

public class CircularRoutesCalculateOfLoadLosesHardActivity extends BaseActivity implements CircularRoutesCalculateOfLoadLosesHardPresenter.IView {

    @BindView(R.id.edt_aci)
    TextInputEditText edtAci;
    @BindView(R.id.edt_akiskan_hizi)
    TextInputEditText edtAkiskanHizi;
    @BindView(R.id.edt_yercekimi_ivmesi)
    TextInputEditText edtYercekimiIvmesi;

    @BindView(R.id.btn_hesapla)
    MaterialButton btnHesapla;

    @BindView(R.id.txt_sonuc)
    TextView txtSonuc;

    private CircularRoutesCalculateOfLoadLosesHardPresenter presenter;

    @Override
    protected void viewDidLoad() {

        presenter = new CircularRoutesCalculateOfLoadLosesHardPresenter(this);
        btnHesapla.setOnClickListener(v -> {
            //noinspection ConstantConditions
            presenter.validate(edtAci.getText().toString(),
                    edtAkiskanHizi.getText().toString(),
                    edtYercekimiIvmesi.getText().toString());
        });

    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_circular_routes_calculate_of_load_loses_hard;
    }

    @Override
    public String setHeaderText() {
        return getStringResource(R.string.circular_routes_calculate_of_charge_load_hard);
    }

    @Override
    public void setError() {
        showToast(getStringResource(R.string.empty_field));
    }

    @Override
    public void setResult(String result) {
        txtSonuc.setText(String.format("Sonuç : %s", result));
    }

    @Override
    public void setButtonEnabled() {
        btnHesapla.setEnabled(true);
    }

    @Override
    public void setButtonDisabled() {
        btnHesapla.setEnabled(false);
    }
}
