package uz.Wedrive.wedrive.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import uz.Wedrive.wedrive.R;

public class SettingScreen extends AppCompatActivity {

    TextView Settings_text;
    EditText Search_setting;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_screen);

        Search_setting = findViewById(R.id.setting_search);
        Settings_text = findViewById(R.id.settings_text);
        a = 0;

    }

    public void search_settings(View view) {
        a = 1;
        Settings_text.setVisibility(View.INVISIBLE);
        Search_setting.setVisibility(View.VISIBLE);
    }

    public void back_settings(View view) {
        if (a == 1) {
            a = 0;
            Settings_text.setVisibility(View.VISIBLE);
            Search_setting.setVisibility(View.INVISIBLE);
        }
        else if (a ==0 ){
            Intent intent = new Intent(getApplicationContext(), WeDriveHome.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        }
    }

    @Override
    public void onBackPressed() {
        if (a == 1) {
            a = 0;
            Settings_text.setVisibility(View.VISIBLE);
            Search_setting.setVisibility(View.INVISIBLE);
        }
        else if (a ==0 ){
            Intent intent = new Intent(getApplicationContext(), WeDriveHome.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        }
    }


}
