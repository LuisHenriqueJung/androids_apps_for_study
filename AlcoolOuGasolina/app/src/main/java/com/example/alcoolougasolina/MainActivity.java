package com.example.alcoolougasolina;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView precoAlcool;
    private TextView precoGasolina;
    private TextView recebeResultado;
    private TextView alerta1;


    private String getPrecoGasolina;
    private String getPrecoAlcool;
    private double alcoolDouble = 0.0;
    private double gasolinaDouble = 0.0;
    boolean camposValidados = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        precoAlcool = findViewById(R.id.tiPrecoAlcool);
        precoGasolina = findViewById(R.id.tiPrecoGasolina);
        recebeResultado = findViewById(R.id.tvResultado);
        alerta1 = findViewById(R.id.tvAlerta1);


    }
    public boolean validacampos(String pAlcool, String pGasolina){
        camposValidados = false;

        if(pAlcool != null && !pAlcool.equals("") && pGasolina != null && !pGasolina.equals("")){
            camposValidados = true;
        }else{
            camposValidados = false;
        }
        return camposValidados;
    }

    public void calculaVantagem(View view) {

        getPrecoAlcool = precoAlcool.getText().toString();
        getPrecoGasolina = precoGasolina.getText().toString();

        if (validacampos(getPrecoAlcool,getPrecoGasolina)){
            alerta1.setText("");
            alcoolDouble = Double.parseDouble(getPrecoAlcool);
            gasolinaDouble = Double.parseDouble(getPrecoGasolina);

            if ((alcoolDouble += alcoolDouble * 0.70) >= gasolinaDouble) {
                recebeResultado.setText("Gasolina é mais vantajoso!");
            } else {
                recebeResultado.setText("Alcool é mais vantajoso!");
            }
        }else{
            alerta1.setText("Preencha os dados para continuar");
        }
    }

}
