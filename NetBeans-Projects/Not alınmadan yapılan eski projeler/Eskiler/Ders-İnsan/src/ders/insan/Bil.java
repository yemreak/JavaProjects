package ders.insan;

public interface Bil {
    // İnterface'in içinde sace abstract method olur, başka method olmaz.
    // Değişken tanımlaması da olmaz X int a = 5;
    public abstract void bilgisayardaYaz(); // Abstract olup, alt classlarında olmak zorunda
    public void bilgi(); // Abstract yazmamıza gerek yok, hepsini abstract diye alıyor.
    
}
