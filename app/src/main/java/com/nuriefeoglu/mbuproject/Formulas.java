package com.nuriefeoglu.mbuproject;

public class Formulas {

    //Türbülans akımı hesaplama
    static Double turbulanceCurrent(Double v,Double d,Double kv){

        //v = akışkanın hızı
        //d = borunun iç çapı
        //kv = kinematik viskozite (m^2/sn)
        //kv değişkeni için sıcaklık değeri girilmeli
        Integer[] temperature ={0,10,20,30,40,50,60};
        Double[] temp0={1.79};
        Double[] temp10={1.31};
        Double[] temp20={1.01};
        Double[] temp30={0.804};
        Double[] temp40={0.661};
        Double[] temp50={0.556};
        Double[] temp60={0.447};

        Double turbulancecurren ;
        turbulancecurren = (v * d) / kv ;

        return turbulancecurren;
    }

    //Borunun ekonomik çapının hesaplanması
    static Double calculateEconomicDiameterOfThePipe(Double n,Double e,Double f,Double q){
        //d = borunun ekonomik çapı
        //n = günlük pompa çalışma saati (24e bölünmüş)
        //e = kWsaat fiyatı (fransız frangı cinsinden)
        //f = hattın birim boy maliyeti (fransız frangı)
        //q = debi (m^3/sn)

        Double economicdiameter ;
        economicdiameter = 1.456*(Math.pow(n*e/f,0.154)*Math.pow(q,0.46) );

        return economicdiameter ;
    }
}
