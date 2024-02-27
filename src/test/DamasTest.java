package test;

import Dominio.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Esta clase define los movimientos que realiza la IA
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class DamasTest{
    Jugador jugador = new Jugador();
    int filaI,columnaI,filaM,columnaM,filaF,columnaF;
    boolean turnoMaq=true;
    private Casilla casillaVacia = new CasillaVacia();
    private Casilla mine = new Mine();
    private Casilla teleport = new Teleport();
    private Casilla jail = new Jail();
    private Ficha normal = new Normal();
    private Ficha reina = new Reina();
    private Ficha ninja = new Ninja();
    private Ficha zombie = new Zombie();
    int x = Tablero.getInstanceTablero().getX();
	private char[][] tablero = Tablero.getInstanceTablero().getTablero();
    
    @BeforeEach
    public void DamasTest()
    {
        
    }

    @Test
    public void deberiaMoverBlanca()
    {
        jugador.mover(1, 7, 3, 8, Tablero.getInstanceTablero().getTablero(), 1);
        Tablero.getInstanceTablero().getTablero();
        if(tablero [3][8]==normal.getTipo(1)){
        	assertTrue(true);
        }
    }
    
    
    @Test
    public void deberiaAdicionarInterseccion()
    {
        
        
    
    }
    
    @Test
    public void deberiaAdicionarRoute()
    {
       
    
      
    }
    
    @Test
    public void deberiaAdicionarSing()
    {
        
     
        
    }
    
    @Test
    public void noDeberiaAdicionarInterseccion()
    {
        
    }
    
    @Test
    public void noDeberiaAdicionarRoute()
    {
        
    }
    
    @Test
    public void noDeberiaAdicionarSing()
    {
        
    }
    
    @Test
    public void deberiaEliminarInterseccion()
    {
        
    }
    
    @Test
    public void deberiaEliminarRoute()
    {
        
    }
    
    @Test
    public void deberiaEliminarSing()
    {
        
    }
    
    
    
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
