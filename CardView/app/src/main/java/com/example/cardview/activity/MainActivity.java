package com.example.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cardview.Adapter.PostagemAdapter;
import com.example.cardview.Model.Postagem;
import com.example.cardview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerPostagem.setLayoutManager( layoutManager );

        this.preparaPostagens();

        PostagemAdapter adapter = new PostagemAdapter( postagens );
        recyclerPostagem.setAdapter( adapter );
    }
    public void preparaPostagens(){
        Postagem p = new Postagem( "Luis Henrique", "Só doidera", R.drawable.imagem1);
        this.postagens.add(p);
        p = new Postagem( "Luis Fernando", "Só tranquilidade", R.drawable.imagem2);
        this.postagens.add(p);
        p = new Postagem( "Luis Alberto", "Só religiosidade", R.drawable.imagem3);
        this.postagens.add(p);
        p = new Postagem( "Luis Paulo", "Só insanidade", R.drawable.imagem4);
        this.postagens.add(p);
    }
}