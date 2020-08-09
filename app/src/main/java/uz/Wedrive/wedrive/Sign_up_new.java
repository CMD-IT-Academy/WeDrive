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

import com.google.firebase.auth.FirebaseAuth;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.List;

import uz.Wedrive.wedrive.HelperClasses.SliderAdapterSignUp;
import uz.Wedrive.wedrive.SharePreferance.Settings;
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
    int currentTab = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_new);
        Settings.init(getApplicationContext());
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

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentTab = position;
                switch (position) {
                    case 1:
                        if (PageFragment.Page1) {
                            // swipe from left to right
                            viewPager.setCurrentItem(1);
                        } else {
                            // swipe from right to left
                            viewPager.setCurrentItem(2);
                        }
                        break;
                    case 2:
                        if (PageFragment2.Page2) {
                            viewPager.setCurrentItem(2);
                        } else {
                            viewPager.setCurrentItem(3);
                        }
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NextButton();
            }
        });

    }

    private void NextButton() {
        if (currentTab == 0) {
            if (PageFragment.CallbackName()) {
                viewPager.setCurrentItem(currentTab + 1);
            }else {
                PageFragment.Warring();
            }
        }else if (currentTab == 1){
            if (PageFragment2.CallBackPage2()){
                viewPager.setCurrentItem(currentTab + 1);
            }else {
                PageFragment2.Warring();
            }

        }

        Toast.makeText(this, "NUMBER : " + currentTab, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}