package Dominio;

import Presentacion.MenuEscogerFichaEspecial;

/**
 * Esta clase define los movimientos que se realizan con las fichas
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class Movimientos {
    Jugador jugador = new Jugador();
    private Comodin infinity = new Infinity();
	private Comodin laser = new Laser();
	private Casilla casillaVacia = new CasillaVacia();
	private Casilla mine = new Mine();
	private Casilla teleport = new Teleport();
	private Casilla jail = new Jail();
	private Ficha normal = new Normal();
	private Ficha reina = new Reina();
	private Ficha ninja = new Ninja();
	private Ficha zombie = new Zombie();
	int x = Tablero.getInstanceTablero().getX();
    int y = Tablero.getInstanceTablero().getY();
    boolean turnoJug=false, hacomido=false, hacomidoNegro=false;
    String  movimiento;

	/**
	 * Método que permite la validación del movimiento de una ficha
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 * @return valida si el se pude o no mover una ficha
	 */
    public boolean moverFicha(int filaI, int columnaI, int filaF, int columnaF, int indentificador){
		try{
			if(jugador.mover(filaI, columnaI, filaF, columnaF, Tablero.getInstanceTablero().getTablero(),indentificador)){
				return true;
			}
		}catch (ArrayIndexOutOfBoundsException ex){}
		return false;
	}

	/**
	 * Método que permite la validación del movimiento de una ficha tipo zombie
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 * @return valida si el se pude o no mover una ficha de tipo zombie
	 */
	public boolean moverZombie(int filaI, int columnaI, int filaF, int columnaF, int indentificador){
		try{
			if(jugador.moverZombie(filaI, columnaI, filaF, columnaF, Tablero.getInstanceTablero().getTablero(),indentificador)){
				return true;
			}
		}catch (ArrayIndexOutOfBoundsException ex){}
		return false;
	}

	/**
	 * Método que permite la validación del movimiento de una ficha tipo ninja
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 * @return valida si el se pude o no mover una ficha tipo ninja
	 */
	public boolean moverNinja(int filaI, int columnaI, int filaF, int columnaF, int indentificador){
		try{
			if(jugador.moverNinja(filaI, columnaI, filaF, columnaF, Tablero.getInstanceTablero().getTablero(),indentificador)){
				return true;
			}
		}catch (ArrayIndexOutOfBoundsException ex){}
		return false;
	}

	/**
	 * Método que permite la validación del movimiento de una ficha tipo reina
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 * @return valida si el se pude o no mover una ficha tipo reina
	 */
	public boolean moverReina(int filaI, int columnaI, int filaF, int columnaF, int indentificador){
		try{
			if(jugador.moverReina(filaI, columnaI, filaF, columnaF, Tablero.getInstanceTablero().getTablero(),indentificador)){
				return true;
			}
		}catch (ArrayIndexOutOfBoundsException ex){}
		return false;
	}

	/**
	 * Método que permite la validación de si se puede o no comer una ficha
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaM fila en donde se encuentra la ficha a comer
	 * @param columnaM columna donde se encuentra la ficha a comer
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 * @return valida si el se pude o no comer una ficha
	 */
	public boolean comerFicha(int filaI, int columnaI, int filaM, int columnaM, int filaF, int columnaF, int indentificador){
		try{
			if(jugador.comer(filaI, columnaI, filaM, columnaM, filaF, columnaF, Tablero.getInstanceTablero().getTablero(),indentificador))
				return true;
		}catch (ArrayIndexOutOfBoundsException ex){}
		return false;
	}

	/**
	 * Método que permite la validación de si  una ficha tipo zombie se puede o no comer una ficha
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaM fila en donde se encuentra la ficha a comer
	 * @param columnaM columna donde se encuentra la ficha a comer
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 * @return valida si el se pude o no comer una ficha
	 */
	public boolean comerZombie(int filaI, int columnaI, int filaM, int columnaM, int filaF, int columnaF, int indentificador){
		try{
			if(jugador.comerZombie(filaI, columnaI, filaM, columnaM, filaF, columnaF, Tablero.getInstanceTablero().getTablero(),indentificador))
				return true;
		}catch (ArrayIndexOutOfBoundsException ex){}
		return false;
	}

	/**
	 * Método que permite la validación de si  una ficha tipo ninja se puede o no comer una ficha
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaM fila en donde se encuentra la ficha a comer
	 * @param columnaM columna donde se encuentra la ficha a comer
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 * @return valida si el se pude o no comer una ficha
	 */
	public boolean comerNinja(int filaI, int columnaI, int filaM, int columnaM, int filaF, int columnaF, int indentificador){
		try{
			if(jugador.comerNinja(filaI, columnaI, filaM, columnaM, filaF, columnaF, Tablero.getInstanceTablero().getTablero(),indentificador))
				return true;
		}catch (ArrayIndexOutOfBoundsException ex){}
		return false;
	}

	/**
	 * Método que permite la validación de si  una ficha tipo reina se puede o no comer una ficha
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaM fila en donde se encuentra la ficha a comer
	 * @param columnaM columna donde se encuentra la ficha a comer
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 * @return valida si el se pude o no comer una ficha
	 */
	public boolean comerReina(int filaI, int columnaI, int filaM, int columnaM, int filaF, int columnaF, int indentificador){
		try{
			if(jugador.comerReina(filaI, columnaI, filaM, columnaM, filaF, columnaF, Tablero.getInstanceTablero().getTablero(),indentificador))
					return true;
		}catch (ArrayIndexOutOfBoundsException ex){}
		return false;
	}

	/**
	 * Metodo que valida si es obligatorio o no comer una ficha
	 * @param indentificador
	 * @return comer El booleano de si es obligatorio o no comer
	 */
	public boolean obligatorioComer(int indentificador){
		boolean comer = false;
		for(int i=0; i<x; i++){
			for(int j=0; j<y; j++){
				try{
					if((comerFicha(i,j, i-(1*indentificador), j+(1*indentificador), i-(2*indentificador),j+(2*indentificador),indentificador) 
							|| comerFicha(i,j,i-(1*indentificador),j-(1*indentificador),i-(2*indentificador),j-(2*indentificador),indentificador)
							|| comerReina(i,j, i-(1*indentificador), j+(1*indentificador), i-(2*indentificador),j+(2*indentificador),indentificador) 
							|| comerReina(i,j,i-(1*indentificador),j-(1*indentificador),i-(2*indentificador),j-(2*indentificador),indentificador)
							|| comerReina(i,j,i+(1*indentificador),j-(1*indentificador),i+(2*indentificador),j-(2*indentificador),indentificador) 
							|| comerReina(i,j,i+(1*indentificador),j+(1*indentificador),i+(2*indentificador),j+(2*indentificador),indentificador)) && (!turnoJug)){
						comer   = true;
					}
				}catch (ArrayIndexOutOfBoundsException ex){}
			}
		}
		return comer;
	}
	/**
	 * Metodo que valida si una ficha sigue o no comiendo
	 * @param indentificador
	 * @return comer El booleano de si puede o no seguir comiendo
	 */
	public boolean sigueComiendo(int i, int j, int indentificador){
		
				try{
					if((comerFicha(i,j, i-(1*indentificador), j+(1*indentificador), i-(2*indentificador),j+(2*indentificador),indentificador) 
							|| comerFicha(i,j,i-(1*indentificador),j-(1*indentificador),i-(2*indentificador),j-(2*indentificador),indentificador)
							|| comerReina(i,j, i-(1*indentificador), j+(1*indentificador), i-(2*indentificador),j+(2*indentificador),indentificador) 
							|| comerReina(i,j,i-(1*indentificador),j-(1*indentificador),i-(2*indentificador),j-(2*indentificador),indentificador)
							|| comerReina(i,j,i+(1*indentificador),j-(1*indentificador),i+(2*indentificador),j-(2*indentificador),indentificador) 
							|| comerReina(i,j,i+(1*indentificador),j+(1*indentificador),i+(2*indentificador),j+(2*indentificador),indentificador)) && (hacomido)){
						return true;
					}
				}catch (ArrayIndexOutOfBoundsException ex){}
			
		return false;
	}

	/**
	 * Metodo que valida los turnos
	 * @return el resultado de si es o no el turno de jugador
	 */
	public boolean turno(){
		boolean res = false;
		if(!turnoJug){
			res = true;
		}else{
			res = false;
		}
		return res;
	}

	/**
	 * Metodo que permite jugar a la ficha
	 * @param filaI fila de origen de la ficha
	 * @param columnaI columna de origen de la ficha
	 * @param filaF fila de destino de la ficha
	 * @param columnaF columna de destino de la ficha
	 * @param indentificador (1 o -1) identifica al jugador 1 o jugador 2
	 */
	public void jugar(int filaI, int columnaI, int filaF, int columnaF, int indentificador){
        //--MOVER (FICHA O DAMA)-------------------
        if(!obligatorioComer(indentificador)){
            if(moverFicha(filaI, columnaI, filaF, columnaF,indentificador)){
                Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
                Tablero.getInstanceTablero().setFicha(filaF, columnaF, normal.getTipo(indentificador));
                if(filaF==0 && indentificador == 1){
                    MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
                    Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
                }else if(filaF==9 && indentificador == -1){
					MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
				} 
                turnoJug=true;
            }
            else if(moverReina(filaI, columnaI, filaF, columnaF,indentificador)){
                Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
                Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
                if(filaF==0 && indentificador == 1){
                    MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
                    Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
                }else if(filaF==9 && indentificador == -1){
					MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
				} 
                turnoJug=true;
            }else if(moverZombie(filaI, columnaI, filaF, columnaF,indentificador)){
                Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
                Tablero.getInstanceTablero().setFicha(filaF, columnaF, zombie.getTipo(indentificador));
                if(filaF==0 && indentificador == 1){
                    MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
                    Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
                }else if(filaF==9 && indentificador == -1){
					MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
				} 
                turnoJug=true;
            }else if(moverNinja(filaI, columnaI, filaF, columnaF,indentificador)){
                Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
                Tablero.getInstanceTablero().setFicha(filaF, columnaF, ninja.getTipo(indentificador));
                if(filaF==0 && indentificador == 1){
                    MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
                    Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
                }else if(filaF==9 && indentificador == -1){
					MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
				} 
                turnoJug=true;
            }
            else
			
                movimiento=null;
        }
        //--COMER (FICHA O DAMA)-------------------
        else if(obligatorioComer(indentificador)){
            if(comerFicha(filaI, columnaI, filaI-(1*indentificador), columnaI-(1*indentificador), filaF, columnaF,indentificador)){
				if(columnaF==columnaI-(2*indentificador)){
					Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaI-(1*indentificador), columnaI-(1*indentificador), casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, normal.getTipo(indentificador));
					if(filaF==0 && indentificador == 1){
						MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					}else if(filaF==9 && indentificador == -1){
						MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					} 
					turnoJug=true;
					hacomido=true;
				}
			}
			if(comerFicha(filaI, columnaI, filaI-(1*indentificador), columnaI+(1*indentificador), filaF, columnaF,indentificador)){
				if(columnaF==columnaI+(2*indentificador)){
					Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaI-(1*indentificador), columnaI+(1*indentificador), casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, normal.getTipo(indentificador));
					if(filaF==0 && indentificador == 1){
						MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					}else if(filaF==9 && indentificador == -1){
						MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					}                         
					turnoJug=true;
					hacomido=true;
				}
			}
			if(comerZombie(filaI, columnaI, filaI-(1*indentificador), columnaI-(1*indentificador), filaF, columnaF,indentificador)){
				if(columnaF==columnaI-(2*indentificador)){
					Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaI-(1*indentificador), columnaI-(1*indentificador), casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, zombie.getTipo(indentificador));
					if(filaF==0 && indentificador == 1){
						MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					}else if(filaF==9 && indentificador == -1){
						MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					} 
					turnoJug=true;
					hacomido=true;
				}
			}
			if(comerZombie(filaI, columnaI, filaI-(1*indentificador), columnaI+(1*indentificador), filaF, columnaF,indentificador)){
				if(columnaF==columnaI+(2*indentificador)){
					Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaI-(1*indentificador), columnaI+(1*indentificador), casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, zombie.getTipo(indentificador));
					if(filaF==0 && indentificador == 1){
						MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					}else if(filaF==9 && indentificador == -1){
						MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					}                         
					turnoJug=true;
					hacomido=true;
				}
			}
			if(comerNinja(filaI, columnaI, filaI-(1*indentificador), columnaI-(1*indentificador), filaF, columnaF,indentificador)){
				if(columnaF==columnaI-(2*indentificador)){
					Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaI-(1*indentificador), columnaI-(1*indentificador), casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, ninja.getTipo(indentificador));
					if(filaF==0 && indentificador == 1){
						MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					}else if(filaF==9 && indentificador == -1){
						MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					} 
					turnoJug=true;
					hacomido=true;
				}
			}
			if(comerNinja(filaI, columnaI, filaI-(1*indentificador), columnaI+(1*indentificador), filaF, columnaF,indentificador)){
				if(columnaF==columnaI+(2*indentificador)){
					Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaI-(1*indentificador), columnaI+(1*indentificador), casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, ninja.getTipo(indentificador));
					if(filaF==0 && indentificador == 1){
						MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					}else if(filaF==9 && indentificador == -1){
						MenuEscogerFichaEspecial menu = new MenuEscogerFichaEspecial();
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					}                         
					turnoJug=true;
					hacomido=true;
				}
			}
			if(comerReina(filaI, columnaI, filaI-(1*indentificador), columnaI-(1*indentificador), filaF, columnaF,indentificador)){
				if(columnaF==columnaI-(2)){
					Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaI-(1), columnaI-(1), casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					turnoJug=true;
					hacomido=true;
				}
			}
			if(comerReina(filaI, columnaI, filaI-(1*indentificador), columnaI+(1*indentificador), filaF, columnaF,indentificador)){
				if(columnaF==columnaI+(2)){
					Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaI-(1), columnaI+(1), casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					turnoJug=true;
					hacomido=true;
				}
			}
			if(comerReina(filaI, columnaI, filaI+(1*indentificador), columnaI+(1*indentificador), filaF, columnaF,indentificador)){
				if(columnaF==columnaI+(2)){
					Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaI+(1), columnaI+(1), casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					turnoJug=true;
					hacomido=true;
				}
			}
			if(comerReina(filaI, columnaI, filaI+(1*indentificador), columnaI-(1*indentificador), filaF, columnaF,indentificador)){
				if(columnaF==columnaI-(2)){
					Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaI+(1), columnaI-(1), casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					turnoJug=true;
					hacomido=true;
				}
			}
            
        }
        else{
            movimiento=null;
        }

        //--SISTEMA DE TURNOS---------------------------------------------
        if(sigueComiendo(filaF,columnaF,-1)){
            turnoJug=false;  
        }
        turnoJug=false;
        hacomido=false;
        hacomidoNegro=false;
	}
}
