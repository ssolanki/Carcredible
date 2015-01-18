package com.sahil.carcredible;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

public class TransmissionFragment extends Fragment {
	
	public TransmissionFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_transmission_filter, container, false);
        CheckBox auto = (CheckBox)rootView.findViewById(R.id.trans_auto);
        CheckBox manual = (CheckBox)rootView.findViewById(R.id.trans_manual);
        
        if(((MainActivity)getActivity()).cbox_auto_set ==1)
        	auto.setChecked(true);
        else
        	auto.setChecked(false);
        if(((MainActivity)getActivity()).cbox_manual_set ==1)
        	manual.setChecked(true);
        else
        	manual.setChecked(false);
       
        ((MainActivity)getActivity()).onCheckboxClicked(auto,3,1);
        ((MainActivity)getActivity()).onCheckboxClicked(manual,3,2);
        
        return rootView;
    }
}