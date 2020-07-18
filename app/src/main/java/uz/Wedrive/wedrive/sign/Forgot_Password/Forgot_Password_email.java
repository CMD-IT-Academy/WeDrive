package uz.Wedrive.wedrive.sign.Forgot_Password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import uz.Wedrive.wedrive.R;

public class Forgot_Password_email extends AppCompatActivity {

    Spinner F_P_E_til;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password_email);

        F_P_E_til = findViewById(R.id.F_P_E_til);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.language, R.layout.custom_spinner);
        F_P_E_til.setAdapter(arrayAdapter);
    }

    public void TryPhone (View view) {
        Intent intent = new Intent(getApplicationContext(), Forgot_Password_Telephone.class);
        startActivity(intent);
        finish();
    }

    public void CendMeCode (View view) {
        Intent intent = new Intent(getApplicationContext(), Email_Verification.class);
        startActivity(intent);
        finish();
    }

}
