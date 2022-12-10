package com.example.cicek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MenuScreen extends AppCompatActivity {

    private Button btn_hakkinda;
    private Button btn_iletisim;
    // databtn
    private Button btn_sula;
    private Button btn_sulandı;

    private TextView txt_nemVeri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);




        // hakkında ve iletişim sayfasının intentleri
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
        // hakkında ve iletişim sayfasının intentleri sonu


        //data gönderme
        btn_sula = findViewById(R.id.btn_sula);

        btn_sula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_sula.setText("Çiçek SULANIYOR");

                if (btn_sula.getText().equals("Çiçek SULANIYOR")) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("useStateWater");

                    myRef.setValue(true);


                    Toast toast = Toast.makeText(getApplicationContext(), "Çiçek Sulanıyor kapatmayı unutmayınız!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();

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
                    DatabaseReference myRef = database.getReference("useStateWater");

                    myRef.setValue(false);

                    Toast toast = Toast.makeText(getApplicationContext(), "Sulama Başarılı Tebrikler.", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();

                }


            }
        });

        //data gönderme sonu

    }
}