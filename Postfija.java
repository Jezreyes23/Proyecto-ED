package clases;
import java.util.Stack;
public class Postfija {
  private int precedencia(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    public String convertir(String expresion) {
        String resultado="";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            
            if (Character.isLetterOrDigit(c)) {
                resultado += c;
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    resultado += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                   
                } else {
                    stack.pop();
                }
            } else { 
                while (!stack.isEmpty() && precedencia(c) <= precedencia(stack.peek())) {
                    resultado += stack.pop();
                }
                stack.push(c);
                
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                 
            resultado += stack.pop();
      
        }
            return resultado;
        }
        public String tabular(String expresion) {
            String resultado="", tabla = "";
            Stack<Character> stack = new Stack<>();
    
            for (int i = 0; i < expresion.length(); i++) {
                char c = expresion.charAt(i);
                
                if (Character.isLetterOrDigit(c)) {
                    resultado += c;
                    tabla = tabla+c+" | "+stack+" | "+resultado+"\n";
                }
                else if (c == '(') {
                    stack.push(c);
                    tabla = tabla+c+" | "+stack+" | "+resultado+"\n";
                }
                else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        resultado += stack.pop();
                        tabla = tabla+c+" | "+stack+" | "+resultado+"\n";
                    }
                    if (!stack.isEmpty() && stack.peek() != '(') {
                       
                    } else {
                        stack.pop();
                        tabla = tabla+c+" | "+stack+" | "+resultado+"\n";
                    }
                } else { 
                    while (!stack.isEmpty() && precedencia(c) <= precedencia(stack.peek())) {
                        resultado += stack.pop();
                        tabla = tabla+c+" | "+stack+" | "+resultado+"\n";
                    }
                    stack.push(c);
                    tabla = tabla+c+" | "+stack+" | "+resultado+"\n";
                }
            }
            while (!stack.isEmpty()) {
                if (stack.peek() == '(')
                     
                resultado += stack.pop();
                tabla = tabla+" | "+stack+" | "+resultado+"\n";
            }
                return tabla;
            }
    
    public double evaluarPostfija(String expresion, double[] valores) {
        Stack<Double> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            if (Character.isLetter(c)) {
                stack.push(valores[index++]);
            } else {
                double val1 = stack.pop();
                double val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
