
package ders.insan;

import java.util.Scanner;

public class StringÇalışması {
    
    String[] liste;
    int sınır;
    
    public StringÇalışması(int sınır){
        this.liste = new String[sınır];
        this.sınır = sınır-1;
    }
    
    public void ekle(String veri,int sıra){
        if(sıra-1 < this.sınır){
            for(int i = this.sınır-1; i >= sıra-1; i--){
                liste[i+1] = liste[i];
            }
        }
        else{
            System.err.println("Eleman kaybı söz konusu olabilir.");
        }
        liste[sıra-1] = veri;
    }
    
    public void çıkart(int sıra){
        if(sıra-1 <= this.sınır){
            for(int i = sıra-1; i < sınır; i++){
                liste[i] = liste[i+1];
            }
            liste[sınır] = null;
        }
        else{
            System.err.println("Girilen değer, liste kapasitesinden fazladır.");
        }
    }
    
    public String enÇok(){
        String enUzun = liste[0];
        for(int i = 0; i < sınır; i++){
            if(liste[i] != null)
            if(liste[i].compareToIgnoreCase(enUzun) > 0){
                enUzun = liste[i];
            }
        }
        return enUzun;
    }
    
    public String enAz(){
        String enKısa = liste[0];
        for(int i = 0; i < sınır; i++){
            if(liste[i] != null)
            if(liste[i].compareToIgnoreCase(enKısa) < 0){
                enKısa = liste[i];
            }
        }
        return enKısa;
    }
    
    public void değiştir(int sayı1, int sayı2){
        String geçici;
        geçici=liste[sayı1-1];
        liste[sayı1-1] = liste[sayı2-1];
        liste[sayı2-1] = geçici;
    }
    
    public void göster(){
        System.out.println("------------------------");
        for(int i =0; i < sınır; i++){
            if(liste[i] != null)
            System.out.println("-> " + liste[i]);
        }
    }
    
    // Selection Sort - Seçici Sıralama
    public void aSırala(boolean a){
        if(a){
            for(int i =0; i < sınır; i++){
                for(int j = i+1; j < sınır; j++){
                    if(liste[i] != null && liste[j] != null)
                        if(liste[j].compareToIgnoreCase(liste[i]) > 0 )
                            değiştir(i+1,j+1);
                }
            }
        }
        else{
            for(int i =0; i < sınır; i++){
                for(int j = i+1; j < sınır; j++){
                    if(liste[i] != null && liste[j] != null)
                        if(liste[j].compareToIgnoreCase(liste[i]) < 0 )
                            değiştir(i+1,j+1);
                }
            }
        }
    }
    
    // Bubble Sort
    public void a_Sırala(boolean a){
        boolean değişim = true;
        if(a){
            while(değişim){
                değişim = false;
                for(int i = 0; i < sınır; i++){
                    if(liste[i] != null && liste[i+1] != null)
                        if(liste[i].compareToIgnoreCase(liste[i+1]) < 0 ){
                            değiştir(i+1,i+2);
                            değişim = true;
                        }
                }
            }
        }
        else{
            while(değişim){
                değişim = false;
                for(int i = 0; i < sınır; i++){
                    if(liste[i] != null && liste[i+1] != null)
                        if(liste[i].compareToIgnoreCase(liste[i+1]) > 0 ){
                            değiştir(i+1,i+2);
                            değişim = true;
                        }
                }
            }
        }
    }
}
