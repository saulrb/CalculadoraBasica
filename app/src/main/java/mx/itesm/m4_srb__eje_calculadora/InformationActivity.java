package mx.itesm.m4_srb__eje_calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InformationActivity extends AppCompatActivity {

    TextView textOperaciones ;
    static String OPERACIONES = "Cantidad de Operaciones:";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        textOperaciones = (TextView) findViewById(R.id.textOperaciones);
        String operaciones = getIntent().getExtras().getString("operaciones");
        textOperaciones.setText(OPERACIONES.concat(operaciones));
    }
}
