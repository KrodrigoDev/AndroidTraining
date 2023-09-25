package krodrigodev.com.br.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

/**
 * @author Kauã Rodrigo
 * @since 24/09/2023
 */
public class Gorjeta extends AppCompatActivity {

    // atributos
    private android.widget.SeekBar barraGorjeta;
    private TextView textoGorjeta, textoTotal, textoPorcento;
    private TextInputEditText campoValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorjeta);

        // inicialização
        barraGorjeta = findViewById(R.id.seekBarPorcentagem);
        textoGorjeta = findViewById(R.id.textValorGorjeta);
        textoTotal = findViewById(R.id.textValorTotal);
        campoValor = findViewById(R.id.campoValor);
        textoPorcento = findViewById(R.id.textoPorcenta);

        // ouvinte
        barraGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // a porcentagem vai mudando conforme o usuário vai deslizando a seekBar
                textoPorcento.setText(progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // ao ser clicado iria realizar uma ação
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // o calculo só vai ser realizado quando o usuário soltar o seekBar
                calcular();
            }
        });


    }

    // método que vai calcular a  gorjeta
    public void calcular() {

        String valorDigitado = campoValor.getText().toString();

        if (valorDigitado.isEmpty()) {

            Toast.makeText(getApplicationContext(), "Preencha o valor antes de calcular", Toast.LENGTH_SHORT).show();

        } else {

            double valorConvertido = Double.parseDouble(valorDigitado);
            int porcentagem = barraGorjeta.getProgress();

            double calcGorjeta = (valorConvertido * porcentagem) / 100.0; // regra de três

            textoGorjeta.setText("R$ " + calcGorjeta);
            textoTotal.setText("R$ " + (calcGorjeta + valorConvertido));

        }
    }


}