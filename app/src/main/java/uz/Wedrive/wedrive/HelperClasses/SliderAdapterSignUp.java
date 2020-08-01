package uz.Wedrive.wedrive.HelperClasses;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.Sign_up_new;

public class SliderAdapterSignUp extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;

    public SliderAdapterSignUp(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        Sign_up_new.position_item = position;
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

}
