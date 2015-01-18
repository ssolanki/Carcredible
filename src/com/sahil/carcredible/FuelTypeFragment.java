package com.sahil.carcredible;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

public class FuelTypeFragment extends Fragment {
	
	public FuelTypeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_fuel_type_filter, container, false);
        CheckBox petrol = (CheckBox)rootView.findViewById(R.id.fuel_type_petrol);
        CheckBox diesel = (CheckBox)rootView.findViewById(R.id.fuel_type_diesel);
        CheckBox lpg = (CheckBox)rootView.findViewById(R.id.fuel_type_lpg);
        if(((MainActivity)getActivity()).cbox_petrol_set ==1)
        	petrol.setChecked(true);
        else
        	petrol.setChecked(false);
        if(((MainActivity)getActivity()).cbox_diesel_set ==1)
        	diesel.setChecked(true);
        else
        	diesel.setChecked(false);
        if(((MainActivity)getActivity()).cbox_lpg_set ==1)
            lpg.setChecked(true);
        else
        	lpg.setChecked(false);
        ((MainActivity)getActivity()).onCheckboxClicked(petrol,1,1);
        ((MainActivity)getActivity()).onCheckboxClicked(diesel,1,2);
        ((MainActivity)getActivity()).onCheckboxClicked(lpg,1,3); 
        return rootView;
    }
}