package com.sahil.carcredible;

import com.sahil.carcredible.adapter.NavDrawerListAdapter;
import com.sahil.carcredible.model.NavDrawerItem;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.CompoundButton;
public class MainActivity extends Activity {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	public int max_budget = 100;
	public int min_budget = 0, car_age = 100,mileage= 100;
	public int cbox_hback_set = 0, cbox_sedan_set=0,cbox_suv_set=0;
	public int cbox_petrol_set = 0, cbox_diesel_set=0, cbox_lpg_set = 0; //var to check checkbox in fuel type fragmetn
	public int cbox_manual_set=0,cbox_auto_set = 0;
	public int cbox_owner1_set=0,cbox_owner2_set=0 ,cbox_owner3_set=0;
	
	// nav drawer title
	private CharSequence mDrawerTitle;

	// used to store app title
	private CharSequence mTitle;

	// slide menu items
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;

	private ArrayList<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter;
	
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTitle = mDrawerTitle = getTitle();
		// load slide menu items
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

		// nav drawer icons from resources
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

		navDrawerItems = new ArrayList<NavDrawerItem>();

		// adding nav drawer items to array
		// Home
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
		// Find People
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
		// Photos
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
		// Communities, Will add a counter here
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1)));
		// Pages
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
		// What's hot, We  will add a counter here
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1) ));
		
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[6], navMenuIcons.getResourceId(6, -1) ));

		navDrawerItems.add(new NavDrawerItem(navMenuTitles[7], navMenuIcons.getResourceId(7, -1) ));

		navDrawerItems.add(new NavDrawerItem(navMenuTitles[8], navMenuIcons.getResourceId(8, -1) ));

		// Recycle the typed array
		navMenuIcons.recycle();

		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		// setting the nav drawer list adapter
		adapter = new NavDrawerListAdapter(getApplicationContext(),
				navDrawerItems);
		mDrawerList.setAdapter(adapter);

		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, //nav menu toggle icon
				R.string.app_name, // nav drawer open - description for accessibility
				R.string.app_name // nav drawer close - description for accessibility
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			displayView(0);
		}
	}

	/**
	 * Slide menu item click listener
	 * */
	private class SlideMenuClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			
			displayView(position);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// toggle nav drawer on selecting action bar app icon/title
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/* *
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	/**
	 * Diplaying fragment view for selected nav drawer list item
	 * */
	private void displayView(int position) {
		// update the main content by replacing fragments
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new HomeFragment();
			break;
		case 1:
			//fragment = new FindPeopleFragment();
			break;
		case 2:
			fragment = new BudgetFragment();
			break;
		case 3:
			fragment = new CarAgeFragment();
			break;
		case 4:
			fragment = new MileageFragment();
			break;
		case 5:
			fragment = new FuelTypeFragment();
			break;
		case 6:
			fragment = new BodyTypeFragment();
			break;
		case 7:
			fragment = new TransmissionFragment();
			break;
		case 8:
			fragment = new OwnerFragment();
			break;
		default:
			break;
		}

		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, fragment).commit();
			
			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(navMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	private SeekBar PRICEbar; 
    private TextView SeekValue;
    private TextView PRICEtextProgress,DISTANCEtextProgress, RATINGtextProgress;
    
    public void AndroidSeekBar(SeekBar id1, TextView textid,int type){
    /** Called when the activity is first created. */
       	
        PRICEbar = id1; // make seekbar object
        SeekValue = textid;                   

        int progress = PRICEbar.getProgress();
        
        PRICEbar.setTag(String.valueOf(type));

        
        PRICEbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ 

        	   @Override 
        	   public void onProgressChanged(SeekBar seekBar, int progress, 
        	     boolean fromUser) { 
      		   
        		   int type=Integer.parseInt(seekBar.getTag().toString());

        	        if(type== 1){
        	     //   	 ((MainActivity)getActivity()).max_budget = progress;
        	        //     ((MainActivity)getActivity()).min_budget = min_budget_sbar.getProgress();
        	        	if(progress < min_budget + 5){
          		       		progress = min_budget + 5;
          		       		seekBar.setProgress(progress);
        	        	}
        	        	max_budget = progress;
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
        	        	car_age = progress;
        	        	if(progress >= 90){
        	        		SeekValue.setText("No Limit");
        	        	}
        	        	else{
        	        		int value = progress/6;
        	        		SeekValue.setText(String.valueOf(value)+ " Years");
        	        	}
        	        }
        	        else if(type==3){
        	        	mileage = progress;
        	        	if(progress>95)
        	        	{
        	        		SeekValue.setText("99999 km");
        	        	}
        	        	else{
        	        		int value = ((progress/5)*5)*1000;
        	        		SeekValue.setText(String.valueOf(value)+ " km");
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
        }
    private SeekBar PRICEbar1;
    private TextView SeekValue1;
    public void AndroidSeekBar1(SeekBar id1, TextView textid,int type){
    /** Called when the activity is first created. */
       	
        PRICEbar1 = id1; // make seekbar object
        SeekValue1 = textid;                   

        int progress = PRICEbar1.getProgress();
        
        PRICEbar1.setTag(String.valueOf(type));

        
        PRICEbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ 

        	   @Override 
        	   public void onProgressChanged(SeekBar seekBar, int progress, 
        	     boolean fromUser) { 
      		       	
      		       	if(progress > max_budget- 5){
      		       		progress = max_budget- 5;
      		       	seekBar.setProgress(progress);
      		       	}
      		       	min_budget = progress;
        	        	if(progress>98){
        	        		SeekValue1.setText("No Limit");
        	        	}
        	        	else{
        	           	float value = (float)(progress*2/10);
        	           	if((progress*2)%10 >= 5){
        	           		value+=0.5;
        	           	}
        	           	 SeekValue1.setText("Rs. "+ String.valueOf(value) + " L");
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
        }
    public void onCheckboxClicked(CheckBox cBox, int filter, int type) {
        // Is the view now checked?
        boolean checked = cBox.isChecked();        
        cBox.setTag(String.valueOf(type));
        if(filter==1)
        {
            cBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    			
    			@Override
    			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    				// TODO Auto-generated method stub
    				int type=Integer.parseInt(buttonView.getTag().toString());
    		        if(type == 1)
    		        {
    		        	if (isChecked)
    		            	cbox_petrol_set = 1;
    		            else
    		            	cbox_petrol_set = 0;
    		        }
    		        else if(type==2)
    		        {
    		            if (isChecked)
    		            	cbox_diesel_set = 1;	
    		            else
    		            	cbox_diesel_set = 0;
    		        }
    		        else if (type==3)
    		        {
    		        	if(isChecked)
    		        		cbox_lpg_set = 1;
    		        	else
    		        		cbox_lpg_set = 0;
    		        }

    			}
    		});

        }
        else if(filter==2)
        {
            cBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    			
    			@Override
    			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    				// TODO Auto-generated method stub
    				int type=Integer.parseInt(buttonView.getTag().toString());
    		        if(type == 1)
    		        {
    		        	if (isChecked)
    		            	cbox_hback_set = 1;
    		            else
    		            	cbox_hback_set = 0;
    		        }
    		        else if(type==2)
    		        {
    		            if (isChecked)
    		            	cbox_sedan_set = 1;	
    		            else
    		            	cbox_sedan_set = 0;
    		        }
    		        else if (type==3)
    		        {
    		        	if(isChecked)
    		        		cbox_suv_set = 1;
    		        	else
    		        		cbox_suv_set = 0;
    		        }

    			}
    		});

        }
        else if(filter==3)
        {
            cBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    			
    			@Override
    			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    				// TODO Auto-generated method stub
    				int type=Integer.parseInt(buttonView.getTag().toString());
    		        if(type == 1)
    		        {
    		        	if (isChecked)
    		            	cbox_auto_set = 1;
    		            else
    		            	cbox_auto_set = 0;
    		        }
    		        else if(type==2)
    		        {
    		            if (isChecked)
    		            	cbox_manual_set = 1;	
    		            else
    		            	cbox_manual_set = 0;
    		        }
    			}
    		});

        }
        else if(filter==4)
        {
            cBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    			
    			@Override
    			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    				// TODO Auto-generated method stub
    				int type=Integer.parseInt(buttonView.getTag().toString());
    		        if(type == 1)
    		        {
    		        	if (isChecked)
    		            	cbox_owner1_set = 1;
    		            else
    		            	cbox_owner1_set = 0;
    		        }
    		        else if(type==2)
    		        {
    		            if (isChecked)
    		            	cbox_owner2_set = 1;	
    		            else
    		            	cbox_owner2_set = 0;
    		        }
    		        else if (type==3)
    		        {
    		        	if(isChecked)
    		        		cbox_owner3_set = 1;
    		        	else
    		        		cbox_owner3_set = 0;
    		        }

    			}
    		});

        }
       
    }
}
