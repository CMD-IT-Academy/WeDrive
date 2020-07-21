package uz.Wedrive.wedrive.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import uz.Wedrive.wedrive.R;

public class MoreScreen extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_screen);

        bottomNavigationView = findViewById(R.id.bottom_menu);

        bottomNavigationView.setSelectedItemId(R.id.more);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.activity:
                        Intent intent  = new Intent(getApplicationContext(), ActivityScreen.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.home:
                        Intent intent1  = new Intent(getApplicationContext(), WeDriveHome.class);
                        startActivity(intent1);
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.more:
                        return true;
                }


                return false;
            }
        });
    }
}
