package com.Elif.okul;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Ogrenci {
    /**
     * Öğrencinin temel bilgileri,
     * dersleri olcak(ArrayList<Ders>)
     * Herhangi bir dersinin not ortalamasını getiren bir metot yazcaz.
     * Öğrencinin ortalamasını getiren bir metot.
     * Öğrencinin derslerini, notlarını ve karşılarında ortalamasını getiren bir metot yazınız.
     */
    String ad;
    String soyad;
    String adres;
    String telefon;
    List<Ders> dersler=new ArrayList<>();
    public void dersOrtalama(String dersAdi){
        HashMap<String,Integer> notlar;
        Optional<Ders> ders = this.dersler
                .stream()
                .filter(d->d.getAd().equalsIgnoreCase(dersAdi))
                .findFirst();
        if(ders.isEmpty())
            return; //bu metodu bitir başka kodlar çalışmasın demek

        notlar =ders.get().notlar;
        AtomicInteger toplam = new AtomicInteger(0);
        notlar.forEach((key,value)->{
            toplam.set(toplam.get()+value); //toplam değerini al ve buna value'yu ekle.
        });
        int ortalama = toplam.get()/notlar.size();
        System.out.println(dersAdi + " dersinin not ortalaması: " + ortalama);

    }

    //Öğrencinin derslerinin içerisinden tek tek tüm notlarını alıp average alan bir metot;
    public void notOrtalama(){
        HashMap<String,Integer> notlar;
        double average =this.dersler.stream()
                .flatMap(d -> d.getNotlar().values().stream())
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("Ortalama" + average);
    }
    public void notOrtalama2(){
        AtomicInteger dersOrtalamaToplami = new AtomicInteger(0);
        dersler.forEach(ders -> {
            AtomicInteger toplam = new AtomicInteger(0);
            ders.getNotlar().forEach((key,value)->{
                toplam.set(toplam.get()+value);
            });
            int ortalama = toplam.get()/ders.getNotlar().size();
            dersOrtalamaToplami.set(dersOrtalamaToplami.get() + ortalama);
        });
        int genelOrtalama = dersOrtalamaToplami.get() / dersler.size();
        System.out.println("Genel Ortalama " + genelOrtalama);
    }


    public void notlariYazdir(){
        dersler.forEach(ders -> {
            System.out.println("----------------------------");
            System.out.println("Dersin Adı...: " +ders.getAd());
            AtomicInteger toplam = new AtomicInteger(0);
            ders.getNotlar().forEach((key,value)->{
                toplam.set(toplam.get()+value);
                System.out.print(key + " : " + value + ", ");
            });
            int ortalama=(toplam.get()/ders.getNotlar().size());
            System.out.println("Ortalama....: "+ ortalama);

        });
    }


    public double ortalamaStream(String dersAdi){
        AtomicInteger ortalama=new AtomicInteger(0);
        dersler.stream()
                .filter(d->d.getAd().equalsIgnoreCase(dersAdi)) //dersadına göre filtreleme yapıyoruz.
                .findFirst()//bulabildiği kaydı dönmesini istiyorum.
                .ifPresentOrElse(d->{
                    /**
                     * Map<Key,value> -> key -> not adı, value -> not
                     */
                    ortalama.set((int)d.getNotlar().values() //hashmap içindeki değerlerin listesini alıyorum.
                            .stream().mapToInt(Integer::intValue).average().orElse(0d));
                },()->{
                    throw new RuntimeException("ders bulunamadı");
                });
        return ortalama.get();

    }

    public int tumNotOrtalamasiStream(){
        return (int) dersler.stream().mapToInt(d->
            (int) d.getNotlar().values().stream().mapToInt(Integer::intValue).average().orElse(0d)
        ).average().orElse(0d);
    }

}
