package com.nuriefeoglu.mbuproject;

public class Formulas {

    //Türbülans akımı hesaplama
    static Double turbulanceCurrent(Double v, Double d, Double kv) {

        //v = akışkanın hızı
        //d = borunun iç çapı
        //kv = kinematik viskozite (m^2/sn)
        //kv değeri için tableTurbulanceCurrent tablosundan değer alınacaktır

        Double turbulancecurrent;
        turbulancecurrent = (v * d) / kv;

        return turbulancecurrent;

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
    static Double calculateOfLoadLoses(Double p, Double g, Double z, Double pcl, Double v) {
        //p = akışkanın yoğunluğu
        //g = yerçekimi ivmesi
        //z = akışkanın referans yatay bir düzleme göre konumu,
        //pcl = akışkan taneciğine uygulanan basınç pascal
        //v = akışkan taneciğin hızı

        Double calculateofloadloses;
        calculateofloadloses = (z + (pcl / p * g) + (Math.pow(v, 2) / 2 * g)); //bernaulli denklemi

        return calculateofloadloses;
    }

    //Yumuşak dönüşlü yük kaybı hesaplaması => dairesel
    static Double circularRoutesCalculateOfChargeLoadSoft(Double d, Double q, Double r, Double v, Double g) {
        //localchargeloss = yerel yük kaybı
        //v = boru içindeki akışkan hızı
        //g = yerçekimi ivmesi
        //k = boyutsuz sabit , yük kaybı katsayısı
        //q = açı

        Double localloadloss;
        localloadloss = (0.13 + 1.85 - Math.pow((r / d) * 1 / 2, 3.5)) * q / 180 * (Math.pow(v, 2) / (2 * g));
        return localloadloss;
    }

    //Keskin dönüşlü yük kaybı => dairesel
    static Double circularRoutesCalculateOfLoadLosesHard(Double q, Double v, Double g) {
        //q = açı
        //v = boru içindeki akışkan hızı
        //g = yerçekimi ivmesi
        Double localloadloss;
        localloadloss = 67 * Math.pow(610, -6) * Math.pow(q, 2.17) * (Math.pow(v, 2) / (2 * g));
        return localloadloss;
    }

    //Gidiş istikametinde dallanma ve giriş akımına bağlantı formulü
    //dallanan bölümler için kr ve kb değerleri tablodan bakılarak girecektir.
    //KONİKLİLERDE YÜK KAYBI KATSAYISI HESAPLAMA(AÇILAN VE DARALAN)
    static Double branchingAndConnectionCurrent(Double Vt, Double k, Double g) {
        //Vt = girişteki akım hızı m/sn
        //Kullanıcı k değeri için Qb/Qt tablosuna bakılacak
        //g = yerçekimi ivmesi

        return k * Math.pow(Vt, 2) / (2 * g);
    }

    static Double expandingConic(Double expansionAngle, Double d1, Double d2, Double v1, Double g) {
        //expansionAngle = genişleme açısı
        //d1 = genişleme öncesi borunun iç çapı m
        //d2 = genişleme sonrası borunun iç çapı m
        //v1 = genişlemeden önceki ortalama hız

        if (expansionAngle <= 10) {
            //k = 3.2 - Math.pow(Math.tan(expansionAngle), 1.25) * (Math.pow(1 - (Math.pow(d1 / d2, 2)), 2);
            return (Math.pow(v1, 2) / (2 * g)) *
                    (3.2 - Math.pow(Math.tan(expansionAngle), 1.25) * (Math.pow(1 - (Math.pow(d1 / d2, 2)), 2)));
        } else {
            return Math.pow(d2 / d1, 2) * (Math.pow(v1, 2) / (2 * g));
        }

    }


    //ÇAPTA ANİ DEĞİŞİMLERLE YÜK KAYBI KATSAYISI
    static Double suddenContraction(Double v2, Double d1, Double d2, Double g) {
        //v2 daralmadan sonraki vız değeri
        //d1 sıkışma öncesi çap
        //d2 sıkışma sonrası çap
        //g yerçekimi izmesi

        return Math.pow(d1 / d2, 2) * Math.pow(v2, 2) / (2 * g);
    }

    //TAM DOLU BORULARDA YÜK KAYIPLARI
    static Double darcyWeisbachMethod(Double lamda, Double D, Double g, Double V) {
        //sonuç yük kaybı değerini döndürür
        //lamda = yük kaybı katsayısı
        //D = boru içi çapı
        //g = yerçekimi ivmesi

        Double J;
        J = (lamda * Math.pow(V, 2) / (2 * g * D));
        return J;
    }

    //KISMEN DOLU HATLARDAKİ YÜK KAYIPLARI
    static Double manningStricklerMethodSame(Double n, Double R, Double J) {
        //J = yük kaybı
        //n = Manning formülünde pürüzlülük katsayısı
        //V = ortalama sıvı akış hızı
        //R = hidrolik yarıçap

        Double V;
        V = (1 / n) * Math.pow(R, 2 / 3) * Math.pow(J, 1 / 2);
        return V;
    }

    //TAM DOLU BORU HATLARINDA YÜK KAYBI
    static Double manningStricklerMethodFull(Double n, Double V, Double D) {

        //n = Manning formülünde pürüzlülük katsayısı
        //V = ortalama sıvı akış hızı
        //R = hidrolik yarıçap
        Double J;
        J = 6.35 * Math.pow(n * V, 2) * Math.pow(D, -4 / 3);
        return J;
    }

    //YARIM DOLU BORULARDA
    static Double hazenWilliamsMethodSame(Double Cwh, Double R, Double J) {
        //Cwh = Hazen williams formülünde pürüzlülük katsayısı
        //R = Hidrolik yarıçap
        //J = yük kaybı

        Double V;
        V = 0.849 * (Cwh) * Math.pow(R, 0.63) * Math.pow(J, 0.54);
        return V;
    }

    //TAM DOLU BORULARDA
    static Double hazenWilliamsMethodFull(Double Cwh, Double V, Double D) {
        //Cwh =Hazen williams formülünde pürüzlülük katsayısı
        //V = ortalama sıvı akışı
        //D = boru iç çapı
        Double J;
        J = 6.824 * Math.pow(V / Cwh, 1.852) * Math.pow(D, -1.167);
        return J;
    }

    static Double colebrookWhiteMethod(Double epsilon, Double D, Double Re) {
        //epsilon = türbülans dağılma oranı
        Double lamda;
        lamda = 0.25 / Math.pow(Math.log((epsilon / D) / (3.7)) + (5.74 / (Math.pow(Re, 0.9))), 2);
        return lamda;
    }
}
