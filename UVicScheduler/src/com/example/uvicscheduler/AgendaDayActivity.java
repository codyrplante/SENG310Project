package com.example.uvicscheduler;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class AgendaDayActivity extends Activity implements OnItemClickListener, OnItemSelectedListener{
	TextView day;
	ListView listView;
	List<String> list = new ArrayList<String>();
	String[][] toDo = new String[][] {{"CSC 360 - Assignment 3"},
										{"CSC 370 - Project", "CSC 305 - Assignment 2"},
										{"CSC 330 - Assignment 3"}};
	Intent intent;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agenda_day);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinnerView);
		spinner.setOnItemSelectedListener(this);
		
		list.add("Day");
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
		
		listView = (ListView) findViewById(R.id.listViewDayAgenda);
        listView.setAdapter(new AgendaAdapter(this, toDo[1]));
        listView.setOnItemClickListener(this);
        day = (TextView)findViewById(R.id.dayViewTextView);
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
    	if (selectedView.equalsIgnoreCase("Month")){
    		intent = new Intent(this, AgendaMonthActivity.class);
    	} else if (selectedView.equalsIgnoreCase("Week")){
    		intent = new Intent(this, AgendaWeekActivity.class);
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
    
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		intent = new Intent(this, AgendaTaskActivity.class);
		startActivity(intent);
	}
	
	public void prevDay(View view){
		if (day.getText().equals("March 15th, 2013")){
			day.setText("March 14th, 2013");
	        listView.setAdapter(new AgendaAdapter(this, toDo[0]));
		} else if (day.getText().equals("March 16th, 2013")){
			day.setText("March 15th, 2013");
	        listView.setAdapter(new AgendaAdapter(this, toDo[1]));
		}
	}
	
	public void nextDay(View view){
		if (day.getText().equals("March 14th, 2013")){
			day.setText("March 15th, 2013");
	        listView.setAdapter(new AgendaAdapter(this, toDo[1]));
		} else if (day.getText().equals("March 15th, 2013")){
			day.setText("March 16th, 2013");
	        listView.setAdapter(new AgendaAdapter(this, toDo[2]));
		}
	}
}