package com.example.calculadoraddegorjetas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
   private TextView tvRecebeValor;
    private TextView tvExibePorcentagem;
    private TextView tvExibeGorjete;
    private TextView tvExibeTotal;
   private SeekBar sbRecebePorcentagem;

   private int recebePorcentagem = 0;
    private double recebeValor = 0.0;
    private double valorGorjeta = 0.0;
    private double valorFinal = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRecebeValor = findViewById(R.id.inputRecebeValor);
        tvExibePorcentagem = findViewById(R.id.tvExibePorcentagem);
        tvExibeGorjete = findViewById(R.id.tvExibeValorGorjeta);
        tvExibeTotal = findViewById(R.id.tvExibeValorTotal);

        sbRecebePorcentagem = findViewById(R.id.seekBarRecebePorcentagem);

        tvRecebeValor.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                calculaValor();
                return false;
            }
        });

        sbRecebePorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                calculaValor();


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void calculaValor(){
        recebePorcentagem = sbRecebePorcentagem.getProgress();
        tvExibePorcentagem.setText(recebePorcentagem + "%");
        try {
            recebeValor =Double.parseDouble(tvRecebeValor.getText().toString());
        }catch(Exception e){
            /*Toast.makeText(
                    getApplicationContext(),
                    "Insira o valor da compra para continuar!",
                    Toast.LENGTH_LONG
            ).show();
             */
            TextView tv = new TextView(getApplicationContext());
            tv.setText("Insira um valor para continuar");
            tv.setBackgroundResource(R.color.laranjaForte);
            tv.setPadding(20,5,20,5);
            
            Toast mensagem = new Toast(getApplicationContext());
            mensagem.setView(tv);
            mensagem.show();

        }

        valorGorjeta = recebeValor * recebePorcentagem /100;
        valorFinal = recebeValor + valorGorjeta;
        tvExibeGorjete.setText(String.format("R$ "+ "%.2f", valorGorjeta));
        tvExibeTotal.setText(String.format("R$ "+ "%.2f", valorFinal));
    }

}