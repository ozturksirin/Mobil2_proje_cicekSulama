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

    //btn damla
    private Button btn_damla;
    private Button btn_damla_kapat;


    private TextView txt_nemVeri;

    private DatabaseReference mDatabase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        txt_nemVeri= findViewById(R.id.txt_nemVeri);



        //database veri okuma & yazma için

        mDatabase = FirebaseDatabase.getInstance().getReference("yuzdeNemVeri");

// read data start


        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                int nem= dataSnapshot.getValue(Integer.class);
                txt_nemVeri.setText(String.valueOf(nem+"%"));
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                // ...

            }
        };
           mDatabase.addValueEventListener(postListener);
//read data end

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


        // damlama sulama baslangıc

        btn_damla = findViewById(R.id.btn_damla);

        btn_damla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_damla.setText("Damlama Su Veriliyor");
                if(btn_damla.getText().equals("Damlama Su Veriliyor")){
                    FirebaseDatabase damla = FirebaseDatabase.getInstance();
                    DatabaseReference damlaRef = damla.getReference("Sulama_Damla");
                    damlaRef.setValue(true);

                    Toast toast = Toast.makeText(getApplicationContext(), "Çiçek Damlama Sulanıyor kapatmayı unutmayınız!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }

            }
        });

        btn_damla_kapat = findViewById(R.id.btn_damla_kapat);

        btn_damla_kapat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_damla.setText("Damlama Su Ver");
                if(btn_damla.getText().equals("Damlama Su Ver")){
                    FirebaseDatabase damla = FirebaseDatabase.getInstance();
                    DatabaseReference damlaRef = damla.getReference("Sulama_Damla");
                    damlaRef.setValue(false);

                    Toast toast = Toast.makeText(getApplicationContext(), "Çiçek Damlama Sulama Kapatıldı!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            }
        });


        //damlama bitis


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
                    //myRef.child("useState").setValue(true);

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
                    //myRef.child("useState").setValue(false);

                    Toast toast = Toast.makeText(getApplicationContext(), "Sulama Başarılı Tebrikler.", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();

                }



            }
        });

        //data gönderme sonu

    }
}