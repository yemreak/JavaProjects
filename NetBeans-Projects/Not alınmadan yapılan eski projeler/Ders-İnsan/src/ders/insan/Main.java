package ders.insan;

public class Main {

    public static void main(String[] args) {
        
        Öğr öğrenci1 = new MatÖğr("Yunus",1306150001); // BU şekilde olur
        Öğr öğrenci2 = new FenÖğr("Emre",1306150002);
        // Öğr öğrenci1 = new Öğr("İsimsiz",6); Bu şekilde olmaz Öğr erişim almıyor.
        
        öğrenci1.alBölüm(); // Abstract fonksiyon olarak öğrenci'de tanımandıysa, bu şekilde kullanılır.
        ((MatÖğr)öğrenci1).alBölüm(); // Tipinin MatÖğr olduğunu belirtmemiz lazım (abstract fonksiyon değilse)
        ((FenÖğr)öğrenci2).alBölüm(); // Tipinin FenÖğr olduğunu belirtmemiz lazım (abstract fonksiyon değilse)
        // öğrenci1.alBölüm(); şeklinde kullanılmaz.
        
        /*
        Hayvan h1 = new Hayvan("isimsiz",8);
        Kedi k1 = new Kedi("isimsiz",1,"et");
        
        h1.sesÇıkar();
        k1.sesÇıkar();
        
        
        */
        /*
        StringÇalışması liste1 = new StringÇalışması(6);
        liste1.ekle("Ekmek", 1);
        liste1.ekle("Süt", 1);
        liste1.ekle("Yumurta", 2);
        liste1.ekle("Böğürtlen",1);
        liste1.aSırala(true); // Z-A
        liste1.göster();
        liste1.aSırala(false); // A-Z
        liste1.göster();
        liste1.a_Sırala(true);
        liste1.göster();
        
        /*
        Array a = new Array();
        İnsan i1 = new İnsan(),i2 = new İnsan();
        
        i1.setİsim("Yunus Emre");
        i1.setYaş(20);
        
        i2.setİsim("Şilan");
        i2.setYaş(18);
        
        Bisiklet b1 = new Bisiklet("İlk bisiklet"),b2 = new Bisiklet("İkinci bisiklet");
        b1.Bin(i1);
        b1.Bin(i2);
        b2.İn();
        b1.İn();
        */
    }
}
