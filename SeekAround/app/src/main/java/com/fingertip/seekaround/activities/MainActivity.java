package com.fingertip.seekaround.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fingertip.seekaround.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUsername, etEmail, etPassword, etPhoneno;
    private Button btnLogin;
    private TextView tvCreateAccount, tvForgotPassword, tvSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        initializeViews();
        setingListners();
    }

    private void setingListners() {
        btnLogin.setOnClickListener(this);
        tvCreateAccount.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);
        tvSignIn.setOnClickListener(this);
    }

    private void initializeViews() {
        //All edittext
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPhoneno = findViewById(R.id.etPhoneno);

        //button
        btnLogin = findViewById(R.id.btnLogin);

        //TextViews
        tvCreateAccount = findViewById(R.id.tvCreateAccount);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvSignIn = findViewById(R.id.tvSignIn);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnLogin:
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                break;
            case R.id.tvCreateAccount:
                etEmail.setVisibility(View.VISIBLE);
                etPhoneno.setVisibility(View.VISIBLE);
                tvCreateAccount.setVisibility(View.GONE);
                tvSignIn.setVisibility(View.VISIBLE);
                tvSignIn.setText("Have account?");
                tvForgotPassword.setVisibility(View.GONE);
                btnLogin.setText("Sign Up");
                break;
            case R.id.tvForgotPassword:
                break;
            case R.id.tvSignIn:
                etEmail.setVisibility(View.GONE);
                etPhoneno.setVisibility(View.GONE);
                tvCreateAccount.setVisibility(View.VISIBLE);
                tvSignIn.setVisibility(View.INVISIBLE);
                tvSignIn.setText("");
                tvForgotPassword.setVisibility(View.VISIBLE);
                btnLogin.setText("Sign In");
                break;
        }

    }
}
