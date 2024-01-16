package com.Elif.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Personel {
    String uuid;
    String ad;
    String soyad;
    String adres;
    String telefon;
    Integer yas;
    String unvan;
    String departman;

}
