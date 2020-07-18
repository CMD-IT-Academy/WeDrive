package uz.Wedrive.wedrive.sign.Forgot_Password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.sign.Login;

public class ForgotPassword extends AppCompatActivity {

    Spinner Forgot_Password_til;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        Forgot_Password_til = findViewById(R.id.Forgot_Password_til);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.language, R.layout.custom_spinner);
        Forgot_Password_til.setAdapter(arrayAdapter);

    }

    public void signup(View view){
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
    }

    public void back_to_login(View view){
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
    }

    public void Forgot_Password_Phone(View view){
        Intent intent = new Intent(getApplicationContext(), Forgot_Password_Telephone.class);
        startActivity(intent);
    }

    public void Forgot_Password_Email(View view){
        Intent intent = new Intent(getApplicationContext(), Forgot_Password_email.class);
        startActivity(intent);
    }



}
