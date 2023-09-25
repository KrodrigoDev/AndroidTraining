package krodrigodev.com.br.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

/**
 * @author Kauã Rodrigo
 * @since 24/09/2023
 * <p>
 * Classe com alguns campos de textos e as diferenças enttre os inputs deles
 */
public class MainActivity extends AppCompatActivity {

    // atributos
    EditText nome, nascimento, telefone;
    TextInputEditText email;
    TextView textoDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();

    }

    // método para ir na janela de checkBox
    public void checkBoxJanela(View view) {
        startActivity(new Intent(this, CaixasTexto.class));
    }

    // método para mudar os textos
    public void enviarDadosCampos(View view) {

        String nomeDigitado = nome.getText().toString();
        String emailDigitado = email.getText().toString();
        String nascimentoDigitado = nascimento.getText().toString();
        String telefoneDigitado = telefone.getText().toString();

        textoDados.setText(
                "Nome : " + nomeDigitado + "\n\n Email : " + emailDigitado
                        + "\n\nData : " + nascimentoDigitado + "\n\nTelefone : " + telefoneDigitado);

        limpar();
    }


    // inicializando
    public void inicializar() {
        nome = findViewById(R.id.campoNome);
        nascimento = findViewById(R.id.campoNascimento);
        telefone = findViewById(R.id.campoTelefone);
        email = findViewById(R.id.campoEmail);

        textoDados = findViewById(R.id.idDados);
    }

    // limpando os campos
    public void limpar() {
        nome.setText("");
        nascimento.setText("");
        telefone.setText("");
        email.setText("");
    }


}