package com.Elif;

import com.Elif.entity.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Runner_SiteVeri {
    public static void main(String[] args) {
        Marka marka1= Marka.builder().id(1L).ad("A Marka").build();
        Marka marka2= Marka.builder().id(2L).ad("B Marka").build();
        Marka marka3= Marka.builder().id(3L).ad("C Marka").build();

        Model model1= Model.builder().id(1L).ad("A Model").build();
        Model model2= Model.builder().id(2L).ad("B Model").build();
        Model model3= Model.builder().id(3L).ad("C Model").build();

        FiyatDegisimleri fd1= FiyatDegisimleri.builder().id(1L).localDate(LocalDate.of(2024,1,1)).fiyat(150.0).link("www.1.com").siteAdi("A Site").build();
        FiyatDegisimleri fd2= FiyatDegisimleri.builder().id(2L).localDate(LocalDate.of(2024,1,2)).fiyat(250.0).link("www.2.com").siteAdi("B Site").build();
        FiyatDegisimleri fd3= FiyatDegisimleri.builder().id(3L).localDate(LocalDate.of(2024,1,3)).fiyat(350.0).link("www.3.com").siteAdi("C Site").build();

        FiyatDegisimleri fd4= FiyatDegisimleri.builder().id(4L).localDate(LocalDate.of(2024,1,4)).fiyat(450.0).link("www.4.com").siteAdi("D Site").build();
        FiyatDegisimleri fd5= FiyatDegisimleri.builder().id(5L).localDate(LocalDate.of(2024,1,5)).fiyat(550.0).link("www.5.com").siteAdi("E Site").build();
        FiyatDegisimleri fd6= FiyatDegisimleri.builder().id(6L).localDate(LocalDate.of(2024,1,6)).fiyat(650.0).link("www.6.com").siteAdi("F Site").build();

        FiyatDegisimleri fd7= FiyatDegisimleri.builder().id(7L).localDate(LocalDate.of(2024,1,1)).fiyat(100.0).link("www.1.com").siteAdi("A Site").build();
        FiyatDegisimleri fd8= FiyatDegisimleri.builder().id(8L).localDate(LocalDate.of(2024,1,2)).fiyat(200.0).link("www.2.com").siteAdi("B Site").build();
        FiyatDegisimleri fd9= FiyatDegisimleri.builder().id(9L).localDate(LocalDate.of(2024,1,3)).fiyat(300.0).link("www.3.com").siteAdi("C Site").build();

        FiyatDegisimleri fd10= FiyatDegisimleri.builder().id(10L).localDate(LocalDate.of(2024,1,4)).fiyat(400.0).link("www.4.com").siteAdi("D Site").build();
        FiyatDegisimleri fd11= FiyatDegisimleri.builder().id(11L).localDate(LocalDate.of(2024,1,5)).fiyat(500.0).link("www.5.com").siteAdi("E Site").build();
        FiyatDegisimleri fd12= FiyatDegisimleri.builder().id(12L).localDate(LocalDate.of(2024,1,6)).fiyat(600.0).link("www.6.com").siteAdi("F Site").build();

        Urun urun1= Urun.builder().id(1L).ad("A Urun").markaId(1L).modelId(1L).build();
        Urun urun2= Urun.builder().id(2L).ad("B Urun").markaId(2L).modelId(2L).build();
        Urun urun3= Urun.builder().id(3L).ad("C Urun").markaId(3L).modelId(3L).build();
        Urun urun4= Urun.builder().id(4L).ad("D Urun").markaId(1L).modelId(1L).build();

        urun1.setFiyatDegisimleriList(new ArrayList<>());
        urun1.getFiyatDegisimleriList().add(fd1);
        urun1.getFiyatDegisimleriList().add(fd2);
        urun1.getFiyatDegisimleriList().add(fd3);

        urun2.setFiyatDegisimleriList(new ArrayList<>());
        urun2.getFiyatDegisimleriList().add(fd4);
        urun2.getFiyatDegisimleriList().add(fd5);
        urun2.getFiyatDegisimleriList().add(fd6);

        urun3.setFiyatDegisimleriList(new ArrayList<>());
        urun3.getFiyatDegisimleriList().add(fd4);
        urun3.getFiyatDegisimleriList().add(fd5);
        urun3.getFiyatDegisimleriList().add(fd6);

        urun4.setFiyatDegisimleriList(new ArrayList<>());
        urun4.getFiyatDegisimleriList().add(fd7);
        urun4.getFiyatDegisimleriList().add(fd8);
        urun4.getFiyatDegisimleriList().add(fd9);

        Kategori k1= Kategori.builder().id(1L).ad("A Kategori").urunList(List.of(urun1,urun2)).build();
        Kategori k2= Kategori.builder().id(2L).ad("B Kategori").urunList(List.of(urun1,urun2,urun3)).build();
        Kategori k3= Kategori.builder().id(3L).ad("C Kategori").urunList(List.of(urun1,urun2,urun3,urun4)).build();
        Kategori k4= Kategori.builder().id(4L).ad("D Kategori").urunList(List.of(urun2)).build();
        Kategori k5= Kategori.builder().id(5L).ad("E Kategori").urunList(List.of(urun2,urun3)).build();
        Kategori k6= Kategori.builder().id(6L).ad("F Kategori").urunList(List.of(urun1,urun3,urun4)).build();

        k1.kategoriFiyatYuzdesi();
        urun2.belliTarihArasiDegisimYuzdeleri(LocalDate.of(2024,1,1),LocalDate.of(2024,1,6));
        urun3.belliTarihArasiDegisimYuzdeleri(LocalDate.of(2024,1,1),LocalDate.of(2024,1,6));

    }

}
