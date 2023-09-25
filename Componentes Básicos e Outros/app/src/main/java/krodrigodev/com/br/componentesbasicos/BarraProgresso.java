package krodrigodev.com.br.componentesbasicos;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * @author Kauã Rodrigo
 * @since 24/09/2023
 * <p>
 * Quero aprender a utilizar melhor essas barras de progresso
 * já que tentei implementar algumas coisas que eu constumava utilizar
 * no swing e não deu certo aqui
 */
public class BarraProgresso extends AppCompatActivity {

    // atributos
    private ProgressBar barraProgresso1, barraProgresso2, circuloProgresso;
    private TextView porcentagem;
    private int progresso = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barra_progresso);

        // inicialização
        barraProgresso1 = findViewById(R.id.progressBar1);
        barraProgresso2 = findViewById(R.id.progressBar2);
        circuloProgresso = findViewById(R.id.progressBarCircular);
        porcentagem = findViewById(R.id.textPorcentagem);

        // escondendo progresso cirular
        circuloProgresso.setVisibility(View.GONE);


    }

    public void carregarBarra1(View view) {
        progresso += 10;
        barraProgresso1.setProgress(progresso);
        circuloProgresso.setVisibility(View.VISIBLE);

        if (progresso == 100) {
            circuloProgresso.setVisibility(View.GONE);
            progresso = 0;
        }
    }

    public void carregarBarra2(View view) {
        progresso += 10;
        barraProgresso2.setProgress(progresso);
        porcentagem.setText(progresso + "%");

        if (progresso == 100) {
            progresso = 0;
        }

    }


}