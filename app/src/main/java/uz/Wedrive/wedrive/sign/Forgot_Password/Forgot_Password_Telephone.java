package uz.Wedrive.wedrive.sign.Forgot_Password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.User.WeDriveHome;
import uz.Wedrive.wedrive.sign.Login;
import uz.Wedrive.wedrive.sign.TelephoneSpinner;
import uz.Wedrive.wedrive.sign.TelephoneSpinnerAdapter;

public class Forgot_Password_Telephone extends AppCompatActivity {

    Spinner Telephone, Forgot_Password_til;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password__telephone);

        Telephone = findViewById(R.id.Telefon_nomer);
        Forgot_Password_til = findViewById(R.id.F_P_T_til);


        final List<TelephoneSpinner> customList1 = new ArrayList<>();
        customList1.add(new TelephoneSpinner(R.drawable.ic_call, "+998937402581"));

        TelephoneSpinnerAdapter telephoneSpinnerAdapter = new TelephoneSpinnerAdapter(Forgot_Password_Telephone.this, R.layout.custom_spinner, customList1);
        Telephone.setAdapter(telephoneSpinnerAdapter);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.language, R.layout.custom_spinner);
        Forgot_Password_til.setAdapter(arrayAdapter);
    }

    public void F_P_SignIn(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
    }

    public void TryEmail(View view) {
        Intent intent = new Intent(getApplicationContext(), Forgot_Password_email.class);
        startActivity(intent);
        finish();
    }

    public void F_P_Next(View view) {
        Intent intent = new Intent(getApplicationContext(), WeDriveHome.class);
        startActivity(intent);
        finish();
    }
}
