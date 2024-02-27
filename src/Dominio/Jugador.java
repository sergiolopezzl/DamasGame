package Dominio;

/**
 * Clase que genera un jugador
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class Jugador{
	int filaI, columnaI, filaM, columnaM, filaF, columnaF;
	private Comodin infinity = new Infinity();
	private Comodin laser = new Laser();
	private Casilla casillaVacia = new CasillaVacia();
	private Casilla casillaMine = new Mine();
	private Casilla casillaTeleport = new Teleport();
	private Casilla casillaJail = new Jail();
	private Ficha normal = new Normal();
	private Ficha reina = new Reina();
	private Ficha ninja = new Ninja();
	private Ficha zombie = new Zombie();
	private int x = 10;
	private int y = 10;

	/**
	 * Constructor que genera un jugador
	 */
	public Jugador(){
		
	}

	/**
	 * Método que permite al jugador mover una ficha
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param tablero tablero de juego
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 * @return valida si el jugador puede mover la ficha
	 */
	public boolean mover(int filaI, int columnaI, int filaF, int columnaF, char tablero[][], int indentificador){ 
		int numero = (int)(Math.random()*50+1);
		boolean mueve = false;
		if(tablero[filaI][columnaI]==normal.getTipo(indentificador)	&& (filaF==filaI-(1*indentificador)
																	&& (columnaF==columnaI-(1) || columnaF==columnaI+(1)))){
					if(tablero[filaF][columnaF]==casillaVacia.getTipo()){
						this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
						mueve = true;
					}else if(tablero[filaF][columnaF]==casillaMine.getTipo()){
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF-1, columnaF-1, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF+1, columnaF-1, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF-1, columnaF+1, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF+1, columnaF+1, casillaVacia.getTipo());
						this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
						mueve = false;
					}else if(tablero[filaF][columnaF]==casillaTeleport.getTipo()){
						for (int i = 0; i <= numero; i++) {
							
						}
						Tablero.getInstanceTablero().setFicha(4, 9, normal.getTipo(indentificador));
						Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, casillaVacia.getTipo());
						System.out.println(numero);
						this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
						mueve = false;
					}else if(tablero[filaF][columnaF]==infinity.getTipo()){
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
						Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
						
						this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
						mueve = false;
					}else if(tablero[filaF][columnaF]==laser.getTipo()){
						for(int k = 0; k<10; k++){
							Tablero.getInstanceTablero().setFicha(filaF, columnaF, casillaVacia.getTipo());
							Tablero.getInstanceTablero().setFicha(filaF-k, columnaF-k, casillaVacia.getTipo());
							Tablero.getInstanceTablero().setFicha(filaF+k, columnaF-k, casillaVacia.getTipo());
							Tablero.getInstanceTablero().setFicha(filaF-k, columnaF+k, casillaVacia.getTipo());
							Tablero.getInstanceTablero().setFicha(filaF+k, columnaF+k, casillaVacia.getTipo());
						}
						this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
						mueve = false;
					}
		}
		return mueve;
	}

	/**
	 * Método que permite al jugador mover una ficha de tipo zombie
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param tablero tablero de juego
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 * @return valida si el jugador puede mover la ficha de tipo zombie
	 */
	public boolean moverZombie(int filaI, int columnaI, int filaF, int columnaF, char tablero[][], int indentificador){ 
		int numero = (int)(Math.random()*50+1);
		boolean mueve = false;
		if(tablero[filaI][columnaI]==zombie.getTipo(indentificador)	&& (filaF==filaI-(1*indentificador)
																	&& (columnaF==columnaI-(1) || columnaF==columnaI+(1)))){
					if(tablero[filaF][columnaF]==casillaVacia.getTipo()){
						this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
						mueve = true;
					}else if(tablero[filaF][columnaF]==casillaMine.getTipo()){
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF-1, columnaF-1, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF+1, columnaF-1, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF-1, columnaF+1, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF+1, columnaF+1, casillaVacia.getTipo());
						this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
						mueve = false;
					}else if(tablero[filaF][columnaF]==casillaTeleport.getTipo()){
						for (int i = 0; i <= numero; i++) {
							
						}
						Tablero.getInstanceTablero().setFicha(4, 9, normal.getTipo(indentificador));
						Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, casillaVacia.getTipo());
						System.out.println(numero);
						this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
						mueve = false;
					}else if(tablero[filaF][columnaF]==infinity.getTipo()){
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, normal.getTipo(indentificador));
						Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
						
						this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
						mueve = false;
					}else if(tablero[filaF][columnaF]==laser.getTipo()){
						for(int k = 0; k<10; k++){
							Tablero.getInstanceTablero().setFicha(filaF, columnaF, casillaVacia.getTipo());
							Tablero.getInstanceTablero().setFicha(filaF-k, columnaF-k, casillaVacia.getTipo());
							Tablero.getInstanceTablero().setFicha(filaF+k, columnaF-k, casillaVacia.getTipo());
							Tablero.getInstanceTablero().setFicha(filaF-k, columnaF+k, casillaVacia.getTipo());
							Tablero.getInstanceTablero().setFicha(filaF+k, columnaF+k, casillaVacia.getTipo());
						}
						this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
						mueve = false;
					}
		}
		return mueve;
	}

	/**
	 * Método que permite al jugador mover una ficha de tipo ninja
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param tablero tablero de juego
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 * @return valida si el jugador puede mover la ficha de tipo ninja
	 */
	public boolean moverNinja(int filaI, int columnaI, int filaF, int columnaF, char tablero[][], int indentificador){ 
		int numero = (int)(Math.random()*50+1);
		boolean mueve = false;
		if(tablero[filaI][columnaI]==ninja.getTipo(indentificador)	&& (filaF==filaI-(1*indentificador)
																	&& (columnaF==columnaI-(1) || columnaF==columnaI+(1)))){
					if(tablero[filaF][columnaF]==casillaVacia.getTipo()){
						this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
						mueve = true;
					}else if(tablero[filaF][columnaF]==casillaMine.getTipo()){
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF-1, columnaF-1, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF+1, columnaF-1, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF-1, columnaF+1, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF+1, columnaF+1, casillaVacia.getTipo());
						this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
						mueve = false;
					}else if(tablero[filaF][columnaF]==casillaTeleport.getTipo()){
						for (int i = 0; i <= numero; i++) {
							
						}
						Tablero.getInstanceTablero().setFicha(4, 9, normal.getTipo(indentificador));
						Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, casillaVacia.getTipo());
						System.out.println(numero);
						this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
						mueve = false;
					}else if(tablero[filaF][columnaF]==infinity.getTipo()){
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, ninja.getTipo(indentificador));
						Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
						
						this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
						mueve = false;
					}else if(tablero[filaF][columnaF]==laser.getTipo()){
						for(int k = 0; k<10; k++){
							Tablero.getInstanceTablero().setFicha(filaF, columnaF, casillaVacia.getTipo());
							Tablero.getInstanceTablero().setFicha(filaF-k, columnaF-k, casillaVacia.getTipo());
							Tablero.getInstanceTablero().setFicha(filaF+k, columnaF-k, casillaVacia.getTipo());
							Tablero.getInstanceTablero().setFicha(filaF-k, columnaF+k, casillaVacia.getTipo());
							Tablero.getInstanceTablero().setFicha(filaF+k, columnaF+k, casillaVacia.getTipo());
						}
						this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
						mueve = false;
					}
		}
		return mueve;
	}

	/**
	 * Método que permite al jugador comer una ficha
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaM fila en donde se encuentra la ficha a comer
	 * @param columnaM columna donde se encuentra la ficha a comer
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param tablero tablero de juego
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 * @return valida si el jugador puede o no comer la ficha
	 */
	public boolean comer(int filaI, int columnaI, int filaM, int columnaM, int filaF, int columnaF, char tablero[][], int indentificador){
		boolean comer = false;
		
		if(tablero[filaI][columnaI]==normal.getTipo(indentificador) && 
				((tablero[filaM][columnaM]==normal.getTipo(-(indentificador)) || 
				tablero[filaM][columnaM]==reina.getTipo(-(indentificador)) ||
				tablero[filaM][columnaM]==zombie.getTipo(-(indentificador)) ||
				tablero[filaM][columnaM]==ninja.getTipo(-(indentificador)))
						&& (filaM==filaI-(1*indentificador) & (columnaM==columnaI-(1) || columnaM==columnaI+(1)))
						&& (tablero[filaF][columnaF]==casillaVacia.getTipo()||tablero[filaF][columnaF]==casillaJail.getTipo() ||
						tablero[filaF][columnaF]==casillaMine.getTipo()|| tablero[filaF][columnaF]==casillaTeleport.getTipo() ||
						tablero[filaF][columnaF]==infinity.getTipo() || tablero[filaF][columnaF]==laser.getTipo())) && (filaF==filaI-(2*indentificador) && (columnaF==columnaI-(2*indentificador) || columnaF==columnaI+(2*indentificador)))){
			this.filaI=filaI; this.columnaI=columnaI; this.filaM=filaM; this.columnaM=columnaM; this.filaF=filaF; this.columnaF=columnaF;
			comer = true;
		}
		return comer;
	}
	/**
	 * Método que permite al jugador comer con una ficha tipo zombie
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaM fila en donde se encuentra la ficha a comer
	 * @param columnaM columna donde se encuentra la ficha a comer
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param tablero tablero de juego
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 * @return valida si el jugador puede o no comer con la ficha tipo zombie
	 */
	public boolean comerZombie(int filaI, int columnaI, int filaM, int columnaM, int filaF, int columnaF, char tablero[][], int indentificador){
		boolean comer = false;
		if(tablero[filaI][columnaI]==zombie.getTipo(indentificador) && 
				((tablero[filaM][columnaM]==normal.getTipo(-(indentificador)) || 
				tablero[filaM][columnaM]==reina.getTipo(-(indentificador)) ||
				tablero[filaM][columnaM]==zombie.getTipo(-(indentificador)) ||
				tablero[filaM][columnaM]==ninja.getTipo(-(indentificador)) )
						&& (filaM==filaI-(1*indentificador) & (columnaM==columnaI-(1) || columnaM==columnaI+(1)))
						&& (tablero[filaF][columnaF]==casillaVacia.getTipo()||tablero[filaF][columnaF]==casillaJail.getTipo() ||
						tablero[filaF][columnaF]==casillaMine.getTipo()|| tablero[filaF][columnaF]==casillaTeleport.getTipo() ||
						tablero[filaF][columnaF]==infinity.getTipo() || tablero[filaF][columnaF]==laser.getTipo())) && (filaF==filaI-(2*indentificador) && (columnaF==columnaI-(2*indentificador) || columnaF==columnaI+(2*indentificador)))){
			this.filaI=filaI; this.columnaI=columnaI; this.filaM=filaM; this.columnaM=columnaM; this.filaF=filaF; this.columnaF=columnaF;
			comer = true;
		}
		return comer;
	}
	/**
	 * Método que permite al jugador comer con una ficha tipo ninja
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaM fila en donde se encuentra la ficha a comer
	 * @param columnaM columna donde se encuentra la ficha a comer
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param tablero tablero de juego
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 * @return valida si el jugador puede o no comer con la ficha tipo ninja
	 */
	public boolean comerNinja(int filaI, int columnaI, int filaM, int columnaM, int filaF, int columnaF, char tablero[][], int indentificador){
		boolean comer = false;
		
		if(tablero[filaI][columnaI]==ninja.getTipo(indentificador) && 
				((tablero[filaM][columnaM]==normal.getTipo(-(indentificador)) || 
				tablero[filaM][columnaM]==reina.getTipo(-(indentificador)) ||
				tablero[filaM][columnaM]==zombie.getTipo(-(indentificador)) ||
				tablero[filaM][columnaM]==ninja.getTipo(-(indentificador)))
						&& (filaM==filaI-(1*indentificador) & (columnaM==columnaI-(1) || columnaM==columnaI+(1)))
						&& (tablero[filaF][columnaF]==casillaVacia.getTipo()||tablero[filaF][columnaF]==casillaJail.getTipo() ||
						tablero[filaF][columnaF]==casillaMine.getTipo()|| tablero[filaF][columnaF]==casillaTeleport.getTipo() ||
						tablero[filaF][columnaF]==infinity.getTipo() || tablero[filaF][columnaF]==laser.getTipo())) && (filaF==filaI-(2*indentificador) && (columnaF==columnaI-(2*indentificador) || columnaF==columnaI+(2*indentificador)))){
			this.filaI=filaI; this.columnaI=columnaI; this.filaM=filaM; this.columnaM=columnaM; this.filaF=filaF; this.columnaF=columnaF;
			comer = true;
		}
		return comer;
	}

	/**
	 * Método que permite al jugador mover una ficha de tipo reina
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param tablero tablero de juego
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 * @return valida si el jugador puede o no mover la ficha de tipo reina
	 */
	public boolean moverReina(int filaI, int columnaI, int filaF, int columnaF, char tablero[][], int indentificador){
		
		boolean mover = false;
		for(int i = 0;i<10;i++){
			if(tablero[filaI][columnaI]==reina.getTipo(indentificador) && ((filaF==filaI+(i) || filaF==filaI-(i)) 
																		&& (columnaF==columnaI-(i) || columnaF==columnaI+(i)))){

				if(tablero[filaF][columnaF]==casillaVacia.getTipo()){
					this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
					mover = true;
				}else if(tablero[filaF][columnaF]==casillaMine.getTipo()){
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF-1, columnaF-1, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF+1, columnaF-1, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF-1, columnaF+1, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF+1, columnaF+1, casillaVacia.getTipo());
					this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
					mover = false;

				}else if(tablero[filaF][columnaF]==casillaTeleport.getTipo()){
					
					Tablero.getInstanceTablero().setFicha(4, 9, normal.getTipo(indentificador));
					Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, casillaVacia.getTipo());
					System.out.println();
					this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
					mover = false;
				}else if(tablero[filaF][columnaF]==laser.getTipo()){
					for(int k = 0; k<10; k++){
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF-k, columnaF-k, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF+k, columnaF-k, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF-k, columnaF+k, casillaVacia.getTipo());
						Tablero.getInstanceTablero().setFicha(filaF+k, columnaF+k, casillaVacia.getTipo());
					}
					this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
					mover = false;
				}
				else if(tablero[filaF][columnaF]==infinity.getTipo()){
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, laser.getTipo());
					Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
					
					this.filaI=filaI; this.columnaI=columnaI; this.filaF=filaF; this.columnaF=columnaF;
					mover = false;
				}
			}
			
		}
		return mover;
	}

	/**
	 * Método que permite al jugador comer con una ficha tipo reina
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaM fila en donde se encuentra la ficha a comer
	 * @param columnaM columna donde se encuentra la ficha a comer
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param tablero tablero de juego
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 * @return valida si el jugador puede o no comer con la ficha tipo reina
	 */
	public boolean comerReina(int filaI, int columnaI, int filaM, int columnaM, int filaF, int columnaF, char tablero[][], int indentificador){
		boolean comer = false;
		for(int i = 0;i<10;i++){
			if(tablero[filaI][columnaI]==reina.getTipo(indentificador) && 
				((tablero[filaM][columnaM]==normal.getTipo(-(indentificador)) || 
				tablero[filaM][columnaM]==reina.getTipo(-(indentificador)) ||
				tablero[filaM][columnaM]==zombie.getTipo(-(indentificador)) ||
				tablero[filaM][columnaM]==ninja.getTipo(-(indentificador)))
								&& ((filaM==filaI+(i) || filaM==filaI-(i)) & (columnaM==columnaI-(i) || columnaM==columnaI+(i)))
								&& (tablero[filaF][columnaF]==casillaVacia.getTipo()||tablero[filaF][columnaF]==casillaJail.getTipo() ||
								tablero[filaF][columnaF]==casillaMine.getTipo()|| tablero[filaF][columnaF]==casillaTeleport.getTipo() ||
								tablero[filaF][columnaF]==infinity.getTipo() || tablero[filaF][columnaF]==laser.getTipo())) && ((filaF==filaI+(2) || filaF==filaI-(2)) && (columnaF==columnaI-(2) || columnaF==columnaI+(2)))){
				this.filaI=filaI; this.columnaI=columnaI; this.filaM=filaM; this.columnaM=columnaM; this.filaF=filaF; this.columnaF=columnaF;
				comer = true;
			}
		}
		return comer;
	}
}
