public class Personaje {

private int nivelEnergia;
private String codigo;
private String nombre;

public Personaje(int energia, String cod, String nomb){
this.nivelEnergia = energia;
this.codigo = cod;
this.nombre = nomb;
}

public String getCodigo(){
return this.codigo;
}
public void sumarGanado(){
int duelosGanados = 0;
duelosGanados++;

}

public String getNombre(){
return this.nombre;
}
public void sumarPerdidos(){
int duelosPerdidos = 0;
duelosPerdidos++;
}

public int getEnergia(){
return this.nivelEnergia;   
}
}