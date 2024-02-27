package Presentacion;

import Dominio.Tablero;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Esta clase es una interfaz que recolecta los nombres de los jugadores que van a jugar
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class DatosJ1VSJ2 extends JDialog {
    private static DatosJ1VSJ2 instanceDatosJ1VSJ2;
    private static ArrayList<String> colores = new ArrayList<String>();
    private JDialog datos1 = new JDialog();
    private JButton iniciar;
    private ArrayList<String> nombres;
    private JLabel jugador1, jugador2;
    private JTextField jug1, jug2;
    private JPanel panel = new JPanel();
    private Principal gui;
    private  String nombre1;
    private  String nombre2;

    /**
     * Constructor que genera la interfaz para la recolección de los nombres de los jugadores
     * @param colores lista de los colores de las fichas escogidas por los jugadores.
     */
    public DatosJ1VSJ2(ArrayList<String> colores) {
        nombres = new ArrayList<String>();
        this.colores = colores;
        prepareDatosJugadorVSJugador();
        actionJ1VSJ2();
    }

    /**
     * Método que realiza la construcción y organización de la interfaz
     */
    public void prepareDatosJugadorVSJugador() {
        datos1.setTitle("Información de los jugadores");
        datos1.setSize(500,200);
        datos1.setResizable(false);
        jugador1 = new JLabel("Jugador 1: ");
        jugador2 = new JLabel("Jugador 2: ");
        iniciar = new JButton("Empezar");
        jug1 = new JTextField(20);
        jug2 = new JTextField(20);

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        //Se agregan los componentes al panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(jugador1, constraints);

        constraints.gridx = 1;
        panel.add(jug1, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(jugador2, constraints);

        constraints.gridx = 1;
        panel.add(jug2, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(iniciar, constraints);

        datos1.add(panel);
        datos1.setLocationRelativeTo(null);
        datos1.setVisible(true);
    }

    /**
     * Método que realiza la acción de generar la partida una vez recolectado
     * los datos y configuración de la partida de los jugadores
     */
    public void actionJ1VSJ2() {
        iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tablero.getInstanceTablero().reiniciar();
                nombre1 = jug1.getText();
                nombre2 = jug2.getText();
                nombres.add(nombre1);
                nombres.add(nombre2);
                gui = new Principal(nombres, colores);
                gui.setVisible(true);
                setVisible(false);
                datos1.dispose();
            }
        });
    }
    public static DatosJ1VSJ2 getInstanceDatosJugador(){
        if(getInstanceDatosJugador() == null){
            instanceDatosJ1VSJ2 = new DatosJ1VSJ2(colores);
        }
        return instanceDatosJ1VSJ2;
    }
}