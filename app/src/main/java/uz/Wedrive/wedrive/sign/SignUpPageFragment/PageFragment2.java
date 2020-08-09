package uz.Wedrive.wedrive.sign.SignUpPageFragment;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
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

public class PageFragment2 extends Fragment {
    static EditText PhoneNumber;
    public static Boolean Page2 = false;

    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.sign_up_page2, container, false);

        PhoneNumber = rootView.findViewById(R.id.phone_number);
        PhoneNumber.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        progressBar = rootView.findViewById(R.id.progressbas1);

//        SendverficationCode(PhoneNumber.getText().toString());


//


        return rootView;
    }

    public static Boolean CallBackPage2() {
        if (!PhoneNumber.getText().toString().isEmpty()) {
            Settings.getSettings().setPhone(PhoneNumber.getText().toString());
            Page2 = true;
        }

        return Page2;
    }

    public static void Warring() {
        PhoneNumber.setError("Edit Phone Number");
        PhoneNumber.setFocusable(true);
    }







}
