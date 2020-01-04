package com.nuriefeoglu.mbuproject.circularroutescalculateofchargeloadsoft;

import com.nuriefeoglu.mbuproject.Formulas;

import java.util.ArrayList;
import java.util.List;

public class CircularRoutesCalculateOfChargeLoadSoftPresenter {

    private IView view;
    private List<Double> pipeArr = new ArrayList<>();

    CircularRoutesCalculateOfChargeLoadSoftPresenter(IView view){
        this.view = view;
    }

    private void calculate(){

        try {
            Double result;
            result = Formulas.circularRoutesCalculateOfChargeLoadSoft(pipeArr.get(0),pipeArr.get(1),pipeArr.get(2),pipeArr.get(3),pipeArr.get(4));
            view.setResult(result.toString());
            view.setButtonEnabled();
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    void validate(String... pipes){
        pipeArr.clear();
        view.setButtonDisabled();
        for (String pipe : pipes){
            if (pipe.isEmpty() || pipe.matches("")){
                view.setError();
                pipeArr.clear();
                view.setButtonEnabled();
                return;
            }else {
                pipeArr.add(Double.parseDouble(pipe));
            }
        }
        calculate();
    }

    interface IView {
        void setError();

        void setResult(String result);

        void setButtonEnabled();

        void setButtonDisabled();

    }
}
