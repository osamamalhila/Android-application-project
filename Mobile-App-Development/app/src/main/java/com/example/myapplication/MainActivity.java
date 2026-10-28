package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
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

        Button btnBirthday = findViewById(R.id.btnBirthday);
        Button btnTaskDone = findViewById(R.id.btnTaskDone);
        Button btnQuadrant = findViewById(R.id.btnQuadrant);
        Button btnArticle = findViewById(R.id.btnArticle);
        Button btnBusinessCard = findViewById(R.id.btnBusinessCard);
        ImageButton btnThemeToggle = findViewById(R.id.btnThemeToggle);

        btnBirthday.setOnClickListener(v -> startActivity(new Intent(this, BirthdayCardActivity.class)));
        btnTaskDone.setOnClickListener(v -> startActivity(new Intent(this, TaskDoneActivity.class)));
        btnQuadrant.setOnClickListener(v -> startActivity(new Intent(this, QuadrantActivity.class)));
        btnArticle.setOnClickListener(v -> startActivity(new Intent(this, ArticleActivity.class)));
        btnBusinessCard.setOnClickListener(v -> startActivity(new Intent(this, BusinessCardActivity.class)));
        btnThemeToggle.setOnClickListener(v -> {
            int currentMode = AppCompatDelegate.getDefaultNightMode();
            boolean isDarkMode = (currentMode == AppCompatDelegate.MODE_NIGHT_YES) ||
                    (currentMode == AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM &&
                            (getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK) == android.content.res.Configuration.UI_MODE_NIGHT_YES);

            if (isDarkMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        });
    }
}
