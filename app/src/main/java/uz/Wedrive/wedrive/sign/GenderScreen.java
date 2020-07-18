package uz.Wedrive.wedrive.sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import uz.Wedrive.wedrive.R;

public class GenderScreen extends AppCompatActivity {

    Spinner Gender_til;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_screen);

        Gender_til = findViewById(R.id.Gender_til);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.language, R.layout.custom_spinner);
        Gender_til.setAdapter(arrayAdapter);

    }

    public void Gender_signin(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
    }

    public void telephone_next(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp_Last_Page.class);
        startActivity(intent);
        finish();
    }
}
