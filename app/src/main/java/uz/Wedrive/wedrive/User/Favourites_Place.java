package uz.Wedrive.wedrive.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import uz.Wedrive.wedrive.R;

public class Favourites_Place extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites_place);
    }

    public void back_f_p(View view) {
        finish();
    }
}
