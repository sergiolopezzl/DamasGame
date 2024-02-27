package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static javax.swing.GroupLayout.Alignment.*;

/**
 * Esta clase es una interfaz que recolecta los datos de configuración de la partida
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class DatosTablero extends JDialog {
    private DatosJ1VSJ2 datosJ1VSJ2;
    private DatosJ1VsMaquina datosJ1VSMaquina;
    private static DatosTablero instanceDatosTablero;
    private MenuEscogerFichaEspecial menu;
    private ArrayList<String> colores;
    private JDialog ajustes = new JDialog();
    private JButton j1VSj2, j1VSmq;
    private JLabel jlblTitle, colorFicha1, colorFicha2, casillasEspeciales;
    private JComboBox jcmbxFicha1, jcmbxFicha2;
    private JCheckBox permanente,relampago;
    private JPanel panelInferior, info;
    private String color1, color2;

    /**
     * Constructor para los datos del tablero
     */
    public DatosTablero(){
        colores = new ArrayList<String>();
        prepareNuevaPartida();
        prepareActions();
        instanceDatosTablero = this;
    }

    /**
     * Método que pinta la interfaz para la recolección de la configuración establecida por el jugador para la partida
     */
    public void prepareNuevaPartida() {
        ajustes.setTitle("Información para iniciar la partida");
        ajustes.setSize(600, 250);
        ajustes.setResizable(false);
        jlblTitle = new JLabel("Información para iniciar la partida");
        colorFicha1 = new JLabel("Color Ficha 1");
        colorFicha2 = new JLabel("Color Ficha 2");
        casillasEspeciales = new JLabel("Casillas Especiales");
        jcmbxFicha1 = new JComboBox();
        jcmbxFicha1.addItem("Seleccionar");
        jcmbxFicha1.addItem("Negras");
        jcmbxFicha1.addItem("Blancas");
        jcmbxFicha1.addItem("Rojas");
        jcmbxFicha1.addItem("Verdes");
        jcmbxFicha2 = new JComboBox();
        jcmbxFicha2.addItem("Seleccionar");
        jcmbxFicha2.addItem("Negras");
        jcmbxFicha2.addItem("Blancas");
        jcmbxFicha2.addItem("Rojas");
        jcmbxFicha2.addItem("Verdes");
        permanente = new JCheckBox("Permanente");
        permanente.setBackground(Color.LIGHT_GRAY);
        relampago = new JCheckBox("Relampago");
        relampago.setBackground(Color.LIGHT_GRAY);
        j1VSj2 = new JButton("Jugador VS Jugador");
        j1VSmq = new JButton("Jugador VS Maquina");
        panelInferior = new JPanel(new GridLayout());
        info = new JPanel();
        info.setBackground(Color.LIGHT_GRAY);
        info.setSize(500, 200);
        ajustes.add(panelInferior, BorderLayout.SOUTH);
        GroupLayout layout = new GroupLayout(info);
        info.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(jlblTitle)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addComponent(colorFicha1)
                                        .addComponent(colorFicha2)
                                        .addComponent(casillasEspeciales))
                                .addGroup(
                                        layout.createParallelGroup(LEADING)
                                                .addComponent(jcmbxFicha1)
                                                .addComponent(jcmbxFicha2)
                                                .addComponent(permanente, CENTER)
                                                .addComponent(j1VSj2, CENTER))
                                .addGroup(
                                        layout.createParallelGroup(LEADING)
                                                .addComponent(relampago, CENTER)
                                                .addComponent(j1VSmq)))));
        layout.setVerticalGroup(layout
                .createSequentialGroup()
                .addGroup(
                        layout.createParallelGroup(BASELINE)
                                .addComponent(jlblTitle))
                .addGroup(
                        layout.createParallelGroup(LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(
                                                layout.createParallelGroup(BASELINE)
                                                        .addComponent(colorFicha1)
                                                        .addComponent(jcmbxFicha1))
                                        .addGroup(
                                                layout.createParallelGroup(BASELINE)
                                                        .addComponent(colorFicha2)
                                                        .addComponent(jcmbxFicha2))
                                        .addGroup(
                                                layout.createParallelGroup(BASELINE)
                                                        .addComponent(casillasEspeciales)
                                                        .addComponent(permanente)
                                                        .addComponent(relampago))
                                        .addGroup(
                                                layout.createParallelGroup(BASELINE)
                                                        .addComponent(j1VSj2)
                                                        .addComponent(j1VSmq)))));
        ajustes.add(info);
        ajustes.setLocationRelativeTo(null);
        ajustes.setVisible(true);
        ajustes.setModal(true);
    }

    /**
     * Método que encapsula las acciones que se realizan en esta interfaz
     */
    public void prepareActions() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        prepareActionJ1VSJ2();
        prepareActionJ1VSMaquina();

    }

    /**
     * Método que realiza la acción de la creación de otra interfaz para la recolección de los nombres de los dos jugadores
     */
    public void prepareActionJ1VSJ2() {
        j1VSj2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                color1 = (String)jcmbxFicha1.getSelectedItem();
                color2 = (String)jcmbxFicha2.getSelectedItem();
                colores.add(color1);
                colores.add(color2);
                datosJ1VSJ2 = new DatosJ1VSJ2(colores);
                ajustes.dispose();
            }
        });
    }
    /**
     * Método que realiza la acción de la creación de otra interfaz para la recolección del nombre del jugador
     */
    public void prepareActionJ1VSMaquina() {
        j1VSmq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                color1 = (String)jcmbxFicha1.getSelectedItem();
                color2 = (String)jcmbxFicha2.getSelectedItem();
                colores.add(color1);
                colores.add(color2);
                datosJ1VSMaquina = new DatosJ1VsMaquina(colores);
                ajustes.dispose();
            }
        });
    }
    public static DatosTablero getInstanceDatosTablero(){
        if(instanceDatosTablero == null){
            instanceDatosTablero = new DatosTablero();
        }
        return instanceDatosTablero;
    }

}