package ders.insan;

public class Hayvan {
    
    private String isim;
    private int yaş;
    /*
    public Hayvan(){
        
    }
    
    public Hayvan(String isim){
        this.isim = isim;
        this.yaş = 0;
    }
    */
    public Hayvan(int yaş){
        this.isim = "İsimsiz";
        this.yaş = yaş;
    } 
    public Hayvan(String isim, int yaş){
        this.isim = isim;
        this.yaş = yaş;
    }
    
    public int işlemYap(int a, int b){
        return a+b;
    }
    
    public void yürü(){
        System.out.println("-> Yürüdüm");
    }
    
    public void yaşSöyle(){
        System.out.println("-> Yaşım: " + yaş);
    }
    
    public void sesÇıkar(){
        System.out.print("\n-> Ben bir hayvanım");
    }
    
    public int alYaş(){
        return yaş;
    }
}
