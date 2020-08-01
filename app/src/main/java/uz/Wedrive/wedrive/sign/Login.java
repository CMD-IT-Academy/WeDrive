package uz.Wedrive.wedrive.sign;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.Sign_up_new;
import uz.Wedrive.wedrive.sign.Forgot_Password.ForgotPassword;

public class Login extends AppCompatActivity {

    Spinner Spinner_SignIn_til;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Spinner_SignIn_til = findViewById(R.id.SignIn_til);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.language, R.layout.custom_spinner);
        Spinner_SignIn_til.setAdapter(arrayAdapter);
    }

    public void signup(View view) {
        Intent intent = new Intent(getApplicationContext(), Sign_up_new.class);
        startActivity(intent);
        finish();
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

    public void forgot_password (View view) {
        Intent intent = new Intent(getApplicationContext(), ForgotPassword.class);
        startActivity(intent);
    }
}
