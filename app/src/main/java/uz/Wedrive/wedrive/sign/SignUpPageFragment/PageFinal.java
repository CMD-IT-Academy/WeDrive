package uz.Wedrive.wedrive.sign.SignUpPageFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.SharePreferance.Settings;

public class PageFinal extends Fragment {
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.sign_up_page4, container, false);

        textView = rootView.findViewById(R.id.Userinfo);
        textView.setText("Hello " + Settings.getSettings().getFirsName() + "\nAlmost Done Set a Profile Picture");


        return rootView;
    }
}
