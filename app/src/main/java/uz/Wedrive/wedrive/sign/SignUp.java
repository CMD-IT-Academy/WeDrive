package uz.Wedrive.wedrive.sign;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


import uz.Wedrive.wedrive.R;

public class SignUp extends AppCompatActivity {

    EditText FirstName, LastName;

    Spinner Spinner_SignUp_til;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        FirstName = findViewById(R.id.FirstName);
        LastName = findViewById(R.id.LastName);


        Spinner_SignUp_til = findViewById(R.id.SignUp_til);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.language, R.layout.custom_spinner);
        arrayAdapter.setDropDownViewResource(R.layout.custom_spinner);
        Spinner_SignUp_til.setAdapter(arrayAdapter);
    }

    public void signin(View view){
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
    }

    public void NEXT(View view){
        Intent intent = new Intent(getApplicationContext(), Telephone.class);
        startActivity(intent);
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
