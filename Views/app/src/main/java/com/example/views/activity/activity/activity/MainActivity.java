package com.example.views.activity.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.views.R;
import com.example.views.activity.activity.RecyclerItemClickListener;
import com.example.views.activity.activity.adapter.Adapter;
import com.example.views.activity.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycleViewFilmes;
    private List<Filme> listaFilme = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleViewFilmes = findViewById(R.id.recyclerView);

        this.criarFilmes();

        Adapter adapter = new Adapter( listaFilme );

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycleViewFilmes.setLayoutManager( layoutManager );
        recycleViewFilmes.setHasFixedSize(true);
        recycleViewFilmes.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recycleViewFilmes.setAdapter( adapter );

        recycleViewFilmes.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recycleViewFilmes,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Presionouuuuu",
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Seguroooooou",
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );

    }
    public void criarFilmes(){

        Filme filme = new Filme("Homiranha","Locurage","2017");
        this.listaFilme.add( filme );
         filme = new Filme("Muié maravilha     ","Leite","2018");
        this.listaFilme.add( filme );
        filme = new Filme("Liga da injstiça","Boiolage","2011");
        this.listaFilme.add( filme );
         filme = new Filme("It o bagulho","Fantasmagórico","2012");
        this.listaFilme.add( filme );
         filme = new Filme("pic pic","Desehu","2017");
        this.listaFilme.add( filme );
         filme = new Filme("ta ne ","Leite","2017");
        this.listaFilme.add( filme );
         filme = new Filme("Ueeee","Leite","2017");
        this.listaFilme.add( filme );
         filme = new Filme("Chegua","Leite","2017");
        this.listaFilme.add( filme );
         filme = new Filme("no guentu mais","Leite","2017");
        this.listaFilme.add( filme );

    }
}