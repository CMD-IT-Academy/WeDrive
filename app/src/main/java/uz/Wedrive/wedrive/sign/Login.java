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
public class Login extends AppCompatActivity {

    Spinner Spinner_SignIn_til;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

    public void NEXT(View view) {
        Intent intent = new Intent(this, Verification.class);
        startActivity(intent);
        finish();
    }
}
