package com.sahil.carcredible;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.sahil.carcredible.AndroidSeekBar;
public class CarAgeFragment extends Fragment {
	
	public CarAgeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_car_age_filter, container, false);
        SeekBar max_age_sbar = (SeekBar) rootView.findViewById(R.id.max_age_seekbar);
        TextView max_age_tv = (TextView) rootView.findViewById(R.id.max_age);
        AndroidSeekBar set_max= new AndroidSeekBar(max_age_sbar, max_age_tv,2); 
        return rootView;
    }
}