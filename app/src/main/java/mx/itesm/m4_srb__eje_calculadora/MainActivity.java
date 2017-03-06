package mx.itesm.m4_srb__eje_calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edNumber1 ;
    EditText edNumber2 ;
    TextView textResultado;
    TextView textSuma;
    TextView textResta;
    TextView textMultiplica;
    TextView textDivide;
    TextView textLimpiar;
    ImageView imVInformacion;

    static final String NUMEROS_REGEX = "^\\d+(\\.\\d{1,5}){0,1}$";

    static int operaciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edNumber1 = (EditText) findViewById(R.id.editNumber1);
        edNumber2 = (EditText) findViewById(R.id.editNumber2);
        textDivide = (TextView) findViewById(R.id.textDividir);
        textDivide.setOnClickListener(this);
        textLimpiar = (TextView) findViewById(R.id.textLimpiar);
        textLimpiar.setOnClickListener(this);
        textMultiplica = (TextView) findViewById(R.id.textMultiplicar);
        textMultiplica.setOnClickListener(this);
        textResta = (TextView) findViewById(R.id.textResta);
        textResta.setOnClickListener(this);
        textResultado = (TextView) findViewById(R.id.textResultado);
        textSuma = (TextView) findViewById(R.id.textSuma);
        textSuma.setOnClickListener(this);
        imVInformacion = (ImageView) findViewById(R.id.imageInformation);
        imVInformacion.setOnClickListener(this);
        operaciones = 0;
    }


    @Override
    public void onClick(View v) {
        double number1, number2 ,resultado = 0;
        boolean entreCero = false;
       if (v.getId() ==  R.id.imageInformation) {
           Intent intent = new Intent(MainActivity.this,InformationActivity.class);
           intent.putExtra("operaciones",String.valueOf(operaciones));
           startActivity(intent);
       } else if ( isValidNumber(edNumber1.getText().toString()) && isValidNumber(edNumber2.getText().toString())) {
           number1 = Double.parseDouble(edNumber1.getText().toString());
           number2 = Double.parseDouble(edNumber2.getText().toString());
           switch (v.getId()) {
               case R.id.textSuma:
                   resultado = number1 + number2;
                   operaciones++;
                   break;
               case R.id.textResta:
                   resultado = number1 - number2;
                   operaciones++;
                   break;
               case R.id.textMultiplicar:
                   resultado = number1 * number2;
                   operaciones++;
                   break;
               case R.id.textDividir:
                   if ( number2 == 0 ) {
                       entreCero = true;
                   }else {
                       resultado = number1 / number2;
                       operaciones++;
                   }
                   break;
               case R.id.textLimpiar:
                   edNumber2.setText("");
                   edNumber1.setText("");
                   textResultado.setText("");
                   break;
           }
           if (edNumber2.getText().length() > 0 && edNumber1.getText().length() > 0)
               if (entreCero)
                   textResultado.setText("ERROR");
                else
                    textResultado.setText(String.valueOf(resultado));
       }else {
           Toast.makeText(this.getApplicationContext(),"Verifique los valores de entrada sean numeros enteros o decimales",Toast.LENGTH_LONG).show();
       }
    }

    private boolean isValidNumber(String number){
        boolean valid = false;
        if (number.length() > 0 && number.matches(NUMEROS_REGEX)){
            valid = true;
        }
        return valid;
    }

}
