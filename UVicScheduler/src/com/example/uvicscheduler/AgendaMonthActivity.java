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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v4.app.NavUtils;


public class AgendaMonthActivity extends Activity implements OnItemClickListener, OnItemSelectedListener{
	TextView month;
	List<String> list = new ArrayList<String>();
	String[] months = new String[] {"January 2013", "February 2013", "March 2013", "April 2013", "May 2013", "June 2013", 
						"July 2013", "August 2013", "September 2013", "October 2013", "November 2013", "December 2013", };
	String[] dates = new String[42];
	int currentMonth = 2;
	Intent intent;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agenda_month);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		GridView gridview = (GridView) findViewById(R.id.calendar);
		
		for (int i = 0; i < 42; i++){
			if (i < 5){
				dates[i] = Integer.toString(i+24);
			} else if (i < 36){
				dates[i] = Integer.toString(i-4);
			} else {
				dates[i] = Integer.toString(i-35);
			}	
		}
		
		gridview.setAdapter(new MonthAdapter(this, dates));
		
		
		Spinner spinner = (Spinner) findViewById(R.id.spinnerView);
		spinner.setOnItemSelectedListener(this);

		List<String> list = new ArrayList<String>();		
		list.add("Month");
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
		month = (TextView)findViewById(R.id.agendaMonthTextView);
		month.setText(months[currentMonth]);
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

	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		intent = new Intent(this, AgendaDayActivity.class);
		startActivity(intent);
	}
	
	public void goToDate(View view){
		intent = new Intent(this, AgendaDayActivity.class);
		startActivity(intent);
	}
	
    public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
    	boolean change = true;
    	String selectedView = (String) parent.getItemAtPosition(pos);
    	if (selectedView.equalsIgnoreCase("Day")){
    		intent = new Intent(this, AgendaDayActivity.class);
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
    
	public void prevMonth(View view){
		if (currentMonth > 0){
			currentMonth--;
		}
		month.setText(months[currentMonth]);
	}
	
	public void nextMonth(View view){
		if (currentMonth < months.length-1){
			currentMonth++;
		}
		month.setText(months[currentMonth]);
	}
}


