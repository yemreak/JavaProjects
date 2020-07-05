package deneme;
public enum Kek {
    Kek1("çikolata","A"),
    Kek2("meyveli","B"),
    Kek3("frambuazlı","C");
    String neli,şık;
    Kek(String a,String b){
        this.neli=a;
        this.şık=b;
    }
    public String yazdır(){
        return(this.şık+"-) "+this.neli);
    }
}
