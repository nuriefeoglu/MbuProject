package com.nuriefeoglu.mbuproject;

public class Formulas {

    //Türbülans akımı hesaplama
    static Double turbulanceCurrent(Double v, Double d, Double kv) {

        //v = akışkanın hızı
        //d = borunun iç çapı
        //kv = kinematik viskozite (m^2/sn)
        //kv değişkeni için sıcaklık değeri girilmeli

        Integer[] temperature = {0, 10, 20, 30, 40, 50, 60};
        Double[] temp0 = {1.79};
        Double[] temp10 = {1.31};
        Double[] temp20 = {1.01};
        Double[] temp30 = {0.804};
        Double[] temp40 = {0.661};
        Double[] temp50 = {0.556};
        Double[] temp60 = {0.447};

        Double turbulancecurren;
        turbulancecurren = (v * d) / kv;

        return turbulancecurren;

    }

    //Borunun ekonomik çapının hesaplanması
    static Double calculateEconomicDiameterOfThePipe(Double n, Double e, Double f, Double q) {
        //d = borunun ekonomik çapı
        //n = günlük pompa çalışma saati (24e bölünmüş)
        //e = kWsaat fiyatı (fransız frangı cinsinden)
        //f = hattın birim boy maliyeti (fransız frangı)
        //q = debi (m^3/sn)

        Double economicdiameter;
        economicdiameter = 1.456 * (Math.pow(n * e / f, 0.154) * Math.pow(q, 0.46));

        return economicdiameter;
    }

    //Yük kayıplarının hesaplanması
    static Double calculateOfChargeLoses(Double p,Double g,Double z,Double pcl,Double v){
        //p = akışkanın yoğunluğu
        //g = yerçekimi ivmesi
        //z = akışkanın referans yatay bir düzleme göre konumu,
        //pcl = akışkan taneciğine uygulanan basınç pascal
        //v = akışkan taneciğin hızı

        Double calculateofchargeloses;
        calculateofchargeloses = (z + (pcl/p*g) + (Math.pow(v,2)/2*g) ); //bernaulli denklemi

        return calculateofchargeloses;
    }

    //Yumuşak dönüşlü yük kaybı hesaplaması => dairesel
    static Double circularRoutesCalculateOfChargeLosesSoft(Double d,Double q,Double r,Double v,Double g){
        //localchargeloss = yerel yük kaybı
        //v = boru içindeki akışkan hızı
        //g = yerçekimi ivmesi
        //k = boyutsuz sabit , yük kaybı katsayısı
        //q = açı

        Double k , localchargeloss ;
        k = (0.13 + 1.85-Math.pow(d/2*r,3.5))*q/180;
        localchargeloss = k * (Math.pow(v,2)/(2*g));
        return  localchargeloss ;
    }
    //Keskin dönüşlü yük kaybı => dairesel
    static Double circularRoutesCalculateOfChargeLosesHard(Double q,Double v,Double g){
        Double k,localchargeloss ;
        k= 67*Math.pow(610,-6)*Math.pow(q,2.17);
        localchargeloss = k * (Math.pow(v,2)/(2*g));
        return localchargeloss ;
    }



}




























