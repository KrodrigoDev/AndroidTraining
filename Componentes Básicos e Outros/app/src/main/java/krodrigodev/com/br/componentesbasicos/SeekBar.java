package krodrigodev.com.br.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * @author Kauã Rodrigo
 * @since 24/09/2023
 * <p>
 * Utilizando o seek bar para recuperar um palpite do usuário (Joguinho de adivinhação)
 */
public class SeekBar extends AppCompatActivity {

    // atributos
    private android.widget.SeekBar barraPalpite;
    private TextView textoResultado;
    private int numeroSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        // inizialização
        barraPalpite = findViewById(R.id.barraPalpite);
        textoResultado = findViewById(R.id.textResultadoSeek);

        // ouvinte
        barraPalpite.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
                // chamado quando eu arrasto o seek bar
                numeroSelecionado = progress;
            }

            @Override
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
                // chamado quando eu clico no seek bar
            }

            @Override
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
                // chamado quando eu soltou o seek bar
            }
        });

    }

    // método para comparar o chute
    public void compararChute(View view) {

        int numeroAle = gerarNumeroAle();

        if (numeroSelecionado == numeroAle) {
            textoResultado.setTextColor(getColor(R.color.green));
            textoResultado.setText("ACERTOU");
        } else {
            textoResultado.setText("ERROU, PENSEI EM " + numeroAle);
            textoResultado.setTextColor(getColor(R.color.red));
        }
    }

    // método que está gerando o número aleatório
    public int gerarNumeroAle() {
        return new Random().nextInt(16);
    }
}