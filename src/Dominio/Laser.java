package Dominio;
/**
 * Clase que genera un comodín de tipo "Laser"
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class Laser extends Comodin {
    private char tipo = 'R';
    /**
     * Constructor para el comodín de tipo "Laser"
     */
    public Laser(){
        super();
    }
    /**
     * Método que retorna el tipo del comodín
     * @return tipo retorna de que tipo del comodín
     */
    public char getTipo(){
        return tipo;
    }
}
