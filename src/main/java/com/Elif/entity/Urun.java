package com.Elif.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Urun {
    Long id;
    String ad;
    Long markaId;
    Long modelId;
    List<FiyatDegisimleri> fiyatDegisimleriList;

    //Belli tarihler arasında, ürünün fiyatlarının bilgisini getirir;
    public void belliTarihlerArasiFiyatlar(LocalDate start, LocalDate finish) {
        List<FiyatDegisimleri> list=this.fiyatDegisimleriList.stream()
                .filter(x->x.getLocalDate().isAfter(start) && x.getLocalDate().isBefore(finish))
                .collect(Collectors.toList());
        list.forEach(x-> {
            System.out.println(x.localDate + " : " + x.getFiyat());
        });
    }

    //belli tarih aralığındaki ürünlerin değişim yüzdeleri;

    public void belliTarihArasiDegisimYuzdeleri(LocalDate start, LocalDate finish){
        List<FiyatDegisimleri> list=this.fiyatDegisimleriList.stream()
                .filter(x->x.getLocalDate().isAfter(start) && x.getLocalDate().isBefore(finish))
                .collect(Collectors.toList());
        for(int i=0;i<list.size()-1;i++){
            double degisim=((list.get(i).getFiyat()-list.get(i+1).getFiyat())/list.get(i).getFiyat())*100;
            System.out.println(this.ad+
                    " adlı ürünün"+
                    this.fiyatDegisimleriList.get(i).localDate+ " ve "+this.fiyatDegisimleriList.get(i+1).localDate+
                    "tarihleri arasındaki değişimi :"+degisim);
        }
    }


}
