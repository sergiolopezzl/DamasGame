package Dominio;
/**
 * Clase que genera un comodín de tipo "Infinity"
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class Infinity extends Comodin {
    private char tipo = 'Y';

    /**
     * Constructor para el comodín de tipo "Infinity"
     */
    public Infinity(){
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
