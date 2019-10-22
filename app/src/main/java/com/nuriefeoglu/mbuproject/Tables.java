package com.nuriefeoglu.mbuproject;

public class Tables {

    void tableTurbulanceCurrent() {
        Integer[] temperature = {0, 10, 20, 30, 40, 50, 60};
        Double[] temp0 = {1.79};
        Double[] temp10 = {1.31};
        Double[] temp20 = {1.01};
        Double[] temp30 = {0.804};
        Double[] temp40 = {0.661};
        Double[] temp50 = {0.556};
        Double[] temp60 = {0.447};
    }
/*
    void tableCircularRoutesCalculateOfChargeLosesSoft() {
        Double[] rdividedD = {1.0, 1.5, 2.0, 2.5}; // formuldeki r/d değeri için
        Double[] angleValues = {11.25, 22.5, 30.0, 45.0, 90.0, 180.0}; //açı degeri (q)
        Double[] angleValue11 = {0.037, 0.021, 0.018, 0.017};
        Double[] angleValue22 = {0.074, 0.043, 0.036, 0.034};
        Double[] angleValue30 = {0.098, 0.057, 0.048, 0.046};
        Double[] angleValue45 = {0.147, 0.085, 0.073, 0.069};
        Double[] angleValue90 = {0.249, 0.170, 0.145, 0.138};
        Double[] angleValue180 = {0.588, 0.341, 0.291, 0.275};

    }*/
/*

    void tableCircularRoutesCalculateOfLoadLosesHard() {
        Double[] angleValues = {22.5, 30.0, 45.0, 60.0, 90.0};
        Double[] kvaluefor22 = {0.07};
        Double[] kvaluefor30 = {0.11};
        Double[] kvaluefor45 = {0.24};
        Double[] kvaluefor60 = {0.47};
        Double[] kvaluefor90 = {1.13};

    }
*/
    //dallanan bölümler için
    void tableBranchingAndConnectionCurrent(){
        Double[] QbDividedQt = {0.0, 0.2, 0.4, 0.6, 0.8, 1.0};

        Double[] branchkr = {0.04, -0.08, -0.05, 0.07, 0.21, 0.35};  //kr dallanma
        Double[] branchkb = {0.95, 0.88, 0.89, 0.95, 1.10, 1.28};    //kb dallanma

        Double[] connectkr = {0.04, 0.17, 0.30, 0.41, 0.51, 0.60};   //kr bağlanma
        Double[] connectkb = {-1.12, -0.40, 0.08, 0.47, 0.72, 0.91}; //kb bağlanma

    }
}
