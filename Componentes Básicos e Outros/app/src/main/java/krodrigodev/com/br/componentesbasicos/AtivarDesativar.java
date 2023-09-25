package krodrigodev.com.br.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View;
import android.widget.ToggleButton;

/**
 * @author Kauã Rodrigo
 * @since 23/09/2023
 */
public class AtivarDesativar extends AppCompatActivity {

    // atributos
    private ToggleButton toggleSenha;
    private Switch switchSenha; // switch é uma palavra reservada
    private TextView res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ativar_desativar);

        // inicialização
        toggleSenha = findViewById(R.id.toggleSenha);
        switchSenha = findViewById(R.id.switchSenha);
        res = findViewById(R.id.textRes);
    }

    // eu poderia muito bem fazer um ouvinte, mas não vou por conta da hora
    // vale lembrar que eu consigo alcançar resultados similares com check box
    public void enviarToggle(View view) {
        if (toggleSenha.isChecked()) {
            res.setText(toggleSenha.getTextOn());
        } else {
            res.setText(toggleSenha.getTextOff());
        }
    }


}