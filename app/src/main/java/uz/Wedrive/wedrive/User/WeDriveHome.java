package uz.Wedrive.wedrive.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import uz.Wedrive.wedrive.HelperClasses.ModelUsers;
import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.SharePreferance.Settings;

public class WeDriveHome extends AppCompatActivity {
    DatabaseReference dbRef;
//    Spinner user;
    FirebaseUser user;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.we_drive_home);

        sendFirebaseData();

        Toast.makeText(this, "" + Settings.getSettings().getFirsName() + "\n"
                + Settings.getSettings().getLastName() + "\n"
                + Settings.getSettings().getPhone() + "\n"
                + Settings.getSettings().getData() + "\n"
                + Settings.getSettings().getId() + "\n"
                + Settings.getSettings().getEmail(), Toast.LENGTH_LONG).show();
    }

    private void sendFirebaseData() {
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        Settings.getSettings().setId(user.getUid());
        ModelUsers modelUsers = new ModelUsers(Settings.getSettings().getFirsName(), Settings.getSettings().getLastName(), Settings.getSettings().getPhone(), Settings.getSettings().getEmail(), Settings.getSettings().getId(), Settings.getSettings().getData());
        dbRef = FirebaseDatabase.getInstance().getReference("Users");
        dbRef.child(user.getUid().toString()).setValue(modelUsers).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(getApplicationContext(), "Успешное завершение !!", Toast.LENGTH_SHORT).show();
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


    public void settings(View view) {
        Intent intent = new Intent(getApplicationContext(), SettingScreen.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}

