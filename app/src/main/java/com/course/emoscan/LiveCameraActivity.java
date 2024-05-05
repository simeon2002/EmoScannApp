package com.course.emoscan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.navigation.NavigationBarView;

public class LiveCameraActivity extends AppCompatActivity {
    NavigationBarView navigationBar;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_live_camera);

        // fetch views
        navigationBar = findViewById(R.id.bottom_navigation);

        // navbar setup
    navigationBar.setSelectedItemId(R.id.profile);
        // deselect selected option.
        BottomNavigationItemView itemSelected = (BottomNavigationItemView) findViewById(navigationBar.getSelectedItemId());
        itemSelected.setChecked(false);
//         setup navbar listeners
        navigationBar.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.files) {
                startActivity(new Intent(this, FilesActivity.class));
                return true;
            }
            else if (item.getItemId() == R.id.home) {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            }
            else if (item.getItemId() == R.id.profile) {
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
            }
            else
                return false;
        });
    }


}