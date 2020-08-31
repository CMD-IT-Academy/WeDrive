package uz.Wedrive.wedrive.Common;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.Sign_up_new;

public class Splash extends AppCompatActivity {

    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        SystemClock.sleep(2000);

        onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
        boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);

        if(isFirstTime){

            SharedPreferences.Editor editor = onBoardingScreen.edit();
            editor.putBoolean("firstTime", false);
            editor.commit();

            Intent intent = new Intent(Splash.this, OnBoarding.class);
            startActivity(intent);
            finish();
        }
        else {
            Intent intent = new Intent(Splash.this, Sign_up_new.class);
            startActivity(intent);
            finish();
        }
    }
}
