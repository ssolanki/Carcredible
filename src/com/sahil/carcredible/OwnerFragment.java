package com.sahil.carcredible;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

public class OwnerFragment extends Fragment {
	
	public OwnerFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_owner_filter, container, false);
        CheckBox owner1 = (CheckBox)rootView.findViewById(R.id.owner_type1);
        CheckBox owner2 = (CheckBox)rootView.findViewById(R.id.owner_type2);
        CheckBox owner3 = (CheckBox)rootView.findViewById(R.id.owner_type3);
        if(((MainActivity)getActivity()).cbox_owner1_set ==1)
        	owner1.setChecked(true);
        else
        	owner1.setChecked(false);
        if(((MainActivity)getActivity()).cbox_owner2_set ==1)
        	owner2.setChecked(true);
        else
        	owner2.setChecked(false);
        if(((MainActivity)getActivity()).cbox_owner3_set ==1)
            owner3.setChecked(true);
        else
        	owner3.setChecked(false);
        ((MainActivity)getActivity()).onCheckboxClicked(owner1,4,1);
        ((MainActivity)getActivity()).onCheckboxClicked(owner2,4,2);
        ((MainActivity)getActivity()).onCheckboxClicked(owner3,4,3); 
        return rootView;
    }
}