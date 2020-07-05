
package dosyaişlemleri;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DosyayaYazma {
    
    FileWriter dosyayazıcı1,dosyayazıcı2;
    BufferedWriter yazıcı1,yazıcı2;
    
    public DosyayaYazma(){
        
        try {
            dosyayazıcı1 = new FileWriter("Çıktı.txt");
            yazıcı1 = new BufferedWriter(dosyayazıcı1);     
            
            yazıcı1.write("Bu bir denemediffr"); // \r satır sonlandırma \n satır atlatma
            yazıcı1.newLine(); // Alt satıra geçme,  \n gibi
            yazıcı1.flush(); // Flush dosyayı kapatmadan verilerin kaydedilmesini sağlar.
            // Close yapılmadan dosyaya veriler kaydedilmez.
            yazıcı1.close();
            
        }
        catch (IOException e) {
            System.err.println("Dosya hatası");
        }
    }
    
    public void okumaYazmaDeneme(){
        
        
    }
}
