package ders.insan;

public class FenÖğr extends Öğr{
    // Birden fazla class'a extends edemeyiz. Bunun için interface kullanırız.
    public FenÖğr(String isim, int no){
        super(isim,no);
    }
    
    @Override
    public void alBölüm(){
        System.out.println("-> Fen Öğrencisiyim");
    }
}
