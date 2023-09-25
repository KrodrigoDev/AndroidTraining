package krodrigodev.com.br.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

/**
 * @author Kauã Rodrigo
 * @since 24/09/2023
 */
public class AlcoolGasolina extends AppCompatActivity {

    // atributos
    private TextInputEditText gasolina, alcool;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcool_gasolina);

        // inicialização
        gasolina = findViewById(R.id.campoGasolina);
        alcool = findViewById(R.id.campoAlcool);
        resultado = findViewById(R.id.textResultado);


    }

    public void calcular(View view) {

        // recuperando valores
        String recuperarGasolina = gasolina.getText().toString();
        String recuperarAlcool = alcool.getText().toString();

        if (recuperarGasolina.isEmpty() || recuperarAlcool.isEmpty()) {

            Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_LONG).show();

        } else {

            double precoGasolina = Double.parseDouble(recuperarGasolina.replace(",", "."));
            double precoAlcool = Double.parseDouble(recuperarAlcool.replace(",", "."));

            // avaliação (vi esse calculo em um site)
            if ((precoAlcool / precoGasolina) >= 0.7) {
                resultado.setText("Ácool compesa mais");
            } else {
                resultado.setText("Gasolina compesa mais");
            }

        }
    }
}