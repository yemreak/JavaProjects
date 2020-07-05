
package panellerlabeller.SoruCevap;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SorularÇerçevesi extends JFrame implements ActionListener{
    
    Soru[] sorular;
    Soru soru;
    Random rast;
    JButton buton1;
    JLabel lskor;
    
    int skor = 0;
    int enfazla_soru = 100;
    int soru_sayısı = 0;
    int soru_sayacı = 0;
    
    boolean kontrol = false;
    
    public SorularÇerçevesi(int x, int y){
        
        super();
        super.setDefaultLookAndFeelDecorated(true);
        
        setSize(x,y);
        setLayout(new GridLayout(3, 1, 10, 5));
        
        sorular = new Soru[enfazla_soru];
        buton1 = new JButton("Onayla");
        lskor = new JLabel("Skor: " + skor);
        rast = new Random();
        
        buton1.addActionListener(this);
        
        sorularıOluştur();
    }
    
    public void başlat(){
        if(kontrol){
            soru_sayacı = 0;
            soru = sorular[soru_sayacı];
            
            add(soru); 
            add(lskor);
            add(buton1);
            
            setVisible(true);
        }
        else{
            System.err.println("Soru yok !");
        }
    }
    public void sorularıOluştur(){
        
        FileReader dosyaokuyucu;
        BufferedReader okuyucu;
        
        try{
            // File dosya = fopen gibi bir şey bu da .
            dosyaokuyucu = new FileReader("Sorular.txt");
            // Okuma izni verme sanırım (?)
            okuyucu = new BufferedReader(dosyaokuyucu); // Veriler su olsun, içinden bardar bardak almayı sağlıyor.
            
            String satır;
            // Bir satır veri okuma, eğer veri yoksa döndürdüğü değer null olur.
            while((satır = okuyucu.readLine()) != null){
                kontrol = true;
                System.out.println(satır);
                sorular[soru_sayacı] = new Soru(
                    satır, 
                    okuyucu.readLine(),
                    okuyucu.readLine(),
                    okuyucu.readLine(),
                    okuyucu.readLine(),
                    okuyucu.readLine()    
                );
                soru_sayacı++;
                soru_sayısı++;
                // satır = okuyucu.readLine();               
            }
            okuyucu.close();
            dosyaokuyucu.close();
        }
        catch(FileNotFoundException e){
            System.err.println("Dosya bulunamadı");
        }
        catch (IOException ex) {
            Logger.getLogger(SorularÇerçevesi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void soruEkle(
            String soru, String şıkA, String şıkB, 
            String şıkC, String şıkD, Soru.Cevap cevap
            ){
        
        sorular[soru_sayısı] = new Soru(soru, şıkA, şıkB, şıkC, şıkD, cevap);
        //System.out.println(sorular[soru_sayısı].alSoru());
        soru_sayısı++;
        soru_sayacı = rast.nextInt(soru_sayısı);
        
        kontrol = true;
    }
    
    public void soruyuDeğiştir(){
            
            int yeni = rast.nextInt(soru_sayısı);
            
            while(soru_sayacı == yeni && soru_sayısı != 1)
                yeni = rast.nextInt(soru_sayısı);
            
            soru_sayacı = yeni;
            
            //soru = sorular[soru_sayacı]; Bu şekilde değişkenler birbirine atanmıyor !
            soru.değiştir(sorular[soru_sayacı]);      
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if(soru.cevapKontrol()){
            soru.seçiliOlanıSıfırla(); // Seçili olan radio buttonları kaldırıyor.
            soruyuDeğiştir(); 
            
        }
        else 
            System.exit(1);
            
    }

}
