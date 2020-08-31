package uz.Wedrive.wedrive.HelperClasses;

import android.view.View;
import android.view.ViewGroup;
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
    private Fragment mCurrentFragment;
   public static int num;


    public Fragment getCurrentFragmnent(){
        return mCurrentFragment;
    }

    public SliderAdapterSignUp(FragmentManager fm, Fragment mCurrentFragment) {
        super(fm);
        this.mCurrentFragment = mCurrentFragment;
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        if (getCurrentFragmnent() != object){
            mCurrentFragment = (Fragment) object;
        }
        super.setPrimaryItem(container, position, object);
    }

    public SliderAdapterSignUp(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        Sign_up_new.position_item = position;
        num = position;
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

}
