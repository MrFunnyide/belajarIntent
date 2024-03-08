package com.example.belajarintent.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.belajarintent.R;

public class Profile extends AppCompatActivity {

    TextView tvTitle, tvName, tvUmur, tvAlamat;
    ImageView ivProfile;

    public static String EXTRA_TITLE = "extra_title";
    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_UMUR = "extra_umur";
    public static String EXTRA_ALAMAT = "extra_alamat";
    public static String EXTRA_PROFILE = "extra_profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvTitle = findViewById(R.id.tvTitle);
        tvName = findViewById(R.id.tvNama);
        tvUmur = findViewById(R.id.tvUmur);
        tvAlamat = findViewById(R.id.tvAlamat);

        ivProfile = findViewById(R.id.ivProfile);

        // set data yang yang di ambil dari intent
        tvTitle.setText(getIntent().getStringExtra(EXTRA_TITLE));
        tvName.setText(getIntent().getStringExtra(EXTRA_NAME));
        tvUmur.setText(getIntent().getStringExtra(EXTRA_UMUR));
        tvAlamat.setText(getIntent().getStringExtra(EXTRA_ALAMAT));
    }
}