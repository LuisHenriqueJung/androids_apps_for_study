package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView nome;
    private  TextView email;
    private TextView exibeDados;

    private  String recebeNome;
    String recebeEmail;

    private CheckBox checkAzul;
    private CheckBox checkVerde;
    private CheckBox checkVermelho;
    private TextView exibeSelecionados;
    private String coresSelecionadas = "";

    private RadioButton masculino;
    private RadioButton feminino;
    private RadioGroup sexo;
    private TextView exibeSexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.tiNome);
        email = findViewById(R.id.tiEmail);
        exibeDados = findViewById(R.id.tvExibeDados);

        recebeNome = nome.getText().toString();
        recebeEmail = email.getText().toString();

        checkAzul = findViewById(R.id.cbAzul);
        checkVerde = findViewById(R.id.cbVerde);
        checkVermelho = findViewById(R.id.cbVermelho);
        exibeSelecionados = findViewById(R.id.textView2);

        masculino = findViewById(R.id.rbMasculino);
        feminino = findViewById(R.id.rbFeminino);
        sexo = findViewById(R.id.rgSexo);
        exibeSexo = findViewById(R.id.tvSexo);
        sexoselecionado();
    }
    public void enviarDados(View view){

        exibeDados.setText("Nome: " + recebeNome + "\n E-mail: " + recebeEmail);
        nome.setText("");
        email.setText("");
        corSelecionada();


    }
    public void corSelecionada(){
        coresSelecionadas = "";
        if(checkVermelho.isChecked()){
            coresSelecionadas += checkVermelho.getText().toString() + " Selecionado\n";
        }

        if(checkAzul.isChecked()){
            coresSelecionadas += checkAzul.getText().toString() + " Selecionado\n";
        }

        if(checkVerde.isChecked()){
            coresSelecionadas += checkVerde.getText().toString() + " Selecionado\n";
        }
        exibeSelecionados.setText(coresSelecionadas);
    }
    public void sexoselecionado(){
        /*
        if(masculino.isChecked()){
            exibeSexo.setText(masculino.getText().toString());
        }
        if(feminino.isChecked()){
            exibeSexo.setText(feminino.getText().toString());
        }*/
        sexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.rbFeminino){
                    exibeSexo.setText("Feminino!");
                }else if( i == R.id.rbMasculino){
                    exibeSexo.setText("Masculino!");
                }
            }
        });
    }
}