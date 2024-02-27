package Dominio;
/**
 * Clase que genera la pieza de tipo zombie con la que se va a jugar en un tablero
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class Zombie extends Ficha{
    /**
     * constructor de la ficha tipo zombie
     */
    public Zombie(){
        super();
    }

    @Override
    /**
     * Método que retorna el tipo de la ficha zombie según la identificación del jugador
     * @param indentificador (1 o -1) entero que indentifica a cada jugador
     * @return tipo retorna de que tipo de la ficha zombie
     */
    public char getTipo(int indentificador){
        char tipo = '.';
        if(indentificador == 1){
            tipo = 'I';
        }else if(indentificador == -1){
            tipo = 'E';
        }
        return tipo;
    }
}
