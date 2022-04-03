
package ludo;

public class Dado {
    
    int numero;
    
    public int lanzar(){
        this.numero = (int) Math.round(Math.random()*5+1);
        return numero;
    }
    
}
