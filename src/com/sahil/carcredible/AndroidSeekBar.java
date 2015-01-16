package com.sahil.carcredible;

import android.app.Activity;

import android.os.Bundle;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


public class AndroidSeekBar{

    // declare text objects variables
    private SeekBar PRICEbar; 
    private TextView SeekValue;
    private TextView PRICEtextProgress,DISTANCEtextProgress, RATINGtextProgress;
    
    public AndroidSeekBar(SeekBar id1, TextView textid,int type){
    /** Called when the activity is first created. */
       	
        PRICEbar = id1; // make seekbar object
        SeekValue = textid;                   
        
//        MyApp objMyApp = (MyApp)id1.getContext().getApplicationContext();   
        int is_reset = 0;//objMyApp.getDeafultVarValue();
        if(is_reset==1)
        {
        	PRICEbar.setProgress(0);
        }
        else{
	        if(type==2)
	        	PRICEbar.setProgress(50);
	        if(type==3)
	        	PRICEbar.setProgress(100);
        }
        int progress = PRICEbar.getProgress();
        
        PRICEbar.setTag(String.valueOf(type));
 
        PRICEbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ 

        	   @Override 
        	   public void onProgressChanged(SeekBar seekBar, int progress, 
        	     boolean fromUser) { 
        	    // TODO Auto-generated method stub 
        		//   	if(progress>95)
		       	//			SeekValue.setText("No Limit");
		       	//	else
        		   
        		   int type=Integer.parseInt(seekBar.getTag().toString());
        	        if(type==1){
        	        	if(progress>98){
        	        		SeekValue.setText("No Limit");
        	        	}
        	        	else{
        	           	float value = (float)(progress*2/10);
        	           	if((progress*2)%10 >= 5){
        	           		value+=0.5;
        	           	}
        	           	SeekValue.setText("Rs. "+ String.valueOf(value) + " L");
        	        	}	
        	        }
        	        else if(type==2){
        	        	if(progress >= 90){
        	        		SeekValue.setText("No Limit");
        	        	}
        	        	else{
        	        		progress = progress/6;
        	        		SeekValue.setText(String.valueOf(progress)+ " Years");
        	        	}
        	        }
        	        else if(type==3){
        	        	if(progress>95)
        	        	{
        	        		SeekValue.setText("99999 km");
        	        	}
        	        	else{
        	        		progress = ((progress/5)*5)*1000;
        	        		SeekValue.setText(String.valueOf(progress)+ " km");
        	        	}
        	        }
		       		
        	   } 
        	   		
        	   @Override 
        	   public void onStartTrackingTouch(SeekBar seekBar) { 
        	    // TODO Auto-generated method stub 
        	   } 

        	   @Override 
        	   public void onStopTrackingTouch(SeekBar seekBar) { 
        	    // TODO Auto-generated method stub 
        	   } 
        	       });
  /*      if(type==1)
        	SeekValue.setText("Rs."+ SeekValue.getText()+ " L");
        else if(type==2)
        	SeekValue.setText(SeekValue.getText()+ " Years");        
        else if(type ==3)
        	SeekValue.setText(SeekValue.getText()+ " km");
*/    }
    	
}