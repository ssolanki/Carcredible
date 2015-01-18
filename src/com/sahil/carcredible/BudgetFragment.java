package com.sahil.carcredible;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.sahil.carcredible.AndroidSeekBar;
public class BudgetFragment extends Fragment {

    private TextView max_budget_tv,min_budget_tv;
    private SeekBar max_budget_sbar,min_budget_sbar;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		int max_value = ((MainActivity)getActivity()).max_budget ;
		int min_value = ((MainActivity)getActivity()).min_budget ;
        View rootView = inflater.inflate(R.layout.fragment_budget_filter, container, false);
//        String.valueOf(this.getId());
        max_budget_sbar = (SeekBar) rootView.findViewById(R.id.budget_max_seekbar);
        max_budget_tv = (TextView) rootView.findViewById(R.id.max_budget);
        min_budget_sbar = (SeekBar) rootView.findViewById(R.id.budget_min_seekbar);
        min_budget_tv = (TextView) rootView.findViewById(R.id.min_budget);
        max_budget_sbar.setProgress(max_value);
        min_budget_sbar.setProgress(min_value);
    	if(max_value>98){
    		max_budget_tv.setText("No Limit");
    	}
    	else if(max_value <= 98){
       	float value = (float)(max_value*2/10);
       	if((max_value*2)%10 >= 5){
       		value+=0.5;
       	}
       		max_budget_tv.setText("Rs. "+ String.valueOf(value) + " L");
    	}
    	if(min_value>98){
    		min_budget_tv.setText("No Limit");
    	}
    	else if (min_value<=98){
       	float value = (float)(min_value*2/10);
       	if((min_value*2)%10 >= 5){
       		value+=0.5;
       	}
       		min_budget_tv.setText("Rs. "+ String.valueOf(value) + " L");
    	}
        ((MainActivity)getActivity()).AndroidSeekBar1(min_budget_sbar, min_budget_tv,0);
    	 ((MainActivity)getActivity()).AndroidSeekBar(max_budget_sbar, max_budget_tv,1 );
    	 
        return rootView;
    }
}

