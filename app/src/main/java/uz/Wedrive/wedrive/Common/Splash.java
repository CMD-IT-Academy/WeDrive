package uz.Wedrive.wedrive.Common;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.appcompat.app.AppCompatActivity;

import uz.Wedrive.wedrive.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SystemClock.sleep(2000);
        Intent intent = new Intent(Splash.this, OnBoarding.class);
        startActivity(intent);
        finish();
    }
}
