package com.example.cicek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        Thread timerThread = new Thread(){ //timer kullanarak ekranın 5 saniye sonra diğer ekrana geçmesini söyliyorum
            public void run(){
                try{
                    sleep(3000);//3sn olduğunu belirtiyorum
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreen.this, MenuScreen.class);//ekran1'e geçmesini söylüyorum
                    startActivity(intent);
                }

                finish();
            }
        };
        timerThread.start();


    }
}