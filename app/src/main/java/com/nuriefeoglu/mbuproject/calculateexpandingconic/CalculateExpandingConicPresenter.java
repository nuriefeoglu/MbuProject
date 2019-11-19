package com.nuriefeoglu.mbuproject.calculateexpandingconic;

import com.nuriefeoglu.mbuproject.Formulas;

import java.util.ArrayList;
import java.util.List;

public class CalculateExpandingConicPresenter {

    private IView view;
    private List<Double> pipeArr = new ArrayList<>();

    CalculateExpandingConicPresenter(IView view) {
        this.view = view;
    }

    private void calculate() {

        try {
            Double result;
            result = Formulas.expandingConic(pipeArr.get(0), pipeArr.get(1), pipeArr.get(2), pipeArr.get(3), pipeArr.get(4));
            view.setResult(result.toString());
            view.setButtonEnabled();
        } catch (ArrayIndexOutOfBoundsException e) {
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
            } else {
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
