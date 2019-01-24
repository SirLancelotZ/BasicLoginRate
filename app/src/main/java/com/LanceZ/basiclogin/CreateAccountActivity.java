package com.garrettshorr.basiclogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private EditText editTextEmail;
    private Button buttonCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        wireWidgets();
        prefillUserName();
    }

    private void prefillUserName() {
        String username = getIntent().getStringExtra(LoginActivity.EXTRA_USERNAME);
        if(username != null) {
            editTextUsername.setText(username);
        }
    }

    private void registerAccountOnBackendless(){
        String password = editTextPassword.getText().toString();
        String confirmpassword = editTextConfirmPassword.getText().toString();
        String username = editTextUsername.getText().toString();
        String email = editTextEmail.getText().toString();
        String name = editTextName.getText().toString();

        if(allFieldsValid(password, confirmpassword, username, email, name))
        {
            BackendlessUser user = new BackendlessUser();
            user.setProperty("email", email);
            user.setProperty("name", name);
            user.setProperty("username", username);
        }
    }

    private boolean allFieldsValid(String password, String confirmpassword, String username, String email, String name) {
            return true;
    }


    private void wireWidgets() {
        editTextUsername = findViewById(R.id.edittext_create_username);
        editTextName = findViewById(R.id.edittext_create_name);
        editTextPassword = findViewById(R.id.edittext_create_password);
        editTextConfirmPassword = findViewById(R.id.edittext_create_confirmpassword);
        editTextEmail = findViewById(R.id.edittext_create_email);
    }
}
