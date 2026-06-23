public class Arma{
    private int Codigo;
    private String Nombre;
    private String Tipo;
    private String Poder;

    //Constructores
    public Arma(int Cod, String Nom, String Tip, String Pod) {
        this.Codigo = Cod;
        this.Nombre = Nom;
        this.Tipo = Tip;
        this.Poder = Pod;
    }

    //Observadores
    public int getCodigo() { return Codigo; }
    public String getNombre(){ return Nombre; }
    public String getTipo(){ return Tipo; }
    public String getPoder(){ return Poder; }

    //Modificadores
    public void setCodigo(int Cod){ this.Codigo = Cod; }
    public void setNombre(String Nom){ this.Nombre = Nom; }
    public void setTipo(String Tip){ this.Tipo = Tip; }
    public void setPoder(String Pod){ this.Poder = Pod; }

    //Propias del tipo
    public String toString() {
        return "Arma{" +
                "Codigo=" + Codigo +
                ", Nombre='" + Nombre + '\'' +
                ", Tipo='" + Tipo + '\'' +
                ", Poder='" + Poder + '\'' +
                '}';
    }

    public boolean esMagica(){
        return this.Tipo.equalsIgnoreCase("Mágica");
    }
}