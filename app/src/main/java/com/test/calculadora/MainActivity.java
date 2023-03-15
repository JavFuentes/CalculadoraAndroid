package com.test.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String operacionPendiente = "";

    private float primerOperando = 0f;
    private float resultado = 0f;
    private int resultadoInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buscar el TextView que muestra el resultado
        TextView visor_resultado = findViewById(R.id.tv_resultado);

        // Asignar un listener a cada botón numérico
        Button boton1 = findViewById(R.id.btn_1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarDigito(1);
            }
        });

        Button boton2 = findViewById(R.id.btn_2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarDigito(2);
            }
        });

        Button boton3 = findViewById(R.id.btn_3);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarDigito(3);
            }
        });

        Button boton4 = findViewById(R.id.btn_4);
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarDigito(4);
            }
        });

        Button btn_5 = findViewById(R.id.btn_5);
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarDigito(5);
            }
        });

        Button boton6 = findViewById(R.id.btn_6);
        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarDigito(6);
            }
        });

        Button boton7 = findViewById(R.id.btn_7);
        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarDigito(7);
            }
        });

        Button boton8 = findViewById(R.id.btn_8);
        boton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarDigito(8);
            }
        });

        Button boton9 = findViewById(R.id.btn_9);
        boton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarDigito(9);
            }
        });

        Button boton0 = findViewById(R.id.btn_0);
        boton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarDigito(0);
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

        // Asignar un listener a cada botón de operación
        Button botonSuma = findViewById(R.id.btn_suma);
        botonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacionPendiente = "+";
                primerOperando = Float.parseFloat(visor_resultado.getText().toString());
                visor_resultado.setText("");
            }
        });

        Button botonResta = findViewById(R.id.btn_resta);
        botonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacionPendiente = "-";
                primerOperando = Float.parseFloat(visor_resultado.getText().toString());
                visor_resultado.setText("");
            }
        });

        Button botonMultiplicacion = findViewById(R.id.btn_multiplicacion);
        botonMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacionPendiente = "*";
                primerOperando = Float.parseFloat(visor_resultado.getText().toString());
                visor_resultado.setText("");
            }
        });

        Button botonDivision = findViewById(R.id.btn_division);
        botonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacionPendiente = "/";
                primerOperando = Float.parseFloat(visor_resultado.getText().toString());
                visor_resultado.setText("");
            }
        });

        // Asignar un listener al botón punto
        Button botonPunto = findViewById(R.id.btn_punto);
        botonPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarPunto();
            }
        });
    }

    // Método para agregar un dígito al número en pantalla
    public void agregarDigito(int digito) {

        // Buscar el TextView que muestra el resultado
        TextView visor_resultado = findViewById(R.id.tv_resultado);

        // Obtener el número actual
        String numeroActual = visor_resultado.getText().toString();
        numeroActual = eliminarCerosIzquierda(numeroActual);

        // Agregar el nuevo dígito
        String nuevoNumero = numeroActual + digito;

        // Mostrar el nuevo número en pantalla
        visor_resultado.setText(nuevoNumero);
    }

    public void agregarPunto() {

        // Buscar el TextView que muestra el resultado
        TextView visor_resultado = findViewById(R.id.tv_resultado);

        // Obtener el número actual
        String numeroActual = visor_resultado.getText().toString();

        // Agregar el nuevo dígito
        String nuevoNumero = numeroActual + ".";

        // Mostrar el nuevo número en pantalla
        visor_resultado.setText(nuevoNumero);
    }

    // Método para calcular el resultado final
    private void realizarOperacion() {

        // Buscar el TextView que muestra el resultado
        TextView visor_resultado = findViewById(R.id.tv_resultado);

        // Realizar la operación pendiente (si existe)
        if (operacionPendiente.equals("+")) {
            resultado = primerOperando + Float.parseFloat(visor_resultado.getText().toString());
        } else if (operacionPendiente.equals("-")) {
            resultado = primerOperando - Float.parseFloat(visor_resultado.getText().toString());
        } else if (operacionPendiente.equals("*")) {
            resultado = primerOperando * Float.parseFloat(visor_resultado.getText().toString());
        } else if (operacionPendiente.equals("/")) {
            resultado = primerOperando / Float.parseFloat(visor_resultado.getText().toString());
        }

        // Mostrar el resultado final en pantalla
        if (Math.floor(resultado) == resultado) {
            resultadoInt = (int) resultado;
            visor_resultado.setText(String.valueOf(resultadoInt));
        } else {
            // El número float tiene una parte decimal distinta de cero, no se puede convertir a int
            visor_resultado.setText(String.valueOf(resultado));

        }
        // Se reinician variables
        operacionPendiente = "";
        resultado = 0;
    }

    //  Función que reinicia las operaciones
    public void borrar() {

        // Buscar el TextView que muestra el resultado
        TextView visor_resultado = findViewById(R.id.tv_resultado);

        // Borra el contenido del TextView y reinicia variables
        visor_resultado.setText("0");
        operacionPendiente = "";
        primerOperando = 0f;
    }

    //  Función que elimina los ceros a la izquerda de una cadena
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
}