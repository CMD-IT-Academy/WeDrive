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

public class PageFragment extends Fragment {
    private static EditText FirstName, LastName;
    public static Boolean Page1 = false;
    Button button;
    private static String Fname, Lname;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.sign_up_page1, container, false);

        FirstName = rootView.findViewById(R.id.FirstName1);
        LastName = rootView.findViewById(R.id.LastName1);
        button = rootView.findViewById(R.id.sign_google);


        CallbackName();

        return rootView;
    }

    public static Boolean CallbackName() {
        Fname = FirstName.getText().toString();
        Lname = LastName.getText().toString();

        if (!Fname.isEmpty()) {
            Settings.getSettings().setFirsName(Fname);
            Settings.getSettings().setLastName(Lname);
            Page1 = true;
        }

        return Page1;
    }
    public static void Warring() {
            FirstName.setError("Set Name");
            FirstName.setFocusable(true);
    }


}
