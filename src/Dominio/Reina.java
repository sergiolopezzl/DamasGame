package Dominio;
/**
 * Clase que genera la pieza de tipo reina con la que se va a jugar en un tablero
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class Reina extends Ficha{
    /**
     * constructor de la ficha tipo normal
     */
    public Reina(){
        super();
    }
    /**
     * Método que retorna el tipo de la ficha reina según la identificación del jugador
     * @param indentificador (1 o -1) entero que indentifica a cada jugador
     * @return tipo retorna de que tipo de la ficha reina
     */
    @Override
    public char getTipo(int indentificador){
        char tipo = '.';
        if(indentificador == 1){
            tipo = 'D';
        }else if(indentificador == -1){
            tipo = 'X';
        }
        return tipo;
    }
}
