package com.example.hamodi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginpage2 extends AppCompatActivity {
    EditText emailEditText;
    EditText passwordEditText;
    Button loginButton;
    TextView newAccountButton;
    TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage2);


        emailEditText=findViewById(R.id.ptSignUp);
        passwordEditText=findViewById(R.id.ptPassword);
        loginButton=findViewById(R.id.BtLogin);
        newAccountButton=findViewById(R.id.TvSignUp);
        newAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginpage2.this, Signuppage.class);
                startActivity(intent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error.setVisibility(View.GONE);
                final FirebaseAuth mAuth=FirebaseAuth.getInstance();
                mAuth.signInWithEmailAndPassword(emailEditText.getText().toString(), passwordEditText.getText().toString())
                        .addOnCompleteListener(loginpage2.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();

                                } else {

                                    Log.d("error","erro");

                                }
                            }
                        });
            }
        });

    }
}