public class Arma{
private int poderAtaque;
private boolean magica;

public Arma(int pAtaque, boolean esmag){
this.poderAtaque = pAtaque;
this.magica = esmag;
}

    public int getPoderAtaque() {
        return poderAtaque;
    }

public boolean esMagica(){
return this.magica;
}


}