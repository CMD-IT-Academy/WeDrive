package uz.Wedrive.wedrive.sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import uz.Wedrive.wedrive.R;

public class GenderScreen extends AppCompatActivity {

    Spinner Gender_til;
    RadioButton radioButton;
    RadioGroup radioGroup;
    int radioId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_screen);


        radioGroup = findViewById(R.id.radio_group);
        Gender_til = findViewById(R.id.Gender_til);
//        radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioGroup.getCheckedRadioButtonId());

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.language, R.layout.custom_spinner);
        Gender_til.setAdapter(arrayAdapter);

    }


    public void Gender_signin(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
    }

    public void telephone_next(View view) {
        radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
//        Log.i("TAG1", String.valueOf(radioGroup.getCheckedRadioButtonId()));
        if (radioButton != null) {
            Intent intent = new Intent(getApplicationContext(), SignUp_Last_Page.class);
            startActivity(intent);
            Log.i("TAG1", radioButton.getText().toString());
            finish();
        }
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
    }
}
