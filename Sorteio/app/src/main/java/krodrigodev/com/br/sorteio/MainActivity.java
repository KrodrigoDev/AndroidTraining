package krodrigodev.com.br.sorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    // atributos
    private EditText campoPalpite;
    private TextView textResultado;
    private TextView quantidadePontos;
    private TextView textInteracao;

    private int pontos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar as Views após a configuração do layout
        campoPalpite = findViewById(R.id.campoPalpite);
        textResultado = findViewById(R.id.textResultado);
        quantidadePontos = findViewById(R.id.quantidadePontos);
        textInteracao = findViewById(R.id.textInteracao);
    }

    public void palpite(View view) {

        int numeroAleatorio = gerarNumeros();
        textResultado.setText(Integer.toString(numeroAleatorio));

        String palpiteUsuario = campoPalpite.getText().toString().trim();


        if (palpiteUsuario.equals(Integer.toString(numeroAleatorio))) {
            pontos += 10;
            textInteracao.setText("ACERTOU");
            textInteracao.setTextColor(0xFF4CAF50);
        } else {

            if (pontos >= 10) {
                pontos -= 10;
            } else {
                pontos = 0;
            }

            textInteracao.setText("ERROU");
            textInteracao.setTextColor(0xFFF44336);
        }

        quantidadePontos.setText(Integer.toString(pontos));
    }

    public int gerarNumeros() {
        return new Random().nextInt(11);
    }

}