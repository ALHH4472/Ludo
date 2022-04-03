
package ludo;

public class Jugador {
    boolean play;
    Ficha ficha1;
    Ficha ficha2;
    Ficha ficha3;
    Ficha ficha4;
    int fichaenCasa;
    
    
    
    public Jugador(){
        this.play = false;
        this.ficha1 = new Ficha();
        this.ficha2 = new Ficha();
        this.ficha3 = new Ficha();
        this.ficha4 = new Ficha();
        
    }
    
    
}
