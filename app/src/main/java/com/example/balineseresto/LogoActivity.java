package com.example.balineseresto;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LogoActivity extends AppCompatActivity {
    private static int WELCOME_TIMEOUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcome = new Intent(LogoActivity.this, MainActivity.class);
                        startActivity(welcome);
                        finish();
            }
        }, WELCOME_TIMEOUT);
    }
}
