package ders.insan;

public class Kedi extends Hayvan {
    
    private String mamatürü;
    
    public Kedi(String isim, int yaş, String mamatürü){
        super(isim,yaş); // Constructer içerisinde ilk bu çağırılmalı, kedi objesini oluşturmadan hayvan objesini oluşturması lazım, bu sebeple ilk hayvan objesine uygun işlem olmalı.
    // Hayvan'ın constructer'i gibi olmalı. 
    // Hayvan'ın ismi ve yaşını aldığı isim gibi yapar.
    // Hayvan'ın boş constructer olmadığı için kullanım zorunluluğu var.
    this.mamatürü = mamatürü;
    }
    
    @Override
    public int işlemYap(int a, int b){
        return super.işlemYap(a, b)+a+b;
    }
    @Override // tekrar yazıldığını ifade ediyor.
    public void sesÇıkar(){
        super.sesÇıkar(); // super komutu üst classtaki veriyi kullan demek
        System.out.println("-> Miyav :)");
    }
    
}
