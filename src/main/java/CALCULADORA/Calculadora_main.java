package CALCULADORA;

import java.awt.*;
import java.awt.event.*;

/**
 * 
 * @author Iván Pérez
 */
public class Calculadora_main extends Frame {

    protected final String[] botones = {
        "7", "8", "9", "+",
        "4", "5", "6", "-",
        "1", "2", "3", "*",
        ",", "0", "C", "="
    };

    protected final Button[] btn = new Button[20];
    protected final Panel Panel_principal;
    protected final Panel Panel_texto;
    protected final Panel Panel_botones;
    protected final TextField pantalla;

    public Calculadora_main(String texto) {
        super(texto);
        Panel_principal = new Panel(new BorderLayout());
        add(Panel_principal);

        Panel_texto = new Panel(new BorderLayout());
        Panel_botones = new Panel(new GridLayout(botones.length / 4, 4));

        Panel_principal.add(Panel_texto, BorderLayout.NORTH);
        Panel_principal.add(Panel_botones, BorderLayout.CENTER);

        pantalla = new TextField("");
        Panel_texto.add(pantalla);
        agregarBotones();
        setLocationRelativeTo(null);
    }

    private void agregarBotones() {
        for (int i = 0; i < botones.length; i++) {
            btn[i] = new Button("" + botones[i]);
            Panel_botones.add(btn[i]);
        }
    }

    public static void main(String[] args) {
        Calculadora_main app = new Calculadora_main("Calculadora");
        app.setSize(250, 300);
        app.setVisible(true);

        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
