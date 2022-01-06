package CALCULADORA;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Iván Pérez
 */
public class Calculadora_main extends Frame implements ActionListener {

    protected final String[] botones = {
        "DEL", "CE", "C", "+",
        "7", "8", "9", "-",
        "4", "5", "6", "/",
        "1", "2", "3", "*",
        "", "0", ".", "="
    };
    protected String numeroPantalla = "0";
    protected double numero = 0;
    protected operacionesCalculadora estadoOperacion;
    protected final Button[] btn = new Button[20];
    protected final Panel Panel_principal;
    protected final Panel Panel_texto;
    protected final Panel Panel_botones;
    protected final TextField pantalla;

    /**
     * Contructor donde definimos la estructura de nuestra interfaz. 
     * @param texto nombre de la applicacion.
     */
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

    /**
     * Metodo para agregar los botones a la interfaz, ademas de darle funcionalidad a cada boton.
     */
    private void agregarBotones() {
        for (int i = 0; i < botones.length; i++) {
            btn[i] = new Button("" + botones[i]);
            Panel_botones.add(btn[i]);
            btn[i].addActionListener(this);
        }
    }
    
    /**
     * Clase "especial" para definir las operaciones de mi calculadora.
     */
    private enum operacionesCalculadora {
        SUMA("+"),
        RESTA("-"),
        DIV("/"),
        MULTIP("*");

        String opr;
        operacionesCalculadora(String a) {
            this.opr = a;
        }
    }

    /**
     * Metodo funcional de la calculadora. Calcula suma,resta,multiplicaciones y divisiones NO encadenadas.
     * @param evento 
     */
    public void actionPerformed(ActionEvent evento) {
        String operacionBoton = evento.getActionCommand();
        switch (operacionBoton) {
            case "+":
                if (!numeroPantalla.equals("-0")) {
                    estadoOperacion = operacionesCalculadora.SUMA;
                    numero = Double.parseDouble(numeroPantalla);
                }
                numeroPantalla = "0";
                break;
            case "-":
                if (!numeroPantalla.equals("0")) {
                    estadoOperacion = operacionesCalculadora.RESTA;
                    numero = Double.parseDouble(numeroPantalla);
                    numeroPantalla = "0";
                } else {
                    numeroPantalla = "-0";
                }
                break;
            case "*":
                estadoOperacion = operacionesCalculadora.MULTIP;
                numero = Double.parseDouble(numeroPantalla);
                numeroPantalla = "0";
                break;
            case "/":
                estadoOperacion = operacionesCalculadora.DIV;
                numero = Double.parseDouble(numeroPantalla);
                numeroPantalla = "0";
                break;
            case "C":
                numeroPantalla = "0";
                break;
            case "CE":
                numeroPantalla = "0";
                break;
            case "DEL":
                if (!numeroPantalla.equals("")) {
                    numeroPantalla = numeroPantalla.substring(0, numeroPantalla.length() - 1);
                }
                if (numeroPantalla.equals("")) {
                    numeroPantalla = "0";
                }
                break;
            case ".":
                numeroPantalla += operacionBoton;
                break;
            case "=":
                switch (estadoOperacion) {
                    case SUMA:
                        numeroPantalla = String.valueOf(numero + Double.parseDouble(numeroPantalla));
                        break;
                    case RESTA:
                        numeroPantalla = String.valueOf(numero - Double.parseDouble(numeroPantalla));
                        break;
                    case MULTIP:
                        numeroPantalla = String.valueOf(numero * Double.parseDouble(numeroPantalla));
                        break;
                    case DIV:
                        numeroPantalla = String.valueOf(numero / Double.parseDouble(numeroPantalla));
                        break;
                }
                break;
            default:
                if (numeroPantalla.contains("0")) {
                    numeroPantalla = operacionBoton;
                } else if (numeroPantalla.contains("-0")) {
                    numeroPantalla = "-" + operacionBoton;
                } else {
                    numeroPantalla += operacionBoton;
                }
                break;
        }
        pantalla.setText(numeroPantalla);

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
