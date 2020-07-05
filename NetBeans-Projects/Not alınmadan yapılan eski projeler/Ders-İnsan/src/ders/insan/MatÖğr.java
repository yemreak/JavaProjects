package ders.insan;

public class MatÖğr extends Öğr {
    
    public MatÖğr(String isim, int no){
        super(isim,no); // Verileri süper constructer'a gönderiyor.
    }
    
    @Override
    public void alBölüm(){
        System.out.println("-> Matematik Öğrencisiyim");
    }
}
