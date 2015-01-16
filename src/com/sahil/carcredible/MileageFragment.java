package com.sahil.carcredible;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.sahil.carcredible.AndroidSeekBar;
public class MileageFragment extends Fragment {
	
	public MileageFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_mileage_filter, container, false);
        
        SeekBar max_mileage_sbar = (SeekBar) rootView.findViewById(R.id.max_mileage_seekbar);
        TextView max_mileage_tv = (TextView) rootView.findViewById(R.id.max_mileage);
        AndroidSeekBar set_max= new AndroidSeekBar(max_mileage_sbar, max_mileage_tv,3);
        
        return rootView;
    }
}