package clases;
public class PigLatin {
    private String palabra;
    public int calcularD() {
        int dato = 1;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == ' ') {
                dato++;
            }
        }
        return dato;
    }
    public void guardar(int d, String[] p) {
        int dato = 0, bucle = 0;
        if (d > 1) {
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == ' ') {
                    p[bucle] = palabra.substring(dato, i);
                    dato = i + 1;
                    bucle++;
                }
            }
            p[bucle] = palabra.substring(dato, palabra.length());
        } else {
            p[0] = palabra;
        }
    }
    public String convertirP(String[] p, int d) {
        int vocal = -1;
        String w = "";
        if (p[d].matches("^[aeiou].*") || p.length == 1) {
            w = p[d] + "way";
        } else {
            for (int i = 0; i < p[d].length(); i++) {
                if ("aeiou".indexOf(p[d].charAt(i)) != -1) {
                    vocal = i;
                    break;
                }
            }
            if (vocal == -1) {
                w = p[d] + "ay";
            } else {
                w = p[d].substring(vocal) + p[d].substring(0, vocal) + "ay";
            }
        }
        return w;
    }
    public String getPalabra() {
        return palabra;
    }
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}