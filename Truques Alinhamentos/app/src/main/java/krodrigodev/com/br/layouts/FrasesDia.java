package krodrigodev.com.br.layouts;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class FrasesDia extends AppCompatActivity {

    private TextView textFraseDia, textDataAtual;
    private LocalDate data;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frases_dia);

        textFraseDia = findViewById(R.id.FraseDaVez);
        textDataAtual = findViewById(R.id.diaAtual);

        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Inicialize a variável 'data' com a data atual
        data = LocalDate.now();
        textDataAtual.setText(data.format(dataFormatada));
    }


    // método para realizar a escolha da frase
    public void frases(View view) {

        String[] frasesBizaras = {"Hoje tem?", "Boa relembrar", "Tô sem ideias", "Cê vai sentar na cabeça", "Bora beber um vinho", "Era pra ser umas frases bonitinhas, mas nem tudo são flores", "A vida é uma piada, e a punchline é você", "Se a vida te der limões, faça uma caipirinha", "Sorria, mesmo que seja um sorriso amarelo", "Quando a vida te derrubar, faça uma flexão", "Nada é impossível, mas algumas coisas são improváveis", "A verdade está lá fora... mas evite o trânsito e fique em casa", "A melhor vingança é viver bem, mas também pode ser uma lasanha bem feita", "O otimista vê o copo meio cheio, o pessimista vê o copo meio vazio, o realista pergunta quem bebeu metade do meu refrigerante", "Quando a vida te desafiar, pisque para a vida e diga: 'É tudo o que você tem?'", "O sucesso é como ser grávido, todos dizem parabéns, mas ninguém sabe como você conseguiu", "A única coisa constante na vida é a mudança, e as contas para pagar", "Se você não pode rir das próprias falhas, pelo menos ria das falhas dos outros", "O tempo voa, mas pelo menos você é o piloto", "Lembre-se, você é único, assim como todos os outros", "A cada dia que passa, aumenta a lista de coisas que não sei",};


        textFraseDia.setText(frasesBizaras[gerarNumerosAle()]);
    }


    // método criado para simplificar a sepração, mas pderia ser movido para o método principal
    // do botão
    public int gerarNumerosAle() {
        return new Random().nextInt(18); // ele vai gerar de 0 até 18
    }


}