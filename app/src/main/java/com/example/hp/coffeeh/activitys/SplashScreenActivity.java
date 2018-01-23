package com.example.hp.coffeeh.activitys;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hp.coffeeh.R;

public class SplashScreenActivity extends AppCompatActivity {
   private static int TIME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slpash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            goActivity();
            }
        },TIME);

    }
    private void goActivity(){
        startActivity(new Intent(SplashScreenActivity.this,LoginActivity.class));
        finish();
    }

}
