package Presentacion;
import Dominio.*;
import Presentacion.Principal.Fondo;
import Presentacion.Principal.PanelInicio;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.BevelBorder;


/**
 * Esta clase pinta el tablero del juego de Damas
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class Principal extends JFrame implements ActionListener{

    private static Principal instancePrincipal;
    private static ArrayList<String> nombres = new ArrayList<String>();
    private static ArrayList<String> colores = new ArrayList<String>();
    private final JLabel ficha1 = new JLabel();
    private JLabel ficha2 = new JLabel();
    private JLabel jugador1 = new JLabel();
    private JLabel jugador2 = new JLabel();
    private JMenuBar barraDeMenu;
    private JMenu opciones;
    private JMenuItem abrir, salir, guardar, nuevo;
    private JFileChooser seleccionarArchivo;
    private JPanel panel = new JPanel();
    private DatosTablero datosTablero;
    private GridBagLayout gridbag = new GridBagLayout();
    private GridBagConstraints cons = new GridBagConstraints();
    private GridBagLayout gridbagSur = new GridBagLayout();
    private BorderLayout border = new BorderLayout();
    private Fondo fondo = new Fondo();
    private PanelInicio pantallaInicio = new PanelInicio();
    private String [] mensaje = {"Blancas juegan","Negras juegan",
						"Obligatorio comer", "Blancas ganan",
						"Negras ganan", "Terminada en tablas",
						"Ha rechazado las tablas"};
    private JLabel mensajeL = new JLabel();
    private JLabel informacionJuego = new JLabel();
    private JLabel fichasblancasL = new JLabel();
    private JLabel fichasnegrasL = new JLabel();
    private JLabel contablancasL = new JLabel();
    private JLabel contanegrasL = new JLabel();
    private JPanel panelSur = new JPanel();
    private JPanel panelNorte = new JPanel();
    private JPanel panelDerecho = new JPanel(new GridLayout(2,1));
    private JPanel infoJuego = new JPanel();
    private JButton empezar = new JButton();
    private JButton tablas = new JButton();
    private JOptionPane dialogo = new JOptionPane();
    private Font fuente = new Font("Arial",Font.BOLD,12);
    private int contB=0, contN=0;


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            // Crear la instancia de la clase Principal y hacerla visible
            Principal principal = new Principal();
            principal.setVisible(true);
        });
    }


    /**
     * Este constructor crea el tablero con sus fichas y datos del jugador o jugadores
     * @param nombres lista de los nombres de los jugadores.
     * @param colores lista de los colores de las fichas escogidas por los jugadores.
     */
    public Principal(ArrayList<String> nombres, ArrayList colores){
        super("DAMAS");
        this.nombres = nombres;
        this.colores = colores;
        prepareElementoTablero();
        prepareActionsMenu();
        panelEstadisticas();
        setLocationRelativeTo(null);
        instancePrincipal = this;
    }

    /**
     * Este constructor pinta la pantalla inicial del juego sin fichas ni datos del jugador
     */
    public Principal() {
        super("DAMAS");
        panelDeInicio();
        prepareActionsMenu();
        setLocationRelativeTo(null);
    }


    public static Principal getInstancePrincipal() {
        if (getInstancePrincipal() == null) {
            instancePrincipal = new Principal();
        }
        return instancePrincipal;
    }

    /**
     * Este metodo pinta el tablero de Damas sin fichas y lo pone en el centro de la pantalla
     */
	public void prepareElementoTablero(){
        Grafica Presentacion = new Grafica(colores);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (pantalla.height)/ 4;
        int width = (pantalla.width) / 4;
        setBounds(width, height, 900,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel);
        panel.setLayout(border);
        panel.add(fondo, BorderLayout.CENTER);
        fondo.setLayout(gridbag);
        fondo.add(Presentacion);
        panelNorte();
        prepareElementsMenu();
        setVisible(true);
    }

    /**
     * Este metodo pinta el tablero de Damas con fichas y lo pone en el centro de la pantalla
     */
    public void panelDeInicio(){
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (pantalla.height)/ 4;
        int width = (pantalla.width) / 4;
        setBounds(width, height, 900,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel);
        panel.setLayout(border);
        panel.add(fondo, BorderLayout.CENTER);
        fondo.setLayout(gridbag);
        fondo.add(pantallaInicio);
        panelNorte();
        prepareElementsMenu();
        setVisible(true);
    }

    /**
     * Este metodo pinta la parte susperior del tablero en donde se ubican los botones para empezar una nueva partida
     */
    public void panelNorte(){
		panelNorte.add(empezar);
		panelNorte.add(tablas);
		empezar.addActionListener(this);
		tablas.addActionListener(this);
		panelNorte.setBackground(Color.DARK_GRAY);
		empezar.setIcon(new ImageIcon(getClass().getResource("images/nuevoj.png")));
		empezar.setRolloverIcon(new ImageIcon(getClass().getResource("images/nuevojr.png")));
		empezar.setFocusPainted(false);
		empezar.setBorderPainted(false);
		empezar.setContentAreaFilled(false);
		tablas.setIcon(new ImageIcon(getClass().getResource("images/tablas.png")));
		tablas.setRolloverIcon(new ImageIcon(getClass().getResource("images/tablasr.png")));
		tablas.setFocusPainted(false);
		tablas.setBorderPainted(false);
		tablas.setContentAreaFilled(false);
		panel.add(panelNorte, BorderLayout.NORTH);
	}

    /**
     * Este metodo pinta el panel de datos del jugador
     */
	public void panelEstadisticas(){
        panelDerecho.add(panelSur);
        panelSur.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        JPanel juga1 = new JPanel(new GridLayout(4,1));
        juga1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        JPanel juga2 = new JPanel(new GridLayout(4,1));
        juga2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        juga1.setBackground(Color.DARK_GRAY);
        juga2.setBackground(Color.DARK_GRAY);
        panelSur.setLayout(new GridLayout(1,2));
        panelSur.add(juga1);
        panelSur.add(juga2);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(3, 3, 3, 3);

        //imagen de player1
        ficha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ficha1.setIcon(new ImageIcon(getClass().getResource("images/player1.png")));
        ficha1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        cons.gridx = 0;
        cons.gridy = 0;
        gridbagSur.setConstraints(ficha1, cons);
        juga1.add(ficha1);

        //imagen de player2
        ficha2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ficha2.setIcon(new ImageIcon(getClass().getResource("images/player2.png")));
        ficha2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        cons.gridx = 0;
        cons.gridy = 1;
        gridbagSur.setConstraints(ficha2, cons);
        juga2.add(ficha2);

        //Nombre Jugador1
        jugador1.setText(nombres.get(0));
        jugador1.setFont(new Font("Arial",Font.PLAIN,18));
        jugador1.setForeground(Color.WHITE);
        jugador1.setHorizontalAlignment(SwingConstants.CENTER);
        cons.gridx = 1;
        cons.gridy = 0;
        gridbagSur.setConstraints(jugador1, cons);
        juga1.add(jugador1);

        //Nombre Jugador2
        jugador2.setText(nombres.get(1));
        jugador2.setFont(new Font("Arial",Font.PLAIN,18));
        jugador2.setForeground(Color.WHITE);
        jugador2.setHorizontalAlignment(SwingConstants.CENTER);
        cons.gridx = 1;
        cons.gridy = 1;
        gridbagSur.setConstraints(jugador2, cons);
        juga2.add(jugador2);

        //Color jugador1
        fichasblancasL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fichasblancasL.setFont(new Font("Arial",Font.PLAIN,18));
        fichasblancasL.setText(colores.get(0));
        fichasblancasL.setForeground(Color.WHITE);
        cons.gridx = 2;
        cons.gridy = 0;
        gridbagSur.setConstraints(fichasblancasL, cons);
        juga1.add(fichasblancasL);

        //color jugador 2
        fichasnegrasL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fichasnegrasL.setFont(new Font("Arial",Font.PLAIN,18));
        fichasnegrasL.setText(colores.get(1));
        fichasnegrasL.setForeground(Color.WHITE);
        cons.gridx = 2;
        cons.gridy = 1;
        gridbagSur.setConstraints(fichasnegrasL, cons);
        juga2.add(fichasnegrasL);

        //-contador blancas
        contablancasL.setFont(new Font("Arial",Font.PLAIN,18));
        contablancasL.setForeground(Color.WHITE);
        contablancasL.setHorizontalAlignment(SwingConstants.CENTER);
        cons.gridx = 3;
        cons.gridy = 0;
        gridbagSur.setConstraints(contablancasL, cons);
        juga1.add(contablancasL);

        //contador Jugador2
        contanegrasL.setFont(new Font("Arial",Font.PLAIN,18));
        contanegrasL.setForeground(Color.WHITE);
        contanegrasL.setHorizontalAlignment(SwingConstants.CENTER);
        cons.gridx = 3;
        cons.gridy = 1;
        gridbagSur.setConstraints(contanegrasL, cons);
        juga2.add(contanegrasL);

        //-Mensaje principal
        panelDerecho.add(infoJuego);
        infoJuego.setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        infoJuego.setLayout(new GridLayout(3,1));
        infoJuego.setBackground(Color.DARK_GRAY);
        cons.anchor = GridBagConstraints.NORTHWEST;
        infoJuego.add(informacionJuego);
        informacionJuego.setIcon(new ImageIcon(getClass().getResource("images/infoPartida.png")));
        // informacion

        infoJuego.add(mensajeL);
        mensajeL.setPreferredSize(new Dimension(100,30));
        mensajeL.setFont(new Font("Arial",Font.PLAIN,18));
        mensajeL.setForeground(Color.WHITE);
        mensajeL.setText("              ");
        mensajeL.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(panelDerecho, BorderLayout.EAST);
	}

    /**
     * Este metodo realiza el llamado para crear el tablero de datos y
     * mostrar la información de la cantidad de fichas de los jugadores.
     * @param e the event to be processed
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==empezar){
            datosTablero = new DatosTablero();
            this.dispose();
		}
		else if(e.getSource()==tablas && contB==contN && contB<6
				&& mensajeL.getText()==mensaje[0]){
			mensajeL.setText(mensaje[5]);
		}
		else if(e.getSource()==tablas  && (contB==contN && contB>6
				&& mensajeL.getText()==mensaje[0]) || (contB!=contN))
			mensajeL.setText(mensaje[6]);
	}

    /**
     * Este método realiza la acción de cerrar el juego
     */
    public void actionClose() {
        // Se pide una confirmación antes de finalizar el programa
        int option = JOptionPane.showConfirmDialog(null,
                "¿Estás seguro de que quieres cerrar la aplicación?",
                "Confirmación de cierre",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    /**
     * Esta clase permite crear el fondo del tablero
     */
	public class Fondo extends JPanel{
		private Image fondo = new ImageIcon(getClass().getResource("images/fondo.jpg")).getImage();
		
		public Fondo(){
			setPreferredSize(new Dimension(600,600));
			setVisible(true);
		}

        /**
         * Este metodo pinta el tablero con una imagen
         * @param g the <code>Graphics</code> object to protect
         */
		public void paintComponent(Graphics g){
			g.drawImage(fondo,0,0,this);
		}
	}

    /**
     * Esta clase sirve para generar la pantalla de inicio del juego
     */
    public class PanelInicio extends JPanel {
        Image tablero1 = new ImageIcon(getClass().getResource("images/tablero10x10V2.png")).getImage();
        public PanelInicio(){
            setPreferredSize(new Dimension(575,575));
            setVisible(true);
        }

        /**
         * Este metodo pinta el tablero de la pantalla de incio del juego
         * @param g the <code>Graphics</code> object to protect
         */
        public void paintComponent(Graphics g) {
            g.drawImage(tablero1, 0, 0, this);
        }
    }

    /**
     * Esta clase pinta las fichas del tablero y permite escoger las fichas especiales de acuerdo a los listeners
     */
    public class Grafica extends JPanel implements MouseListener{
        private Image tablero = new ImageIcon(getClass().getResource("images/tablero10x10V2.png")).getImage();
        private Image normalRoja = new ImageIcon(getClass().getResource("images/normalRoja.png")).getImage();
        private Image normalVerde = new ImageIcon(getClass().getResource("images/normalVerde.png")).getImage();
        private Image normalBlanca = new ImageIcon(getClass().getResource("images/normalBlanca1.png")).getImage();
        private Image normalBlancaSelec = new ImageIcon(getClass().getResource("images/normalBlancaSelec.png")).getImage();
        private Image normalNegra = new ImageIcon(getClass().getResource("images/normalNegra1.png")).getImage();
        private Image normalNegraSelec = new ImageIcon(getClass().getResource("images/normalNegraSelec.png")).getImage();
        private Image reinaBlanca = new ImageIcon(getClass().getResource("images/reinaBlanca.png")).getImage();
        private Image reinaBlancaSelec = new ImageIcon(getClass().getResource("images/reinaBlancaSelec.png")).getImage();
        private Image reinaNegra = new ImageIcon(getClass().getResource("images/reinaNegra.png")).getImage();
        private Image reinaNegraSelec = new ImageIcon(getClass().getResource("images/reinaNegraSelec.png")).getImage();
        private Image zombieBlanca = new ImageIcon(getClass().getResource("images/zombieBlanca.png")).getImage();
        private Image zombieBlancaSelec = new ImageIcon(getClass().getResource("images/zombieBlancaSelec.png")).getImage();
        private Image zombieNegra = new ImageIcon(getClass().getResource("images/zombieNegra.png")).getImage();
        private Image zombieNegraSelec = new ImageIcon(getClass().getResource("images/zombieNegraSelec.png")).getImage();
        private Image ninjaBlanca = new ImageIcon(getClass().getResource("images/ninjaBlanca.png")).getImage();
        private Image ninjaBlancaSelec = new ImageIcon(getClass().getResource("images/ninjaBlancaSelec.png")).getImage();
        private Image ninjaNegra = new ImageIcon(getClass().getResource("images/ninjaNegra.png")).getImage();
        private Image ninjaVerde = new ImageIcon(getClass().getResource("images/ninjaVerde.png")).getImage();
        private Image ninjaRoja = new ImageIcon(getClass().getResource("images/ninjaRoja.png")).getImage();
        private Image zombieVerde = new ImageIcon(getClass().getResource("images/zombieVerde.png")).getImage();
        private Image zombieRoja = new ImageIcon(getClass().getResource("images/zombieRojo.png")).getImage();
        private Image reinaVerde = new ImageIcon(getClass().getResource("images/reinaVerde.png")).getImage();
        private Image reinaRoja = new ImageIcon(getClass().getResource("images/reinaRoja.png")).getImage();
        private Image ninjaNegraSelec = new ImageIcon(getClass().getResource("images/ninjaNegraSelec.png")).getImage();
        private Image equis = new ImageIcon(getClass().getResource("images/equis.png")).getImage();
        private Image mine = new ImageIcon(getClass().getResource("images/mine.png")).getImage();
        private Image teleport = new ImageIcon(getClass().getResource("images/teleport.png")).getImage();
        private Image jail = new ImageIcon(getClass().getResource("images/jail.png")).getImage();
        private Image infinity = new ImageIcon(getClass().getResource("images/infinity.png")).getImage();
        private Image laser = new ImageIcon(getClass().getResource("images/laser.png")).getImage();
        private static ArrayList<String> colores = new ArrayList<String>();
        private MovimientosIA movimientosIA = new MovimientosIA();
        int filaI=0,columnaI=0;
        boolean selecB=false, selecDB=false, selecN=false, selecDN=false, selecI=false, selecE=false, selecJ=false, selecA=false , selecCasilla = false; 
        boolean turnoJug=false, turnoJugNegro=false;
        private Movimientos jugador1 = new Movimientos();
        private Movimientos jugador2 = new Movimientos();
        private Comodin comodinInfinity = new Infinity();
        private Comodin comodinLaser = new Laser();
        private Casilla casillaVacia = new CasillaVacia();
        private Casilla casillaMine = new Mine();
        private Casilla casillaJail = new Jail();
        private Casilla casillaTeleport = new Teleport();
        private Ficha normal = new Normal();
	    private Ficha reina = new Reina();
        private Ficha ninja = new Ninja();
	    private Ficha zombie = new Zombie();
        private int x = Tablero.getInstanceTablero().getX();
        private int y = Tablero.getInstanceTablero().getY();
        private ArrayList<Integer> posiciones = new ArrayList<>();

        /**
         *Este constructor genera el tablero del juego con las fichas de acuerdo al color que elijan los jugadores
         * @param colores lista de los colores de las fichas escogidas por los jugadores.
         */
        public Grafica(ArrayList<String> colores){
            this.colores = colores;
            setPreferredSize(new Dimension(575,575));
            setVisible(true);
            addMouseListener(this);
        }

        /**
         * Este metodo pinta las fichas del tablero de acuerdo al color que elija el jugador
         * @param g the <code>Graphics</code> object to protect
         */
        public void paintComponent(Graphics g){
            g.drawImage(tablero,0,0,this);
            contB=0;
            contN=0;
            for(int i=0; i<x; i++){
                for(int j=0;j<y; j++){
                    if (Tablero.getInstanceTablero().getTablero()[i][j] == normal.getTipo(1)) {
                            if(colores.get(0)=="Rojas") {
                                g.drawImage(normalRoja, j * 56 + 10, i * 56 + 10, 56, 56, this);
                            }else if(colores.get(0)=="Blancas"){
                                g.drawImage(normalBlanca, j * 56 + 10, i * 56 + 10, 56, 56, this);
                            }else if(colores.get(0)=="Negras") {
                                g.drawImage(normalNegra, j * 56 + 10, i * 56 + 10, 56, 56, this);
                            }else if(colores.get(0)=="Verdes") {
                                g.drawImage(normalVerde, j * 56 + 10, i * 56 + 10, 56, 56, this);
                            }else if(colores.get(0)=="Seleccionar"){
                                g.drawImage(normalBlanca, j * 56 + 10, i * 56 + 10, 56, 56, this);
                            }
                            contB++;
                        }
                    else if(Tablero.getInstanceTablero().getTablero()[i][j]==normal.getTipo(-1)){
                        if(colores.get(1)=="Rojas") {
                            g.drawImage(normalRoja, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(1)=="Blancas"){
                            g.drawImage(normalBlanca, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(1)=="Negras"){
                            g.drawImage(normalNegra, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(1)=="Verdes"){
                            g.drawImage(normalVerde, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(1)=="Selecionar"){
                            g.drawImage(normalNegra, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }
                        contN++;
                    }
                    else if(Tablero.getInstanceTablero().getTablero()[i][j]==reina.getTipo(1)){
                        if(colores.get(0)=="Rojas") {
                            g.drawImage(reinaRoja, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(0)=="Blancas"){
                            g.drawImage(reinaBlanca, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(0)=="Negras"){
                            g.drawImage(reinaNegra, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(0)=="Verdes"){
                            g.drawImage(reinaVerde, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(0)=="Selecionar"){
                            g.drawImage(reinaBlanca, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }
                        contB++;
                    }
                    else if(Tablero.getInstanceTablero().getTablero()[i][j]==reina.getTipo(-1)){
                        if(colores.get(1)=="Rojas") {
                            g.drawImage(reinaRoja, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(1)=="Blancas"){
                            g.drawImage(reinaBlanca, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(1)=="Negras"){
                            g.drawImage(reinaNegra, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(1)=="Verdes"){
                            g.drawImage(reinaVerde, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(1)=="Selecionar"){
                            g.drawImage(reinaNegra, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }
                        contN++;
                    }
                    else if(Tablero.getInstanceTablero().getTablero()[i][j]==ninja.getTipo(1)){
                        if(colores.get(0)=="Rojas") {
                            g.drawImage(ninjaRoja, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(0)=="Blancas"){
                            g.drawImage(ninjaBlanca, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(0)=="Negras"){
                            g.drawImage(ninjaNegra, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(0)=="Verdes"){
                            g.drawImage(ninjaVerde, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(0)=="Selecionar"){
                            g.drawImage(ninjaBlanca, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }
                        contB++;
                    }
                    else if(Tablero.getInstanceTablero().getTablero()[i][j]==ninja.getTipo(-1)){
                        if(colores.get(1)=="Rojas") {
                            g.drawImage(ninjaRoja, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(1)=="Blancas"){
                            g.drawImage(ninjaBlanca, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(1)=="Negras"){
                            g.drawImage(ninjaNegra, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(1)=="Verdes"){
                            g.drawImage(ninjaVerde, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(1)=="Selecionar"){
                            g.drawImage(ninjaNegra, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }
                        contN++;
                    }
                    else if(Tablero.getInstanceTablero().getTablero()[i][j]==zombie.getTipo(1)){
                        if(colores.get(0)=="Rojas") {
                            g.drawImage(zombieRoja, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(0)=="Blancas"){
                            g.drawImage(zombieBlanca, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(0)=="Negras"){
                            g.drawImage(zombieNegra, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(0)=="Verdes"){
                            g.drawImage(zombieVerde, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(0)=="Selecionar"){
                            g.drawImage(zombieBlanca, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }
                        contB++;
                    }
                    else if(Tablero.getInstanceTablero().getTablero()[i][j]==zombie.getTipo(-1)){
                        if(colores.get(1)=="Rojas") {
                            g.drawImage(zombieRoja, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(1)=="Blancas"){
                            g.drawImage(zombieBlanca, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(1)=="Negras"){
                            g.drawImage(zombieNegra, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(1)=="Verdes"){
                            g.drawImage(zombieVerde, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }else if(colores.get(1)=="Selecionar"){
                            g.drawImage(zombieNegra, j * 56 + 10, i * 56 + 10, 56, 56, this);
                        }
                        contN++;
                    }
                    else if(Tablero.getInstanceTablero().getTablero()[i][j]==casillaMine.getTipo()){
                        g.drawImage(mine, j*56+10,i*56+10, 56, 56, this);
                    }
                    else if(Tablero.getInstanceTablero().getTablero()[i][j]==casillaTeleport.getTipo()){
                        g.drawImage(teleport, j*56+10,i*56+10, 56, 56, this);
                    }
                    else if(Tablero.getInstanceTablero().getTablero()[i][j]==casillaJail.getTipo()){
                        g.drawImage(jail, j*56+10,i*56+10, 56, 56, this);
                    }
                    else if(Tablero.getInstanceTablero().getTablero()[i][j]==comodinInfinity.getTipo()){
                        g.drawImage(infinity, j*56+10,i*56+10, 56, 56, this);
                    }
                    else if(Tablero.getInstanceTablero().getTablero()[i][j]==comodinLaser.getTipo()){
                        g.drawImage(laser, j*56+10,i*56+10, 56, 56, this);
                    }

                }
            }
            if(selecCasilla){
                g.drawImage(equis, columnaI*56+10,filaI*56+10, 56, 56, this);
            }
            if(selecB){
                g.drawImage(normalBlancaSelec, columnaI*56+10,filaI*56+10, 56, 56, this);
            }else if(selecN){
                g.drawImage(normalNegraSelec, columnaI*56+10,filaI*56+10, 56, 56, this);
            }else if(selecDB){
                g.drawImage(reinaBlancaSelec, columnaI*56+10,filaI*56+10, 56, 56, this);
            }else if(selecDN){
                g.drawImage(reinaNegraSelec, columnaI*56+10,filaI*56+10, 56, 56, this);
            }else if(selecI){
                g.drawImage(zombieBlancaSelec, columnaI*56+10,filaI*56+10, 56, 56, this);
            }else if(selecE){
                g.drawImage(zombieNegraSelec, columnaI*56+10,filaI*56+10, 56, 56, this);
            }else if(selecJ){
                g.drawImage(ninjaBlancaSelec, columnaI*56+10,filaI*56+10, 56, 56, this);
            }else if(selecA){
                g.drawImage(ninjaNegraSelec, columnaI*56+10,filaI*56+10, 56, 56, this);
            }
            contablancasL.setText(""+contB);
            contanegrasL.setText(""+contN);
        }

        /**
         * Este método válida que la fichas del jugador 1 coman de manera obligatoria
         * @return variable que indica si el jugador 1 debe comer obligatoriamente.
         */
        public boolean obligatorioMoverBlanco(){
            boolean res = false;
            if(!turnoJugNegro){
                res = true;
            }else{
                res = false;
            }
            return res;
        }

        /**
         * Este método valida que la fichas del jugador 2 coman de manera obligatoria
         * @return variable que indica si el jugador 2 debe comer obligatoriamente.
         */
        public boolean obligatorioMoverNegro(){
            boolean res = false;
            if(!turnoJug){
                res = true;
            }else{
                res = false;
            }
            return res;
        }

        /**
         * Este metodo sirve para validar la ficha escogida por el usuario
         * @param f fila escogida
         * @param c columna escogida
         * @param indentificador saber si el jugador es "player 1" o "Player 2" (1 o -1)
         * @return valor booleano para saber si la ficha escogida es normal
         */
        public boolean escogerFicha(int f, int c, int indentificador){
            try{
                if(Tablero.getInstanceTablero().getTablero()[f][c]== normal.getTipo(indentificador)){
                    return true;
                }
            }catch (ArrayIndexOutOfBoundsException ex){}
            return false;
        }

        /**
         * Este metodo sirve para validar si la fiucha que escogio el jugador es la ficha tipo reina
         * @param f fila escogida
         * @param c columna escogida
         * @param indentificador saber si el jugador es "player 1" o "Player 2" (1 o -1)
         * @return valor booleano para saber si la ficha escogida es reina
         */
        public boolean escogerReina(int f, int c, int indentificador){
            try{
                if(Tablero.getInstanceTablero().getTablero()[f][c]== reina.getTipo(indentificador)){
                    return true;
                }
            }catch (ArrayIndexOutOfBoundsException ex){}
            return false;
        }

        /**
         * Este metodo valida el tipo de casilla que escogio el jugador para poner su ficha
         * @param f fila escogida
         * @param c columna escogida
         * @param indentificador saber si el jugador es "player 1" o "Player 2" (1 o -1)
         * @return valor booleano para saber si el jugador eligio una casilla especial
         */
        public boolean escogerCasilla(int f, int c, int indentificador){
            try{
                if(Tablero.getInstanceTablero().getTablero()[f][c]== casillaVacia.getTipo() ||
                   Tablero.getInstanceTablero().getTablero()[f][c]== casillaMine.getTipo() ||
                   Tablero.getInstanceTablero().getTablero()[f][c]== casillaTeleport.getTipo() ||
                   Tablero.getInstanceTablero().getTablero()[f][c]== casillaJail.getTipo()){
                    return true;
                }
            }catch (ArrayIndexOutOfBoundsException ex){}
            return false;
        }

        /**
         * Este metodo valida si la ficha que el jugador escogio es de tipo zombie
         * @param f fila escogida
         * @param c columna escogida
         * @param indentificador saber si el jugador es "player 1" o "Player 2" (1 o -1)
         * @return valor booleano para saber si la ficha escogida es zombie
         */
        public boolean escogerZombie(int f, int c, int indentificador){
            try{
                if(Tablero.getInstanceTablero().getTablero()[f][c]== zombie.getTipo(indentificador)){
                    return true;
                }
            }catch (ArrayIndexOutOfBoundsException ex){}
            return false;
        }
        /**
         * Este metodo valida si la ficha que el ju7gador escogio es de tipo ninja
         * @param f fila escogida
         * @param c columna escogida
         * @param indentificador saber si el jugador es "player 1" o "Player 2" (1 o -1)
         * @return valor booleano para saber si la ficha escogida es ninja
         */
        public boolean escogerNinja(int f, int c, int indentificador){
            try{
                if(Tablero.getInstanceTablero().getTablero()[f][c]==ninja.getTipo(indentificador)){
                    return true;
                }
            }catch (ArrayIndexOutOfBoundsException ex){}
            return false;
        }

        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent arg0) {}
        @Override
        public void mouseExited(MouseEvent arg0) {}

        /**
         * Este método es un evento que permite realizar la acción cuando el jugador escoge la ficha
         * @param e the event to be processed
         */
        @Override
        public void mousePressed(MouseEvent e) {
            
        posiciones.add(e.getY()/56);
        posiciones.add(e.getX()/56);
        
        if(posiciones.size()>3 ){

            jugador1.jugar(posiciones.get(0), posiciones.get(1), posiciones.get(2),  posiciones.get(3),1);
            if(nombres.get(1)=="CPU"){
                movimientosIA.IA(-1);}
            else{
                jugador2.jugar(posiciones.get(0), posiciones.get(1), posiciones.get(2),  posiciones.get(3),-1);
            }
            System.out.println(posiciones);
            
            posiciones.clear();
        }
        
        if(!obligatorioMoverBlanco()){ 
            movimientosIA.IA(-1); 
        }

        if(!obligatorioMoverNegro()){
            //movimientosIA.IA(indentificador);
        }
        
        if(escogerFicha(e.getY()/56,e.getY()/56, 1) && !selecB){
            filaI = e.getY()/56;
            columnaI = e.getX()/56;
            selecB=true; 
        }else if(escogerReina(e.getY()/56,e.getY()/56, 1) && !selecB){
            filaI = e.getY()/56;
            columnaI = e.getX()/56;
            selecDB=true;           
        }else if(escogerZombie(e.getY()/56,e.getY()/56, 1) && !selecB){
            filaI = e.getY()/56;
            columnaI = e.getX()/56;
            selecI=true;           
        }else if(escogerNinja(e.getY()/56,e.getY()/56, 1) && !selecB){
            filaI = e.getY()/56;
            columnaI = e.getX()/56;
            selecJ=true;           
        }else{
            selecB=false;
            selecDB=false;
            selecI=false; 
            selecJ=false;  
        }

        if(escogerFicha(e.getY()/56,e.getY()/56, -1) && !selecN){
            filaI = e.getY()/56;
            columnaI = e.getX()/56;
            selecN=true;
        }else if(escogerReina(e.getY()/56,e.getY()/56, -1) && !selecN){
            filaI = e.getY()/56;
            columnaI = e.getX()/56;
            selecDN=true;
        }else if(escogerZombie(e.getY()/56,e.getY()/56, -1) && !selecN){
            filaI = e.getY()/56;
            columnaI = e.getX()/56;
            selecE=true;
        }else if(escogerNinja(e.getY()/56,e.getY()/56, -1) && !selecN){
            filaI = e.getY()/56;
            columnaI = e.getX()/56;
            selecA=true;
        }else{
            selecN=false;
            selecDN=false;
            selecE=false;
            selecA=false;
        }
        if(escogerCasilla(e.getY()/56,e.getX()/56,1)){
            filaI = e.getY()/56;
            columnaI = e.getX()/56;
            selecCasilla = true;
        }else{
            selecCasilla = false;
        }
         Tablero.getInstanceTablero().imprimir();
         repaint();
         }
        
        @Override
        public void mouseReleased(MouseEvent e) {

            if(mensajeL.getText()==mensaje[6]){
                mensajeL.setText(mensaje[0]);
            }
            else if(contB==0)
                mensajeL.setText(mensaje[4]);
            else if(contN==0)
                mensajeL.setText(mensaje[3]);
            else if(contB==0 && contN==0)
                mensajeL.setText(mensaje[5]);
        }
    }

    /**
     * Este metodo prepara la barra de menu del juego en la cual se podra realizar diferentes acciones
     * como cerrar, abrir, guardar una partida
     */
    public void prepareElementsMenu() {
        barraDeMenu = new JMenuBar();
        opciones = new JMenu("Opciones");
        nuevo = new JMenuItem("Nuevo");
        abrir = new JMenuItem("Abrir");
        guardar = new JMenuItem("Guardar");
        salir = new JMenuItem("Salir");
        opciones.add(abrir);
        opciones.add(guardar);
        opciones.add(salir);
        opciones.add(nuevo);
        barraDeMenu.add(opciones);
        setJMenuBar(barraDeMenu);
        seleccionarArchivo = new JFileChooser();
    }

    /**
     * Este metodo realiza las acciones de la barra de menu del juego
     */
    public void prepareActionsMenu() {
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                actionClose();
            }
        });

        abrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                actionOpen();
            }
        });

        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                actionGuardar();
            }
        });


    }

    /**
     * Metodo que realiza la accion de abrir un nuevo juego
     */
    public void actionOpen() {
        File archivo = null;
        seleccionarArchivo.setVisible(true);
        int abrio = seleccionarArchivo.showOpenDialog(abrir);
        if (abrio == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionarArchivo.getSelectedFile();
        }
        JOptionPane.showMessageDialog(abrir, "No se pudo abrir " + archivo.getName(), "Atencion", 1);
        seleccionarArchivo.setVisible(false);
    }
    /**
     * Metodo que realiza la accion de guardar una partida del juego
     */
    public void actionGuardar() {
        File archivo = null;
        seleccionarArchivo.setVisible(true);
        int guardo = seleccionarArchivo.showSaveDialog(guardar);
        if (guardo == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionarArchivo.getSelectedFile();
        }
        JOptionPane.showMessageDialog(guardar, "No se pudo guardar " + archivo.getName(), "Atencion", 1);
        seleccionarArchivo.setVisible(false);
    }

   
}
