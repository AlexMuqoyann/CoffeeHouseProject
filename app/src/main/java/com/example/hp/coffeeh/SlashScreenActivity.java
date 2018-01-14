package com.example.hp.coffeeh;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SlashScreenActivity extends AppCompatActivity {
   private Animation updown,downtoup;
   private TextView tv_splash_text1;
   private TextView tv_splash_text2;
   private RelativeLayout rl_row1;
   private RelativeLayout rl_row2;
   private static int TIME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slpash_screen);
        init();
        setFont();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            goActivity();
            }
        },TIME);

    }
    private void goActivity(){
        startActivity(new Intent(SlashScreenActivity.this,LoginActivity.class));
        finish();
    }
    private void init(){
//        tv_splash_text1 = (TextView)findViewById(R.id.tv_splashe_text1);
//        tv_splash_text2 = (TextView)findViewById(R.id.tv_splashe_text2);
//        rl_row1 = (RelativeLayout)findViewById(R.id.rl_row1) ;
//        rl_row2 = (RelativeLayout)findViewById(R.id.rl_row2);
//        updown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
//        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
//        rl_row1.setAnimation(updown);
//        rl_row2.setAnimation(downtoup);

    }
    private void setFont(){
//        Typeface mytapface = Typeface.createFromAsset(getAssets(),"paradise.ttf");
//        Typeface mytapface1 = Typeface.createFromAsset(getAssets(),"paradise.ttf");
//        tv_splash_text1.setTypeface(mytapface);
//        tv_splash_text2.setTypeface(mytapface1);
    }
}
