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

import com.example.diceheadproj.Database;
import com.example.diceheadproj.R;
import com.example.diceheadproj.domain.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener{
    ConstraintLayout root;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        TextView textCreateAccountLogIn = (TextView) findViewById(R.id.textSignInLogIn);
        textCreateAccountLogIn.setOnClickListener(this);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayoutStarsLogIn);
        int childCount = constraintLayout.getChildCount();
        for(int i=0;i<childCount;i++){
            View v = constraintLayout.getChildAt(i);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                v.setRenderEffect(RenderEffect.createBlurEffect(3,3, Shader.TileMode.MIRROR));
            }
        }

        ImageView imageLight = (ImageView) findViewById(R.id.imageLight);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            imageLight.setRenderEffect(RenderEffect.createBlurEffect(25,25, Shader.TileMode.MIRROR));
        }

        Button buttonCreateAccount = (Button) findViewById(R.id.buttonCreateAccount);
        buttonCreateAccount.setOnClickListener(this);

        db = FirebaseDatabase.getInstance();
        root = (ConstraintLayout) findViewById(R.id.constraintLayoutReg);
        auth = FirebaseAuth.getInstance();
        users = db.getReference("Users");// Где хранятся пользователи
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.textSignInLogIn:
                Intent intent = new Intent(this,SignInActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonCreateAccount:
                EditText login = (EditText) findViewById(R.id.editTextLogIn);
                EditText email = (EditText) findViewById(R.id.editTextEmailAddress);
                EditText password = (EditText) findViewById(R.id.editTextPassword);
                EditText nickname = (EditText) findViewById(R.id.editTextNickname);

                if (TextUtils.isEmpty(login.getText().toString())){
                    Snackbar.make(root,"Введите ваш логин", Snackbar.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(email.getText().toString())){
                    Snackbar.make(root,"Введите вашу почту", Snackbar.LENGTH_LONG).show();
                    return;
                }
                if (password.getText().toString().length() < 5){
                    Snackbar.make(root,"Введите ваш пароль из более 5 символов", Snackbar.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(nickname.getText().toString())){
                    Snackbar.make(root,"Введите ваш никнейм", Snackbar.LENGTH_LONG).show();
                    return;
                }


//                if (users.orderByChild("email").equalTo(email.getText().toString()).toString() == email.getText().toString()){
//                    Snackbar.make(root,"Такой пользователь уже есть", Snackbar.LENGTH_LONG).show();
//                    return;
//                }
                Intent intent1 = new Intent(this,SignInActivity.class);
                //Регистрация пользователей
                auth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                User user = new User();
                                user.setLogin(login.getText().toString());
                                user.setEmail(email.getText().toString());
                                user.setPassword(password.getText().toString());
                                user.setNickname(nickname.getText().toString());

                                users.child(user.getLogin()).setValue(user)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                Snackbar.make(root, "Успешное создание пользователя!", Snackbar.LENGTH_LONG).show();
                                            }
                                        });

                                startActivity(intent1);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Snackbar.make(root, "Ошибка регистрации" + e.getMessage(),Snackbar.LENGTH_LONG).show();
                            }
                        });

                break;
            default:
                break;

        }
    }
}