package uz.Wedrive.wedrive.sign;

public class TelephoneSpinner {
    private int icon;
    private String iconName;

    public TelephoneSpinner(int icon, String iconName) {
        this.icon = icon;
        this.iconName = iconName;
    }


    public int getIcon() {
        return icon;
    }

    public String getIconName() {
        return iconName;
    }
}
