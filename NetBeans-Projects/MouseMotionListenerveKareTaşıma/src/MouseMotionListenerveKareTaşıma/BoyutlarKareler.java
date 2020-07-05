/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MouseMotionListenerveKareTaşıma;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
public class BoyutlarKareler extends JPanel i
 * @author Yunus Emre
 */
public class BoyutlarKareler extends JPanel implements MouseListener, MouseMotionListener{

    /**
     * @param args the command line arguments
     * @see #BoyutlarKareler() 
     */
    public static void main(String[] args) {
        // Yeni tarz tasarımlı java programı.
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        // Yeni bir ekran (program) oluşturma.
        JFrame frame = new JFrame("Boyutlar ve Kareler");
        
        // Programın X simgesine tıklandığında kapanmasını, arka planda çalışır halde kalmasını engelleme.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Bu class içinden bir panel oluşturma.
        BoyutlarKareler panel = new BoyutlarKareler();
       
        // Oluşturulan program ekranına panel'i ekleme.
        frame.add(panel);
        
    //Program ekranın özel ayarları.
        
        // Max ekran çözünürlüğü
        int maxX = 1366;
        int maxY = 768;
        // Program ekran çözünürlüğü
        int x = 640;
        int y = 480;
        // Ekrandaki konumu ve boyutunu ayarlama
        frame.setBounds(maxX / 2 - x / 2, maxY / 2 - y / 2, x, y);
        // Yeniden boyutlanabilirlik.
        frame.setResizable(true);
        // Görünürlük.
        frame.setVisible(true);
        
    }
    /**
     * Çizimde çerçeveye harcanan uzunluk ve genişlik
     * @see #boyutX
     * @see #boyutY
     */
    int çX = 10;
    int çY = 33;
    
    /**
     * Programın ekran boyutu
     * @see #mouseDragged
     */
    int boyutX = 640 - çX;
    int boyutY = 480 - çY;
    /**
     * Ekranda yer alacak olan yazı
     */
    String yazı = "";
    
    /**
     * dörtgenler dizi listesi
     * 
     */
    ArrayList<Rectangle> dörtgenler;
    
    /**
     * Oluşturulan dörtgen sayısı
     * @see #BoyutlarKareler
     */
    int dSayıX = 2;
    int dSayıY = 1;
    
    /**
     * dörtgenler dizi listesine ait bilgiler
     * @see #BoyutlarKareler
     */
    int xkonum = 10;
    int ykonum = 10;
    int genişlik = 30;
    int yükseklik = 30;
    
    /**
     * Dizi üzerinde gezinmek için yineleyici 
     * @see #paint
     * @see #mouseMoved
     * @see #mousePressed
     */
    Iterator<Rectangle> it;
    

    /**
     * Köşeye yakınlık duyarlılığı
     * @see #köşeNoktaKontrolü
     */
    int köşeDuyarlığı = 3;
    
    /**
     * Seçilen kare'nin program tarafından bulunduğunu ifade eden değişken
     * @see #imleciAyarla
     * @see #mouseMoved
     * @see #imleçSıfırla
     */
    boolean bulundu = false;
    
    /**
     * Geçici dörtgen
     * @see #paint
     * @see #mousePressed
     * @see #mouseMoved
     */
    Rectangle r = null;
    
    /**
     * Fare'nin tıkladığı dörtgen
     * @see #paint
     * @see #mousePressed
     */
    Rectangle seçiliDörtgen = null;
    
    /**
     * Farenin üzerinde bulunduğu dörtgen
     * @see #paint
     * @see #mouseMoved
     */
    Rectangle gSeçiliDörtgen = null;
    
    /**
     * Fare'nin konumu tutan noktasal değişken
     * @see #mouseDragged
     * @see #mousePressed
     * @see #sağTarafaBoyutlandırma
     */
    Point fKonum;
    Point fİlkKonum;
    Point fSonKonum;
  
    /**
     * İmlec'in tipini barındıran kod 
     * @see #mouseDragged
     * @see #fareyeGöreTaşıma
     * @see #imleciAyarla
     * @see #imleçSıfırla
     */
    int imleçKodu = Cursor.DEFAULT_CURSOR;
    
    /**
     * Yazı'nın istenen başlangıç noktasına yazılması için gereken hizalama
     * @see #yazıX
     * @see #yazıY
     */
    int yazıHizalama = 10;
    
    /**
     * Yazı'nın ekrandaki başlangıç koordinatları
     */
    int yazıX = 0;
    int yazıY = 0 + yazıHizalama;
    
    /**
     * Fare ile dörtgenlerin başlangıç noktaları arasındaki koordinat farkı
     * @see #mousePressed
     * @see #mouseDragged
     * @see #sağTarafaBoyutlandırma(java.awt.event.MouseEvent) 
     */
    double farkX;
    double farkY;
    double dFarkX; // Detaylı fark
   
    /**
     * Constructer fonksiyonu
     * @see #main(java.lang.String[]) 
     */
    public BoyutlarKareler(){
        // Varsayılan panel işlemlerini yaptırma
        super();
        
    // dörtgenler dizi üzerindeki işlemler
    
        // dörtgenler için yer ayırma
        dörtgenler = new ArrayList<Rectangle>();
        
        // dörtgenlere yeni eleman ekleme
        for(int i = 0; i < dSayıX; i++)
            for(int j = 0; j < dSayıY; j++)
                dörtgenler.add(new Rectangle(xkonum + i * 34, ykonum + j * 40, genişlik, yükseklik));
        
        // Fare hareketi algılayıcısı ekleme
        addMouseMotionListener(this);
        // Fare tıklaması algılayıcısı ekleme
        addMouseListener(this);
    }
    
    /**
     * İmleci varsayılan hale getirme
     * @see #mouseMoved
     */
    public void imleçSıfırla(){
        if(!bulundu){
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            
            imleçKodu = Cursor.DEFAULT_CURSOR;
        }  
    }
    
    /**
     * Fare kordinatı dörtgenin köşelerinde mi kontrolü
     * @param e Fare olayı
     * @param r Dörtgen
     * @see #mouseMoved
     */
    public void imleciAyarla(MouseEvent e){
        elİmleci(e);
        
        if(r.equals(seçiliDörtgen)){
            
            solÜstKöşeBoyutlandırmaİmleci(e);
            sağÜstKöşeBoyutlandırmaİmleci(e);
            sağAltKöşeBoyutlandırmaİmleci(e);
            solAltKöşeBoyutlandırmaİmleci(e);

            yukarıBoyutlandırmaİmleci(e);
            aşağıBoyutlandırmaİmleci(e);
            sağTarafBoyutlandırmaİmleci(e);
            solTarafBoyutlandırmaİmleci(e);
            
            taşımaİmleci(e);

            repaint();
        }
    }
    
    /**
     * İmlecin'nin şeklini taşıma şekline getirme
     * @param e
     * @see #mouseDragged
     */
    public void taşımaİmleci(MouseEvent e){
       if(seçiliDörtgen != null){
            Rectangle temp = duyarlıKareOluştur(seçiliDörtgen);

            if(temp.contains(e.getPoint())){
                // Fare imlecini taşıma imleci yapma
                setCursor(new Cursor(Cursor.MOVE_CURSOR));
                
                imleçKodu = Cursor.MOVE_CURSOR;
            }
        }
    }
    
    /**
     * 
     * @param e
     * 
     */
    public void elİmleci(MouseEvent e){
        Rectangle temp = duyarlıKareOluştur(r);
        
        if(temp.contains(e.getPoint())){
            if(seçiliDörtgen == null){           
                setCursor(new Cursor(Cursor.HAND_CURSOR));

                imleçKodu = Cursor.HAND_CURSOR;

                bulundu = true;
            }
            else{
                if(!seçiliDörtgen.contains(e.getPoint())){
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
            
                    imleçKodu = Cursor.HAND_CURSOR;

                    bulundu = true;
                }
            }
        }
    }
            
    /**
     * İmleci kontrol eedip değiştirme
     * @param e Fare aktiviteleri
     * @see #imleciAyarla
     */
    public void yukarıBoyutlandırmaİmleci(MouseEvent e){
        if(
            e.getX() > r.getX() + köşeDuyarlığı &&
            e.getX() < r.getX() + r.getWidth() - köşeDuyarlığı &&
            e.getY() < r.getY() + köşeDuyarlığı &&
            e.getY() > r.getY() - köşeDuyarlığı 
        ){
            setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
            
            imleçKodu = Cursor.N_RESIZE_CURSOR;
            
            bulundu = true;
        }
    }
    
    /**
     * İmleci kontrol eedip değiştirme
     * @param e Fare aktiviteleri
     * @see #imleciAyarla
     */
    public void aşağıBoyutlandırmaİmleci(MouseEvent e){
        if(
            e.getX() > r.getX() + köşeDuyarlığı &&
            e.getX() < r.getX() + r.getWidth() - köşeDuyarlığı &&
            e.getY() > r.getY() + r.getHeight() - köşeDuyarlığı &&
            e.getY() < r.getY() + r.getHeight() + köşeDuyarlığı
        ){
            setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));
            
            imleçKodu = Cursor.S_RESIZE_CURSOR;
            
            bulundu = true;
        }
    }
    
     /**
     * İmleci kontrol eedip değiştirme
     * @param e Fare aktiviteleri
     * @see #imleciAyarla
     */
    public void solTarafBoyutlandırmaİmleci(MouseEvent e){
        if(
            e.getX() < r.getX() + köşeDuyarlığı &&
            e.getX() > r.getX() - köşeDuyarlığı &&
            e.getY() > r.getY() + köşeDuyarlığı &&
            e.getY() < r.getY() + r.getHeight() - köşeDuyarlığı
        ){
            setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
            
            imleçKodu = Cursor.W_RESIZE_CURSOR;            
            
            bulundu = true;
        }
    }
    
    /**
     * Sağa Tarafa boyutlandırma işlemi
     * @param e Fare olayları
     * @see #mouseDragged(java.awt.event.MouseEvent) 
     */
    
    public void sağTarafaBoyutlandırma(MouseEvent e){
        if(imleçKodu == Cursor.E_RESIZE_CURSOR){           
            seçiliDörtgen.setRect(seçiliDörtgen.getX(), seçiliDörtgen.getY(), 
                 fSonKonum.getX() - seçiliDörtgen.getX() - dFarkX, seçiliDörtgen.getHeight());
            
        }
    }
   
    /**
     * İmleci kontrol eedip değiştirme
     * @param e Fare aktiviteleri
     * @see #imleciAyarla
     */
    public void sağTarafBoyutlandırmaİmleci(MouseEvent e){
        if(
            e.getX() < r.getX() + r.getWidth() + köşeDuyarlığı &&
            e.getX() > r.getX() + r.getWidth() - köşeDuyarlığı &&
            e.getY() > r.getY() + köşeDuyarlığı &&
            e.getY() < r.getY() + r.getHeight() - köşeDuyarlığı
        ){
            setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
            
            imleçKodu = Cursor.E_RESIZE_CURSOR;
            
            bulundu = true;
        }
    }
    
    /**
     * İmleci kontrol eedip değiştirme
     * @param e Fare aktiviteleri
     * @see #imleciAyarla
     */
    public void solÜstKöşeBoyutlandırmaİmleci(MouseEvent e){
        if(
            e.getX() >= r.getX() - köşeDuyarlığı &&
            e.getY() >= r.getY() - köşeDuyarlığı &&
            e.getX() <= r.getX() &&
            e.getY() <= r.getY()         
        ){
            setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
            
            imleçKodu = Cursor.NW_RESIZE_CURSOR;
            
            bulundu = true;
        }
    }
    
     /**
     * İmleci kontrol eedip değiştirme
     * @param e Fare aktiviteleri
     * @see #imleciAyarla
     */
    public void sağÜstKöşeBoyutlandırmaİmleci(MouseEvent e){
        if(
            e.getX() >= r.getX() + r.getWidth() - köşeDuyarlığı &&
            e.getY() >= r.getY() - köşeDuyarlığı &&
            e.getX() <= r.getX() + r.getWidth() + köşeDuyarlığı &&
            e.getY() <= r.getY() + köşeDuyarlığı       
        ){
            setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
            
            imleçKodu = Cursor.NE_RESIZE_CURSOR;
            
            bulundu = true;
        }
    }
    
     /**
     * İmleci kontrol eedip değiştirme
     * @param e Fare aktiviteleri
     * @see #imleciAyarla
     */
    public void sağAltKöşeBoyutlandırmaİmleci(MouseEvent e){
        if(
            e.getX() >= r.getX() + r.getWidth() - köşeDuyarlığı &&
            e.getY() >= r.getY() + r.getHeight() - köşeDuyarlığı &&
            e.getX() <= r.getX() + r.getWidth() + köşeDuyarlığı &&
            e.getY() <= r.getY() + r.getHeight() + köşeDuyarlığı        
        ){
            setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
            
            imleçKodu = Cursor.SE_RESIZE_CURSOR;
            
            bulundu = true;
        }
    }
    
     /**
     * İmleci kontrol eedip değiştirme
     * @param e Fare aktiviteleri
     * @see #imleciAyarla
     */
    public void solAltKöşeBoyutlandırmaİmleci(MouseEvent e){
        if(
            e.getX() >= r.getX() - köşeDuyarlığı &&
            e.getY() >= r.getY() + r.getHeight() - köşeDuyarlığı &&
            e.getX() <= r.getX() + köşeDuyarlığı &&
            e.getY() <= r.getY() + r.getHeight() + köşeDuyarlığı         
        ){
            setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
            
            imleçKodu = Cursor.SW_RESIZE_CURSOR;
            
            bulundu = true;
        }
    }
    
    /**
     * Dörtgenin kenarlarının duyarlılık alanları dışındaki dörtgen
     * @param r Kırpılacak dörtgen
     * @return Yeni dörtgen
     * @see #elİmleci
     * @see #mousePressed
     */
    public Rectangle duyarlıKareOluştur(Rectangle r){
        return 
            new Rectangle(r.x + köşeDuyarlığı, r.y + köşeDuyarlığı, r.width - 2 * köşeDuyarlığı, r.height - 2 * köşeDuyarlığı);
    }
    
    /**
     * Ekrana çizdirme fonksiyonu
     * @param g Panelin grafik bilgisi
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        // Ekrana yazı yazdırma
        g.drawString(yazı, yazıX, yazıY);
        
        // dörtgenler dizisinde dolaşmak için yineleyici kullanıyoruz.
        it = dörtgenler.iterator();
        
        // Sırasıyla her dizideki elemanı kontrol etme ve gerekli işlemleri yapma
        while(it.hasNext()){
            // Sıradaki elemanı dörtgen değişkenine atama
            r = it.next();
            
            if(seçiliDörtgen != null && r.equals(seçiliDörtgen)){
                if(gSeçiliDörtgen !=null)
                    if(gSeçiliDörtgen.equals(seçiliDörtgen)){
                        // Çizim rengini belirleme
                        g.setColor(new Color(-7927549));
                        // İçi dolu dörtgen çizme
                        g.fillRect(r.x, r.y, r.width, r.height);
                        
                        // Devam'ını yapmadan bir sonraki döngüye geçme
                        continue;
                    }
               
                // Çizim rengini değiştirme
                g.setColor(Color.RED);
                // Ekrana içi dolu dörtgen çizdirme
                g.fillRect(r.x, r.y, r.width, r.height); // Sıradaki elemanı dörtgen değişkenine atama               
            }
            else if(gSeçiliDörtgen != null && r.equals(gSeçiliDörtgen)){
                // Çizim rengini belirleme
                g.setColor(new Color(-12830408));
                // İçi dolu dörtgen çizme
                g.fillRect(r.x, r.y, r.width, r.height);
                
            }
            else{
                // Çizim rengini belirleme
                g.setColor(Color.BLACK);
                // Ekrana içi dolu dörtgen çizdirme
                g.fillRect(r.x, r.y, r.width, r.height); // Sıradaki elemanı dörtgen değişkenine atama
            }
                
        }
    }
    
    /**
     * Taşıma işleminde fareye göre konum ayarlama
     * @param e
     * @see #mouseDragged
     */
    public void fareyeGöreTaşıma(MouseEvent e){
        
        if(imleçKodu == Cursor.MOVE_CURSOR){
                // Fare'nin konumu
                fKonum = (Point)e.getPoint().clone();

                if(
                   fKonum.getX() - farkX >= 0 &&
                   fKonum.getY() - farkY >= 0 &&
                   fKonum.getX() - farkX <= boyutX - genişlik &&
                   fKonum.getY() - farkY <= boyutY - yükseklik 
                )
                   seçiliDörtgen.setLocation((int)(fKonum.getX() - farkX),(int)(fKonum.getY() - farkY));

                // Eğer Y ekseninde ilerleniyorsa, x koordinatı sabit kalsın, y ekseninde ilerlesin
                else if(fKonum.getY() - farkY >= 0 && fKonum.getY() - farkY <= boyutY - yükseklik){
                    seçiliDörtgen.setLocation((int)(seçiliDörtgen.getX()), (int)(fKonum.getY() - farkY));
                }
                 // Eğer X ekseninde ilerleniyorsa, x koordinatı sabit kalsın, x ekseninde ilerlesin
                else if(fKonum.getX() - farkX >= 0 && fKonum.getX() - farkX <= boyutX - genişlik){
                   seçiliDörtgen.setLocation((int)(fKonum.getX() - farkX), (int)(seçiliDörtgen.getY()));
                }
        }
    }
    
    /**
     * Fare'nin basılı tutulup hareket ettirilmesi ile çalışan, konum algılayıcı
     * @param e 
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        // Fare'nin son konumu (bulunduğu konumu) atama
        fSonKonum = (Point)e.getPoint().clone();
        
        if(e.getModifiers() == MouseEvent.BUTTON1_MASK){
            // Seçilmiş kare varsa
            if(seçiliDörtgen != null){
                taşımaİmleci(e);
                        
                fareyeGöreTaşıma(e);
                sağTarafaBoyutlandırma(e);
                
                repaint();
            }
           
        }
    }

    /**
     * Fare'nin bulunduğu yer ile ilgili işlemler.
     * Basılı tutulursa çalışmaz.
     * @param e Fare olayları
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        // dörtgenler dizisinde dolaşmka için yenileyici kullanıyoruz.
        it = dörtgenler.iterator();
        
        bulundu = false;
        
        gSeçiliDörtgen = null;
        
        while(it.hasNext()){
            
            // Sıradaki elemanı r'ye atama
            r = it.next();  
            if (r.contains(e.getPoint()))
                gSeçiliDörtgen = r;
            
            imleciAyarla(e);
            repaint();
        }
        
        imleçSıfırla();
        
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    
    }
    
    /**
     * Mouse tıklandığında yapılan işlemler
     * @param e tıklama olayı bilgileri
     */
    @Override
    public void mousePressed(MouseEvent e) {
        // Fare'nin ilk tıklandığı konum bellekte tutma
        fİlkKonum = (Point)e.getPoint().clone();
        
        if(e.getButton() == MouseEvent.BUTTON3)
            seçiliDörtgen = null;
        
        if(e.getButton() == MouseEvent.BUTTON1){
            // dörtgenler dizisinde dolaşmak için yineleyici kullanıyoruz.
            it = dörtgenler.iterator();

            while(it.hasNext()){
                // Dizinin sıradaki elemanını alma
                r = it.next();
                
                // Karenin kenarları dışındaki alan
                
                
                // r dörtgeni basılan noktayı içeriyorsa eğer , bu işlemler yapılacak
                if(r.contains(e.getPoint())){
                    // Dizideki dörtgeni seçilmiş dörtgen yap
                    seçiliDörtgen = r;

                    // Fare konumunu atama
                    fKonum = (Point)e.getPoint().clone();
                   
                    // Fare ile dörtgenin sol üst noktası arasındaki koodinatlar farkı
                    farkX = fKonum.getX() - seçiliDörtgen.getX();
                    farkY = fKonum.getY() - seçiliDörtgen.getY();
                    
                   // solÜst = new Rectangle(seçiliDörtgen.getX(), seçiliDörtgen.getY(), WIDTH, HEIGHT);
                    
                    // Döngüden çıkma
                    break;
                }
            }
            
            if(seçiliDörtgen != null){
                dFarkX = fİlkKonum.getX() - seçiliDörtgen.getX() - seçiliDörtgen.getWidth();
            }
        }
            imleçSıfırla();
            // Ekranı yeniden çizme
            repaint();
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
    
}
