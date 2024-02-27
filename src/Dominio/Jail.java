package Dominio;

/**
 * Clase que genera una casilla especial de tipo "Jail"
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class Jail extends Casilla{
    private char tipo = 'L';

    /**
     * Constructor para la casilla especial de tipo "Jail"
     */
    public Jail(){
        super();
    }

    /**
     * Método que retorna el tipo de la cárcel
     * @return tipo retorna de que tipo de la cárcel
     */
    public char getTipo(){
        return tipo;
    }
}
