package uz.Wedrive.wedrive.sign.SignUpPageFragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class PageFragment3 extends Fragment {
    private PinView pinView;
    private String phoneNumber;
    private String verificationId = "";
    private FirebaseAuth mAuth;
    private TextView btngetcode, verify;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.sign_up_page3, container, false);

        mAuth = FirebaseAuth.getInstance();
        pinView = rootView.findViewById(R.id.pinView);
        phoneNumber = "+998" + Settings.getSettings().getPhone();
        btngetcode = rootView.findViewById(R.id.reset_email3);
        verify = rootView.findViewById(R.id.try_email3);
        String c = pinView.getText().toString().trim();
        if (c.isEmpty()) {
            pinView.setError("EMPTY enter code ...");
            pinView.requestFocus();
        }

        btngetcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendVerification();
            }
        });
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "verificationId  :  " + verificationId, Toast.LENGTH_SHORT).show();
                String code = pinView.getText().toString();
                Toast.makeText(getContext(), "code PIN :  " + code, Toast.LENGTH_SHORT).show();
                verfyCode();
            }
        });


        return rootView;
    }

    private void verfyCode() {
        try {
            String code = pinView.getText().toString();
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
            signInWith(credential);
        } catch (Exception e) {
            Toast toast = Toast.makeText(getContext(), "Verification Code is wrong", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    private void signInWith(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener((Activity) getContext(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getContext(), "OK SUCCESSFUL", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "teredcfe", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    public void sendVerification() {
        Toast.makeText(getContext(), "" + phoneNumber, Toast.LENGTH_SHORT).show();
        Log.i("LOG3", phoneNumber);

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,
                60,
                TimeUnit.SECONDS,
                (Activity) getContext(),
                mCallbacks);
    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationId = s;
            Log.i("LOG1", "Code ersdf : " + s);
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String cod = phoneAuthCredential.getSmsCode();
            Log.i("LOG1", "SMS CODE : " + cod);
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Log.i("LOG1", " onVerificationFailed  : " + e.getMessage());
            Toast.makeText(getContext(), "Faled : " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };
}
