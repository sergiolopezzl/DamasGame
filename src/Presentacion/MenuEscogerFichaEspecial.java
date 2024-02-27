package Presentacion;

import Dominio.Tablero;
import Dominio.Zombie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase es una interfaz para escoger el nuevo tipo de ficha cuando esta llega al otro extremo del tablero
 * @author: Sergio Lopez y Santiago Naranjo
 * @version: 11/12/2022
 */
public class MenuEscogerFichaEspecial {
    private static MenuEscogerFichaEspecial instanceMenu;
    private JDialog datos1 = new JDialog();
    private JButton reina, zombie, ninja;
    private JLabel rei, zom, nin;
    private JPanel panel = new JPanel();
    private Principal gui;

    private String tipo;

    /**
     * Constructor que genera toda la interfaz y funcionalidad del menu para la selección de fichas especiales
     */
    public MenuEscogerFichaEspecial() {
        prepareMenuFichasEspeciales();
        actionFichaNinja();
        actionFichaReina();
        actionFichaZombie();
    }

    /**
     * Este método pinta el menu de las fichas especiales
     */
    public void prepareMenuFichasEspeciales() {
        datos1.setTitle("Escoger Ficha Especial");
        datos1.setSize(200, 200);
        datos1.setResizable(false);
        rei = new JLabel("Reina  ");
        //rei.setForeground(Color.WHITE);
        zom = new JLabel("Zombie   ");
        nin = new JLabel("Ninja   ");
        reina = new JButton();
        reina.setBackground(Color.WHITE);
        reina.setIcon(new ImageIcon("src/Presentacion/images/iconReina.png"));
        zombie = new JButton();
        zombie.setBackground(Color.WHITE);
        zombie.setIcon(new ImageIcon("src/Presentacion/images/iconZombie.png"));
        ninja = new JButton();
        ninja.setBackground(Color.WHITE);
        ninja.setIcon(new ImageIcon("src/Presentacion/images/iconNinja.png"));

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        //Agrega los componentes creados al panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(rei, constraints);

        constraints.gridx = 1;
        panel.add(reina, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(zom, constraints);

        constraints.gridx = 1;
        panel.add(zombie, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(nin, constraints);

        constraints.gridx = 1;
        panel.add(ninja, constraints);


        datos1.add(panel);
        datos1.setLocationRelativeTo(null);
        datos1.setVisible(true);

    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String escoger() {
        return tipo;
    }

    /**
     * Este metodo es la acción que se realiza el cambio de ficha a tipo reina
     */
    public void actionFichaReina() {
        reina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tablero.getInstanceTablero().reiniciar();
                //gui = new Principal();
                //gui.setVisible(true);
                datos1.dispose();
                setTipo("reina");
                Tablero.getInstanceTablero().reiniciar();
                DatosTablero.getInstanceDatosTablero().dispose();
                //Principal.getInstancePrincipal().Presentacion.escogerFichaEspecial("reina");
            }
        });
    }
    /**
     * Este método es la acción que se realiza el cambio de ficha a tipo zombie
     */
    public void actionFichaZombie() {
        zombie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tablero.getInstanceTablero().reiniciar();
                gui = new Principal();
                gui.setVisible(true);
                datos1.dispose();
                setTipo("zombie");
                tipo = "ninja";
                DatosTablero.getInstanceDatosTablero().dispose();

            }
        });
    }
    /**
     * Este método es la acción que se realiza el cambio de ficha a tipo ninja
     */
    public void actionFichaNinja() {
        ninja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //grafica.escogerFicha(int filaI, int columnaI, int filaF, int columnaF, int indentificador);
                tipo = "ninja";

            }
        });
    }

    public static MenuEscogerFichaEspecial getInstanceMenu() {
        if (getInstanceMenu() == null) {
            instanceMenu = new MenuEscogerFichaEspecial();
        }
        return instanceMenu;
    }
}
