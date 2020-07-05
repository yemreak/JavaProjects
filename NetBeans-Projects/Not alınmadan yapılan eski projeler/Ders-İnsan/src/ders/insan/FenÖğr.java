package ders.insan;

public class FenÖğr extends Öğr {
    
    public FenÖğr(String isim, int no){
        super(isim,no);
    }
    
    @Override
    public void alBölüm(){
        System.out.println("-> Fen Öğrencisiyim");
    }
}
