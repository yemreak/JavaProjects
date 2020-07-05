
package dosyaişlemleri;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ObjeYazmak {
    
    Kişi kişi1;
    FileOutputStream output;
    FileInputStream input;
    ObjectOutputStream ostream;
    ObjectInputStream istream;
    
    public ObjeYazmak() {
        kişi1 = new Kişi("Yunus","Emre",20);    
    }
    
    public void objeYaz(){
        try {
            // Obje olarak yazdırma, okunabilirliği kötü, data' yapımında kullanılır genelde.
            output = new FileOutputStream("çıktı.dll");
            ostream = new ObjectOutputStream(output);
            
            ostream.writeObject(kişi1);
            ostream.close();
            output.close();
        
        } 
        catch (IOException ex) {
            System.err.println("Dosya Hatası !");
        }
    }
    
    public void objeOku(){
        
        
        
        try {
            input = new FileInputStream("çıktı.dll");
            istream = new ObjectInputStream(input);
            // Object'ler tüm class / değişken tiplerinin geldiği yerdir
            Object okunan_obje = istream.readObject();
            // İlk başta değer ataması yapılmak zorunda.
            Kişi okunan_kişi = null;
            // Eğer okunan obje Kişi class'ıysa... (equal veya == anlamında instanse of kullanılır).
            // Kişi'ye eşitse true, değilse false. // object = true / kişi = true / soru = false
            if (okunan_obje instanceof Kişi){
                okunan_kişi = (Kişi) okunan_obje;
            }
            System.out.println(okunan_kişi);
        } 
        catch (IOException | ClassNotFoundException ex) {
            System.err.println("Dosya Hatası !");
        }
    }
}
