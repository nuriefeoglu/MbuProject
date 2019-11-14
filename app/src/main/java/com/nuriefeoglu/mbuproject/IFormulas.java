package com.nuriefeoglu.mbuproject;

public interface IFormulas {
    Double turbulanceCurrent(Double v, Double d, Double kv);

    Double calculateEconomicDiameterOfThePipe(Double n, Double e, Double f, Double q);

    Double calculateOfLoadLoses(Double p, Double g, Double z, Double plc, Double v);

    Double circularRoutesCalculateOfChargeLoadSoft(Double d, Double q, Double r, Double v, Double g);

    Double circularRoutesCalculateOfLoadLosesHard(Double q, Double v, Double g);

    Double branchingAndConnectionCurrent(Double Vt, Double k, Double g);

    Double expandingConic(Double expansionAngle, Double d1, Double d2, Double v1, Double g);

    Double suddenContraction(Double v2, Double k, Double g);

    Double darcyWeisbachMethod(Double lamda, Double D, Double g, Double V);

    Double darcyWeisbachMethod(Double n, Double V, Double D);

    Double manningStricklerMethodFull(Double n, Double V, Double D);

    Double hazenWilliamsMethodFull(Double Cwh, Double V, Double D);

    Double colebrookWhiteMethod(Double epsilon, Double D, Double Re);

}