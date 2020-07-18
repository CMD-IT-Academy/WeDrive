package uz.Wedrive.wedrive.sign.Forgot_Password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.sign.VerificationScreen;

public class Email_Verification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email__verification);
    }

    public void TryPhone (View view) {
        Intent intent = new Intent(getApplicationContext(), Forgot_Password_Telephone.class);
        startActivity(intent);
        finish();
    }

    public void Verify_and_Login(View view) {
        Intent intent = new Intent(getApplicationContext(), VerificationScreen.class);
        startActivity(intent);
        finish();
    }
}
