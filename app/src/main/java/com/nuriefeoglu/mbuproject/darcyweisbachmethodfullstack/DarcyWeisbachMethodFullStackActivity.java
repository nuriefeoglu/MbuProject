package com.nuriefeoglu.mbuproject.darcyweisbachmethodfullstack;

import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;

import butterknife.BindView;

public class DarcyWeisbachMethodFullStackActivity extends BaseActivity implements DarcyWeisbachMethodFullStackPresenter.IView {

    @BindView(R.id.edt_puruzluluk_katsayisi)
    TextInputEditText edtPuruzlulukKatsayisi;
    @BindView(R.id.edt_hidrolilk_yaricap)
    TextInputEditText edtHidrolikYaricap;
    @BindView(R.id.edt_akiskan_hizi)
    TextInputEditText edtAkiskanHizi;

    @BindView(R.id.btn_hesapla)
    MaterialButton btnHesapla;
    @BindView(R.id.txt_sonuc)
    TextView txtSonuc;

    private DarcyWeisbachMethodFullStackPresenter presenter;

    @Override
    protected void viewDidLoad() {

        presenter = new DarcyWeisbachMethodFullStackPresenter(this);
        btnHesapla.setOnClickListener(v -> {
            //noinspection ConstantConditions
            presenter.validate(edtPuruzlulukKatsayisi.getText().toString(),
                    edtHidrolikYaricap.getText().toString(),
                    edtAkiskanHizi.getText().toString());
        });

    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_darcy_weisbach_method_full_stack;
    }

    @Override
    public String setHeaderText() {
        return getStringResource(R.string.darcy_weisbach_method_full_stack);
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
