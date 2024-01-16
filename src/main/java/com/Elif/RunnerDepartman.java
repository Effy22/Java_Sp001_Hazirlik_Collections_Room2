package com.Elif;

import com.Elif.entity.Departman;
import com.Elif.entity.Personel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class RunnerDepartman {
    private static ArrayList<Departman> departmanList = new ArrayList<>();
    /**
     * Departman tanımlıyoruz;
     * id
     * ad
     * kapasite
     * List<Personel> personelList
     * Departman tanımladıktan sonra personel listelerinden ilgili departmanlarda çalışanları
     * departmanlara ekleyebiliriz.
     */
    public static void main(String[] args) {
        Runner.personelEkle();
        List<Personel> personelList = Runner.personelList;
        departmanEkle();
        Map<String, List<Personel>> departmanPersonelMap = personelList.stream()
                .collect(Collectors.groupingBy(Personel::getDepartman));

        System.out.println(departmanPersonelMap);
        departmanList.forEach(d->{
            if(departmanPersonelMap.containsKey(d.getAd())){
               d.getPersonelList().addAll(departmanPersonelMap.get(d.getAd()));
            }
        });


    }
    public static void departmanEkle(){
        Departman departman =Departman.builder()
                .ad("Yazılım")
                .build();
        Departman departman2 =Departman.builder()
                .ad("Pazarlama")
                .build();
        Departman departman3 =Departman.builder()
                .ad("Yönetim")
                .build();
        departmanList.add(departman);
        departmanList.add(departman2);
        departmanList.add(departman3);

    }
}
