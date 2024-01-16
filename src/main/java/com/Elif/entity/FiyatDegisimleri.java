package com.Elif.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class FiyatDegisimleri {
    Long id;
    String link;
    String siteAdi;
    LocalDate localDate;
    Double fiyat;

    //Bir ürünün belli tarihler arasındaki fiyatları;

}
