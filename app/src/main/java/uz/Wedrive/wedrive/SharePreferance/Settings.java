package uz.Wedrive.wedrive.SharePreferance;

import android.content.Context;
import android.content.SharedPreferences;

public class Settings {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private static Settings settings;

    public static void init(Context context) {
        if (settings == null) {
            settings = new Settings(context);
        }
    }

    public static Settings getSettings() {
        return settings;
    }

    private Settings(Context context) {
        preferences = context.getSharedPreferences("SETTINGS", Context.MODE_PRIVATE);
    }

    public void setNightMode(boolean nightMode) {
        editor = preferences.edit();
        editor.putBoolean("NIGHT_MODE", nightMode);
        editor.apply();
    }

    public boolean getNightMode() {
        return preferences.getBoolean("NIGHT_MODE", false);
    }

    public void setLastName(String profilName) {
        editor = preferences.edit();
        editor.putString("PROFIL_LASTNAME", profilName);
        editor.apply();
    }

    public String getLastName() {
        return preferences.getString("PROFIL_LASTNAME", "");
    }

    public void setFirsName(String profilName) {
        editor = preferences.edit();
        editor.putString("PROFIL_FIRSTNAME", profilName);
        editor.apply();
    }

    public String getFirsName() {
        return preferences.getString("PROFIL_FIRSTNAME", "");
    }

    public void setPhone(String profilName) {
        editor = preferences.edit();
        editor.putString("PROFIL_PHONE", profilName);
        editor.apply();
    }

    public String getPhone() {
        return preferences.getString("PROFIL_PHONE", "");
    }

    public void setFireAutId(String select) {
        editor = preferences.edit();
        editor.putString("FireAutId", select);
        editor.apply();
    }

    public String getFireAutId() {
        return preferences.getString("FireAutId","" );
    }

    public void setId(String select) {
        editor = preferences.edit();
        editor.putString("ID", select);
        editor.apply();
    }

    public String getId() {
        return preferences.getString("ID","" );
    }

    public void setEmail(String profilEmail) {
        editor = preferences.edit();
        editor.putString("PROFIL_EMAIL", profilEmail);
        editor.apply();
    }

    public String getEmail() {
        return preferences.getString("PROFIL_EMAIL", "");
    }

    public void setData(String profilEmail) {
        editor = preferences.edit();
        editor.putString("PROFIL_DATA", profilEmail);
        editor.apply();
    }

    public String getData() {
        return preferences.getString("PROFIL_DATA", "");
    }

}
