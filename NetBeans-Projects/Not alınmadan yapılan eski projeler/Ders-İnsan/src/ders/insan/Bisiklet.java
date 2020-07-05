package ders.insan;

public class Bisiklet{
    String isim;
    İnsan binenkişi;
    
    public Bisiklet(){
        this.binenkişi = null;
        this.isim = "İsimsiz";
    }
    
    public Bisiklet(String isim){
        this.binenkişi = null;
        this.isim = isim;
    }
    
    public void Bin(İnsan kişi){
        
        if(this.binenkişi == null){
            this.binenkişi = kişi;
            System.out.println("-> " + this.binenkişi.getBilgi() + " " + this.isim + " adlı bisiklete bindirildi.");
        }
        else{
            System.out.println("-> " + kişi.getBilgi() + " " + this.isim + " adlı bisiklete bindirilemedi, " + this.binenkişi.getBilgi() + " zaten binmekte.");
        }
        
    }
    
    public void İn(){
        if(this.binenkişi == null){
            
          System.out.println("-> " + this.isim + " adlı bisiklet'e binen kişi zaten yok.");  
        }
        else{
            System.out.println("-> " + this.binenkişi.getBilgi() + " " + this.isim + " adlı bisikletten indirildi.");
             this.binenkişi = null;
        }
    }
}
