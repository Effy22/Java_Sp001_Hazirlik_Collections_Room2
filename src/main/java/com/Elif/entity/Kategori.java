package com.Elif.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Kategori {
    Long id;
    String ad;
    List<Urun> urunList;

    //belli kategorinin içerisindeki ürünlerin fiyat değişim bilgisini getirir;

    public void kategoriFiyatYuzdesi(){
        this.getUrunList().stream().forEach(x->{
            System.out.println(x.getAd()+" : ");
            List<FiyatDegisimleri> list= x.getFiyatDegisimleriList();
            for(int i=0;i<list.size()-1;i++){
                double degisim=((list.get(i).getFiyat()-list.get(i+1).getFiyat())/list.get(i).getFiyat())*100;
                System.out.println(x.getAd()+
                        " adlı ürünün"+ x.getFiyatDegisimleriList().get(i).localDate+ " tarihindeki değişimi :"+degisim);
            }
            System.out.println("****************************");
        });
    }
}
