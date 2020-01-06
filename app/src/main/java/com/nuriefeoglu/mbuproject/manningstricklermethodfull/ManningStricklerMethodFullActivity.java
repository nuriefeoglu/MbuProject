package com.nuriefeoglu.mbuproject.manningstricklermethodfull;

import butterknife.BindView;

import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;

public class ManningStricklerMethodFullActivity extends BaseActivity implements ManningStricklerMethodFullPresenter.IView {

    @BindView(R.id.edt_puruzluluk_katsayisi)
    TextInputEditText edtPuruzlulukKatsayisi;
    @BindView(R.id.edt_akiskan_hizi)
    TextInputEditText edtAkiskanHizi;
    @BindView(R.id.edt_hidrolilk_yaricap)
    TextInputEditText edtHidrolikYaricap;

    @BindView(R.id.btn_hesapla)
    MaterialButton btnHesapla;
    @BindView(R.id.txt_sonuc)
    TextView txtSonuc;

    private ManningStricklerMethodFullPresenter presenter;

    @Override
    protected void viewDidLoad() {

        presenter = new ManningStricklerMethodFullPresenter(this);
        btnHesapla.setOnClickListener(v -> {
            //noinspection ConstantConditions
            presenter.validate(edtPuruzlulukKatsayisi.getText().toString(),
                    edtAkiskanHizi.getText().toString(),
                    edtHidrolikYaricap.getText().toString());
        });

    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_manning_strickler_method_full;
    }

    @Override
    public String setHeaderText() {
        return getStringResource(R.string.manning_strickler_method_full);
    }

    @Override
    public void setError() {
        showToast(getStringResource(R.string.empty_field));
    }

    @Override
    public void setResult(String result) {
        txtSonuc.setText(String.format("Sonuç : %s (k-sbt)",result));
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
