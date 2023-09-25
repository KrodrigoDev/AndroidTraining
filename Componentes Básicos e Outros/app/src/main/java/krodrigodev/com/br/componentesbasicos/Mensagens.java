package krodrigodev.com.br.componentesbasicos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Kauã Rodrigo
 * @since 21/09/2023
 * <p>
 * classe com a diferença entre o tempo de duração dos
 * toast e uma breve amostra do que é o alertDialog
 */
public class Mensagens extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }

    // duração curta
    public void mensagemCurta(View view) {
        Toast.makeText(getApplicationContext(), "Mensagem com curta duração", Toast.LENGTH_SHORT).show();
    }

    // duração longa
    public void mensagemLonga(View view) {
        Toast.makeText(getApplicationContext(), "Mensagem com longa duração", Toast.LENGTH_LONG).show();
    }

    // toast personalizado
    public void mensagemPersonalizada(View view) {
        Toast toast = new Toast(getApplicationContext());

        toast.setDuration(Toast.LENGTH_LONG);

        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(R.drawable.alcoolgasolina);
        toast.setView(imageView);

        TextView textView = new TextView(getApplicationContext());


        toast.show();

    }

    // dialog alert
    public void alertaMensagem(View view) {

        // instaciar alert Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this); //

        // cofigurar título e mensagem
        builder.setTitle("Finalizar janela ?");
        builder.setIcon(R.drawable.icon_saco_gelo);
        builder.setMessage("Ao clicar em sim vc vai voltar para janela anterior");

        // configurar opções de sim e não
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Clicou em não", Toast.LENGTH_LONG).show();
            }
        });

        // forçando o usuário a escolher uma opção
        builder.setCancelable(false); // false para que o usuário seja obrigado


        // mostrar o dialog
        builder.create().show();
    }

}