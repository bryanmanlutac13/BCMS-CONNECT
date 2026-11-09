package com.example.bcms_connect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginScreen extends AppCompatActivity {

    public static final String PREF_NAME = "BCMS_UserPrefs";
    public static final String KEY_FIRST_NAME = "first_name";
    public static final String KEY_LAST_NAME = "last_name";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_CONTACT_NUMBER = "contact_number";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_ROLE = "role";
    public static final String KEY_IS_LOGGED_IN = "is_logged_in";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_screen);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize default preferences if first run
        initDefaultUserPrefs();

        EditText editTextUsername = findViewById(R.id.editTextText3);
        EditText editTextPassword = findViewById(R.id.editTextText4);
        Button buttonLogin = findViewById(R.id.button);
        Button buttonForgotPassword = findViewById(R.id.button2);
        Button buttonSignUp = findViewById(R.id.button4);
        CheckBox checkBoxRemember = findViewById(R.id.checkBox);
        ImageView btnTogglePassword = findViewById(R.id.btnTogglePassword);

        // Password visibility toggle
        if (btnTogglePassword != null) {
            btnTogglePassword.setOnClickListener(v -> {
                if (editTextPassword.getInputType() == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                    editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                editTextPassword.setSelection(editTextPassword.getText().length());
            });
        }

        // Login Button action
        buttonLogin.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            boolean rememberMe = checkBoxRemember.isChecked();

            SharedPreferences prefs = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            String regUsername = prefs.getString(KEY_USERNAME, "admin");
            String regPassword = prefs.getString(KEY_PASSWORD, "12345");
            String firstName = prefs.getString(KEY_FIRST_NAME, "Juan");

            if (username.isEmpty() || password.isEmpty() || username.equals("Name") || password.equals("Password")) {
                new AlertDialog.Builder(LoginScreen.this)
                        .setTitle("Login Error")
                        .setMessage("Please enter a valid username and password.")
                        .setPositiveButton("OK", null)
                        .show();
            } else if (username.equalsIgnoreCase(regUsername) && password.equals(regPassword)) {
                // Save session state
                prefs.edit().putBoolean(KEY_IS_LOGGED_IN, true).apply();

                new AlertDialog.Builder(LoginScreen.this)
                        .setTitle("Login Successful")
                        .setMessage("Welcome back, " + firstName + "!\nRemember me: " + (rememberMe ? "Yes" : "No"))
                        .setPositiveButton("Continue", (dialog, which) -> {
                            Intent intent = new Intent(LoginScreen.this, DashBoard.class);
                            startActivity(intent);
                            finish();
                        })
                        .show();
            } else {
                new AlertDialog.Builder(LoginScreen.this)
                        .setTitle("Login Failed")
                        .setMessage("Invalid username or password. Please check your credentials or sign up first.")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

        // Forgot Password Button pop-up dialog
        buttonForgotPassword.setOnClickListener(v -> new AlertDialog.Builder(LoginScreen.this)
                .setTitle("Forgot Password")
                .setMessage("Please contact the Barangay Office to reset your password.")
                .setPositiveButton("OK", null)
                .show());

        // Sign Up Button pop-up dialog
        buttonSignUp.setOnClickListener(v -> {
            LinearLayout layout = new LinearLayout(LoginScreen.this);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setPadding(50, 40, 50, 10);

            EditText inputFirstName = new EditText(LoginScreen.this);
            inputFirstName.setHint("First Name");
            layout.addView(inputFirstName);

            EditText inputLastName = new EditText(LoginScreen.this);
            inputLastName.setHint("Last Name");
            layout.addView(inputLastName);

            EditText inputRegUsername = new EditText(LoginScreen.this);
            inputRegUsername.setHint("Username");
            layout.addView(inputRegUsername);

            EditText inputEmail = new EditText(LoginScreen.this);
            inputEmail.setHint("Email Address");
            layout.addView(inputEmail);

            EditText inputRegPassword = new EditText(LoginScreen.this);
            inputRegPassword.setHint("Password");
            inputRegPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            layout.addView(inputRegPassword);

            new AlertDialog.Builder(LoginScreen.this)
                    .setTitle("Create Account")
                    .setMessage("Enter your details to sign up:")
                    .setView(layout)
                    .setPositiveButton("Register", (dialog, which) -> {
                        String fName = inputFirstName.getText().toString().trim();
                        String lName = inputLastName.getText().toString().trim();
                        String uName = inputRegUsername.getText().toString().trim();
                        String userEmail = inputEmail.getText().toString().trim();
                        String pWord = inputRegPassword.getText().toString().trim();

                        if (fName.isEmpty() || lName.isEmpty() || uName.isEmpty() || pWord.isEmpty()) {
                            Toast.makeText(LoginScreen.this, "First Name, Last Name, Username, and Password are required!", Toast.LENGTH_SHORT).show();
                        } else {
                            if (userEmail.isEmpty()) {
                                userEmail = uName.toLowerCase() + "@gmail.com";
                            }
                            SharedPreferences prefs = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString(KEY_FIRST_NAME, fName);
                            editor.putString(KEY_LAST_NAME, lName);
                            editor.putString(KEY_USERNAME, uName);
                            editor.putString(KEY_EMAIL, userEmail);
                            editor.putString(KEY_PASSWORD, pWord);
                            editor.putString(KEY_CONTACT_NUMBER, "0917 123 4567");
                            editor.putString(KEY_ADDRESS, "Purok 3, Barangay San Isidro");
                            editor.putString(KEY_ROLE, "Resident");
                            editor.apply();

                            Toast.makeText(LoginScreen.this, "Registration Successful! You can now log in.", Toast.LENGTH_LONG).show();

                            // Pre-fill username field for convenience
                            editTextUsername.setText(uName);
                            editTextPassword.setText("");
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        });
    }

    private void initDefaultUserPrefs() {
        SharedPreferences prefs = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        if (!prefs.contains(KEY_USERNAME)) {
            prefs.edit()
                    .putString(KEY_FIRST_NAME, "Juan")
                    .putString(KEY_LAST_NAME, "Dela Cruz")
                    .putString(KEY_USERNAME, "admin")
                    .putString(KEY_PASSWORD, "12345")
                    .putString(KEY_EMAIL, "juandelacruz@gmail.com")
                    .putString(KEY_CONTACT_NUMBER, "0917 123 4567")
                    .putString(KEY_ADDRESS, "Purok 3, Barangay San Isidro")
                    .putString(KEY_ROLE, "Resident")
                    .apply();
        }
    }
}