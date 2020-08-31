package uz.Wedrive.wedrive.sign.SignUpPageFragment;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.regex.Pattern;

import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.SharePreferance.Settings;

public class PageGetName extends Fragment {
    public static EditText FirstNam, LastNam;
    static Boolean call = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.sign_up_page1, container, false);
//        Settings.init(getContext());

        FirstNam = rootView.findViewById(R.id.First_name);
        LastNam = rootView.findViewById(R.id.Last_name);

//        Callback();

        return rootView;
    }

    public static Boolean Callback() {
        String First = FirstNam.getText().toString();
        String Last = LastNam.getText().toString();
        if (!First.isEmpty() && !Last.isEmpty()) {
            call = true;
            Settings.getSettings().setLastName(LastNam.getText().toString());
            Settings.getSettings().setFirsName(FirstNam.getText().toString());
            Log.e("MAFU", "First : " + First);
            Log.e("MAFU", "Last :" + Last);

        } else {
            call = false;
            Warring(First,Last);
        }
        return call;
    }


    public static void Warring(String First,String Last) {
        if (First.isEmpty()){
            FirstNam.setError("Set FirstName");
            FirstNam.setFocusable(true);
        }else if (Last.isEmpty()){
            LastNam.setError("Set LastName");
            LastNam.setFocusable(true);
        }
    }


}
