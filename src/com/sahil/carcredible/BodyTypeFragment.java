package com.sahil.carcredible;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.TextView;
import com.sahil.carcredible.AndroidSeekBar;
public class BodyTypeFragment extends Fragment {
	
	public BodyTypeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_body_type_filter, container, false);
        CheckBox hback = (CheckBox)rootView.findViewById(R.id.body_hback);
        CheckBox sedan = (CheckBox)rootView.findViewById(R.id.body_sedan);
        CheckBox suv = (CheckBox)rootView.findViewById(R.id.body_suv);
        if(((MainActivity)getActivity()).cbox_hback_set ==1)
        	hback.setChecked(true);
        else
        	hback.setChecked(false);
        if(((MainActivity)getActivity()).cbox_sedan_set ==1)
        	sedan.setChecked(true);
        else
        	sedan.setChecked(false);
        if(((MainActivity)getActivity()).cbox_suv_set ==1)
            suv.setChecked(true);
        else
        	suv.setChecked(false);
        ((MainActivity)getActivity()).onCheckboxClicked(hback,2,1);
        ((MainActivity)getActivity()).onCheckboxClicked(sedan,2,2);
        ((MainActivity)getActivity()).onCheckboxClicked(suv,2,3);
        
        return rootView;
    }
}