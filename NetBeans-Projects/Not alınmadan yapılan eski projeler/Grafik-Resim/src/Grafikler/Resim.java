
package Grafikler;
// Bir resmi yükleyip ekranda gösterme.

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Resim extends JPanel implements ActionListener{
// Image : Yüklenen / alınan resmi doğrudan ekranda göstermeye yarar, içindeki piksellere doğrudan erişebilmemizi sağlamıyor.
// BufferedImage : YÜklenen resmi hafızada / ramde tutarak, piksellere ulaşabiliyoruz ve resim üzerinde değişiklik yapabiliyoruz.
        
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        JFrame pencere = new JFrame();
        
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere.setSize(650,513);
        
        Resim r = new Resim();
        r.resimYükle();
        r.resimKopyala();
        r.boyutlandır(3,true);
        r.pixelYenile();
        r.blur(5, 0.6);
        //r.kaydet();
        //r.başlat();
        //r.karanlıktanGel();
        //r.maviPixelleriSil(100);
        //r.kırmızıPixelleriSil(100);
        //r.yeşilPixelleriSil(100);
        //r.siyahBeyazPixeller();
        //r.rastgelePixeller();
        
        pencere.add(r);
        
        pencere.setResizable(true);
        pencere.setVisible(true);
    }
    // Resmin programın hafızasına kaydetmek için.
    BufferedImage görsel, modgör;
    
    String dosya = "elma.jpg";
    int x, y; // Resmin x, y boyutu.
    int sınır = 0; // Renk katsayısı sınırı.
   
    Color[][] pixel;  // Resmin her bir pixelini tutan dizi.
    
    Random rst = new Random();
    // Yineleyici
    Timer yinele = new Timer(1,this);
    // Resmin başarılı bir şekilde alınıp alınmadığını kontrol etme.
    boolean resimyüklendi = false;
    // Sınırın 255'den büyük olmasını kontrol etme.
    boolean arttır = true;

// ----------------------------------------------  
    public Resim(){
        super();

    }

// Zamanlayıcıyı başlatma
    public void başlat(){ // Zamanlayıcıyı başlatma.
        yinele.start();
    }   

// Resmi kopylama, değişiklikler yapmak için.
    public void resimKopyala(){
        modgör = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
    
        modgör.getGraphics().drawImage(görsel, 0, 0, null);
        
        pixelleriAl(modgör);
    }

// Elimizdeki resmi yükleme fonksiyonu
    public void resimYükle(){
        // Sorun varsa catch yapılıyor.
        try {
            // Statik methodları oluduğu için new ' ile yer ayırmadan kullanabiliyoruz.
            görsel = ImageIO.read(new File(dosya));
           
            resimyüklendi = true;
            
            pixelleriAl(görsel);
                     
        } 
        catch (IOException ex) {
            Logger.getLogger(Resim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

// Yeni dosyayı kaydetme.
    public void kaydet(){
        try {
            ImageIO.write(görsel,"jpg", new File("yeni.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Resim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
// Etrafındaki pixellere bakıp, onlara göre ortalama renk belirleme, r komşularından oluşan çemberin yarı çapı.
    public void blur(int r, double benzemeOranı){
       
        if(r <= 0){
            System.out.println("Yarıçap 0'dan küçük veya 0'a eşit olamaz ! (1 Alındı.)");
            r = 1;
        }
        
        if(benzemeOranı <= 1){
            
            BufferedImage yeniGörsel
                = new BufferedImage(x, y, modgör.getType());
    
            Color c1;
        
            for(int i = 0; i < x; i++)
                for(int j = 0; j < y; j++){
            
                c1 = komsuOrtala(r, benzemeOranı, i, j);
                yeniGörsel.setRGB(i, j, c1.getRGB());
            }
        
            modgör = yeniGörsel;
        }
        
        else{
            System.err.println("Blur içindeki benzeme oranı 1'den büyük olamaz. (1 değeri alındı.)");
            blur(r,1);
        }
    }

// Renk ortalaması alma.
    public Color komsuOrtala(int r, double benzemeOranı, int x , int y){
        
        int elemanSayısı = 0;
        
        int toplamR = 0;
        int toplamG = 0;
        int toplamB = 0;
        
        int ortR = 0;
        int ortG = 0;
        int ortB = 0;
        
        for(int i = x - r; i <= x + r; i++){
            for(int j = y - r; j <= y + r; j++){
                if(i >= 0 && j >= 0 && i < modgör.getWidth() && j < modgör.getHeight()){
                    if(i == x && j == y)
                        continue;
                    
                    toplamR += pixel[i][j].getRed();
                    toplamG += pixel[i][j].getGreen();
                    toplamB += pixel[i][j].getBlue();
                    
                    elemanSayısı++;
                }
                    
            }
        }
        
        if(elemanSayısı != 0){
            
            ortR = (int) ((toplamR / elemanSayısı) * benzemeOranı + 
                    pixel[x][y].getRed() * (1 - benzemeOranı));
            ortG = (int) ((toplamG / elemanSayısı) * benzemeOranı + 
                    pixel[x][y].getGreen() * (1 - benzemeOranı));
            ortB = (int) ((toplamB / elemanSayısı) * benzemeOranı + 
                    pixel[x][y].getBlue() * (1 - benzemeOranı));
        }
        
        return new Color(ortR, ortG, ortB);
    }

// Tüm pikselleri diziye kaydediyor.
    public void pixelleriAl(BufferedImage görsel){
        if(resimyüklendi){
            x = görsel.getWidth();
            y = görsel.getHeight();
            
            pixel = new Color[x][y];
            // Bütün pikselleri dolaşıyor.
            for(int i = 0; i < x; i++)
                for(int j = 0; j < y; j++){
                    pixel[i][j] = new Color(görsel.getRGB(i, j));
                    
                }
        }
    }

// Siyalıktan resmin oluşmasını sağlar.
    public void karanlıktanGel(){
        if(resimyüklendi){
            
            for(int i = 0; i < x; i++)
                for(int j = 0; j < y; j++){
                    Color geçici = new Color(görsel.getRGB(i, j));
                    
                    if(sınır >= geçici.getRed()   || 
                       sınır >= geçici.getGreen() || 
                       sınır >= geçici.getBlue()
                    ){
                        modgör.setRGB(i, j, görsel.getRGB(i, j));
                    }
                    else{
                        modgör.setRGB(i, j, Color.BLACK.getRGB());
                    }
                    
                    
                }        
                    
                    
                
        }
    }

// Resmi gri tonda, kararığ yeniden kendisine gelmesini sağlar.
    public void karanlığaGit(){
        if(resimyüklendi){
            
            for(int i = 0; i < x; i++)
                    for(int j = 0; j < y; j++){
                        int s_b = 
                            (int)(
                                 (pixel[i][j].getRed() * 0.299) +
                                 (pixel[i][j].getGreen() * 0.587) + 
                                 (pixel[i][j].getBlue() * 0.114)
                            );
                        
                        Color geçici = new Color(s_b,s_b,s_b);
                        
                        if(s_b >= sınır)
                            modgör.setRGB(i, j, geçici.getRGB());
                        else{
                            modgör.setRGB(i, j, geçici.BLACK.getRGB());
                        }                        
                    }
        }
    }

// Siyah-Beyaz görüntü elde etme.
    public void siyahBeyazPixeller(){
        if(resimyüklendi){
            
            for(int i = 0; i < x; i++)
                    for(int j = 0; j < y; j++){
                        int siyah_beyaz = 
                            (int)(
                                 (pixel[i][j].getRed() * 0.299) +
                                 (pixel[i][j].getGreen() * 0.587) + 
                                 (pixel[i][j].getBlue() * 0.114)
                            );
                        
                        Color geçici = new Color(siyah_beyaz,siyah_beyaz,siyah_beyaz);
                        
                        modgör.setRGB(i, j, geçici.getRGB());
                    }
        }
    } 

// Resmi kayıplı boyutlandırma.
    public void boyutlandır(int kat, boolean boyut){
        if(resimyüklendi){
    
            BufferedImage yeniGörsel;
           
            if(boyut){
                yeniGörsel = new BufferedImage(x * kat, y * kat, modgör.getType());
                
                for(int i = 0; i < x * kat; i++)
                    for(int j = 0 ; j < y * kat ; j++){
                        yeniGörsel.setRGB(i, j, pixel[i/kat][j/kat].getRGB()); 
                }
            }
            else{
                 yeniGörsel = new BufferedImage(x / kat , y / kat, modgör.getType());
            
                 for(int i = 0; i < x / kat; i++)
                    for(int j = 0 ; j < y / kat ; j++){
                        
                        yeniGörsel.setRGB(i, j, pixel[i * kat][j * kat].getRGB()); 
                }
            }
            modgör = yeniGörsel;
        }
    }
// Modgör'e göre pixel yenileme
    public void pixelYenile(){
        pixelleriAl(modgör);
    }
// Belirli katsayının üstündeki tüm pixelleri sıfırlar.
    public void pixelleriSil(int r){
        maviPixelleriSil(r);
        kırmızıPixelleriSil(r);
        yeşilPixelleriSil(r);
    }

// Rastgele renkte pixel görüntüsü.
    public void rastgelePixeller(){
        if(resimyüklendi){
            
            for(int i = 0; i < x; i++)
                    for(int j = 0; j < y; j++){
                        Color geçici = new Color(rst.nextInt(256), rst.nextInt(256), rst.nextInt(256));
                        modgör.setRGB(i, j, geçici.getRGB());
                    }
        }
    }

// Mavi renk katsayısı sıfırlar.
    public void maviPixelleriSil(){
        if(resimyüklendi){
            
            for(int i = 0; i < x; i++)
                    for(int j = 0; j < y; j++){
                        Color geçici = new Color(pixel[i][j].getRed(), pixel[i][j].getGreen(), 0);
                        modgör.setRGB(i, j, geçici.getRGB());
                    }
        }
    }

// Belli bir seviyeden düşük olan mavi renk katsayısını sıfırlar.
    public void maviPixelleriSil(int r){
        if(resimyüklendi){
            
            for(int i = 0; i < x; i++)
                    for(int j = 0; j < y; j++){
                        Color geçici;
                        if(pixel[i][j].getGreen() > r)
                            geçici = new Color(pixel[i][j].getRed(), pixel[i][j].getGreen(), 0);
                        else
                            geçici = new Color(pixel[i][j].getRed(), pixel[i][j].getGreen(), pixel[i][j].getBlue());
                        
                        modgör.setRGB(i, j, geçici.getRGB());
                    }
        }
    }

// Kırmızı renk katsayısını sıfırlar.
    public void kırmızıPixelleriSil(){
        if(resimyüklendi){
            
            for(int i = 0; i < x; i++)
                    for(int j = 0; j < y; j++){
                        Color geçici = new Color(0, pixel[i][j].getGreen(), pixel[i][j].getBlue());
                        modgör.setRGB(i, j, geçici.getRGB());
                    }
        }
    }

// Belli bir seviyeden düşük olan kırmızı renk katsayısını sıfırlar.
    public void kırmızıPixelleriSil(int r){
        if(resimyüklendi){
            
            for(int i = 0; i < x; i++)
                    for(int j = 0; j < y; j++){
                        Color geçici;
                        if(pixel[i][j].getGreen() > r)
                            geçici = new Color(0, pixel[i][j].getGreen(), pixel[i][j].getBlue());
                        else
                            geçici = new Color(pixel[i][j].getRed(), pixel[i][j].getGreen(), pixel[i][j].getBlue());
                        
                        modgör.setRGB(i, j, geçici.getRGB());
                    }
        }
    }

// Yeşil renk katsayısını sıfırlar.
    public void yeşilPixelleriSil(){
        if(resimyüklendi){
            
            for(int i = 0; i < x; i++)
                    for(int j = 0; j < y; j++){
                        Color geçici = new Color(pixel[i][j].getRed(), 0, pixel[i][j].getBlue());
                        
                        modgör.setRGB(i, j, geçici.getRGB());
                    }
        }
    }

// Belli bir seviyeden düşük olan yeşil renk katsayısını sıfırlar.
    public void yeşilPixelleriSil(int r){
        if(resimyüklendi){
            
            for(int i = 0; i < x; i++)
                    for(int j = 0; j < y; j++){
                        Color geçici;
                        if(pixel[i][j].getGreen() > r)
                            geçici = new Color(pixel[i][j].getRed(), 0, pixel[i][j].getBlue());
                        else
                            geçici = new Color(pixel[i][j].getRed(), pixel[i][j].getGreen(), pixel[i][j].getBlue());
                        
                        modgör.setRGB(i, j, geçici.getRGB());
                    }
        }
    }
          
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // İmageObserver resmin yüklenme anını beklemek için , o kontrolleri yapmak için kullanılır.(buarada null).
        if(resimyüklendi)
            g.drawImage(modgör, 0, 0, null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {             
        if(arttır)
            sınır++;
        else
            sınır--;
        
        if(sınır > 254){
            sınır = 255;
        
            arttır = false;
        }
        else if(sınır < 0){
            sınır = 0;
            
            arttır = true;
        }
        
        //karartma();
        karanlıktanGel();
        repaint();
    }
}
