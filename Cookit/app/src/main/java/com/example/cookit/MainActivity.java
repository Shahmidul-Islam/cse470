package com.example.cookit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public FirebaseAuth mAuth = FirebaseAuth.getInstance();
    TextView loginTextView;
    Boolean signUpModeActive = true;
    EditText emailEditText;
    EditText passwordEditText;



    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.loginTextView){
            Button signUpButton = findViewById(R.id.signUpButton);

            if (signUpModeActive){
                signUpModeActive = false;
                signUpButton.setText("Login");
                loginTextView.setText("or, Sign Up");
            }else{
                signUpModeActive = true;
                signUpButton.setText("Sign Up");
                loginTextView.setText("or, Login");


            }


        }
    }

    public void signUpClicked(View view){
         emailEditText = findViewById(R.id.emailEditText);
         passwordEditText = findViewById(R.id.passwordEditText);

        if(emailEditText.getText().toString().matches("")|| passwordEditText.getText().toString().matches("")){
            Toast.makeText(this, " email and password is required.",Toast.LENGTH_SHORT).show();

        }else{
            if (signUpModeActive){
                //signup
                mAuth.createUserWithEmailAndPassword(emailEditText.getText().toString(), passwordEditText.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    startActivity(new Intent(MainActivity.this, Recipies.class));
                                    finish();


                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivity.this , "use proper form", Toast.LENGTH_SHORT).show();



                                }

                                // ...
                            }
                        });


            }else{
                //login
                mAuth.signInWithEmailAndPassword(emailEditText.getText().toString(), passwordEditText.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(MainActivity.this, Recipies.class));
                                    finish();


                                }else{
                                    Toast.makeText(MainActivity.this,"use valid email and password",Toast.LENGTH_SHORT).show();


                                }

                                // ...
                            }
                        });



            }


        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginTextView = findViewById(R.id.loginTextView);
        loginTextView.setOnClickListener(this);
    }



}









