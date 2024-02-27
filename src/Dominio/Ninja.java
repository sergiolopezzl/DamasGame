package Dominio;

/**
 * Clase que genera la pieza de tipo ninja con la que se va a jugar en un tablero
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class Ninja extends Ficha{
    /**
     * constructor de la ficha tipo ninja
     */
    public Ninja(){
        super();
    }
    /**
     * Método que retorna el tipo de la ficha ninja según la identificación del jugador
     * @param indentificador (1 o -1) entero que indentifica a cada jugador
     * @return tipo retorna de que tipo de la ficha ninja
     */
    @Override
    public char getTipo(int indentificador){
        char tipo = '.';
        if(indentificador == 1){
            tipo = 'J';
        }else if(indentificador == -1){
            tipo = 'A';
        }
        return tipo;
    }
}
