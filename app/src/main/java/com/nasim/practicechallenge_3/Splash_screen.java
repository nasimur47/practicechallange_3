package com.nasim.practicechallenge_3;

import static java.lang.Thread.sleep;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Objects;

public class Splash_screen extends AppCompatActivity {
    ProgressBar     progressBar ;
    LottieAnimationView     lottiAnimView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash_screen );

        Objects.requireNonNull( getSupportActionBar() ).hide();

        progressBar = findViewById( R.id.progressBar );
        lottiAnimView = findViewById( R.id.lottiAnimView );


        lottiAnimView.animate().translationY( -1600 ).setDuration( 3000 ).setStartDelay( 3000 );




        Thread thread = new Thread( new Runnable() {
            @Override
            public void run() {

                doWork();
                startApp();

            }
        } );
        thread.start();

    }

        public void doWork(){

            int Progress;
            for (Progress = 20 ; Progress <= 100 ; Progress = Progress+20  ){

                try {
                    Thread.sleep( 3000 );
                    progressBar.setProgress( Progress );
                }catch ( Exception e){
                    e.printStackTrace();

                }

                }
        }

        public void startApp(){

        Intent intent =new Intent(Splash_screen.this,MainActivity.class);
        startActivity( intent );
        finish();

        }



}