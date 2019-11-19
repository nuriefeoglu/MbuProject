package com.nuriefeoglu.mbuproject.darcyweisbachmethod;

import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;

import butterknife.BindView;

public class DarcyWeisbachMethodActivity extends BaseActivity implements DarcyWeisbachMethodPresenter.IView{

    @BindView(R.id.edt_lamda_input)
    TextInputEditText edtLamdaInput;
    @BindView(R.id.edt_boru_ic_cap)
    TextInputEditText edtBoruIciCap;
    @BindView(R.id.edt_yercekimi_ivmesi)
    TextInputEditText edtYercekimiIvmesi;
    @BindView(R.id.edt_akiskan_hizi)
    TextInputEditText edtAkiskanHizi;

    @BindView(R.id.btn_hesapla)
    MaterialButton btnHesapla;
    @BindView(R.id.txt_sonuc)
    TextView txtSonuc;


    private DarcyWeisbachMethodPresenter presenter;

    @Override
    protected void viewDidLoad() {

        presenter = new DarcyWeisbachMethodPresenter(this);
        btnHesapla.setOnClickListener(v -> {
            //noinspection ConstantConditions
            presenter.validate(edtLamdaInput.getText().toString(),
                    edtBoruIciCap.getText().toString(),
                    edtYercekimiIvmesi.getText().toString(),
                    edtAkiskanHizi.getText().toString());
        });

    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_darcy_weisbach_method;
    }

    @Override
    public String setHeaderText() {
        return getStringResource(R.string.darcy_weisbach_method);
    }

    @Override
    public void setError() {
        showToast(getStringResource(R.string.empty_field));
    }

    @Override
    public void setResult(String result) {
        txtSonuc.setText(String.format("Sonuç : %s",result));
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
