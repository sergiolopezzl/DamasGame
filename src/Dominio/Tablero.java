package Dominio;

/**
 * Clase que genera un tablero de damas en el cual se van a poner las respectivas fichas y casillas
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */

public class Tablero {
	private static Tablero instanceTablero;
	private Comodin infinity = new Infinity();
	private Comodin laser = new Laser();
	private Jugador jugador = new Jugador();
	private Casilla casillaVacia = new CasillaVacia();
	private Casilla mine = new Mine();
	private Casilla teleport = new Teleport();
	private Casilla jail = new Jail();
	private Ficha normal = new Normal();
	private Ficha reina = new Reina();
	private Ficha zombie = new Zombie();
	private Ficha ninja = new Ninja();
	private int x = 10;
	private int y = 10;
	private int numB = 4;
	private int numN = 4;
	char tablero[][] = new char[x][y];

	/**
	 * Constructor del tablero
	 */
	public Tablero(){
		for(int i=0;i<x;i++){
			for(int j=0; j<y; j++){
				tablero[i][j] = casillaVacia.getTipo();
				tablero[5][0] = teleport.getTipo();
				tablero[4][3] = mine.getTipo();
				tablero[1][8] = jail.getTipo();
				tablero[5][8] = infinity.getTipo();
				tablero[5][6] = infinity.getTipo();
				tablero[4][5] = infinity.getTipo();
			}
		}
		colocarFichas();
	}

	/**
	 * Método que pone las fichas en el tablero
	 */
	public void colocarFichas(){
		for(int i=x-1; i>=x-numB; i--){
			for(int j=0; j<y; j++){
				if((i%2==1 && j%2==0)||(i%2==0 && j%2==1))
					tablero[i][j] = normal.getTipo(1);
					tablero[6][7] = zombie.getTipo(1);
					tablero[6][9] = ninja.getTipo(1);
			}
		}
		for(int i=0; i<=numN-1; i++){
			for(int j=0; j<y; j++){
				if((i%2==1 && j%2==0)||(i%2==0 && j%2==1))
					tablero[i][j] = normal.getTipo(-1);
					//tablero[6][9] = reina.getTipo(-1);
			}
		}
		for(int i=0; i<x; i++){
			System.out.println(tablero[i]);
		}
	}

	/**
	 * Método que reinicia el tablero
	 */
	public void reiniciar(){
		for(int i=0;i<x;i++){
			for(int j=0; j<y; j++){
				tablero[i][j] = casillaVacia.getTipo();
				tablero[5][0] = teleport.getTipo();
				tablero[4][3] = mine.getTipo();
				tablero[1][8] = jail.getTipo();
				tablero[5][8] = infinity.getTipo();
				tablero[5][6] = infinity.getTipo();
				tablero[4][5] = infinity.getTipo();
			}
		}
		for(int i=x-1; i>=x-numB; i--){
			for(int j=0; j<y; j++){
				if((i%2==1 && j%2==0)||(i%2==0 && j%2==1))
					tablero[i][j] = normal.getTipo(1);
					//tablero[4][3] = reina.getTipo(1);
					tablero[6][7] = zombie.getTipo(1);
					tablero[6][9] = ninja.getTipo(1);
			}
		}
		for(int i=0; i<=numN-1; i++){
			for(int j=0; j<y; j++){
				if((i%2==1 && j%2==0)||(i%2==0 && j%2==1))
					tablero[i][j] = normal.getTipo(-1);
					//tablero[6][9] = reina.getTipo(-1);
			}
		}
	}

	/**
	 * Método que devuelve el tablero
	 * @return tablero donde se esta jugando
	 */
	public char [][]getTablero() { return tablero; }
	/**
	 * Método que devuelve el jugador
	 * @return juaador que tiene el tablero
	 */
	public Jugador getJugador()	{ return jugador; }

	/**
	 * Método que cambia la ficha de acuerdo a su tipo
	 * @param f fila donde esta la ficha
	 * @param c columna donde esta la ficha
	 * @param letra tipo de la ficha
	 */
	public void setFicha(int f, int c, char letra) { tablero[f][c]=letra; }
	/**
	 * Método que devuelve el valor de x
	 * @return se obtiene el valor de x
	 */
	public int getX(){
		return x;
	}
	/**
	 * Método que devuelve el valor de y
	 * @return se obtiene el valor de y
	 */
	public int getY(){
		return y;	
	}

	public static Tablero getInstanceTablero(){
		if(instanceTablero == null){
			instanceTablero = new Tablero();
		}
		return instanceTablero;
	}

	/**
	 * Método que imprime en consola la situación del tablero
	 */
	public void imprimir(){
		System.out.println(" ");
		for(int i=0; i<x; i++){
			System.out.println(tablero[i]);
		}
	}
	
}
