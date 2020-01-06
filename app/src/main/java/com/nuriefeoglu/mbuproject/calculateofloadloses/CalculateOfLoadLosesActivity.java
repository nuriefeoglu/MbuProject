package com.nuriefeoglu.mbuproject.calculateofloadloses;

import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;

import butterknife.BindView;

public class CalculateOfLoadLosesActivity extends BaseActivity implements CalculateOfLoadLosesPresenter.IView {

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

    private CalculateOfLoadLosesPresenter presenter;

    @Override
    protected void viewDidLoad() {

        presenter = new CalculateOfLoadLosesPresenter(this);
        btnHesapla.setOnClickListener(v -> {
            //noinspection ConstantConditions
            presenter.validate(edtAkiskanYogunlugu.getText().toString(),
                    edtYercekimiIvmesi.getText().toString(),
                    edtAkiskaninYatayDuzlemeGoreKonumu.getText().toString(),
                    edtBasincDegeri.getText().toString(),
                    edtAkiskanHizi.getText().toString());
        });

    }

    @Override
    protected int layoutRes() {
        return  R.layout.activity_calculate_of_load_loses;
    }

    @Override
    public String setHeaderText() {
        return getStringResource(R.string.calculate_of_load_loses);
    }

    @Override
    public void setError() {
        showToast(getStringResource(R.string.empty_field));
    }

    @Override
    public void setResult(String result) {
        txtSonuc.setText(String.format("Sonuç :%s (Sbt)",result));
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
