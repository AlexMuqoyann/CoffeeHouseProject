package com.example.hp.coffeeh.activitys;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hp.coffeeh.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class LoginActivity extends AppCompatActivity {

    private TextView tv_coffeHouse;
    private EditText et_email;
    private EditText et_password;
    private CircularProgressButton btn_login;
    private TextView tv_dont_have_account;
    private boolean isValid;
    private boolean logic = true;
    private AlertDialog.Builder builder;
    private FirebaseAuth mAuth;
    private TextView tv_resset_password;
    private TextView tv_info;
    private FirebaseAuth.AuthStateListener maAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        mAuth = FirebaseAuth.getInstance();


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();
                if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
                    tv_info.setVisibility(View.VISIBLE);
                }
                else {
                    @SuppressLint("StaticFieldLeak") AsyncTask<String, String, String> go = new AsyncTask<String, String, String>() {
                        @Override
                        protected void onPostExecute(String s) {
                            super.onPostExecute(s);
                            if (s.equals("done")) {
                                btn_login.doneLoadingAnimation(Color.parseColor("#00BCD4"), BitmapFactory.decodeResource(getResources(), R.drawable.ic_done_white_48dp));
                            }
                        }

                        @Override
                        protected String doInBackground(String... strings) {
                            try {
                                Thread.sleep(400);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            return "done";
                        }
                    };
                    login(email,password);
                    btn_login.startAnimation();
                    go.execute();
                    tv_info.setVisibility(View.GONE);
                }


            }
        });
        setFont();
        tv_resset_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RessetPaswordActivity.class));
            }
        });

        maAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                }
            }
        };


    }


    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(maAuthStateListener);
    }

    private void login(String email, final String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                    tv_info.setVisibility(View.GONE);
                } else {
                    tv_info.setVisibility(View.VISIBLE);
                    tv_info.setText("Please Sign up");
                }
            }
        });
    }


    private void init() {
        tv_coffeHouse = (TextView) findViewById(R.id.tv_coffeHouse);
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (CircularProgressButton) findViewById(R.id.btn_login);
        tv_dont_have_account = (TextView) findViewById(R.id.tv_dont_have_account);
        tv_resset_password = (TextView) findViewById(R.id.tv_resset_password);
        tv_info = (TextView) findViewById(R.id.tv_info);


        tv_dont_have_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, DontHaveAcountActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setFont() {
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "coffehouse.ttf");
        tv_coffeHouse.setTypeface(myTypeface);
    }

    @Override
    public void onBackPressed() {
        if (logic = true) {
            String title = "Exit";
            String message = "Do you want to exit the Application?";
            String button1String = "Yes";
            String button2String = "No";
            builder = new AlertDialog.Builder(LoginActivity.this);
            builder.setTitle(title);
            builder.setIcon(R.drawable.coffehousee);
            builder.setMessage(message);
            builder.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();

                }
            });

            builder.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.show();
        } else {
            super.onBackPressed();
        }
    }


}
