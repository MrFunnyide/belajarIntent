package com.example.belajarintent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.belajarintent.R;

public class MainActivity extends AppCompatActivity {

    Button btnKonversi, btnProfile, btnShare;

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

        btnKonversi = findViewById(R.id.btnKonversi);
        btnProfile = findViewById(R.id.btnProfile);
        btnShare = findViewById(R.id.btnShare);

        // button di klik
        btnKonversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKonversi = new Intent(MainActivity.this, Konversi.class);
                startActivity(intentKonversi);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProfile = new Intent(MainActivity.this, Profile.class);

                intentProfile.putExtra(Profile.EXTRA_TITLE, "Profile");
                intentProfile.putExtra(Profile.EXTRA_NAME, "Aji Bayu Permadi");
                intentProfile.putExtra(Profile.EXTRA_UMUR, "18 Tahun");
                intentProfile.putExtra(Profile.EXTRA_ALAMAT, "Suak Rengas");

                startActivity(intentProfile);
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShare = new Intent();
                intentShare.setAction(Intent.ACTION_SEND);
                intentShare.putExtra(Intent.EXTRA_TEXT, "belajar android di android santai");
                intentShare.setType("text/plain");

                if (intentShare.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentShare);
                }
            }
        });
    }
}