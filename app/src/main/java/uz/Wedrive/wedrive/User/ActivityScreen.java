package uz.Wedrive.wedrive.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import uz.Wedrive.wedrive.R;

public class ActivityScreen extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        bottomNavigationView = findViewById(R.id.bottom_menu);

        bottomNavigationView.setSelectedItemId(R.id.activity);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.activity:
                        return true;

                    case R.id.home:
                        Intent intent  = new Intent(getApplicationContext(), WeDriveHome.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.more:
                        Intent intent1  = new Intent(getApplicationContext(), MoreScreen.class);
                        startActivity(intent1);
                        overridePendingTransition(0, 0);
                        return true;
                }


                return false;
            }
        });
    }
}
