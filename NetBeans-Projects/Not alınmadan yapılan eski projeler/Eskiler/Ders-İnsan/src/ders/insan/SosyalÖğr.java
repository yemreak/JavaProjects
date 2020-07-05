package ders.insan;

public abstract class SosyalÖğr extends Öğr {
    // Birden fazla class'a extends edemeyiz. Bunun için interface kullanırız.
    public SosyalÖğr(String isim, int no){
        super(isim,no);
    }
    
    // Tipi abstract olduğu için, alBölüm() 'e gerek yok.
    // Doğrudan bu tipten değişken tanımlayamadığımız için gerek yok, nasılsa değişken yok.
}
