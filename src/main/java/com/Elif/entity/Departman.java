package com.Elif.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Departman {
    Long id;
    String ad;
    Long kapasite;
    List<Personel> personelList;

}
