package uz.Wedrive.wedrive.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.sign.Telephone;
import uz.Wedrive.wedrive.sign.TelephoneSpinner;
import uz.Wedrive.wedrive.sign.TelephoneSpinnerAdapter;

public class WeDriveHome extends AppCompatActivity {

    Spinner user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.we_drive_home);

        user = findViewById(R.id.username);
        final List<TelephoneSpinner> customList1 = new ArrayList<>();
        customList1.add(new TelephoneSpinner(R.drawable.ic_user, "Bog'ibek Matyaqubov"));
        customList1.add(new TelephoneSpinner(R.drawable.ic_add, "Add new Account"));

        TelephoneSpinnerAdapter telephoneSpinnerAdapter = new TelephoneSpinnerAdapter(WeDriveHome.this, R.layout.spinner_layout, customList1);
        user.setAdapter(telephoneSpinnerAdapter);

        user.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void activity(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityScreen.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void more(View view) {
        Intent intent = new Intent(getApplicationContext(), MoreScreen.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }


    @Override
    public void onBackPressed() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(R.string.exit_title);
        alertDialog.setIcon(R.drawable.ic_exit);
        alertDialog.setCancelable(true);
        alertDialog.setMessage(R.string.exit_message);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.show();
    }


}

