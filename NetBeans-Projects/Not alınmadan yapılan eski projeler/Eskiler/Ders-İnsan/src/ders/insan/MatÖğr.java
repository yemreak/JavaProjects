package ders.insan;

public class MatÖğr extends Öğr implements Bil,Çiz{
    // MatÖğr, Öğr'nin abstract method'larının tanımlanmasına sahip olmak zorunda.
    // MatÖğr, Bil ve Çiz'in her method'unun (hepsi abstract çünkü) tanımlanmasına sahip olmak zorunda.
    // Birden fazla class'a extends edemeyiz. Bunun için ek interface tanımlarız, birden fazla interface olabilir.
    // ve onu çağırırken implements olarak ifade ederiz.
    public MatÖğr(String isim, int no){
        super(isim,no); // Verileri süper constructer'a gönderiyor.
    }
    
    @Override // Tekrardan yazılıdığını ifade ediyor.
    public void alBölüm(){
        System.out.println("-> Matematik Öğrencisiyim");
    }
    
    @Override // Tekrardan yazılıdığını ifade ediyor.
    public void bilgisayardaYaz(){
        System.out.println("-> Math, bilgisayardan yazdım !");
    }
    
    @Override // Tekrardan yazılıdığını ifade ediyor.
    public void bilgi(){
        System.out.println("-> Pc. math biliyorum");
    }
    
    @Override // Tekrardan yazıldığını ifade ediyor.
    public void Çiz(){
        System.out.println("-> Çizerim abi... (Math)");
    }
}
