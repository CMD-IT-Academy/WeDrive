package uz.Wedrive.wedrive.sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.Sign_up_new;

public class Verification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
    }

    public void NEXT(View view) {
        Intent intent = new Intent(this, Sign_up_new.class);
        startActivity(intent);
        finish();
    }
}
