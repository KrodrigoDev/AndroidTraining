package krodrigodev.com.br.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Kauã Rodrigo
 * @since 23/09/2023
 * <p>
 * Nessa classe tem uma concentração enorme de botões e caminhos que levam
 * para activitys diferentes (Gambiarra e preguiça de fazer um menu)
 */
public class CaixasTexto extends AppCompatActivity {

    // atributos
    private CheckBox lucro, despesa;
    private TextView resultado;
    private RadioButton masculino, feminino, outro;
    private RadioGroup grupo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caixas_texto);

        // inicialização
        lucro = findViewById(R.id.idLucro);
        despesa = findViewById(R.id.idDespesa);
        resultado = findViewById(R.id.idResultado);
        masculino = findViewById(R.id.masculino);
        feminino = findViewById(R.id.feminino);
        outro = findViewById(R.id.outro);
        grupo = findViewById(R.id.grupoRadio);

        ouvinteGrupo();
    }

    // método que tem um ouvinte (grupo)
    public void ouvinteGrupo() {
        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (masculino.isChecked()) {
                    resultado.setText(masculino.getText().toString());
                } else if (feminino.isChecked()) {
                    resultado.setText(feminino.getText().toString());
                } else {
                    Toast.makeText(getApplicationContext(), "Teste usando ouvinte", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // método
    public boolean enviar(View view) {
        boolean lucroSelecionado = lucro.isChecked();
        boolean despesaSelecionado = despesa.isChecked();
        boolean masculinoSelecionado = masculino.isChecked();
        boolean femininoSelecionado = feminino.isChecked();


        if (lucroSelecionado || despesaSelecionado) {
            resultado.setText(lucro.getText().toString() + " : " + lucroSelecionado + "\n\nDespesa : " + despesaSelecionado);
            return true;
        }

        // randio button
        if (masculinoSelecionado || femininoSelecionado) {
            resultado.setText(masculino.getText().toString());
            return true;
        }
        Toast.makeText(getApplicationContext(), "Selecione uma das caixas", Toast.LENGTH_LONG).show();
        return false;
    }


    // todos os métodos de navegação

    public void janelaCamaraGelo(View view) {
        startActivity(new Intent(this, CamaraGelo.class));
    }

    public void janelaAlcoolGasolina(View view) {
        startActivity(new Intent(this, AlcoolGasolina.class));
    }

    public void janelaAtivarDesativar(View view) {
        startActivity(new Intent(this, AtivarDesativar.class));
    }

    public void janelaToast(View view) {
        startActivity(new Intent(this, Mensagens.class));
    }

    public void janelaBarrasProgresso(View view) {
        startActivity(new Intent(this, BarraProgresso.class));
    }

    public void janelaImc(View view) {
        startActivity(new Intent(this, Imc.class));
    }

    public void janelaSeekBar(View view) {
        startActivity(new Intent(this, SeekBar.class));
    }

    public void janelaGorjeta(View view) {
        startActivity(new Intent(this, Gorjeta.class));
    }

}