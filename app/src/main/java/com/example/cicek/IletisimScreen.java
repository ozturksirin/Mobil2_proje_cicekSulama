package com.example.cicek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IletisimScreen extends AppCompatActivity {




    private Button btn_gonder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iletisim_screen);

        btn_gonder = findViewById(R.id.btn_gonder);

        btn_gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(IletisimScreen.this, " Mesajınız Gönderildi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}