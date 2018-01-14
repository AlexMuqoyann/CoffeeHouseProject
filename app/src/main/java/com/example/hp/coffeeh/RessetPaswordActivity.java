package com.example.hp.coffeeh;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class RessetPaswordActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_coffeeh;
    private EditText et_resset_email;
    private Button btn_resset;
    private Button btn_back;
    private ProgressBar progressBar;
    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resset_pasword);
        init();
        mauth = FirebaseAuth.getInstance();

    }

    private void init() {
        tv_coffeeh = (TextView) findViewById(R.id.tv_coffeeh);
        et_resset_email = (EditText) findViewById(R.id.et_resset_email);
        btn_resset = (Button) findViewById(R.id.btn_resset);
        btn_back = (Button) findViewById(R.id.btn_back);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btn_back.setOnClickListener(this);
        btn_resset.setOnClickListener(this);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "coffehouse.ttf");
        Typeface myTypeface1 = Typeface.createFromAsset(getAssets(), "zilap.ttf");
        tv_coffeeh.setTypeface(myTypeface);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_resset:
                String email = et_resset_email.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    et_resset_email.setError("Enter your email");

                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    mauth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(RessetPaswordActivity.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(RessetPaswordActivity.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                                    }

                                    progressBar.setVisibility(View.GONE);
                                }
                            });
                }


        }
    }
}
