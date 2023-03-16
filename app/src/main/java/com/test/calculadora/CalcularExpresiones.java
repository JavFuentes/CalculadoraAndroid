package com.test.calculadora;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

// Clase CalcularExpresiones para evaluar expresiones matemáticas
public class CalcularExpresiones {

    // Método main para probar la clase CalcularExpresiones
    public static void main(String[] args) {
        // Definir una expresión matemática como cadena de caracteres
        String expresion = "(3.2+4.8)*(5.1-2.3)/3";

        // Calcular el resultado de la expresión
        double resultado = evaluarExpresion(expresion);

        // Imprimir el resultado en la consola
        System.out.println("Resultado: " + resultado);
    }

    // Método evaluarExpresion que recibe una cadena con la expresión matemática
    // y devuelve el resultado como un valor double
    public static double evaluarExpresion(String expresion) {
        // Crear un objeto Expression utilizando la biblioteca exp4j
        Expression e = new ExpressionBuilder(expresion).build();

        // Evaluar la expresión y devolver el resultado
        return e.evaluate();
    }
}