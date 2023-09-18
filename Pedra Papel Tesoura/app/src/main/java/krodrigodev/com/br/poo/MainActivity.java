package krodrigodev.com.br.poo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView vazio;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fazendo referência
        inicializar();
    }

    // opção selecionada pelo usuário
    public void pedraSelecionada(View view) {
        opcaoSelecionada(0);
    }

    public void papelSelecionada(View view) {
        opcaoSelecionada(1);
    }

    public void tesouraSelecionada(View view) {
        opcaoSelecionada(2);
    }

    public void opcaoSelecionada(int opcao) {
        int escolhaApp = escolhaApp();

        if (opcao == escolhaApp) {

            resultado.setText("Empataram :D");

        } else if ((opcao == 0 && escolhaApp == 2) || // pedra X tesoura
                   (opcao == 1 && escolhaApp == 0) || // papel X pedra
                   (opcao == 2 && escolhaApp == 1)) {//tesoura X papel

            resultado.setText("Você venceu!");

        } else {

            resultado.setText("App venceu!");

        }
    }

    // vai gerar um número
    public int escolhaApp() {

        int ale = new Random().nextInt(3); // vai de 0 até 2

        switch (ale) {
            case 0:
                vazio.setImageResource(R.drawable.papel);
                break;
            case 1:
                vazio.setImageResource(R.drawable.papel);
                break;
            case 2:
                vazio.setImageResource(R.drawable.tesoura);
                break;
        }

        return ale;

    }

    public void inicializar() {
        vazio = findViewById(R.id.imgEscolhaApp);
        resultado = findViewById(R.id.textResultado);
    }
}