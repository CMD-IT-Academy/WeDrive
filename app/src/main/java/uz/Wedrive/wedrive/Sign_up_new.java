package uz.Wedrive.wedrive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.List;

import uz.Wedrive.wedrive.HelperClasses.SliderAdapterSignUp;
import uz.Wedrive.wedrive.sign.SignUpPageFragment.PageFragment;
import uz.Wedrive.wedrive.sign.SignUpPageFragment.PageFragment2;
import uz.Wedrive.wedrive.sign.SignUpPageFragment.PageFragment3;
import uz.Wedrive.wedrive.sign.SignUpPageFragment.PageFragment4;
import uz.Wedrive.wedrive.sign.SignUpPageFragment.PageFragment5;

public class Sign_up_new extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private WormDotsIndicator wormDotsIndicator;
    private Button next_btn;
    public static int position_item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_new);

        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment());
        list.add(new PageFragment2());
        list.add(new PageFragment3());
        list.add(new PageFragment4());

        next_btn = findViewById(R.id.login);
        wormDotsIndicator = findViewById(R.id.dot1);
        viewPager = findViewById(R.id.slider2);
        pagerAdapter = new SliderAdapterSignUp(getSupportFragmentManager(), list);
        viewPager.setAdapter(pagerAdapter);
        wormDotsIndicator.setViewPager(viewPager);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NextButton();
            }
        });

    }

    private void NextButton() {
//        int pos = pagerAdapter.getItemPosition(pagerAdapter);
        viewPager.setCurrentItem(position_item ++);
        Toast.makeText(this, "NUMBER : " + position_item, Toast.LENGTH_SHORT).show();


    }
}