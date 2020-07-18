package uz.Wedrive.wedrive.HelperClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import uz.Wedrive.wedrive.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;


    public SliderAdapter(Context context) {
        this.context = context;
    }

    int[] images = {
            R.drawable.hand_booking_online,
            R.drawable.ic_taxi_inside_city,
            R.drawable.guide_page_3,
            R.drawable.guide_4


    };

    int[] headings = {
            R.string.first_slide_title,
            R.string.second_slide_title,
            R.string.third_slide_title,
            R.string.fourth_slide_title,

    };
    int[] descriptions_n1 = {
            R.string.first_slide_desc_n1,
            R.string.second_slide_desc_n1,
            R.string.third_slide_desc_n1,
            R.string.fourth_slide_desc_n1,
    };

    int[] descriptions_n2 = {
            R.string.first_slide_desc_n2,
            R.string.second_slide_desc_n2,
            R.string.third_slide_desc_n2,
            R.string.fourth_slide_desc_n2,
    };

    int[] descriptions_n3 = {
            R.string.first_slide_desc_n3,
            R.string.second_slide_desc_n3,
            R.string.third_slide_desc_n3,
            R.string.fourth_slide_desc_n3,
    };

    @Override
    public int getCount() {
        return(headings.length);
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout,container,false);

        //Hooks
        ImageView Dots_load1 = view.findViewById(R.id.dots_load1);
        ImageView Dots_load2 = view.findViewById(R.id.dots_load2);
        ImageView Dots_load3 = view.findViewById(R.id.dots_load3);
        ImageView Dots_load4 = view.findViewById(R.id.dots_load4);
        ImageView imageView = view.findViewById(R.id.slider_image);
        TextView heading = view.findViewById(R.id.slider_heading);
        TextView desc_n1 = view.findViewById(R.id.slider_desc_n1);
        TextView desc_n2 = view.findViewById(R.id.slider_desc_n2);
        TextView desc_n3 = view.findViewById(R.id.slider_desc_n3);

        imageView.setImageResource(images[position]);
        heading.setText(headings[position]);
        desc_n1.setText(descriptions_n1[position]);
        desc_n2.setText(descriptions_n2[position]);
        desc_n3.setText(descriptions_n3[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
