package com.Elif;

import com.Elif.entity.Personel;

import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    /**
     * Bir personel sınıfı oluşturunuz ve bu sınıfın listesini oluşturarak buna değer
     * giriniz.
     * uuid
     * ad
     * soyad
     * adres
     * telefon
     * yaş
     * ünvan
     *
     */
    static ArrayList<Personel> personelList = new ArrayList<>();
    public static void main(String[] args) {
       personelEkle();
       List<Personel> personelAnkara= personelList
               .stream().filter(p -> p.getAdres().equalsIgnoreCase("Ankara")).toList();
        System.out.println(personelAnkara);

        //Bazen de uuid'leri bir listeye toplamak isteriz;

        List<String> uuidList = personelList.stream().map(Personel::getUuid).toList();
        //Şehirlere göre gruplamak isteseydik;
        Map<String, List<Personel>> sehirlereGore =personelList
                .stream()
                .collect(Collectors.groupingBy(Personel::getAdres));

        TreeMap<String, List<Personel>> sehirlereGore2 = personelList
                .stream()
                .collect(Collectors.groupingBy(
                        Personel::getAdres,
                        TreeMap::new,
                        Collectors.toList()));

        //personel listesinden yaşı en büyük olanı getir deseydik;
        Personel yasiEnBuyuk = personelList.stream()
                .max(Comparator.comparing(Personel::getYas)).get();
        System.out.println(yasiEnBuyuk);

        System.out.println("YAZILIM DEPARTMANINDAKİ KİŞİLER");
        List<Personel> departmanaGorePersonel = personelList.stream()
                .collect(Collectors.groupingBy(Personel::getDepartman)).get("Yazılım");


    }
    static void personelEkle(){
        personelList.add(Personel.builder()
                .uuid(UUID.randomUUID().toString())
                .ad("Ahmet")
                .soyad("Yılmaz")
                .adres("Istanbul")
                .telefon("5555555555")
                .yas(25)
                .unvan("Developer")
                .departman("Yazılım")
                .build());
        personelList.add(Personel.builder()
                .uuid(UUID.randomUUID().toString())
                .ad("Ayşe")
                .soyad("Yılmaz")
                .adres("Ankara")
                .telefon("55555522355")
                .yas(35)
                .unvan("Coder")
                .departman("Yazılım")
                .build());
        personelList.add(Personel.builder()
                .uuid(UUID.randomUUID().toString())
                .ad("Ayşe")
                .soyad("Yıldır")
                .adres("Ankara")
                .telefon("55555522355")
                .yas(42)
                .unvan("Kimyager")
                .departman("Pazarlama")
                .build());
        personelList.add(Personel.builder()
                .uuid(UUID.randomUUID().toString())
                .ad("Sedat")
                .soyad("Pekmez")
                .adres("İstanbul")
                .telefon("52334522355")
                .yas(65)
                .departman("Pazarlama")
                .unvan("İnşaat Mühendisi")
                .build());
        personelList.add(Personel.builder()
                .uuid(UUID.randomUUID().toString())
                .ad("Alipek")
                .soyad("Sırlar")
                .adres("İstanbul")
                .telefon("55555542345")
                .departman("Yönetim")
                .yas(43)
                .unvan("Muhendis")
                .build());
        personelList.add(Personel.builder()
                .uuid(UUID.randomUUID().toString())
                .ad("Kadir")
                .soyad("Güngörler")
                .adres("İstanbul")
                .telefon("55523442345")
                .departman("Yönetim")
                .yas(31)
                .unvan("Satış")
                .build());
    }

}

