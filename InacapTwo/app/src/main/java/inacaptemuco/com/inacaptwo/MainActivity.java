package inacaptemuco.com.inacaptwo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import clases.Seguro;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtAnoVehiculo;
    ImageButton imbCalcular;
    TextView txvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAnoVehiculo = (EditText) findViewById(R.id.edt_ingresa_ano);
        imbCalcular = (ImageButton) findViewById(R.id.imb_calcular);
        txvResultado = (TextView) findViewById(R.id.txv_resultado);

        imbCalcular.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        int anoIngresado = Integer.parseInt(edtAnoVehiculo.getText().toString());
        Seguro seguro = new Seguro();
        seguro.setAnoVehiculo(anoIngresado);
        seguro.setValorUf(27000);

        double valorSeguro = seguro.calcularValorSeguro();
        txvResultado.setText("El valor del seguro es: " + valorSeguro);
        consultarDatos();
    }

    public void consultarDatos() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://mindicador.cl/api/uf/10-10-2018";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                       // mTextView.setText("Response is: "+ response.substring(0,500));
                        Context context= getApplicationContext();
                        Toast toast= Toast.makeText(context, "Valor UF obtenido: ", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txvResultado.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
