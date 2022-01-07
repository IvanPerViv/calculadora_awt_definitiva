# Calculadora en AWT
Proyecto de clase, se intenta crear una calculadora (funcional) con la herramienta de interfaz de usuario, AWT

## Construido con 🛠️

* [Maven](https://maven.apache.org/) - Manejador de dependencias

## Descripción del proyecto. 🚀
El proyecto costa de una sola clase. 

<h3> Clase  "Calculadora_main" </h3>

<p> Clase principal del programa. Este generara toda la estructura de la calculadora y la funcionalidad para cada boton. </p>

<h4> Contructor </h4>

<p> Encargado de añadirle el titulo y la estructura de la interfaz. </p>

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
    
<h4> Metodo agregarBotones() .</h4>

<p> Agrega los botones a la interfaz y da funcionalidad a cada boton. </p>

    private void agregarBotones() {
        for (int i = 0; i < botones.length; i++) {
            btn[i] = new Button("" + botones[i]);
            Panel_botones.add(btn[i]);
            btn[i].addActionListener(this);
        }
    }
    
<h4> Clase operacionesCalculadora .</h4>

<p> Utilizada para definir las operacion de mi calculadora </p>
    
    private void agregarBotones() {
        for (int i = 0; i < botones.length; i++) {
            btn[i] = new Button("" + botones[i]);
            Panel_botones.add(btn[i]);
            btn[i].addActionListener(this);
        }
    }

##  Funciones de la caluladora.

- La calculadora puede realizar operaciones <b>basicas</b> de <i>suma, resta, multiplicacion y division,</i> simples, con numeros no encadenados. <br>
- Calculos tanto de numeros positivos, como negativos. <br>
- Operaciones con numeros decimales. <br>
- Funcionalidad de borrar, numero por numero. <br>
- Funcionalidad de borrar todo el contenido de la pantalla. <br>

##  Creador & licencia.
Iván Pérez Vivas.
