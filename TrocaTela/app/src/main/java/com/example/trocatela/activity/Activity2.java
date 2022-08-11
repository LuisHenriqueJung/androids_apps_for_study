package com.example.trocatela.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.trocatela.R;
import com.example.trocatela.model.Usuario;

import java.io.Serializable;

public class Activity2 extends AppCompatActivity {

    private TextView textNome,textIdade, textEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textNome = findViewById(R.id.textNome);
        textIdade = findViewById(R.id.textIdade);
        textEmail = findViewById(R.id.textEmail);

        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("nome");
        int idade = dados.getInt("idade");
        Usuario user = (Usuario) dados.getSerializable("objeto");

        textNome.setText(user.getNome());
        textIdade.setText(String.valueOf(idade));
        textEmail.setText(user.getEmail());

    }
}