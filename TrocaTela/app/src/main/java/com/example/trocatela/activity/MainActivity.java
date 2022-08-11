package com.example.trocatela.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trocatela.R;
import com.example.trocatela.activity.Activity2;
import com.example.trocatela.model.Usuario;

public class MainActivity extends AppCompatActivity {

    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botao = findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = new Usuario("Luis Henrique " , "luis.cafu@outlook.com");
                Intent intent = new Intent(getApplicationContext(), Activity2.class);

                intent.putExtra("nome", "Luis Henrique");
                intent.putExtra("idade", 26);
                intent.putExtra("objeto",usuario);
                startActivity( intent );

            }
        });
    }
}