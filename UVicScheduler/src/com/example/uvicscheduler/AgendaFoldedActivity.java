package com.example.uvicscheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.support.v4.app.NavUtils;

public class AgendaFoldedActivity extends Activity implements OnItemClickListener, OnItemSelectedListener{
	public final static String ITEM_TITLE = "title";
	public final static String ITEM_CAPTION = "caption";
	private final static String[] days = new String[]{"Monday March 4", "Completed March 4", "Monday March 11", "Tuesday March 19", "Tuesday March 26"};
	private final static String[][] notes = new String[][]{{"CSC 305 - Assignment 3", "CSC 330 - Assignment 2"},
															{"SENG 310 - Prototype"},
															{"SENG 310 - Heuristic Evaluation"},
															{"CSC 360 - Assignment 3", "CSC 370 - Assignment 3"},
															{"CSC 370 - Assignment 4"}};
	private SeparatedListAdapter adapter;
	private ListView journalListView;
	private AgendaAdapter listadapter;

	public Map<String, ?> createItem(String title, String caption)
		{
			Map<String, String> item = new HashMap<String, String>();
			item.put(ITEM_TITLE, title);
			item.put(ITEM_CAPTION, caption);
			return item;
		}
	
	Intent intent;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agenda_folded);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinnerView);
		spinner.setOnItemSelectedListener(this);
		
		List<String> list = new ArrayList<String>();		
		list.add("Tasks");
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
		
		// Create the ListView Adapter
		adapter = new SeparatedListAdapter(this);
		
		for (int i = 0; i < days.length; i++){
			listadapter = new AgendaAdapter(this, notes[i]);
			adapter.addSection(days[i], listadapter);		
		}

		// Get a reference to the ListView holder
		journalListView = (ListView) this.findViewById(R.id.listViewfolded);

		// Set the adapter on the ListView holder
		journalListView.setAdapter(adapter);
		journalListView.setOnItemClickListener(this);
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
    	} else if (selectedView.equalsIgnoreCase("Week")){
    		intent = new Intent(this, AgendaWeekActivity.class);
    	} else if (selectedView.equalsIgnoreCase("Month")){
    		intent = new Intent(this, AgendaMonthActivity.class);
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
}