package com.Elif.okul;

import java.util.HashMap;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Ders {
    //ders ad, notlar ->HashMap
    String ad;
    HashMap<String, Integer> notlar;
}
