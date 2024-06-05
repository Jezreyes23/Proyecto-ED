import javax.swing.JOptionPane;
import clases.*;

public class Main {
    public static void main(String[] args) {
        PigLatin pl = new PigLatin();
        Postfija pf = new Postfija();
        int menu = 0, menuPost = 0, numeros = 0, dato = 0;
        boolean leido = true;
        String palabra = "", operacion = "";
        String resultadoP= "",tablaP = "", postfijo = "";
        double resultado = 0;
        ColaSimple cola = new ColaSimple();
        
    

        JOptionPane.showMessageDialog(null, "Bienvenido al proyecto N°2 de Estructura de datos", "Proyecto 2",
                JOptionPane.INFORMATION_MESSAGE);
        do {
            do {
                try {
                    leido = true;
                    menu = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "1. PANTALLA DE PRESENTACIÓN\r\n" + "2. GENERADOR PIG LATIN\r\n"
                                    + "3. CONVERSIÓN INFIJO – POSTFIJO\r\n" + "4. SALIR",
                            "Menu Principal", JOptionPane.QUESTION_MESSAGE));
                    if (menu < 1 || menu > 4) {
                        JOptionPane.showMessageDialog(null, "ERROR: Elija una opción válida", "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                        leido = false;
                    } else {
                        leido = true;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
                    leido = false;
                }
            } while (!leido);
            switch (menu) {
                case 1:
                    JOptionPane.showMessageDialog(null,
                            " UNIVERSIDAD TECNOLÓGICA DE PANAMÁ\r\n"
                                    + "FACULTAD DE INGENIERÍA DE SISTEMAS COMPUTACIONALES\r\n"
                                    + "LIC. EN INGENIERÍA DE SISTEMAS Y COMPUTACIÓN\r\n"
                                    + "ESTRUCTURA DE DATOS I\r\n" + "ASIGNACIÓN N° 10\r\n" + "PROYECTO 2\r\n"
                                    + "TEMA: Implementación de colas y pilas\r\n" + "FACILITADOR:\r\n"
                                    + "Ing. Jacqueline S. de Ching\r\n" + "INTEGRANTES:\r\n" + "Jezreel Reyes 8-97-8\r\n"
                                    + "Grupo: 1IL121\r\n",
                            "Presentación", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    do {
                        try {
                            leido = true;
                            palabra = JOptionPane.showInputDialog(null, "Ingrese una palabra u oración", "Pig Latin",
                                    JOptionPane.QUESTION_MESSAGE);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
                            leido = false;
                        }
                    } while (!leido);
                    pl.setPalabra(palabra);
                    dato = pl.calcularD();
                    String palabras[] = new String[dato];
                    pl.guardar(dato, palabras);
                    for (int i = 0; i < dato; i++) {
                        cola.push(pl.convertirP(palabras, i));
                    }
                    while (!cola.isEmpty()) {
                        resultadoP = resultadoP + cola.pull() + " ";
                    }
                    JOptionPane.showMessageDialog(null, "Conversión en Pig Latin: " + resultadoP, "Pig Latin",
                            JOptionPane.INFORMATION_MESSAGE);
                    resultadoP = "";
                    break;
                case 3:
                    do {
                        leido = true;
                        do {
                            try {
                                leido = true;
                                menuPost = Integer.parseInt(JOptionPane.showInputDialog(null,
                                        "1. Cargar operadores en la PILA\r\n"
                                                + "2. Mostrar procedimiento de la conversión.\r\n"
                                                + "3. Resultado de la conversión.\r\n"
                                                + "4. Resultado de la operación.\r\n"
                                                + "5. Regresar al menú principal",
                                        "Menu", JOptionPane.QUESTION_MESSAGE));
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR",
                                        JOptionPane.ERROR_MESSAGE);
                                leido = false;
                            }
                        } while (!leido);
                        switch (menuPost) {
                            case 1:
                                do {
                                    try {
                                        leido = true;
                                        operacion = JOptionPane.showInputDialog(null, "Ingrese una operación matemática",
                                                "Conversión a postfijo", JOptionPane.QUESTION_MESSAGE);
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR",
                                                JOptionPane.ERROR_MESSAGE);
                                        leido = false;
                                    }
                                } while (!leido);
                                postfijo = pf.convertir(operacion);
                                JOptionPane.showMessageDialog(null, "Conversión a postfijo: " + postfijo, "Conversión a postfijo", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            case 2:
                                tablaP = pf.tabular(operacion);
                                JOptionPane.showMessageDialog(null, "Tabla de proceso \n "+tablaP, "Conversión a postfijo",
                                        JOptionPane.INFORMATION_MESSAGE);
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Resultado de la conversión: " + postfijo,
                                        "Conversión a postfijo", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            case 4:
                                JOptionPane.showMessageDialog(null, "Indicación para introducir dato",
                                        "Conversión a postfijo", JOptionPane.INFORMATION_MESSAGE);
                                double[] valores = new double[postfijo.length()]; 
                                for (int i = 0; i < postfijo.length(); i++) {
                                    if (Character.isLetter(postfijo.charAt(i))) {
                                        do {
                                            try {
                                                leido = true;
                                                valores[i] = Double.parseDouble(JOptionPane.showInputDialog(null,
                                                        "Ingrese valor para " + postfijo.charAt(i) + ":", "Conversión a postfijo",
                                                        JOptionPane.QUESTION_MESSAGE));
                                            } catch (Exception e) {
                                                JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR",
                                                        JOptionPane.ERROR_MESSAGE);
                                                leido = false;
                                            }
                                        } while (!leido);
                                    }
                                }
                                resultado = pf.evaluarPostfija(postfijo, valores);
                                JOptionPane.showMessageDialog(null, "Resultado de la operación: " + resultado,
                                        "Conversión a postfijo", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            default:
                                leido = false;
                                break;
                        }
                    } while (menuPost != 5);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "La ejecución del proyecto ha terminado.\n ¡Gracias por su atención!", "Presentación",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        } while (menu != 4);
    }

}