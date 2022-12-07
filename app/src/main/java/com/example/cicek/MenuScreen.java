package com.example.cicek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenuScreen extends AppCompatActivity {

    private Button btn_hakkinda;
    private Button btn_iletisim;

    private Button btn_sula;
    private Button btn_sulandı;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        btn_hakkinda = findViewById(R.id.btn_hakkinda);

        btn_hakkinda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuScreen.this, HakkindaScreen.class);
                startActivity(intent);
            }
        });

        btn_iletisim = findViewById(R.id.btn_iletisim);

        btn_iletisim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuScreen.this, IletisimScreen.class);
                startActivity(intent);
            }
        });



        btn_sula = findViewById(R.id.btn_sula);

        btn_sula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_sula.setText("Çiçek SULANIYOR");

                if (btn_sula.getText().equals("Çiçek SULANIYOR")) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("SuVeriliyor");

                    myRef.setValue(true);

                }
            }
        });

        btn_sulandı = findViewById(R.id.btn_sulandı);

        btn_sulandı.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_sula.setText("Çiçek SULANDI");

                if (btn_sula.getText().equals("Çiçek SULANDI")) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("SuVerildi");

                    myRef.setValue(false);

                }


            }
        });



    }
}