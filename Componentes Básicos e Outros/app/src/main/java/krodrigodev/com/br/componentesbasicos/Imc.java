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
public class Imc extends AppCompatActivity {

    // atributos
    private TextInputEditText campoPeso, campoAltura;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        // inicialização
        campoPeso = findViewById(R.id.campoPeso);
        campoAltura = findViewById(R.id.campoAltura);
        res = findViewById(R.id.textResultadoIMC);
    }

    // realizando o calculo do imc (Eu poderia ter feito uma sepração melhor)
    public void imc(View view) {
        try {

            String pesoRecuperado = campoPeso.getText().toString();
            String alturaRecuperada = campoAltura.getText().toString();

            // validação
            if (pesoRecuperado.isEmpty() || alturaRecuperada.isEmpty()) {

                Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();

            } else {

                // recuperando os valores e realizando o calculo
                float peso = Float.parseFloat(pesoRecuperado);
                float altura = Float.parseFloat(alturaRecuperada);
                float imc = peso / (altura * altura);

                // faixas do imc
                if (imc < 18.5) {
                    res.setText("Magreza");
                } else if (imc >= 18.5 && imc < 24.9) {
                    res.setText("Normal");
                } else if (imc >= 24.9 && imc < 29.9) {
                    res.setText("Sobrepeso");
                } else if (imc >= 29.9 && imc < 34.9) {
                    res.setText("Obesidade Grau I");
                } else if (imc >= 34.9 && imc < 39.9) {
                    res.setText("Obesidade Grau II");
                } else if (imc > 40) {
                    res.setText("Obesidade Grau III");
                }

            }

        } catch (Exception erro) {
            Toast.makeText(getApplicationContext(), "Use apenas pontos ex: 1.73", Toast.LENGTH_LONG).show();
        }

    }
}