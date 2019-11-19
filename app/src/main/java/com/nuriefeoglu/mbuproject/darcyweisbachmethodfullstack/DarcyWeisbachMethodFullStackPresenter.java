package com.nuriefeoglu.mbuproject.darcyweisbachmethodfullstack;

import com.nuriefeoglu.mbuproject.Formulas;

import java.util.ArrayList;
import java.util.List;

public class DarcyWeisbachMethodFullStackPresenter {

    private IView view;
    private List<Double> pipesArr = new ArrayList<>();

    DarcyWeisbachMethodFullStackPresenter(IView view) {
        this.view = view;
    }

    private void calculate(){

        try {
            Double result = Formulas.darcyWeisbachMethod(pipesArr.get(0),pipesArr.get(1),pipesArr.get(2));
            view.setResult(result.toString());
            view.setButtonEnabled();
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

    }

    void validate(String... pipes){
        pipesArr.clear();
        view.setButtonDisabled();
        for (String pipe : pipes){
            if (pipe.isEmpty() || pipe.matches("")){
                view.setError();
                pipesArr.clear();
                view.setButtonEnabled();
                return;
            } else {
                pipesArr.add(Double.parseDouble(pipe));
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
