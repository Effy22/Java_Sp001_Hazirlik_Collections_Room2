package com.Elif;

import java.util.*;

public class Runner_Siralama {
    /**
     * rastgele 20 adet sayı üretin ve bu sayıları bir listeye ekleyin.Bu listedeki sayıları
     * büyükten küçüğe sıralayıp yazdırın
     *
     */
    public static void main(String[] args) {
        ArrayList<Integer> sayilarListesi = new ArrayList<>();
        Random rnd = new Random();

        for(int i=0;i<20;i++){
            sayilarListesi.add((int)(rnd.nextInt(0,150)));
        }
       List<Integer> list = new Random() .ints(20,0,150)
                        .boxed().toList(); //bu for döngüsü yerine daha performanslı çalışıyor.
        System.out.println("------------------");
        sayilarListesi.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("------------------");
        sayilarListesi.forEach(System.out::println);
        Collections.reverse(sayilarListesi);
        System.out.println("------------------");
        sayilarListesi.forEach(System.out::println);
        sayilarListesi.sort(Comparator.reverseOrder());
        System.out.println(sayilarListesi);


    }
}
