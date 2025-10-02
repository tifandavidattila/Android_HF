package com.example.addingnumbers;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText szam1 = findViewById(R.id.editSzam1);
        EditText szam2 = findViewById(R.id.editSzam2);
        Button szamol = findViewById(R.id.btnszamol);
        TextView tv = findViewById(R.id.txteredmeny);

        szamol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                   double eredmeny = Double.parseDouble(szam1.getText().toString()) + Double.parseDouble(szam2.getText().toString());
                   tv.setText(Double.toString(eredmeny));
                   Toast.makeText(MainActivity.this, szam2.getText().toString(), Toast.LENGTH_SHORT).show();
               } catch (NumberFormatException e) {
                   Toast.makeText(MainActivity.this,szam2.getText().toString(), Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
}