package uz.Wedrive.wedrive.sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.User.WeDriveHome;

public class SignUp_Last_Page extends AppCompatActivity {

    Spinner Last_Page_Til;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__last__page);

        Last_Page_Til = findViewById(R.id.Last_Page_Til);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.language, R.layout.custom_spinner);
        arrayAdapter.setDropDownViewResource(R.layout.custom_spinner);
        Last_Page_Til.setAdapter(arrayAdapter);
    }

    public void signup(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
    }

    public void telephone_next(View view) {
        Intent intent = new Intent(getApplicationContext(), WeDriveHome.class);
        startActivity(intent);
        finish();
    }
}
