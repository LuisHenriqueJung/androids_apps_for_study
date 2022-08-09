package com.example.pedrapapeltesoura;

import static com.example.pedrapapeltesoura.R.drawable.papel;
import static com.example.pedrapapeltesoura.R.drawable.pedra;
import static com.example.pedrapapeltesoura.R.drawable.tesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int selecaoUser;
    int selecaoCPU;

    public void selecionadoPedra(View view){
        ImageView suaEscolha = findViewById(R.id.imgSuaEscolha);
        suaEscolha.setImageResource(pedra);
        this.selecaoUser =0;
        selecaoCPU();
    }
    public void selecionadoPapel(View view){

        ImageView suaEscolha = findViewById(R.id.imgSuaEscolha);
        suaEscolha.setImageResource(papel);
        this.selecaoUser =1;
        selecaoCPU();
    }
    public void selecionadoTesoura(View view){
        ImageView suaEscolha = findViewById(R.id.imgSuaEscolha);
        suaEscolha.setImageResource(tesoura);
        this.selecaoUser =2;
        selecaoCPU();
    }

    public void selecaoCPU(){
        int selecao = new Random().nextInt(2);
        ImageView escolhaApp = findViewById(R.id.imgEscolhaApp);

        if (selecao == 0) {
            escolhaApp.setImageResource(pedra);
        }
        else if(selecao == 1) {
            escolhaApp.setImageResource(papel);
        }
        else{
            escolhaApp.setImageResource(tesoura);
        }

        this.selecaoCPU = selecao;

        aplicaResultado(this.selecaoUser,this.selecaoCPU);
    }

    public void aplicaResultado(int selecaoUser,int selecaoCPU){
        System.out.println(selecaoCPU);
        TextView resultado = findViewById(R.id.txResultado);

        if (selecaoUser == 0 && selecaoCPU == 0 ||
                selecaoUser == 1 && selecaoCPU == 1 ||
                selecaoUser == 2 && selecaoCPU == 2
        ){
            resultado.setText("Empate");
        }
        else if( selecaoUser == 0 && selecaoCPU == 2 ||  selecaoUser == 2 && selecaoCPU == 1 || selecaoUser == 1 && selecaoCPU == 0 ){
            resultado.setText("Você venceu!");
        }
        else{
            resultado.setText("Você perdeu!");
        }
    }





}