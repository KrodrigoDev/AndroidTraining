package krodrigodev.com.br.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

/**
 * @author Kauã Rodrigo
 * @since 23/09/2023
 * <p>
 * Fiz isso aqui pra praticar, além de que eu poderia usar no meu trabalho atual
 * (Almoxarifado)
 */
public class CamaraGelo extends AppCompatActivity {

    // atributos
    private TextInputEditText kgGelo, qntdSaco;
    private TextView res;

    private Button bntCalcularKg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara_gelo);

        // inicialização
        kgGelo = findViewById(R.id.campoKg);
        qntdSaco = findViewById(R.id.campoSaco);
        bntCalcularKg = findViewById(R.id.bntCalcularKg);
        res = findViewById(R.id.textResultadoKg);

        // ouvinte (poderia ser feito de outra forma, mas eu quero praticar o uso de ouvintes)
        bntCalcularKg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // recuperando valores
                String recuperarKgGelo = kgGelo.getText().toString();
                String recuperarQntdSaco = qntdSaco.getText().toString();

                // validação
                if (recuperarQntdSaco.isEmpty() || recuperarKgGelo.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_LONG).show();
                } else {
                    int quantidadeKgEntregue = Integer.parseInt(recuperarKgGelo) * Integer.parseInt(recuperarQntdSaco);
                    res.setText("No SAP deve ter solicitado : " + quantidadeKgEntregue + " KG");
                }

            }
        });

    }
}