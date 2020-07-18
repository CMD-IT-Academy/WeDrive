package uz.Wedrive.wedrive.sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.User.WeDriveHome;

public class VerificationScreen extends AppCompatActivity {

    Spinner Telephone, Verification_til;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_screen);

        Telephone = findViewById(R.id.Telefon_nomer);
        Verification_til = findViewById(R.id.SMS_til);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.language, R.layout.custom_spinner);
        arrayAdapter.setDropDownViewResource(R.layout.custom_spinner);
        Verification_til.setAdapter(arrayAdapter);

        final List<TelephoneSpinner> customList1 = new ArrayList<>();
        customList1.add(new TelephoneSpinner(R.drawable.ic_call, "+998937402581"));
        customList1.add(new TelephoneSpinner(R.drawable.ic_edit, "Edit"));

        TelephoneSpinnerAdapter telephoneSpinnerAdapter = new TelephoneSpinnerAdapter(VerificationScreen.this, R.layout.custom_spinner, customList1);
        Telephone.setAdapter(telephoneSpinnerAdapter);

        Telephone.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if(customList1.get(i).getIconName().equals("Edit")){
                    Intent intent = new Intent(getApplicationContext(), Telephone.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void SMS_signin(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
    }

    public void F_P_Next(View view) {
        Intent intent = new Intent(getApplicationContext(), WeDriveHome.class);
        startActivity(intent);
        finish();
    }

    public void telephone_next(View view) {
        Intent intent = new Intent(getApplicationContext(), GenderScreen.class);
        startActivity(intent);
        finish();
    }
}
