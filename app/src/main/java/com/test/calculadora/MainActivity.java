package com.test.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private String expresion = "";
    private double resultado = 0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignar un listener a cada botón numérico
        Button boton1 = findViewById(R.id.btn_1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter("1");
            }
        });

        Button boton2 = findViewById(R.id.btn_2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter("2");
            }
        });

        Button boton3 = findViewById(R.id.btn_3);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter("3");
            }
        });

        Button boton4 = findViewById(R.id.btn_4);
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter("4");
            }
        });

        Button btn_5 = findViewById(R.id.btn_5);
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter("5");
            }
        });

        Button boton6 = findViewById(R.id.btn_6);
        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter("6");
            }
        });

        Button boton7 = findViewById(R.id.btn_7);
        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter("7");
            }
        });

        Button boton8 = findViewById(R.id.btn_8);
        boton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter("8");
            }
        });

        Button boton9 = findViewById(R.id.btn_9);
        boton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter("9");
            }
        });

        Button boton0 = findViewById(R.id.btn_0);
        boton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter("0");
            }
        });

        Button botonSuma = findViewById(R.id.btn_suma);
        botonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter("+");
            }
        });

        Button botonResta = findViewById(R.id.btn_resta);
        botonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter("-");
            }
        });

        Button botonMultiplicacion = findViewById(R.id.btn_multiplicacion);
        botonMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter("*");
            }
        });

        Button botonDivision = findViewById(R.id.btn_division);
        botonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter("/");
            }
        });

        // Asignar un listener al botón de apertura de paréntesis
        Button botonParentesisApertura = findViewById(R.id.btn_parentesis_apertura);
        botonParentesisApertura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter("(");
            }
        });

        // Asignar un listener al botón de cierre de paréntesis
        Button botonParentesisCierre = findViewById(R.id.btn_parentesis_cierre);
        botonParentesisCierre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter(")");
            }
        });

        // Asignar un listener al botón de borrar
        Button botonBorrar = findViewById(R.id.btn_borrar);
        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrar();
            }
        });

        // Asignar un listener al botón de resultado
        Button botonResultado = findViewById(R.id.btn_resultado);
        botonResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarOperacion();
            }
        });

        // Asignar un listener al botón punto
        Button botonPunto = findViewById(R.id.btn_punto);
        botonPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarCaracter(".");
            }
        });
    }

    // Método para agregar un caracter al número en pantalla
    public void agregarCaracter(String caracter) {

        // Buscar el TextView que muestra el resultado
        TextView visor_resultado = findViewById(R.id.tv_resultado);

        // Obtener el número actual
        String expresionActual = visor_resultado.getText().toString();
        expresionActual = eliminarCerosIzquierda(expresionActual);

        // Agregar el nuevo dígito
        String nuevaExpresion = expresionActual + caracter;

        // Mostrar el nuevo número en pantalla
        visor_resultado.setText(nuevaExpresion);
    }


    // Función que reinicia las operaciones
    public void borrar() {

        // Buscar el TextView que muestra el resultado
        TextView visor_resultado = findViewById(R.id.tv_resultado);

        // Borra el contenido del TextView
        visor_resultado.setText("0");
    }

    // Función que elimina los ceros a la izquerda de una cadena
    public static String eliminarCerosIzquierda(String cadena) {

        // Verifica si la cadena es nula o está vacía, si es así devuelve la cadena original
        if (cadena == null || cadena.isEmpty()) {
            return cadena;
        }

        // Recorre la cadena hasta encontrar el primer caracter distinto de cero
        int i = 0;
        while (i < cadena.length() && cadena.charAt(i) == '0') {
            i++;
        }

        // Devuelve la subcadena a partir del primer caracter distinto de cero
        return cadena.substring(i);
    }

    // Método para calcular el resultado final
    private void realizarOperacion() {

        // Buscar el TextView que muestra el resultado
        TextView visor_resultado = findViewById(R.id.tv_resultado);

        // Obtener la expresión matemática como una cadena de caracteres desde el TextView
        expresion = visor_resultado.getText().toString();

        // Calcular el resultado de la expresión utilizando la clase CalcularExpresiones
        resultado = CalcularExpresiones.evaluarExpresion(expresion);

        // Crear un objeto DecimalFormat para limitar el resultado a un máximo de 8 decimales
        DecimalFormat df = new DecimalFormat("#.########");

        // Formatear el resultado utilizando el objeto DecimalFormat creado
        String resultadoFormateado = df.format(resultado);

        // Establecer el resultado formateado en el TextView que muestra el resultado
        visor_resultado.setText(resultadoFormateado);
    }
}