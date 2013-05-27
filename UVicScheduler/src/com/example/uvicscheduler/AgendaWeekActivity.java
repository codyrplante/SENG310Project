package com.example.uvicscheduler;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.support.v4.app.NavUtils;

public class AgendaWeekActivity extends Activity implements OnItemSelectedListener{
	TextView week;
	int weekOf = 1;
	List<String> list = new ArrayList<String>();
	String[] weeklisting = new String[] {"Week Of Feb 25, 2013", "Week Of Mar 4, 2013", "Week Of Mar 11, 2013", "Week Of Mar 18, 2013"};
	Button toDo1, toDo2, toDo3, toDo4, toDo5, toDo6;

	Intent intent;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agenda_week);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinnerView);
		spinner.setOnItemSelectedListener(this);
		
		list.add("Week");
		list.add("Day");
		list.add("Week");
		list.add("Month");
		list.add("Tasks");
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<String> termAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list) {
		    @Override
		    public View getDropDownView(int position, View convertView, ViewGroup parent)
		    {
		        View v = null;
		 
		        // If this is the initial dummy entry, make it hidden
		        if (position == 0) {
		            TextView tv = new TextView(getContext());
		            tv.setHeight(0);
		            tv.setVisibility(View.GONE);
		            v = tv;
		        }
		        else {
		            // Pass convertView as null to prevent reuse of special case views
		            v = super.getDropDownView(position, null, parent);
		        }
		 
		        // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
		        parent.setVerticalScrollBarEnabled(false);
		        return v;
		    }
		};
		
		// Specify the layout to use when the list of choices appears
		termAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(termAdapter);
		
		week = (TextView)findViewById(R.id.weekTextView);
		week.setText(weeklisting[weekOf]);
		
		toDo1 = (Button) findViewById(R.id.weekToDo1);
		toDo2 = (Button) findViewById(R.id.weekToDo2);
		toDo3 = (Button) findViewById(R.id.weekToDo3);
		toDo4 = (Button) findViewById(R.id.weekToDo4);
		toDo5 = (Button) findViewById(R.id.weekToDo5);
		toDo6 = (Button) findViewById(R.id.weekToDo6);
		toDo3.setVisibility(View.INVISIBLE);
		toDo4.setVisibility(View.INVISIBLE);
		toDo5.setVisibility(View.INVISIBLE);
		toDo6.setVisibility(View.INVISIBLE);
		
		toDo1.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFFFF00FF));
		toDo2.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFF008000));
		toDo3.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFF357EC7));
		toDo4.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFFFFA500));
		toDo5.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFF357EC7));
		toDo6.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFFAA0000));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
    public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
    	boolean change = true;
    	String selectedView = (String) parent.getItemAtPosition(pos);
    	if (selectedView.equalsIgnoreCase("Day")){
    		intent = new Intent(this, AgendaDayActivity.class);
    	} else if (selectedView.equalsIgnoreCase("Month")){
    		intent = new Intent(this, AgendaMonthActivity.class);
    	} else if (selectedView.equalsIgnoreCase("Tasks")){
    		intent = new Intent(this, AgendaFoldedActivity.class);
    	} else {
    		change = false;
    	}
    	if (change){
    		startActivity(intent);
    	}
    }
    
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
    
    public void viewTask(View view){
		Intent intent = new Intent(this, AgendaTaskActivity.class);
		startActivity(intent);    	
    }
    
	public void prevWeek(View view){
		if (weekOf > 0){
			weekOf--;
		}
		week.setText(weeklisting[weekOf]);
		if (weekOf == 0){
			toDo1.setVisibility(View.INVISIBLE);
			toDo2.setVisibility(View.INVISIBLE);
			toDo3.setVisibility(View.VISIBLE);
			toDo4.setVisibility(View.INVISIBLE);
			toDo5.setVisibility(View.INVISIBLE);
			toDo6.setVisibility(View.INVISIBLE);
		} else if (weekOf == 1){
			toDo1.setVisibility(View.VISIBLE);
			toDo2.setVisibility(View.VISIBLE);
			toDo3.setVisibility(View.INVISIBLE);
			toDo4.setVisibility(View.INVISIBLE);
			toDo5.setVisibility(View.INVISIBLE);
			toDo6.setVisibility(View.INVISIBLE);
		} else if (weekOf == 2){
			toDo1.setVisibility(View.INVISIBLE);
			toDo2.setVisibility(View.INVISIBLE);
			toDo3.setVisibility(View.INVISIBLE);
			toDo4.setVisibility(View.VISIBLE);
			toDo5.setVisibility(View.VISIBLE);
			toDo6.setVisibility(View.INVISIBLE);
		} else {
			toDo1.setVisibility(View.INVISIBLE);
			toDo2.setVisibility(View.INVISIBLE);
			toDo3.setVisibility(View.INVISIBLE);
			toDo4.setVisibility(View.INVISIBLE);
			toDo5.setVisibility(View.INVISIBLE);
			toDo6.setVisibility(View.VISIBLE);
		}
	}
	
	public void nextWeek(View view){
		if (weekOf < weeklisting.length-1){
			weekOf++;
		}
		week.setText(weeklisting[weekOf]);
		if (weekOf == 0){
			toDo1.setVisibility(View.INVISIBLE);
			toDo2.setVisibility(View.INVISIBLE);
			toDo3.setVisibility(View.VISIBLE);
			toDo4.setVisibility(View.INVISIBLE);
			toDo5.setVisibility(View.INVISIBLE);
			toDo6.setVisibility(View.INVISIBLE);
		} else if (weekOf == 1){
			toDo1.setVisibility(View.VISIBLE);
			toDo2.setVisibility(View.VISIBLE);
			toDo3.setVisibility(View.INVISIBLE);
			toDo4.setVisibility(View.INVISIBLE);
			toDo5.setVisibility(View.INVISIBLE);
			toDo6.setVisibility(View.INVISIBLE);
		} else if (weekOf == 2){
			toDo1.setVisibility(View.INVISIBLE);
			toDo2.setVisibility(View.INVISIBLE);
			toDo3.setVisibility(View.INVISIBLE);
			toDo4.setVisibility(View.VISIBLE);
			toDo5.setVisibility(View.VISIBLE);
			toDo6.setVisibility(View.INVISIBLE);
		} else {
			toDo1.setVisibility(View.INVISIBLE);
			toDo2.setVisibility(View.INVISIBLE);
			toDo3.setVisibility(View.INVISIBLE);
			toDo4.setVisibility(View.INVISIBLE);
			toDo5.setVisibility(View.INVISIBLE);
			toDo6.setVisibility(View.VISIBLE);
		}
	}
}