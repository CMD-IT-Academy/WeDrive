package uz.Wedrive.wedrive.sign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import uz.Wedrive.wedrive.R;

public class TelephoneSpinnerAdapter extends ArrayAdapter<TelephoneSpinner> {

    private Context context;
    private List<TelephoneSpinner> country;

    public TelephoneSpinnerAdapter(@NonNull Context context, int resource, List<TelephoneSpinner> country) {
        super(context, resource, country);
        this.context = context;
        this.country = country;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return myCustomSpinnerView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return myCustomSpinnerView(position, convertView, parent);
    }

    private View myCustomSpinnerView(int position, @Nullable View myView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = layoutInflater.inflate(R.layout.spinner_layout, parent, false);

        TextView Country_Name = (TextView)customView.findViewById(R.id.Country_Name);
        ImageView Country_Flag = (ImageView)customView.findViewById(R.id.Country_Flag);

        Country_Name.setText(country.get(position).getIconName());
        Country_Flag.setImageResource(country.get(position).getIcon());

        return customView;
    }
}
