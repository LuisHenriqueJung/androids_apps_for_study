package com.example.fragments.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.FragmentTransitionSupport;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.fragments.R;
import com.example.fragments.fragments.ContatosFragment;
import com.example.fragments.fragments.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button btnConversas, btnContatos;

    private ContatosFragment contatosFragment;
    private ConversasFragment conversasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        btnContatos = findViewById(R.id.buttonContatod);
        btnConversas = findViewById(R.id.buttonConversas);

        contatosFragment = new ContatosFragment();
        conversasFragment = new ConversasFragment();


        btnContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.frameConteudo , contatosFragment);
                transaction.commit();
            }
        });
        btnConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.frameConteudo , conversasFragment);
                transaction.commit();

            }
        });



    }
}