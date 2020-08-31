package uz.Wedrive.wedrive.sign.SignUpPageFragment;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.SharePreferance.Settings;

public class PageGetDateGender extends Fragment {
    public static EditText Userdata;
    public static Spinner UserGen;
    public static Boolean Page ;


    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.sign_up_page2, container, false);

        Userdata = rootView.findViewById(R.id.Settting_User_name);
        UserGen = rootView.findViewById(R.id.user_gender);


        return rootView;
    }

    public static Boolean CallGetDataGen() {
        String Userd = Userdata.getText().toString();
        if (!Userd.isEmpty()) {
            Page = true;
            Settings.getSettings().setData(Userdata.getText().toString());
        } else {
            Page = false;
            Userdata.setError("Set Data");
            Userdata.setFocusable(true);
        }
        return Page;
    }


}
