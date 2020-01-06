package com.nuriefeoglu.mbuproject.branchingandconnectioncurrent;

import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nuriefeoglu.mbuproject.R;
import com.nuriefeoglu.mbuproject.base.BaseActivity;

import butterknife.BindView;

public class BranchingAndConnectionCurrentActivity extends BaseActivity implements BranchingAndConnectionCurrentPresenter.IView {

    @BindView(R.id.edt_akiskan_hizi)
    TextInputEditText edtAkiskanHizi;
    @BindView(R.id.edt_k_degeri)
    TextInputEditText edtKDegeri;
    @BindView(R.id.edt_yercekimi_ivmesi)
    TextInputEditText edtYercekimiIvmesi;

    @BindView(R.id.btn_hesapla)
    MaterialButton btnHesapla;
    @BindView(R.id.txt_sonuc)
    TextView txtSonuc;

    private BranchingAndConnectionCurrentPresenter presenter;

    @Override
    protected void viewDidLoad() {

        presenter = new BranchingAndConnectionCurrentPresenter(this);
        btnHesapla.setOnClickListener(v -> {
            //noinspection ConstantConditions
            presenter.validate(edtAkiskanHizi.getText().toString(),
                    edtKDegeri.getText().toString(),
                    edtYercekimiIvmesi.getText().toString());
        });

    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_branching_and_connection_current;
    }

    @Override
    public String setHeaderText() {
        return getStringResource(R.string.branching_and_connection_current);
    }

    @Override
    public void setError() {

        showToast(getStringResource(R.string.empty_field));

    }

    @Override
    public void setResult(String result) {

        txtSonuc.setText(String.format("Sonuc : %s (m)", result));

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
