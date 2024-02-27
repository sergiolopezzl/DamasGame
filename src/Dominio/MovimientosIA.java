package Dominio;
/**
 * Esta clase define los movimientos que realiza la IA
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class MovimientosIA {
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

	/**
	 * Método que permite el movimiento de las fichas por part de la IA
	 * @param indentificador el número del jugador que puede ser la máquina(1 o -1)
	 */
    public void IA(int indentificador){
		//La Inteligencia Artificial--------------------------------
		turnoMaq=true;
		try{
			while(obligatorioComerFicha(indentificador) || obligatorioComerReina(indentificador)){
				if(obligatorioComerFicha(indentificador)){
					Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
                    Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaM, columnaM, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, normal.getTipo(indentificador));
					if(filaF==0 && indentificador == 1)
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					if(filaF==x-1 && indentificador == -1)
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
				}
				else if(obligatorioComerReina(indentificador)){
					Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaM, columnaM, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
				}
				turnoMaq=false;
			}
				if(mover(indentificador) && turnoMaq){
					Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, normal.getTipo(indentificador));
					if(filaF==0 && indentificador == 1)
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
					if(filaF==x-1 && indentificador == -1)
						Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
				}
				else if(moverReina(indentificador) && turnoMaq){
					Tablero.getInstanceTablero().setFicha(filaI, columnaI, casillaVacia.getTipo());
					Tablero.getInstanceTablero().setFicha(filaF, columnaF, reina.getTipo(indentificador));
				}
				turnoMaq=false;
		}catch (ArrayIndexOutOfBoundsException ex){}
	}
	/**
	 * Método que valida si es obligatorio o no comer una ficha
	 * @param indentificador el número del jugador que puede ser la máquina(1 o -1)
	 * @return  valor booleano de si es obligatorio comer una ficha
	 */
	private boolean obligatorioComerFicha(int indentificador){
		for(int i=0; i<x; i++){
			for(int j=0; j<x; j++){
				try{
					if(jugador.comer(i, j, i-(1*indentificador), j-(1*indentificador), i-(2*indentificador), j-(2*indentificador), Tablero.getInstanceTablero().getTablero(),indentificador)){
						filaI=i;
						columnaI=j;
						filaM=i-(1*indentificador);
						columnaM=j-(1*indentificador);
						filaF=i-(2*indentificador);
						columnaF=j-(2*indentificador);
						return true;
					}
				}catch (ArrayIndexOutOfBoundsException ex){}
				try{
					if(jugador.comer(i,j,i-(1*indentificador),j+(1*indentificador),i-(2*indentificador),j+(2*indentificador),Tablero.getInstanceTablero().getTablero(),indentificador)){
						filaI=i;
						columnaI=j;
						filaM=i-(1*indentificador);
						columnaM=j+(1*indentificador);
						filaF=i-(2*indentificador);
						columnaF=j+(2*indentificador);
						return true;
					}

				}catch (ArrayIndexOutOfBoundsException ex){}
			}
		}
		return false;
	}

	/**
	 * Método que valida si es obligatorio o no comer para una ficha de tipo reina
	 * @param indentificador el número del jugador que puede ser la máquina(1 o -1)
	 * @return  valor booleano de si es obligatorio comer para una ficha de tipo reina
	 */
	private boolean obligatorioComerReina(int indentificador){
		for(int i=0; i<x; i++){
			for(int j=0; j<x; j++){
				try{
					if(jugador.comerReina(i,j,i+(1*indentificador),j-(1*indentificador),i+(2*indentificador),j-(2*indentificador),Tablero.getInstanceTablero().getTablero(),indentificador)){
						filaI=i;
						columnaI=j;
						filaM=i+(1*indentificador);
						columnaM=j-(1*indentificador);
						filaF=i+(2*indentificador);
						columnaF=j-(2*indentificador);
						return true;
					}
				}catch (ArrayIndexOutOfBoundsException ex){}
				try{
					if(jugador.comerReina(i,j,i+(1*indentificador),j+(1*indentificador),i+(2*indentificador),j+(2*indentificador),Tablero.getInstanceTablero().getTablero(),indentificador)){
						filaI=i;
						columnaI=j;
						filaM=i+(1*indentificador);
						columnaM=j+(1*indentificador);
						filaF=i+(2*indentificador);
						columnaF=j+(2*indentificador);
						return true;
					}
				}catch (ArrayIndexOutOfBoundsException ex){}
				try{
					if(jugador.comerReina(i,j,i-(1*indentificador),j+(1*indentificador),i-(2*indentificador),j+(2*indentificador),Tablero.getInstanceTablero().getTablero(),indentificador)){
						filaI=i;
						columnaI=j;
						filaM=i-(1*indentificador);
						columnaM=j+(1*indentificador);
						filaF=i-(2*indentificador);
						columnaF=j+(2*indentificador);
						return true;
					}
				}catch (ArrayIndexOutOfBoundsException ex){}
				try{
					if(jugador.comerReina(i,j,i-(1*indentificador),j-(1*indentificador),i-(2*indentificador),j-(2*indentificador),Tablero.getInstanceTablero().getTablero(),indentificador)){
						filaI=i;
						columnaI=j;
						filaM=i-(1*indentificador);
						columnaM=j-(1*indentificador);
						filaF=i-(2*indentificador);
						columnaF=j-(2*indentificador);
						return true;
					}
				}catch (ArrayIndexOutOfBoundsException ex){}
			}
		}
		return false;
	}
	/**
	 * Método que valida si es posible o no moverse
	 * @param indentificador el número del jugador que puede ser la máquina(1 o -1)
	 * @return  valor booleano de si se puede o no mover
	 */
	private boolean mover(int indentificador){
		for(int i=0; i<x; i++){
			for(int j=0; j<x; j++){
				try{
					if(jugador.mover(i, j, i-(1*indentificador), j-(1*indentificador), Tablero.getInstanceTablero().getTablero(),indentificador)){
						filaI=i;
						columnaI=j;
						filaF=i-(1*indentificador);
						columnaF=j-(1*indentificador);
						return true;
					}
				}catch (ArrayIndexOutOfBoundsException ex){}
				try{
					if(jugador.mover(i,j,i-(1*indentificador),j+(1*indentificador),Tablero.getInstanceTablero().getTablero(),indentificador)){
						filaI=i;
						columnaI=j;
						filaF=i-(1*indentificador);
						columnaF=j+(1*indentificador);
						return true;
					}
				}catch (ArrayIndexOutOfBoundsException ex){}
			}
		}
		return false;
	}
	/**
	 * Método que valida si es posible o no moverse con una ficha tipo reina
	 * @param indentificador el número del jugador que puede ser la máquina(1 o -1)
	 * @return  valor booleano de si se puede o no mover con una ficha tipo reina
	 */
	private boolean moverReina(int indentificador){
		for(int i=0; i<x; i++){
			for(int j=0; j<x; j++){
				try{
					if(jugador.moverReina(i,j,i+(1*indentificador),j-(1*indentificador),Tablero.getInstanceTablero().getTablero(),indentificador)){
						filaI=i;
						columnaI=j;
						filaF=i+(1*indentificador);
						columnaF=j-(1*indentificador);
						return true;
					}
				}catch (ArrayIndexOutOfBoundsException ex){}
				try{
					if(jugador.moverReina(i,j,i+(1*indentificador),j+(1*indentificador),Tablero.getInstanceTablero().getTablero(),indentificador)){
						filaI=i;
						columnaI=j;
						filaF=i+(1*indentificador);
						columnaF=j+(1*indentificador);
						return true;
					}
				}catch (ArrayIndexOutOfBoundsException ex){}
				try{
					if(jugador.moverReina(i,j,i-(1*indentificador),j+(1*indentificador),Tablero.getInstanceTablero().getTablero(),indentificador)){
						filaI=i;
						columnaI=j;
						filaF=i-(1*indentificador);
						columnaF=j+(1*indentificador);
						return true;
					}
				}catch (ArrayIndexOutOfBoundsException ex){}
				try{
					if(jugador.moverReina(i,j,i-(1*indentificador),j-(1*indentificador),Tablero.getInstanceTablero().getTablero(),indentificador)){
						filaI=i;
						columnaI=j;
						filaF=i-(1*indentificador);
						columnaF=j-(1*indentificador);
						return true;
					}
				}catch (ArrayIndexOutOfBoundsException ex){}
			}
		}
		return false;
	}

}
