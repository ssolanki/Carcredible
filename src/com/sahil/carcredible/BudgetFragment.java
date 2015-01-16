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
	 SeekBar max_budget_sbar, min_budget_sbar;
	 TextView max_budget_tv,min_budget_tv;
	public BudgetFragment(){}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putInt("max_budget", max_budget_sbar.getProgress());
		outState.putInt("min_budget", min_budget_sbar.getProgress());
		
	}	

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
        View rootView = inflater.inflate(R.layout.fragment_budget_filter, container, false);
        
        max_budget_sbar = (SeekBar) rootView.findViewById(R.id.budget_max_seekbar);
        max_budget_tv = (TextView) rootView.findViewById(R.id.max_budget);
        min_budget_sbar = (SeekBar) rootView.findViewById(R.id.budget_min_seekbar);
        min_budget_tv = (TextView) rootView.findViewById(R.id.min_budget);
       
        if(savedInstanceState == null){
        	Log.e("Not Saved", " not saved");
        }else{
        	Log.e("Saved", "saved");
        }
       
        AndroidSeekBar set_max= new AndroidSeekBar(max_budget_sbar, max_budget_tv,1);
        AndroidSeekBar set_min= new AndroidSeekBar(min_budget_sbar, min_budget_tv,1);
        
        Button reset_btn = (Button) rootView.findViewById(R.id.reset_button);
        reset_btn.setOnClickListener(new View.OnClickListener() {
        	
        //	((MyApp) this.getApplication()).setDefaultVarValue(1);
            
        	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
//				   MyApp objMyApp = (MyApp)v.getContext().getApplicationContext();   
//				   objMyApp.setDefaultVarValue(1); 
			}
		});
//        SetDefault set_default = new SetDefault(reset_btn);
        
        return rootView;
    }
	
	
}
/*
  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
*/