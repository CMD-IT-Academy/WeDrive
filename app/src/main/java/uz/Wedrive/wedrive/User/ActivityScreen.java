package uz.Wedrive.wedrive.User;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import uz.Wedrive.wedrive.R;

public class ActivityScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

    }

    public void home(View view) {
        Intent intent = new Intent(getApplicationContext(), WeDriveHome.class);
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
        finish();
    }
}
