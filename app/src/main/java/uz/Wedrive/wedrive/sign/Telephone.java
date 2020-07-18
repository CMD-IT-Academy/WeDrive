package uz.Wedrive.wedrive.sign;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import uz.Wedrive.wedrive.R;

public class Telephone extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Spinner Telephone_Country;
    EditText Telephone_Code, Telephone_Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephone);

        Telephone_Country = findViewById(R.id.Phone_Country);

        Telephone_Code = findViewById(R.id.Tel_Code);
        Telephone_Number = findViewById(R.id.Tel_Nomer);

        final List<TelephoneSpinner> customList1 = new ArrayList<>();
        customList1.add(new TelephoneSpinner(R.drawable.ic_uzbekistan, "Uzbekistan"));
        customList1.add(new TelephoneSpinner(R.drawable.ic_russia, "Russia"));

        TelephoneSpinnerAdapter telephoneSpinnerAdapter = new TelephoneSpinnerAdapter(Telephone.this, R.layout.spinner_layout, customList1);
        Telephone_Country.setAdapter(telephoneSpinnerAdapter);

        Telephone_Country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if(customList1.get(i).getIconName().equals("Uzbekistan")){
                    Telephone_Code.setText("  +998  |");
                } else {
                    Telephone_Code.setText("   +7   |");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner Spinner_Telephone_til = findViewById(R.id.Telephone_til);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.language, R.layout.custom_spinner);
        arrayAdapter.setDropDownViewResource(R.layout.custom_spinner);
        Spinner_Telephone_til.setAdapter(arrayAdapter);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public void signin(View view){
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
    }

    public void telephone_next(View view){
        Intent intent = new Intent(getApplicationContext(), VerificationScreen.class);
        startActivity(intent);
        finish();
    }
}
