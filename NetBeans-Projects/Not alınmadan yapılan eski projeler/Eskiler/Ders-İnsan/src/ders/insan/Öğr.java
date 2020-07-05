
package ders.insan;
// abstract tipinde olunca, doğrudan bu class kullanılamıyor.
public abstract class Öğr {
    
    private String isim;
    private int no;
    
    public Öğr(String isim, int no){
        this.isim = isim;
        this.no = no;
    }
    
    public String alİsim(){
        return isim;
    }
    
    public void koyİsim(String isim){
        this.isim = isim;
    }
    
    public int alNo(){
        return no;
    }
    
    public void koyNo(int no){
        this.no = no;
    }
    
    public void adYazdır(){
        System.out.println("-> Adım: "+isim);
    }
    
    public abstract void alBölüm(); 
// Zorunlu olarak bu fonksiyon her (abstarct olarak tanımlanmayan extends edene yazılmalı.
}
