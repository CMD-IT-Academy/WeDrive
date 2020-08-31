package uz.Wedrive.wedrive.sign.SignUpPageFragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import uz.Wedrive.wedrive.R;
import uz.Wedrive.wedrive.SharePreferance.Settings;

public class PageGetEmail extends Fragment {

    private EditText editText;
    private TextView textView;
    boolean pageGetEmail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.sign_up_page3, container, false);
        Settings.init(getContext());
        editText = rootView.findViewById(R.id.user_emil);
        textView = rootView.findViewById(R.id.user_tel);
        textView.setText(Settings.getSettings().getPhone().replaceFirst("(\\d{3})(\\d{2})(\\d{3})(\\d{2})(\\d+)", "$1($2)$3-$4-$5"));

        Call();
        return rootView;
    }

    public void Call() {
        if (editText != null){
            Settings.getSettings().setEmail(editText.getText().toString());
        }
       /* else {
            editText.setError("Set Phone");
            editText.setFocusable(true);
        }  */
    }

}
