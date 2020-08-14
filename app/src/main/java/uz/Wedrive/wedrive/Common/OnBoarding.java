package uz.Wedrive.wedrive.Common;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import uz.Wedrive.wedrive.HelperClasses.SliderAdapter;
import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.sign.Login;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;

    SliderAdapter sliderAdapter;
    Button letsGetStarted;
    Animation animation;
    int currentPos;

    ImageView Page_Image, Dots_load1, Dots_load2, Dots_load3, Dots_load4;
    TextView SliderHeading;
//masalan o'zgardima? qaraqanin ishuni go'r
    Integer page_soni, ikkilik;

    Button skip;

    ImageView next,previous, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

        page_soni = 1;
        ikkilik = 0;

        //Hooks

        Dots_load1 = findViewById(R.id.dots_load1);
        Dots_load2 = findViewById(R.id.dots_load2);
        Dots_load3 = findViewById(R.id.dots_load3);
        Dots_load4 = findViewById(R.id.dots_load4);
        back = findViewById(R.id.back_btn);

        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots_layout);
        letsGetStarted = findViewById(R.id.get_started_btn);
        next = findViewById(R.id.next_btn);
        skip = findViewById(R.id.skip_btn);
        previous = findViewById(R.id.provious_btn);

        Page_Image = findViewById(R.id.slider_image);
        SliderHeading = findViewById(R.id.slider_heading);

        //call adapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        viewPager.addOnPageChangeListener(changeListener);

    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(R.string.exit_title);
        alertDialog.setIcon(R.drawable.ic_exit);
        alertDialog.setCancelable(true);
        alertDialog.setMessage(R.string.exit_message);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.show();
    }



    public void Started(View view){
        startActivity(new Intent(this, Login.class));
        finish();
    }
    public void next(View view){
        viewPager.setCurrentItem(currentPos + 1);
    }
    public void previous(View view){
        viewPager.setCurrentItem(currentPos - 1);
    }

    //OnClick Dots
    public void Dots1(View view){
        viewPager.setCurrentItem(0);
    }
    public void Dots2(View view){
        viewPager.setCurrentItem(1);
    }
    public void Dots3(View view){
        viewPager.setCurrentItem(2);
    }
    public void Dots4(View view){
        viewPager.setCurrentItem(3);
    }


    final ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currentPos = position;

            if (position == 0) {
                Dots_load1.setImageResource(R.drawable.dots_round_on);
                Dots_load2.setImageResource(R.drawable.dots_round_off);
                Dots_load3.setImageResource(R.drawable.dots_round_off);
                Dots_load4.setImageResource(R.drawable.dots_round_off);
                skip.setText("Skip");
                dotsLayout.setVisibility(View.VISIBLE);
                previous.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);
                skip.setVisibility(View.VISIBLE);
                letsGetStarted.setVisibility(View.INVISIBLE);
                page_soni = 1;
            } else if (position == 1) {
                Dots_load1.setImageResource(R.drawable.dots_round_off);
                Dots_load2.setImageResource(R.drawable.dots_round_on);
                Dots_load3.setImageResource(R.drawable.dots_round_off);
                Dots_load4.setImageResource(R.drawable.dots_round_off);
                skip.setText("Skip");
                dotsLayout.setVisibility(View.VISIBLE);
                previous.setVisibility(View.VISIBLE);
                skip.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                letsGetStarted.setVisibility(View.INVISIBLE);
                page_soni = 2;
            } else if (position == 2) {
                Dots_load1.setImageResource(R.drawable.dots_round_off);
                Dots_load2.setImageResource(R.drawable.dots_round_off);
                Dots_load3.setImageResource(R.drawable.dots_round_on);
                Dots_load4.setImageResource(R.drawable.dots_round_off);
                skip.setText("Skip");
                dotsLayout.setVisibility(View.VISIBLE);
                previous.setVisibility(View.VISIBLE);
                skip.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                letsGetStarted.setVisibility(View.INVISIBLE);
                page_soni = 3;
            } else {
                Dots_load1.setImageResource(R.drawable.dots_round_off);
                Dots_load2.setImageResource(R.drawable.dots_round_off);
                Dots_load3.setImageResource(R.drawable.dots_round_off);
                Dots_load4.setImageResource(R.drawable.dots_round_on);
                skip.setText("Back");
                next.setVisibility(View.INVISIBLE);
                dotsLayout.setVisibility(View.INVISIBLE);
                previous.setVisibility(View.INVISIBLE);
                animation = AnimationUtils.loadAnimation(OnBoarding.this, R.anim.get_started_btn_anim);
                letsGetStarted.setAnimation(animation);
                letsGetStarted.setVisibility(View.VISIBLE);
                page_soni = 4;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void skip(View view){
        if(page_soni == 1){
            ikkilik = ikkilik + 1;
            if(ikkilik == 1) {
                viewPager.setCurrentItem(currentPos + 3);
            } else if(ikkilik == 2){
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        }
        else if(page_soni == 2) {
            ikkilik = ikkilik + 1;
            if(ikkilik == 1) {
                viewPager.setCurrentItem((currentPos + 2));
            }
            else if(ikkilik == 2){
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        }
        else if(page_soni == 3){
            ikkilik = ikkilik + 1;
            if(ikkilik == 1){
                viewPager.setCurrentItem(currentPos + 1);
            }
            else if(ikkilik == 2) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        }
        else if(page_soni == 4){
            viewPager.setCurrentItem(currentPos -1);
        }
    }
}
