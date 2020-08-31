package uz.Wedrive.wedrive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.List;

import uz.Wedrive.wedrive.HelperClasses.SliderAdapterSignUp;
import uz.Wedrive.wedrive.SharePreferance.Settings;
import uz.Wedrive.wedrive.User.WeDriveHome;
import uz.Wedrive.wedrive.sign.SignUpPageFragment.PageGetName;
import uz.Wedrive.wedrive.sign.SignUpPageFragment.PageGetDateGender;
import uz.Wedrive.wedrive.sign.SignUpPageFragment.PageGetEmail;
import uz.Wedrive.wedrive.sign.SignUpPageFragment.PageFinal;
import uz.Wedrive.wedrive.sign.SignUpPageFragment.PageGetPhone;
import uz.Wedrive.wedrive.sign.SignUpPageFragment.PagePhoneAut;

public class Sign_up_new extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private WormDotsIndicator wormDotsIndicator;
    private Button next_btn;
    public static int position_item;
    int currentTab = 0;
    public Boolean fireAutSelect;
    public static Context mConext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_new);
        Settings.init(getApplicationContext());
        mConext = getApplicationContext();

        List<Fragment> list = new ArrayList<>();
        list.add(new PageGetPhone());
        list.add(new PagePhoneAut());
        list.add(new PageGetName());
        list.add(new PageGetDateGender());
        list.add(new PageGetEmail());
        list.add(new PageFinal());

        next_btn = findViewById(R.id.next_page);
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
                        if (PageGetPhone.PageGetPhone) {
                            // swipe from left to right
                            viewPager.setCurrentItem(1);
                        } else {
                            // swipe from right to left
                            viewPager.setCurrentItem(2);
                        }
                        break;
                    case 2:
                        if (PagePhoneAut.PagePhoneAut) {
                            // swipe from left to right
                            viewPager.setCurrentItem(2);
                        } else {
                            // swipe from right to left
                            viewPager.setCurrentItem(3);
                        }
                        break;
                    case 3:
                        if (PageGetName.Callback()) {
                            viewPager.setCurrentItem(3);
                        } else {
                            viewPager.setCurrentItem(4);
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
                Log.e("FFF", "CLICK BUTTON");
                NextButton();
            }
        });

    }

    public void nextPage() {
        Log.e("CAM2", "Next page");
        viewPager.setCurrentItem(currentTab + 1);

    }

    public void NextButton() {
        if (currentTab == 0) {
            if (PageGetPhone.CallbackName()) {
                Log.e("CAM2", "case 2 succesfull");
                viewPager.setCurrentItem(currentTab + 1);
                ((PagePhoneAut) ((SliderAdapterSignUp) viewPager.getAdapter()).getCurrentFragmnent()).sendVerification(PageGetPhone.PhoneNumber);
                ((PagePhoneAut) ((SliderAdapterSignUp) viewPager.getAdapter()).getCurrentFragmnent()).setPhoneTextView(PageGetPhone.PhoneNumber.replaceFirst("(\\d{3})(\\d{2})(\\d{3})(\\d{2})(\\d+)", "$1($2)$3-$4-$5"));
            }
        } else if (currentTab == 1) {
            ((PagePhoneAut) ((SliderAdapterSignUp) viewPager.getAdapter()).getCurrentFragmnent()).CallbackPone();
        }
        if (currentTab == 2) {
//            PageGetName pageGetName = new PageGetName();
//            pageGetName.Callback();
            if (PageGetName.Callback()) {
                Log.e("CAM2", "PAGE SUCCESFULL");
                viewPager.setCurrentItem(currentTab + 1);
            }
        }else if (currentTab == 3){
            if (PageGetDateGender.CallGetDataGen()){
                viewPager.setCurrentItem(currentTab + 1);
            }
        }else if (currentTab == 4){
            viewPager.setCurrentItem(currentTab + 1);
        }else if (currentTab == 5){
            Intent intent = new Intent(Sign_up_new.this, WeDriveHome.class);
            startActivity(intent);
            finish();
        }

        Toast.makeText(this, "NUMBER : " + currentTab, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }


}



