package uz.Wedrive.wedrive.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import uz.Wedrive.wedrive.R;

public class SettingScreen extends AppCompatActivity {

    TextView settings_text, setting_user_name, setting_user_id, Edit_Profile, Location_Info, Payment, Language, or_line1, or_line2;
    TextView setting_personal_text, Notification, DarkMode;
    ImageView back_settings, search_settings, setting_add_account, Edit_Profile_icon, Location_Info_icon, Payment_icon, Language_icon;
    ImageView Notification_icon, DarkMode_icon, Edit_Profile_next, Location_Info_next, Payment_next, Notification_next;
    EditText setting_search;
    Button setting_LogOut;
    int a;
    Switch darkmode;
    ConstraintLayout Settings_Oyna, settings_main_layout, settings_user_layout, settings_edit_profile_layout, settings_location_layout;
    ConstraintLayout settings_payment_layout, settings_language_layout, settings_notification_layout, settings_dark_mode_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_screen);

        setting_search = findViewById(R.id.setting_search);                  //Edittext
        settings_text = findViewById(R.id.settings_text);                    //TextView
        back_settings = findViewById(R.id.back_settings);                    //ImageView
        search_settings = findViewById(R.id.search_settings);                //ImageView
        setting_user_name = findViewById(R.id.setting_user_name);            //TextView
        setting_user_id = findViewById(R.id.setting_user_id);                //TextView
        setting_LogOut = findViewById(R.id.setting_LogOut);                  //Button
        setting_add_account = findViewById(R.id.setting_add_account);        //ImageView
        Edit_Profile = findViewById(R.id.Edit_Profile);                      //TextView
        Location_Info = findViewById(R.id.Location_Info);                    //TextView
        Payment = findViewById(R.id.Payment);                                //TextView
        Language = findViewById(R.id.Language);                              //TextView
        or_line1 = findViewById(R.id.or_line1);                              //TextView
        or_line2 = findViewById(R.id.or_line2);                              //TextView
        setting_personal_text = findViewById(R.id.setting_personal_text);    //TextView
        Notification = findViewById(R.id.Notification);                      //TextView
        DarkMode = findViewById(R.id.DarkMode);                              //TextView
        Edit_Profile_icon = findViewById(R.id.Edit_Profile_icon);            //ImageView
        Location_Info_icon = findViewById(R.id.Location_Info_icon);          //ImageView
        Payment_icon = findViewById(R.id.Payment_icon);                      //ImageView
        Language_icon = findViewById(R.id.Language_icon);                    //ImageView
        Notification_icon = findViewById(R.id.Notification_icon);            //ImageView
        DarkMode_icon = findViewById(R.id.DarkMode_icon);                    //ImageView
        Edit_Profile_next = findViewById(R.id.Edit_Profile_next);            //ImageView
        Location_Info_next = findViewById(R.id.Location_Info_next);          //ImageView
        Payment_next = findViewById(R.id.Payment_next);                      //ImageView
        Notification_next = findViewById(R.id.Notification_next);            //ImageView

        //ConstraintLayout
        settings_main_layout = findViewById(R.id.settings_main_layout);
        settings_user_layout = findViewById(R.id.settings_user_layout);
        settings_edit_profile_layout = findViewById(R.id.settings_edit_profile_layout);
        settings_location_layout = findViewById(R.id.settings_location_layout);
        settings_payment_layout = findViewById(R.id.settings_payment_layout);
        settings_language_layout = findViewById(R.id.settings_language_layout);
        settings_notification_layout = findViewById(R.id.settings_notification_layout);
        settings_dark_mode_layout = findViewById(R.id.settings_dark_mode_layout);
        //ConstraintLayout



        a = 0;

        darkmode = findViewById(R.id.DarkModeSwitch);
        Settings_Oyna = findViewById(R.id.Settings_Oyna);

        darkmode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (darkmode.isChecked()){
                    Settings_Oyna.setBackgroundResource(R.color.dark_mode);
                    setting_search.setTextColor(getResources().getColor(R.color.colorWhite));
                    setting_search.setHintTextColor(getResources().getColor(R.color.colorWhite));
                    settings_text.setTextColor(getResources().getColor(R.color.text_dark));
                    back_settings.setImageResource(R.drawable.ic_back_settings_dark);
                    search_settings.setImageResource(R.drawable.ic_search_settings_dark);
                    setting_user_name.setTextColor(getResources().getColor(R.color.text_dark));
                    setting_user_id.setTextColor(getResources().getColor(R.color.text_dark));
                    setting_add_account.setImageResource(R.drawable.ic_add_account_dark);
                    Edit_Profile.setTextColor(getResources().getColor(R.color.text_dark));
                    Location_Info.setTextColor(getResources().getColor(R.color.text_dark));
                    Payment.setTextColor(getResources().getColor(R.color.text_dark));
                    Language.setTextColor(getResources().getColor(R.color.text_dark));
                    or_line1.setBackgroundResource(R.drawable.or_line_dark);
                    or_line2.setBackgroundResource(R.drawable.or_line_dark);
                    setting_personal_text.setTextColor(getResources().getColor(R.color.text_dark));
                    Notification.setTextColor(getResources().getColor(R.color.text_dark));
                    DarkMode.setTextColor(getResources().getColor(R.color.text_dark));
                    Edit_Profile_icon.setImageResource(R.drawable.edit_profile_icon);
                    Location_Info_icon.setImageResource(R.drawable.location_icon);
                    Payment_icon.setImageResource(R.drawable.ic_lock);
                    Language_icon.setImageResource(R.drawable.ic_lock);
                    Notification_icon.setImageResource(R.drawable.ic_lock);
                    DarkMode_icon.setImageResource(R.drawable.dark_mode_icon);
                    Edit_Profile_next.setImageResource(R.drawable.right_icon_dark);
                    Location_Info_next.setImageResource(R.drawable.right_icon_dark);
                    Payment_next.setImageResource(R.drawable.right_icon_dark);
                    Notification_next.setImageResource(R.drawable.right_icon_dark);

                    //ConstraintLayout
                    settings_main_layout.setBackgroundResource(R.drawable.layout_round_dark);
                    settings_user_layout.setBackgroundResource(R.drawable.layout_round_dark);
                    settings_edit_profile_layout.setBackgroundResource(R.drawable.layout_round_dark);
                    settings_location_layout.setBackgroundResource(R.drawable.layout_round_dark);
                    settings_payment_layout.setBackgroundResource(R.drawable.layout_round_dark);
                    settings_language_layout.setBackgroundResource(R.drawable.layout_round_dark);
                    settings_notification_layout.setBackgroundResource(R.drawable.layout_round_dark);
                    settings_dark_mode_layout.setBackgroundResource(R.drawable.layout_round_dark);

                } else {
                    Settings_Oyna.setBackgroundResource(R.color.colorWhite);
                    setting_search.setTextColor(getResources().getColor(R.color.colorBlack));
                    setting_search.setHintTextColor(getResources().getColor(R.color.colorBlack));
                    settings_text.setTextColor(getResources().getColor(R.color.colorBlack));
                    back_settings.setImageResource(R.drawable.ic_back_settings_light);
                    search_settings.setImageResource(R.drawable.ic_search_settings_light);
                    setting_user_name.setTextColor(getResources().getColor(R.color.colorBlack));
                    setting_user_id.setTextColor(getResources().getColor(R.color.colorBlack));
                    setting_add_account.setImageResource(R.drawable.ic_add_account_light);
                    Edit_Profile.setTextColor(getResources().getColor(R.color.colorBlack));
                    Location_Info.setTextColor(getResources().getColor(R.color.colorBlack));
                    Payment.setTextColor(getResources().getColor(R.color.colorBlack));
                    Language.setTextColor(getResources().getColor(R.color.colorBlack));
                    or_line1.setBackgroundResource(R.drawable.or_chiziq);
                    or_line2.setBackgroundResource(R.drawable.or_chiziq);
                    setting_personal_text.setTextColor(getResources().getColor(R.color.colorBlack));
                    Notification.setTextColor(getResources().getColor(R.color.colorBlack));
                    DarkMode.setTextColor(getResources().getColor(R.color.colorBlack));
                    Edit_Profile_icon.setImageResource(R.drawable.edit_profile_icon);
                    Location_Info_icon.setImageResource(R.drawable.location_icon);
                    Payment_icon.setImageResource(R.drawable.ic_lock);
                    Language_icon.setImageResource(R.drawable.ic_lock);
                    Notification_icon.setImageResource(R.drawable.ic_lock);
                    DarkMode_icon.setImageResource(R.drawable.dark_mode_icon);
                    Edit_Profile_next.setImageResource(R.drawable.right_icon_light);
                    Location_Info_next.setImageResource(R.drawable.right_icon_light);
                    Payment_next.setImageResource(R.drawable.right_icon_light);
                    Notification_next.setImageResource(R.drawable.right_icon_light);

                    //ConstraintLayout
                    settings_main_layout.setBackgroundResource(R.drawable.layout_round);
                    settings_user_layout.setBackgroundResource(R.drawable.layout_round);
                    settings_edit_profile_layout.setBackgroundResource(R.drawable.layout_round);
                    settings_location_layout.setBackgroundResource(R.drawable.layout_round);
                    settings_payment_layout.setBackgroundResource(R.drawable.layout_round);
                    settings_language_layout.setBackgroundResource(R.drawable.layout_round);
                    settings_notification_layout.setBackgroundResource(R.drawable.layout_round);
                    settings_dark_mode_layout.setBackgroundResource(R.drawable.layout_round);
                }
            }
        });
    }

    public void search_settings(View view) {
        a = 1;
        settings_text.setVisibility(View.INVISIBLE);
        setting_search.setVisibility(View.VISIBLE);
    }

    public void back_settings(View view) {
        if (a == 1) {
            a = 0;
            settings_text.setVisibility(View.VISIBLE);
            setting_search.setVisibility(View.INVISIBLE);
        }
        else if (a ==0 ){
            Intent intent = new Intent(getApplicationContext(), WeDriveHome.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        }
    }

    @Override
    public void onBackPressed() {
        if (a == 1) {
            a = 0;
            settings_text.setVisibility(View.VISIBLE);
            setting_search.setVisibility(View.INVISIBLE);
        }
        else if (a ==0 ){
            Intent intent = new Intent(getApplicationContext(), WeDriveHome.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        }
    }


}
