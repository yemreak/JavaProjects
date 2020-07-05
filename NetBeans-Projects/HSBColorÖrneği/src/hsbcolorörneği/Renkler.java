/**
 * Önemli Notlar :
 * 
 *  JFrame boyutu oluşturulurken, çerçeve çizimi için harcanan uzunluğa ve genişliğe dikkat edilmelidir.
 *   Örneğin; (10,33)'lük bir kısım çerçeve çizimine harcanır.
 *   Programda çX ve çY değişkeninde saklanmıştır.
 * 
 *  BufferedImage'in koordinatları kendine özgüdür, JFrame'in çerçevesiz koordinatları ile aynı dğeildir.
 *   Örneğin; BufferedImage (10,10) luk bir JFrame'nin çerçevesiz koordinatından çizildiyse, koordinatları JFrame'in çerçevesiz koordinatlarının
 *   10 eksiği olacaktık JframeÇerçevesiz(10,10) = BufferedImage(0,0)
 *   Bu sebeple çizmin yapılacağı başlnagıç noktası, JFrame'in çerçevesiz koordinatlarını referans alırsak,
 *   İstenen nokta - Başlangıç Noktaları
 * 
 *  DrawString metodu, JFrame çerçevesiz koordinatlarıyla çalışır, ama diğer methodların aksine yukarı doğru çizilir
 *   Örneğin; "XYZ" yazacaksak, belirlediğimiz başlangıç noktası, string'in sol alt noktasına eşit olur.
 *   Bu sebeple çizmin yapılacağı başlangıç noktası, JFrame'im çerçevesiz koordinatlarını referans alırsak, 
 *   İstenen nokta + yazı boyutu - 3 (yazı hizalama) kadar olmalıdır.
 * 
 *  Her Graphics değişkeni ayrı tanımlıdır, ve koordinatları kendine özgüdür.
 */

package hsbcolorörneği;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Yunus Emre
 */

public class Renkler extends JPanel implements MouseListener, MouseMotionListener{

/**
 * Ana Fonksyion
 * @param args Dışarıdan programa gelen veri
 */
    public static void main(String[] args) {
    // Yeni tarz tasarımlı java programı.
        JFrame.setDefaultLookAndFeelDecorated(true);
        
    // Yeni bir ekran (program) oluşturma.
        JFrame frame = new JFrame("Renkler");
        
    // Programın X simgesine tıklandığında kapanmasını, arka planda çalışır halde kalmasını engelleme.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    // Bu class içinden bir panel oluşturma.
        Renkler panel = new Renkler();
       
    // Oluşturulan program ekranına panel'i ekleme.
        frame.add(panel);
        
    //Program ekranın özel ayarları.
               
        // Ekrandaki konumu ve boyutunu ayarlama
        frame.setBounds(panel.maxX / 2 - panel.x / 2, panel.maxY / 2 - panel.y / 2, panel.x, panel.y);
        // Yeniden boyutlanabilirlik.
        frame.setResizable(false);
        // Görünürlük.
        frame.setVisible(true);
        
    }
    
// Class içi öğeler.
    
    /**
     * Hafızaya kaydedilecek resim değişkeni. (Pixellerine erişmek için kullanışlı.)
     * @see #paint(java.awt.Graphics)
     * @see #başlangıçRengi
     */
    BufferedImage resim;
    
    /**
     * Değişen rengin parametresi
     * @see #renkDeğiştir
     */
    Color renk;
    
    /**
     * Görselde, mousun tıklandığı yeri gösteren yazı.
     * @see #paint(java.awt.Graphics) 
     */
    String yazı = "X :   Y :";
    
    /**
     * Ekrana yazılan değerleri tutan stringler
     * @see #renkDeğiştir
     */
    String rgbDeğeri = "RGB : ";
    String hueDeğeri = "Hue : ";
    String saturationDeğeri = "Saturation : ";
    String brightnessDeğeri = "Brightness : ";
    
    /**
     * Resim nitelikleri
     * @see #renkDeğiştir 
     * @see #başlangıçRengi
     */
    float hue;
    float saturation;
    float brightness = 1F;
    
    /** 
     * Max ekran çözünürlüğü
     */
    int maxX = 1366;
    int maxY = 768;
    
     /**
      * Program ekran çözünürlüğü
      */
     int x = 640;
     int y = 480;
        
    /**
     * Çerçeve çizimi için harcanan uzunluklar
     * @see #getçX() 
     * @see #getçY() 
     */
    int çX = 10;
    int çY = 33;
    
    /**
     * Resim'in ekrana çizileceği başlangıç koordinatları
     */
    int resimX = 10;
    int resimY = 0;
    
    /**
     * Yazı boyutu
     */
    int yazıFontu = 12;
    
    /**
     * Yazıyı ekrana istenen başlangıç noktasına düzgünce yazdırmak için gereken hizalama
     */
    int yazıHizalama = 3;
    
    /**
     * Yazı'nın ekrana yazılacağı başlangıç koordinatları:
     * Değiştirmek için sadece tam sayı değerlerini değiştiriniz.
     */
    int yazıX = 5 + resimX;
    int yazıY = 5 + yazıFontu - yazıHizalama;
    
    /**
     * Resim boyutları
     * @see #başlangıçRengi
     */
    int boyutX = x - resimX - çX;
    int boyutY = y - resimY - çY;
    
    /**
     * Ekranda gösterilen renk tenk renk mi ?
     * @see #parlaklıkDeğiştir
     */
    boolean tekRenkMi = false;
    
    /**
     * Fare'nin sağ tuşuna daha önceden basılmış mı diye kontrol ediyor
     */
    boolean renkDeğiştiMi = false;
    
/**
 * Class constructer'i
 */
    public Renkler(){
        super();
        
        // Boyutları belirli, RGB renk tipinde beyaz bir resim alanı oluşturma.
        resim = new BufferedImage(boyutX, boyutY, BufferedImage.TYPE_INT_RGB);
        
    // Grafik işlemleri
    
        // Grafik bilgilerini korumak için değişken tanımlaması.
        Graphics2D g = resim.createGraphics();
               
        // Çizilecek grafiklerin rengini ayarlama.
        g.setColor(Color.WHITE);
        // İçidolu dörtgen çizme.
        g.fillRect(0, 0, boyutX, boyutY);
        // Başlangıç rengini ayarlama
        başlangıçRengi();
        // Grafiğe string yazdırma.
        g.drawString(yazı, yazıX, yazıY);
        
        
    // Algılayıcı işlemleri
        
        /**   
         * Mouse algılayıcısı ekleme.
         * Eğer bu algılayıcı frame'e eklenirse, frame'nin çizilmesine harcanan kısımlar da
         * mouse algılayıcısı olur, ve 0 0 çıktısı olmaz, en az çX, çY değerinde olur.
         * {@inheritDoc}
         * 
         */
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    /**
     * Ekrana çizme methodunu yeniden tanımlama.
     * @param g Kullanılmak istenen grafik değişkeni.
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
    // Grafik işlemleri
        
        // Kayıtlı resmi ekrana çizdirme.
        g.drawImage(resim, resimX, resimY, null);
        // Yazı fontunu ayarlama.
        g.setFont(new Font("Consola", 1, yazıFontu));
        
        if(brightness < 0.5F){
            g.setColor(Color.YELLOW);
        }
        else{
            g.setColor(Color.BLACK);
        }
   
        // Grafiğe string yazdırma.
        g.drawString(yazı, yazıX, yazıY);
        // RBG değerini yazdırma
        g.drawString(rgbDeğeri, x / 2 - (rgbDeğeri.length() * 10) / 2, yazıY);
        // Renk özü değerini yazdırma
        g.drawString(hueDeğeri, x - (saturationDeğeri.length() * (int)(yazıFontu * 1.18)) / 2, yazıY);
        // DOygunluk değerini yazdırma
        g.drawString(saturationDeğeri, x - (saturationDeğeri.length() * (int)(yazıFontu * 1.18)) / 2, yazıY + 1 * (int)(yazıFontu * 1.2));
        // Parlaklık değerini yazdırma
        g.drawString(brightnessDeğeri, x - (brightnessDeğeri.length() * (int)(yazıFontu * 1.18)) / 2, yazıY + 2 * (int)(yazıFontu * 1.2));
    }
    
    /**
     * Program ilk açıldığında oluşturulacak resim image'ini ayarlama
     * @see #resim
     */
    public void başlangıçRengi(){
        // Her nokta için ayrı renk oluşturma
        for (int i = 0; i < boyutX; i++){
            for (int j = 0; j < boyutY; j++){
                hue = (float)(i) / (boyutX);
                saturation = (float)(j) / (boyutY);
                
                // Yeni nokta için renk değişkeni oluşturma.
                renk = Color.getHSBColor(hue, saturation, brightness);
                
                // Resme oluşan yeni renkleri atama.
                resim.setRGB(i, j, renk.getRGB());
            }
        }
        yazı = "X :  Y :";
        rgbDeğeri = "RGB : ";
        hueDeğeri = "Hue : ";
        saturationDeğeri = "Saturation :";
        brightnessDeğeri = "Brightness :" + brightness;
        
        // Renk değişikliği kontrolü
        renkDeğiştiMi = false;
        
        // Tek renk olmadığını ifade etme
        tekRenkMi = false;
        
        // Programın ekranını yenileme.
        repaint();
    }
    
    /**
     * Resmin parlaklık değerinin değiştirilmesi
     * @param x Fare'nin x koordinatı
     * @param y Fare'nin y koordinatı
     * @see #mouseClicked
     */
    public void parlaklıkDeğiştir(int x, int y){
        if(x <= resimX){
            // Parlaklığı değiştirme
            brightness = (float) y / boyutY;
            
            if(brightness > 1)
                brightness = 1;
            
            if(brightness < 0)
                brightness = 0;
            
            //Brightness değerini kaydetme
            brightnessDeğeri = "Brightness : " + brightness;           
        }      
    }
    
    /**
     * Ekranı tek renge boyama
     * @see #renkDeğiştir
     */
    public void tekRenkÇiz(){
        
            // Resmin grafik2d değişkenini belleğe kaydetme
            Graphics2D g = resim.createGraphics();
            // Grafik işlemlerindeki rengi ayarlama
            g.setColor(renk);
            // İçi dolu dörtgen çizdirme.
            g.fillRect(0, 0, boyutX, boyutY);

            // Tek renk olduğunu ifade etme
            tekRenkMi = true;

            repaint();
        
    }
    
    /**
     * Tıklandığı zaman rengin değiştirilmesi.
     * @param x Fare'nin x koordinatı
     * @param y Fare'nin y koordinatı
     * @see #mouseClicked
     */
    public void renkDeğiştir(int x, int y){
        if(x >= resimX && y >= resimY && x <= boyutX && y <= boyutY){
            // int / int değeri int olacağı için float takılaması yapıyoruz.
            // Hue = renk özü
            hue = (float)(x - resimX) / boyutX;
            // Saturation = doygunluk
            saturation = (float)(y - resimY) / boyutY;
        }
        // Yine rgb olarka tutuluyor, ama insanların daha kolay algılayabileyeceği renk modelleyicisi
        // Hue Saturation Brightness (renk uzayı). Renkleri sırasıyla; renk özü, doygunluk ve parlaklık olarak tanımlar.
        // Floatlarda çalıştığı için yanına F olması lazım (0.33F mesela), yoksa double algılar.
        // 0 - 1 arası değer alırlar.
        renk = Color.getHSBColor(hue, saturation, brightness);

        // Hue değerini kaydetme
        hueDeğeri = "Hue : " + hue;
        // Saturation değerini kaydetme
        saturationDeğeri = "Saturation : " + saturation;
        // RGB değerini kaydetme
        rgbDeğeri = "RGB : " + renk.getRGB();
        //Brightness değerini kaydetme
        brightnessDeğeri = "Brightness : " + brightness;

        // Renk değişikliği kontorlü
        renkDeğiştiMi = true; 
    }
    
    /**
     * Çerçeveyi çizmek için harcanan uzunluk
     * @return Uzunluk için tam sayı döndürür.
     * @see #çX
     */
    public int getçX(){
        return çX;
    }
    
    /**
     * Çerçeveyi çizmek için harcanan genişlik.
     * @return Genişlik değeri için tam sayı döndürür.
     * @see #çY
     */
    public int getçY(){
        return çY;
    }   
       
// Mouse aksiyonları.
    
    /**
     * Mouse'le tıklandığında yapılacaklar.
     * @param e Mouse'nin tıklama olayı bilgileri
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // Fare'nin sol tuşunda basıldığında yapılacaklar:
        if(e.getButton() == e.BUTTON1){
            // Herhangi bir yere tıklandığında mousun tıkladığı koordinatları konsola yazma.
            yazı = ("X : " + e.getX() + " Y : " + e.getY());
            
            if(e.getX() >= resimX && e.getY() >= resimY){
                renkDeğiştir(e.getX(), e.getY());
                tekRenkÇiz();
            }
            else if(tekRenkMi){
                parlaklıkDeğiştir(e.getX(), e.getY());
                renkDeğiştir(e.getX(), e.getY());
                tekRenkÇiz();
            }
            else{
                parlaklıkDeğiştir(e.getX(), e.getY());
                başlangıçRengi();
            }
        }
        // Fare'nin diğer tuşlarına basıldığında yapılacaklar:
        else{
            // Ekranın ilk rengini oluşturma.
            başlangıçRengi();         
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       if(e.getModifiers() == e.BUTTON1_MASK){
            
    // Fare'nin sol tuşunda basıldığında yapılacaklar:
        
            // Herhangi bir yere tıklandığında mousun tıkladığı koordinatları konsola yazma.
            yazı = ("X : " + e.getX() + " Y : " + e.getY());
            
            if(e.getX() >= resimX && e.getY() >= resimY){
                renkDeğiştir(e.getX(), e.getY());
                tekRenkÇiz();
            }
            
            else if(tekRenkMi){
                parlaklıkDeğiştir(e.getX(), e.getY());
                renkDeğiştir(e.getX(), e.getY());
                tekRenkÇiz();
            }
            else{
                parlaklıkDeğiştir(e.getX(), e.getY());
                başlangıçRengi();
            }
            
       }
    }
    

    @Override
    public void mouseMoved(MouseEvent e) {
    
    }
}
