package com.course.emoscan;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.navigation.NavigationBarView;

public class FilesActivity extends AppCompatActivity {
    NavigationBarView navigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_files);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // fetch views
        navigationBar = findViewById(R.id.bottom_navigation);

        navigationBar.setSelectedItemId(R.id.files);
        navigationBar.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.files) {
                return true;
            } else if (item.getItemId() == R.id.home) {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            } else if (item.getItemId() == R.id.profile) {
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
            } else
                return false;
        });

    }
}