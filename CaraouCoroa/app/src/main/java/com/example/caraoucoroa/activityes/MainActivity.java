package com.example.caraoucoroa.activityes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.caraoucoroa.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView btnJogar;

    private int imagemMoedaID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJogar = findViewById(R.id.btnJogar);


        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogaMoeda();

                Intent abrirTela = new Intent(getApplicationContext(), Jogo.class);
                abrirTela.putExtra("moeda", imagemMoedaID);
                startActivity(abrirTela);

            }
        });
    }
    public int jogaMoeda(){

        imagemMoedaID = new Random().nextInt(2);
        return imagemMoedaID;
    }
}