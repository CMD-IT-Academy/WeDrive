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

}
