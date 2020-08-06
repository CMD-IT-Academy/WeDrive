package uz.Wedrive.wedrive.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import uz.Wedrive.wedrive.R;

public class Settings_Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_payment);
    }

    public void back_payment(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
