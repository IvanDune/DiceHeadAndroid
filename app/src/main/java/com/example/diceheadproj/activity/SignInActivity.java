package com.example.diceheadproj.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diceheadproj.R;
import com.example.diceheadproj.domain.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    ConstraintLayout root;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        TextView textCreateAccount = (TextView) findViewById(R.id.textCreateAccount);
        textCreateAccount.setOnClickListener(this);

        ImageView imageLight = (ImageView) findViewById(R.id.imageLight);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            imageLight.setRenderEffect(RenderEffect.createBlurEffect(25,25, Shader.TileMode.MIRROR));
        }

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayoutStarsSignIn);
        int childCount = constraintLayout.getChildCount();
        for(int i=0;i<childCount;i++){
            View v = constraintLayout.getChildAt(i);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                v.setRenderEffect(RenderEffect.createBlurEffect(3,3, Shader.TileMode.MIRROR));
            }
        }

        Button buttonSignIn = (Button) findViewById(R.id.buttonSignIn);
        buttonSignIn.setOnClickListener(this);

        db = FirebaseDatabase.getInstance();
        root = (ConstraintLayout) findViewById(R.id.constraintLayoutSignIn);
        auth = FirebaseAuth.getInstance();
        users = db.getReference("Users"); // Где хранятся пользователи

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.textCreateAccount:
                Intent intent = new Intent(this,LogInActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonSignIn:
                EditText email = findViewById(R.id.email);
                EditText password = findViewById(R.id.password);

                if (TextUtils.isEmpty(email.getText().toString())){
                    Snackbar.make(root,"Введите вашу почту", Snackbar.LENGTH_LONG).show();
                    return;
                }
                if (password.getText().toString().length() < 5){
                    Snackbar.make(root,"Введите ваш пароль из более 5 символов", Snackbar.LENGTH_LONG).show();
                    return;
                }

                //Регистрация пользователей
                auth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Intent intent = new Intent(SignInActivity.this, LoginFirstActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Snackbar.make(root, "Ошибка авторизации" + e.getMessage(),Snackbar.LENGTH_LONG).show();
                            }
                        });
                break;
            default:
                break;

        }
    }
}