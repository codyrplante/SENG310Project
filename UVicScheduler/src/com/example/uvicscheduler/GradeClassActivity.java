package com.example.uvicscheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class GradeClassActivity extends Activity {
	String[] from = new String[] {"title", "grade", "percentage", "weight"};
	int[] to = new int[] { R.id.courseGradeTitleGridTextView, R.id.courseGradeMarkGridTextView, R.id.courseGradePercentageGridTextView, R.id.courseGradeWeightGridTextView};

	String[][] grades_csc305 = new String[][] {{"Assignment 1", "10/10", "100%", "5%"},
			{"Assignment 2", "10/10", "100%", "10%"},
			{"Assignment 3", "-", "-", "15%"},
			{"Assignment 4", "-", "-", "20%"},
			{"Class Participation", "5/5", "100%", "5%"},
			{"Lab Participation", "-", "-", "5%"},
			{"Midterm", "12/14", "85.7%", "15%"},
			{"Final", "-", "", "25%"}};
	
	String[][] grades_csc330 = new String[][] {};
	
	String[][] grades_csc360 = new String[][] {{"Assignment 1", "95/100", "95%", "10%"},
			{"Assignment 2", "93/10", "90%", "13%"},
			{"Assignment 3", "-", "-", "12%"},
			{"Midterm", "24/25", "96%", "25%"}};
	
	String[][] grades_csc370 = new String[][] {{"Assignment 1", "50/50", "100%", "5%"},
			{"Assignment 2", "26/26", "100%", "5%"},
			{"Assignment 3", "-", "-", "5%"},
			{"Assignment 4", "-", "-", "5%"},
			{"Project", "-", "-", "15%"},
			{"Midterm", "18/20", "90%", "20%"}};
	
	String[][] grades_seng310 = new String[][] {};
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grade_class);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		TextView course = (TextView) findViewById(R.id.courseGradeCourseTextView);
		TextView error = (TextView) findViewById(R.id.courseGradeErrorTextView);
		
	    Intent intent = getIntent();
	    String message = intent.getStringExtra(GradesActivity.EXTRA_MESSAGE);
	    int given_class = Integer.parseInt(message);
	    String[][] values;
	    if (given_class == 0){
	    	values = grades_csc305;
	    	course.setText("CSC 305: Intro Comp Graphics");
	    	error.setVisibility(View.INVISIBLE);
	    } else if (given_class == 1){
	    	values = grades_csc330;
	    	course.setText("CSC 330: Program Languages");
	    } else if (given_class == 2){
	    	values = grades_csc360;
	    	course.setText("CSC 360: Operating Systems");
	    	error.setVisibility(View.INVISIBLE);
	    } else if (given_class == 3){
	    	values = grades_csc370;
	    	course.setText("CSC 370: Database Systems");
	    	error.setVisibility(View.INVISIBLE);
	    } else {
	    	values = grades_seng310;
	    	course.setText("Seng 310: HCI");
	    }
	    
		ListView listView = (ListView) findViewById(R.id.courseGradeList);

    	// prepare the list of all records
    	List<HashMap<String, String>> fillGrades = new ArrayList<HashMap<String, String>>();
    	for(int i = 0; i < values.length; i++){
    		HashMap<String, String> map = new HashMap<String, String>();
    		map.put(from[0], values[i][0]);
    		map.put(from[1], values[i][1]);
    		map.put(from[2], values[i][2]);
    		map.put(from[3],  values[i][3]);
    		fillGrades.add(map);
    	}
    	
        SimpleAdapter adapter = new SimpleAdapter(this, fillGrades, R.layout.grid_item_4, from, to);
        listView.setAdapter(adapter);
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
}