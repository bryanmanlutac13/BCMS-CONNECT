package com.example.bcms_connect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginScreen extends AppCompatActivity {

    private static final String PREF_NAME = "BCMS_UserPrefs";
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

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

        EditText editTextUsername = findViewById(R.id.editTextText3);
        EditText editTextPassword = findViewById(R.id.editTextText4);
        Button buttonLogin = findViewById(R.id.button);
        Button buttonForgotPassword = findViewById(R.id.button2);
        Button buttonSignUp = findViewById(R.id.button4);
        CheckBox checkBoxRemember = findViewById(R.id.checkBox);

        // Login Button action with pop-up AlertDialog and navigation to Dashboard
        buttonLogin.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            boolean rememberMe = checkBoxRemember.isChecked();

            SharedPreferences prefs = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            String regUsername = prefs.getString(KEY_USERNAME, "admin");
            String regPassword = prefs.getString(KEY_PASSWORD, "12345");
            String firstName = prefs.getString(KEY_FIRST_NAME, "Admin");

            if (username.isEmpty() || password.isEmpty() || username.equals("Name") || password.equals("Password")) {
                new AlertDialog.Builder(LoginScreen.this)
                        .setTitle("Login Error")
                        .setMessage("Please enter a valid username and password.")
                        .setPositiveButton("OK", null)
                        .show();
            } else if (username.equals(regUsername) && password.equals(regPassword)) {
                new AlertDialog.Builder(LoginScreen.this)
                        .setTitle("Login Successful")
                        .setMessage("Welcome back, " + firstName + "!\nRemember me: " + (rememberMe ? "Yes" : "No"))
                        .setPositiveButton("Continue", (dialog, which) -> {
                            Intent intent = new Intent(LoginScreen.this, DashBoard.class);
                            startActivity(intent);
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

        // Sign Up Button pop-up dialog with First Name, Last Name, Username, and Password fields
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
                        String pWord = inputRegPassword.getText().toString().trim();

                        if (fName.isEmpty() || lName.isEmpty() || uName.isEmpty() || pWord.isEmpty()) {
                            Toast.makeText(LoginScreen.this, "All fields are required!", Toast.LENGTH_SHORT).show();
                        } else {
                            SharedPreferences prefs = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString(KEY_FIRST_NAME, fName);
                            editor.putString(KEY_LAST_NAME, lName);
                            editor.putString(KEY_USERNAME, uName);
                            editor.putString(KEY_PASSWORD, pWord);
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
}