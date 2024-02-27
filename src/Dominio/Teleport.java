package Dominio;
/**
 * Esta clase define una casilla especial llamada Teleport con su tipo
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class Teleport extends Casilla{
    private char tipo = 'T';
    /**
     * Constructor para la casilla especial de tipo "Teleport"
     */
    public Teleport(){
        super();
    }
    /**
     * Método que retorna el tipo de la casilla especial
     * @return tipo retorna de que tipo de la casilla especial Teleport
     */
    public char getTipo(){
        return tipo;
    }
}
