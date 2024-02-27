package Dominio;

/**
 * Esta clase define una casilla especial llamado Mine con su tipo
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class Mine extends Casilla{
    private char tipo = 'U';
    /**
     * Constructor para la casilla especial de tipo "Mine"
     */
    public Mine(){
        super();
    }

    /**
     * Método que retorna el tipo de la casilla especial
     * @return tipo retorna de que tipo de la casilla especial Mina
     */
    public char getTipo(){
        return tipo;
    }
}
