package com.example.hp.coffeeh;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.coffeeh.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

import io.ghyeok.stickyswitch.widget.StickySwitch;

public class DontHaveAcountActivity extends AppCompatActivity  {

    private MaterialEditText et_name;
    private MaterialEditText et_Sname;
    private MaterialEditText et_age;
    private MaterialEditText et_email;
    private MaterialEditText et_password;
    private MaterialEditText et_number;
    private Spinner spinner;
    private StickySwitch stickySwitch;
    private Button btn_singin;
    private String[] code;
    private String maleOrFemale = "Male";
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    private Button btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dont_have_acount);
        init();
        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        checkFields();



    }

    private void addNewUser(){
        String name = et_name.getText().toString();
        String Sname = et_Sname.getText().toString();
        String  email = et_email.getText().toString();
        String password = et_password.getText().toString();
        String age = et_age.getText().toString();
        String number = et_number.getText().toString();
        String id = databaseReference.push().getKey();
        User user = new User(id,name,email,Sname,password,age,number,maleOrFemale);
        databaseReference.child(id).setValue(user);

    }
    private void checkFields(){
        btn_singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = et_email.getText().toString();
                String password = et_password.getText().toString();
                String name = et_name.getText().toString();
                String sname = et_Sname.getText().toString();
                String number = et_number.getText().toString();
                String age = et_age.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    et_name.setError("please enter your name");
                } else if (TextUtils.isEmpty(sname)) {
                    et_Sname.setError("please enter your sname");
                } else if (TextUtils.isEmpty(age)) {
                    et_age.setError("please enter your age");
                }
                else if (TextUtils.isEmpty(number)) {
                    et_number.setError("please enter your number");
                }
                else if(TextUtils.isEmpty(email)){
                    et_email.setError("please enter your email");
                }else if(TextUtils.isEmpty(password)&&password.length()<6){
                    et_password.setError("please enter password");
                }
                else{
                    createAccount(email,password);
                    addNewUser();
                }

            }
        });
    }


    private void createAccount(String email, final String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    checkpassword(password);
                    Toast.makeText(DontHaveAcountActivity.this, "Registration agre", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DontHaveAcountActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean checkpassword(String password){
        if (password.length()<6){
            return false;
        }
        return true;
    }


    private void init() {
        btn_back = (Button)findViewById(R.id.btn_back1);
        et_name = (MaterialEditText) findViewById(R.id.et_name);
        et_Sname = (MaterialEditText) findViewById(R.id.et_sname);
        et_age = (MaterialEditText) findViewById(R.id.et_age);
        et_email = (MaterialEditText) findViewById(R.id.et_email1);
        et_password = (MaterialEditText) findViewById(R.id.et_password);
        et_number = (MaterialEditText) findViewById(R.id.et_number);
        spinner = (Spinner) findViewById(R.id.spinner_code);
        btn_singin = (Button) findViewById(R.id.btn_singin);
        stickySwitch = (StickySwitch)findViewById(R.id.sticky_switch);
        maleOrFemale = stickySwitch.getText();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        code = getResources().getStringArray(R.array.code);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, code);
        spinner.setAdapter(adapter);






    }


}
