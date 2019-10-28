package com.nuriefeoglu.mbuproject;

public class Tables {

    void tableTurbulanceCurrent() { //tag = 0 için
        Integer[] temperature = {0, 10, 20, 30, 40, 50, 60};
        Double[] temp0 = {1.79};
        Double[] temp10 = {1.31};
        Double[] temp20 = {1.01};
        Double[] temp30 = {0.804};
        Double[] temp40 = {0.661};
        Double[] temp50 = {0.556};
        Double[] temp60 = {0.447};
    }

    //dallanan bölümler için
    void tableBranchingAndConnectionCurrent() {
        Double[] QbDividedQt = {0.0, 0.2, 0.4, 0.6, 0.8, 1.0}; //tag = 5 ve tag = 6 için

        Double[] branchkr = {0.04, -0.08, -0.05, 0.07, 0.21, 0.35};  //kr dallanma tag=5 için
        Double[] branchkb = {0.95, 0.88, 0.89, 0.95, 1.10, 1.28};    //kb dallanma tag=5 için

        Double[] connectkr = {0.04, 0.17, 0.30, 0.41, 0.51, 0.60};   //kr bağlanma tag=6 için
        Double[] connectkb = {-1.12, -0.40, 0.08, 0.47, 0.72, 0.91}; //kb bağlanma tag=6 için

    }
}
