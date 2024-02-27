package Dominio;
/**
 * Esta clase define un objeto llamado casilla vacía con su tipo
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class CasillaVacia extends Casilla{
    private char tipo = '-';

    /**
     * Constructor que hereda de la clase Casilla
     */
    public CasillaVacia(){
        super();
    }

    /**
     * Método que retorna el tipo de la casilla vacía
     * @return tipo retorna de que tipo es la casilla vacía
     */
    public char getTipo(){
        return tipo;
    }
}
