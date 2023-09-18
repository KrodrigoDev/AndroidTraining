package krodrigodev.com.br.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void proximoLayout(View view){
        Intent intent = new Intent(getApplicationContext(), Alinhamentos.class);
        startActivity(intent);
        finish();
    }

    public void anteriorLayout(View view){
        Intent intent = new Intent(getApplicationContext(), FrasesDia.class);
        startActivity(intent);
        finish();
    }



}