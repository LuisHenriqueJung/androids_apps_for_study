package com.example.chain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void geraFrase(View view){

        TextView texto = (TextView)findViewById(R.id.localTexto);
        int numeroFrase = new Random().nextInt(7);

        String[] frases;
        frases = new String[7];

        frases[0]=("As pessoas costumam dizer que a motivação não dura sempre. Bem, nem o efeito do banho, por isso recomenda-se diariamente.");
        frases[1]= ("No meio da dificuldade encontra-se a oportunidade.");
        frases[2]= ("Eu faço da dificuldade a minha motivação. A volta por cima vem na continuação.");
        frases[3]=("O que me preocupa não é o grito dos maus. É o silêncio dos bons.");
        frases[4]=("Você precisa fazer aquilo que pensa que não é capaz de fazer.");
        frases[5]=("O sucesso é ir de fracasso em fracasso sem perder o entusiasmo.");
        frases[6]=("Lute com determinação, abrace a vida com paixão, perca com classe e vença com ousadia, porque o mundo pertence a quem se atreve e a vida é muito para ser insignificante.");
        texto.setText(frases[numeroFrase]);


    }
}