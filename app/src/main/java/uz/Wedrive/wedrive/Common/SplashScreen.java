package uz.Wedrive.wedrive.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.User.WeDriveHome;
import uz.Wedrive.wedrive.sign.Login;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;
    //varibale

    //Animation
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);

                if(isFirstTime){

                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent intent = new Intent(SplashScreen.this, OnBoarding.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(SplashScreen.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        } ,SPLASH_SCREEN);
    }
}
