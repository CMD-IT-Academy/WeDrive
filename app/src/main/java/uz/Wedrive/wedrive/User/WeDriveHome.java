package uz.Wedrive.wedrive.User;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import uz.Wedrive.wedrive.R;

public class WeDriveHome extends AppCompatActivity {

    Spinner user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.we_drive_home);

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


    public void settings(View view) {
        Intent intent = new Intent(getApplicationContext(), SettingScreen.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}

