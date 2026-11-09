package com.example.bcms_connect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dash_board);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Profile buttons
        ImageButton btnProfileGrid = findViewById(R.id.imageButton20);
        ImageButton btnProfileNav = findViewById(R.id.imageButton27);

        if (btnProfileGrid != null) {
            btnProfileGrid.setOnClickListener(v -> startActivity(new Intent(DashBoard.this, ProfileScreen.class)));
        }
        if (btnProfileNav != null) {
            btnProfileNav.setOnClickListener(v -> startActivity(new Intent(DashBoard.this, ProfileScreen.class)));
        }

        // Photo submission button
        ImageButton btnPhotoSub = findViewById(R.id.imageButton16);
        ImageButton btnPhotoNav = findViewById(R.id.imageButton25);
        if (btnPhotoSub != null) {
            btnPhotoSub.setOnClickListener(v -> startActivity(new Intent(DashBoard.this, photosubmission.class)));
        }
        if (btnPhotoNav != null) {
            btnPhotoNav.setOnClickListener(v -> startActivity(new Intent(DashBoard.this, photosubmission.class)));
        }

        // Announcement / Notification button
        ImageButton btnNotification = findViewById(R.id.imageButton19);
        ImageButton btnAnnounceNav = findViewById(R.id.imageButton26);
        if (btnNotification != null) {
            btnNotification.setOnClickListener(v -> startActivity(new Intent(DashBoard.this, NotificationScreen.class)));
        }
        if (btnAnnounceNav != null) {
            btnAnnounceNav.setOnClickListener(v -> startActivity(new Intent(DashBoard.this, NotificationScreen.class)));
        }

        // Logout button
        ImageButton btnLogout = findViewById(R.id.imageButton21);
        if (btnLogout != null) {
            btnLogout.setOnClickListener(v -> new AlertDialog.Builder(DashBoard.this)
                    .setTitle("Logout")
                    .setMessage("Are you sure you want to log out?")
                    .setPositiveButton("Yes, Logout", (dialog, which) -> {
                        SharedPreferences prefs = getSharedPreferences(LoginScreen.PREF_NAME, Context.MODE_PRIVATE);
                        prefs.edit().putBoolean(LoginScreen.KEY_IS_LOGGED_IN, false).apply();
                        Toast.makeText(DashBoard.this, "Logged out successfully.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DashBoard.this, LoginScreen.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    })
                    .setNegativeButton("Cancel", null)
                    .show());
        }
    }
}