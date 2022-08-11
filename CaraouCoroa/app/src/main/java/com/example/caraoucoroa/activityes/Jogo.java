package com.example.caraoucoroa.activityes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caraoucoroa.R;

public class Jogo extends AppCompatActivity {

    private ImageView imagemMoeda;
    private ImageView btnVoltar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        imagemMoeda = findViewById(R.id.imageMoeda);
        btnVoltar = findViewById(R.id.btnVoltar);

        Bundle recebeDados = getIntent().getExtras();
        int valorMoeda = recebeDados.getInt("moeda");

        insereImagem(valorMoeda);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voltarpgIncial = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(voltarpgIncial);
            }
        });

    }
    public void insereImagem(int valorMoeda){
        if(valorMoeda == 0){
            imagemMoeda.setImageResource(R.drawable.moeda_cara);

        }else{
            imagemMoeda.setImageResource(R.drawable.moeda_coroa);
        }
    }

}