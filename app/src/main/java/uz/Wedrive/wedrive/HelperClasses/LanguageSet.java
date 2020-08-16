package uz.Wedrive.wedrive.HelperClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.sign.Login;

public class LanguageSet extends AppCompatActivity {

    TextView uzbek_language, rus_language, ingliz_language;
    ImageView uzbek_language_check, rus_language_check, ingliz_language_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_set);

        uzbek_language = findViewById(R.id.uzbek_language);
        rus_language = findViewById(R.id.rus_language);
        ingliz_language = findViewById(R.id.ingliz_language);
        uzbek_language_check = findViewById(R.id.uzbek_language_check);
        rus_language_check = findViewById(R.id.rus_language_check);
        ingliz_language_check = findViewById(R.id.ingliz_language_check);

    }

    public void uzbek_lang(View view) {
        uzbek_language_check.setImageResource(R.drawable.check_icon);
        rus_language_check.setImageResource(R.drawable.transfer_image);
        ingliz_language_check.setImageResource(R.drawable.transfer_image);
    }

    public void rus_lang(View view) {
        rus_language_check.setImageResource(R.drawable.check_icon);
        uzbek_language_check.setImageResource(R.drawable.transfer_image);
        ingliz_language_check.setImageResource(R.drawable.transfer_image);
    }

    public void english_lang(View view) {
        ingliz_language_check.setImageResource(R.drawable.check_icon);
        rus_language_check.setImageResource(R.drawable.transfer_image);
        uzbek_language_check.setImageResource(R.drawable.transfer_image);
    }

    public void LanguageSet_continue(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        overridePendingTransition(0,0);
        finish();
    }
}