package com.fingertip.seekaround.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fingertip.seekaround.R;

public class SplashActivity extends AppCompatActivity {

    private TextView tvAppname;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        initializeViews();
        setAlphaAnimation(tvAppname);
    }

    private void initializeViews() {
        tvAppname = findViewById(R.id.tvAppname);
        spinner = findViewById(R.id.progress);
        spinner.getIndeterminateDrawable().setColorFilter(0xFFFFFFFF, android.graphics.PorterDuff.Mode.MULTIPLY);
    }


    public void setAlphaAnimation(TextView v) {
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(v, "alpha", .0f, 1f);
        fadeIn.setDuration(2000);
        final AnimatorSet mAnimationSet = new AnimatorSet();
        mAnimationSet.play(fadeIn);

        mAnimationSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                spinner.setVisibility(View.VISIBLE);
                new CountDownTimer(3000, 100) {


                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        Intent homeIntent = new Intent(SplashActivity.this, MainActivity.class);
                        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(homeIntent);
                    }
                }.start();
            }
        });
        mAnimationSet.start();
    }
}
