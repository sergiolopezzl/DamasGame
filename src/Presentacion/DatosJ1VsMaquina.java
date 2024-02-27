package Presentacion;

import Dominio.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Esta clase es una interfaz que recolecta el nombre del jugador que va a jugar contra la máquina
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class DatosJ1VsMaquina extends JDialog{
    private static DatosJ1VsMaquina instanceDatosJ1VSMaquina;
    private static ArrayList<String> colores = new ArrayList<String>();
    private JDialog datos = new JDialog();
    private JButton iniciar;
    private ArrayList<String> nombres;
    private JLabel jugador1;
    private JTextField jug1;
    private JPanel panel = new JPanel();
    private Principal gui;
    private  String nombre1;

    /**
     * Constructor que genera la interfaz para la recolección del nombre del jugador
     * @param colores
     */
    public DatosJ1VsMaquina(ArrayList<String> colores) {
        this.colores = colores;
        nombres = new ArrayList<String>();
        prepareDatosJugadorVSMaquina();
        actionJ1VSMaquina();
    }

    /**
     * Método que realiza la construcción y organización de la interfaz
     */
    public void prepareDatosJugadorVSMaquina() {
        datos.setTitle("Información del jugador");
        datos.setSize(500,130);
        datos.setResizable(false);
        jugador1 = new JLabel("Jugador 1: ");
        iniciar = new JButton("Empezar");
        jug1 = new JTextField(20);
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        //Agrega los componentes al panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(jugador1, constraints);

        constraints.gridx = 1;
        panel.add(jug1, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(iniciar, constraints);

        datos.add(panel);
        datos.setLocationRelativeTo(null);
        datos.setVisible(true);

    }

    /**
     * Método que realiza la acción de generar la partida una vez recolectado los datos y configuración de la partida del jugador
     */
    public void actionJ1VSMaquina() {
        iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tablero.getInstanceTablero().reiniciar();
                nombre1 = jug1.getText();
                nombres.add(nombre1);
                nombres.add("CPU");
                gui = new Principal(nombres, colores);
                gui.setVisible(true);
                datos.dispose();
            }
        });
    }
    public static DatosJ1VsMaquina getInstanceDatosJ1VSMaquina(){
        if(getInstanceDatosJ1VSMaquina() == null){
            instanceDatosJ1VSMaquina = new DatosJ1VsMaquina(colores);
        }
        return instanceDatosJ1VSMaquina;
    }
}
