package uz.Wedrive.wedrive.User;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import uz.Wedrive.wedrive.R;

public class MoreScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_screen);

    }
    public void home(View view) {
        Intent intent = new Intent(getApplicationContext(), WeDriveHome.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void activity(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityScreen.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}
