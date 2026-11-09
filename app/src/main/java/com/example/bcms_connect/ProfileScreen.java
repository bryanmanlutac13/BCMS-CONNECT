package com.example.bcms_connect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class ProfileScreen extends AppCompatActivity {

    private TextView tvProfileName, tvProfileRole, tvProfileAddress;
    private TextView tvContactNumber, tvEmail, tvAddress;
    private ImageView btnBack, btnEditProfileTop;
    private LinearLayout itemEditProfile, itemChangePassword, itemPrivacySecurity, itemNotificationSettings;
    private MaterialButton btnLogout;
    private LinearLayout navDashboard, navTask, navPhoto, navAnnouncement, navProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_screen);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        loadUserProfile();
        setupClickListeners();
    }

    private void initViews() {
        // Header views
        btnBack = findViewById(R.id.btnBack);
        btnEditProfileTop = findViewById(R.id.btnEditProfileTop);

        // User info views
        tvProfileName = findViewById(R.id.tvProfileName);
        tvProfileRole = findViewById(R.id.tvProfileRole);
        tvProfileAddress = findViewById(R.id.tvProfileAddress);

        // Personal Info fields
        tvContactNumber = findViewById(R.id.tvContactNumber);
        tvEmail = findViewById(R.id.tvEmail);
        tvAddress = findViewById(R.id.tvAddress);

        // Account Settings options
        itemEditProfile = findViewById(R.id.itemEditProfile);
        itemChangePassword = findViewById(R.id.itemChangePassword);
        itemPrivacySecurity = findViewById(R.id.itemPrivacySecurity);
        itemNotificationSettings = findViewById(R.id.itemNotificationSettings);

        // Logout button
        btnLogout = findViewById(R.id.btnLogout);

        // Bottom Navigation
        navDashboard = findViewById(R.id.navDashboard);
        navTask = findViewById(R.id.navTask);
        navPhoto = findViewById(R.id.navPhoto);
        navAnnouncement = findViewById(R.id.navAnnouncement);
        navProfile = findViewById(R.id.navProfile);
    }

    private void loadUserProfile() {
        SharedPreferences prefs = getSharedPreferences(LoginScreen.PREF_NAME, Context.MODE_PRIVATE);

        String firstName = prefs.getString(LoginScreen.KEY_FIRST_NAME, "Juan");
        String lastName = prefs.getString(LoginScreen.KEY_LAST_NAME, "Dela Cruz");
        String fullName = firstName + " " + lastName;

        String role = prefs.getString(LoginScreen.KEY_ROLE, "Resident");
        String address = prefs.getString(LoginScreen.KEY_ADDRESS, "Purok 3, Barangay San Isidro");
        String contact = prefs.getString(LoginScreen.KEY_CONTACT_NUMBER, "0917 123 4567");
        String email = prefs.getString(LoginScreen.KEY_EMAIL, "juandelacruz@gmail.com");

        if (tvProfileName != null) tvProfileName.setText(fullName.trim());
        if (tvProfileRole != null) tvProfileRole.setText(role);
        if (tvProfileAddress != null) tvProfileAddress.setText(address);

        if (tvContactNumber != null) tvContactNumber.setText(contact);
        if (tvEmail != null) tvEmail.setText(email);
        if (tvAddress != null) tvAddress.setText(address);
    }

    private void setupClickListeners() {
        // Back Button
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Edit Profile
        View.OnClickListener editProfileListener = v -> showEditProfileDialog();
        if (btnEditProfileTop != null) btnEditProfileTop.setOnClickListener(editProfileListener);
        if (itemEditProfile != null) itemEditProfile.setOnClickListener(editProfileListener);

        // Change Password
        if (itemChangePassword != null) {
            itemChangePassword.setOnClickListener(v -> showChangePasswordDialog());
        }

        // Privacy & Security
        if (itemPrivacySecurity != null) {
            itemPrivacySecurity.setOnClickListener(v -> new AlertDialog.Builder(ProfileScreen.this)
                    .setTitle("Privacy & Security")
                    .setMessage("Your account data is stored securely. No unauthorized access is permitted.")
                    .setPositiveButton("OK", null)
                    .show());
        }

        // Notification Settings
        if (itemNotificationSettings != null) {
            itemNotificationSettings.setOnClickListener(v -> new AlertDialog.Builder(ProfileScreen.this)
                    .setTitle("Notification Settings")
                    .setMessage("Push notifications for Barangay announcements and task updates are enabled.")
                    .setPositiveButton("OK", null)
                    .show());
        }

        // Logout
        if (btnLogout != null) {
            btnLogout.setOnClickListener(v -> new AlertDialog.Builder(ProfileScreen.this)
                    .setTitle("Logout")
                    .setMessage("Are you sure you want to log out?")
                    .setPositiveButton("Yes, Logout", (dialog, which) -> {
                        SharedPreferences prefs = getSharedPreferences(LoginScreen.PREF_NAME, Context.MODE_PRIVATE);
                        prefs.edit().putBoolean(LoginScreen.KEY_IS_LOGGED_IN, false).apply();

                        Toast.makeText(ProfileScreen.this, "Logged out successfully.", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(ProfileScreen.this, LoginScreen.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    })
                    .setNegativeButton("Cancel", null)
                    .show());
        }

        // Bottom Navigation Listeners
        if (navDashboard != null) {
            navDashboard.setOnClickListener(v -> {
                Intent intent = new Intent(ProfileScreen.this, DashBoard.class);
                startActivity(intent);
                finish();
            });
        }

        if (navTask != null) {
            navTask.setOnClickListener(v -> {
                Intent intent = new Intent(ProfileScreen.this, photosubmission.class);
                startActivity(intent);
                finish();
            });
        }

        if (navPhoto != null) {
            navPhoto.setOnClickListener(v -> {
                Intent intent = new Intent(ProfileScreen.this, photosubmission.class);
                startActivity(intent);
                finish();
            });
        }

        if (navAnnouncement != null) {
            navAnnouncement.setOnClickListener(v -> {
                Intent intent = new Intent(ProfileScreen.this, NotificationScreen.class);
                startActivity(intent);
                finish();
            });
        }

        if (navProfile != null) {
            navProfile.setOnClickListener(v -> loadUserProfile());
        }
    }

    private void showEditProfileDialog() {
        SharedPreferences prefs = getSharedPreferences(LoginScreen.PREF_NAME, Context.MODE_PRIVATE);
        String currentFName = prefs.getString(LoginScreen.KEY_FIRST_NAME, "Juan");
        String currentLName = prefs.getString(LoginScreen.KEY_LAST_NAME, "Dela Cruz");
        String currentContact = prefs.getString(LoginScreen.KEY_CONTACT_NUMBER, "0917 123 4567");
        String currentEmail = prefs.getString(LoginScreen.KEY_EMAIL, "juandelacruz@gmail.com");
        String currentAddr = prefs.getString(LoginScreen.KEY_ADDRESS, "Purok 3, Barangay San Isidro");

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(50, 30, 50, 10);

        EditText inputFName = new EditText(this);
        inputFName.setHint("First Name");
        inputFName.setText(currentFName);
        layout.addView(inputFName);

        EditText inputLName = new EditText(this);
        inputLName.setHint("Last Name");
        inputLName.setText(currentLName);
        layout.addView(inputLName);

        EditText inputContact = new EditText(this);
        inputContact.setHint("Contact Number");
        inputContact.setText(currentContact);
        layout.addView(inputContact);

        EditText inputEmail = new EditText(this);
        inputEmail.setHint("Email");
        inputEmail.setText(currentEmail);
        layout.addView(inputEmail);

        EditText inputAddr = new EditText(this);
        inputAddr.setHint("Address");
        inputAddr.setText(currentAddr);
        layout.addView(inputAddr);

        new AlertDialog.Builder(this)
                .setTitle("Edit Profile")
                .setView(layout)
                .setPositiveButton("Save", (dialog, which) -> {
                    String newFName = inputFName.getText().toString().trim();
                    String newLName = inputLName.getText().toString().trim();
                    String newContact = inputContact.getText().toString().trim();
                    String newEmail = inputEmail.getText().toString().trim();
                    String newAddr = inputAddr.getText().toString().trim();

                    if (newFName.isEmpty() || newLName.isEmpty()) {
                        Toast.makeText(this, "First Name and Last Name cannot be empty!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    prefs.edit()
                            .putString(LoginScreen.KEY_FIRST_NAME, newFName)
                            .putString(LoginScreen.KEY_LAST_NAME, newLName)
                            .putString(LoginScreen.KEY_CONTACT_NUMBER, newContact)
                            .putString(LoginScreen.KEY_EMAIL, newEmail)
                            .putString(LoginScreen.KEY_ADDRESS, newAddr)
                            .apply();

                    loadUserProfile();
                    Toast.makeText(this, "Profile updated successfully!", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void showChangePasswordDialog() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(50, 30, 50, 10);

        EditText inputCurrentPass = new EditText(this);
        inputCurrentPass.setHint("Current Password");
        inputCurrentPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        layout.addView(inputCurrentPass);

        EditText inputNewPass = new EditText(this);
        inputNewPass.setHint("New Password");
        inputNewPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        layout.addView(inputNewPass);

        EditText inputConfirmPass = new EditText(this);
        inputConfirmPass.setHint("Confirm New Password");
        inputConfirmPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        layout.addView(inputConfirmPass);

        new AlertDialog.Builder(this)
                .setTitle("Change Password")
                .setView(layout)
                .setPositiveButton("Update", (dialog, which) -> {
                    String currentPass = inputCurrentPass.getText().toString().trim();
                    String newPass = inputNewPass.getText().toString().trim();
                    String confirmPass = inputConfirmPass.getText().toString().trim();

                    SharedPreferences prefs = getSharedPreferences(LoginScreen.PREF_NAME, Context.MODE_PRIVATE);
                    String storedPass = prefs.getString(LoginScreen.KEY_PASSWORD, "12345");

                    if (!currentPass.equals(storedPass)) {
                        Toast.makeText(this, "Incorrect current password!", Toast.LENGTH_SHORT).show();
                    } else if (newPass.isEmpty()) {
                        Toast.makeText(this, "New password cannot be empty!", Toast.LENGTH_SHORT).show();
                    } else if (!newPass.equals(confirmPass)) {
                        Toast.makeText(this, "New passwords do not match!", Toast.LENGTH_SHORT).show();
                    } else {
                        prefs.edit().putString(LoginScreen.KEY_PASSWORD, newPass).apply();
                        Toast.makeText(this, "Password updated successfully!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}