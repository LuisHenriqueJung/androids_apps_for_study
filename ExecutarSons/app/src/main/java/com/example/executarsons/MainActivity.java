package com.example.executarsons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SeekBar volume;
    private AudioManager audioManager;
    private Switch segundoPlano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        segundoPlano= findViewById(R.id.switch1);



        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.teste);
        inicializaVolume();
    }
    public void inicializaVolume(){
        volume = findViewById(R.id.seekBar);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        int volumeMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumeAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        volume.setMax(volumeMax);
        volume.setProgress(volumeAtual);

        volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void play (View view){
        mediaPlayer.start();
    }
    public void pause(View view ){
        if( mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        if(!segundoPlano.isChecked()){
            if( mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mediaPlayer.start();
    }
}