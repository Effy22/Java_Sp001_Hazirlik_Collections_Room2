package com.Elif;


import com.Elif.okul.Ders;
import com.Elif.okul.Ogrenci;

import java.util.ArrayList;
import java.util.HashMap;

public class RunnerOkul {
    public static void main(String[] args) {
        Ders ders= Ders.builder()
                .ad("Matematik")
                .build();
        ders.setNotlar(new HashMap<>());
        ders.getNotlar().put("Vize",43);
        ders.getNotlar().put("Final",66);
        Ders ders2= Ders.builder()
                .ad("Türkçe")
                .build();
        ders2.setNotlar(new HashMap<>());
        ders2.getNotlar().put("Vize",76);
        ders2.getNotlar().put("Final",86);
        Ders ders3= Ders.builder()
                .ad("İngilizce")
                .build();

        ders3.setNotlar(new HashMap<>());
        ders3.getNotlar().put("Vize",76);
        ders3.getNotlar().put("Final",100);

        Ogrenci ogrenci1 = Ogrenci.builder()
                .ad("Ahmet")
                .soyad("Yılmaz")
                .adres("Ankara")
                .telefon("3456789")
                .build();
        ogrenci1.setDersler(new ArrayList<>());
        ogrenci1.getDersler().add(ders);
        ogrenci1.getDersler().add(ders2);
        ogrenci1.getDersler().add(ders3);
        System.out.println();

        //METOTLAR;
        ogrenci1.notOrtalama2();
        System.out.println("*********");
        ogrenci1.notOrtalama();
        System.out.println("*********");
        ogrenci1.notlariYazdir();
    }


}
