package inacaptemuco.com.inacapone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import operaciones.Salud;

public class ResultadoActivity extends AppCompatActivity {

    // 1.- Creamos un objeto de la clase TextView
    TextView txvResultado;
    TextView txvResultadoNombre;
    TextView txvResultadoPesoActual;
    TextView txvResultadoPesoIdeal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        // 2.- Asociar al objeto el componente del layout
        txvResultadoNombre = (TextView) findViewById(R.id.txv_resultado_nombre);
        txvResultadoPesoActual = (TextView) findViewById(R.id.txv_resultado_peso_actual);
        txvResultadoPesoIdeal = (TextView) findViewById(R.id.txv_resultado_ideal);
        // 3.- Capturamos el objeto de la clase Intent que se envía desde el MainAtivity
        Intent intento = getIntent();
        // 4.- Obtenemos los datos enviados en el Activity
        Bundle datosRecibidos = intento.getExtras();
        // 5.- Capturamos uno de los datos enviados desde el Activity mediante en intento.
        int edadRecibida = datosRecibidos.getInt("p_edad");
        int pesoRecibido = datosRecibidos.getInt("p_peso");
        String nombreRecibido = datosRecibidos.getString("p_nombre");

        // 5.1.- Creamos el objeto de la clase Salud.
        Salud salud = new Salud();
        //5.2.- Mediante los Setter asignamos las propiedades al objeto
        salud.setNombre(nombreRecibido);
        salud.setEdad(edadRecibida);
        salud.setPesoRecibido(pesoRecibido);
        // 5.3.- Calculamos el peso Ideal utilizando el método de la clase Salud.

        // 6.- Modificamos el TextView del resultado con lo que corresponde
        txvResultadoNombre.setText("Nombre: " + salud.getNombre());
        txvResultadoPesoActual.setText("Peso Actual: " + salud.getPesoRecibido());
        txvResultadoPesoIdeal.setText("Peso Ideal: " + salud.calcularPesoIdeal());

    }
}
