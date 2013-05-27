package com.example.uvicscheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
//import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class GradesActivity extends Activity implements OnItemClickListener, OnItemSelectedListener{
	public final static String EXTRA_MESSAGE = "com.example.UVicScheduler.MESSAGE";
	String[] from = new String[] {"course", "course_title", "grade"};
	int[] to = new int[] { R.id.courseHeaderTextView, R.id.courseTitleHeaderTextView, R.id.gradeHeaderTextView};
	double CGPA = 7.52;
	TextView help_message, semester_gpa;
	
	String[][] grades_spring2013 = new String[][] {{"CSC 305", "INTRO COMPUTER GRAPHICS", "N/A"},
			{"CSC 330",  "PROGRAMMING LANGUAGES", "N/A"},
			{"CSC 360", "OPERATING SYSTEMS", "N/A"},
			{"CSC 370", "DATABASE SYSTEMS", "N/A"},
			{"SENG 310", "HUMAN COMPUTER INTERACT\'N", "N/A"},
			{"Semester GPA: N/A", "Cumulative GPA: " + CGPA}};

	String[][] grades_fall2012 = new String[][] {{"MATH 222", "DISCRETE+COMBINATOR MATH", "A+"},
			{"CSC 355", "DIGITAL LOGIC+ORGANIZAT\'N", "A"},
			{"SENG 330", "OBJECT ORIENTED SOFTW DEV", "A+"},
			{"CSC 320", "FOUNDATIONS OF COMP SCI", "A"},
			{"SENG 360", "SECURITY SOFTWARE", "A+"},
			{"Semester GPA: 8.6", "Cumulative GPA: " + CGPA}};

	String[][] grades_spring2012 = new String[][] {{"CSC 225", "ALGORITHMS+DATA STUCT:I", "A-"},
			{"CSC 205", "2D COMPUTER GRAPHICS", "A"},
			{"MATH 201", "INTRO DIFFERNTL EQUATIONS", "A-"},
			{"SENG 271", "SOFTWARE MODEL ENGRING", "A-"},
			{"PSYC 215A", "INTRO TO BIOLOGICAL PSYC", "B+"},
			{"Semester GPA: 7", "Cumulative GPA: " + CGPA}};

	String[][] grades_fall2011 = new String[][] {{"CSC 230", "COMPUTER ARCHITECTURE", "A+"},
			{"MATH 211", "MATRIX ALGEBRA: I", "A-"},
			{"PSYC 210", "CONCEPTUAL FOUNDATNS:PSYC", "A-"},
			{"SENG 265", "SOFTWARE DEVELOP METHODS", "A"},
			{"STAT 255", "STATS FOR LIFE SCI:I", "B+"},
			{"Semester GPA: 7.4", "Cumulative GPA: " + CGPA}};

	String[][] grades_spring2011 = new String[][] {{"CSC 115", "FUNDAMENTAL PROGRAMING:II", "A+"},
			{"ENGR 240", "TECHNICAL WRITING", "B+"},
			{"MATH 101", "CALCULUS:II", "B+"},
			{"MATH 122", "LOGIC AND FOUNDATIONS", "A"},
			{"PSYC 100B", "INTRODUCTORY PSYCHOLOGY: II", "A"},
			{"Semester GPA: 7.4", "Cumulative GPA: " + CGPA}};

	String[][] grades_fall2010 = new String[][] {{"CSC 106", "PRACTICE OF COMPUTER SCIENCE", "A"},
			{"CSC 110", "FUNDAMENTAL PROGRAMING:I", "A"},
			{"ENGL 135", "ACADEMIC READING+WRITING", "B+"},
			{"MATH 100", "CALCULUS:I", "A-"},
			{"PSYC 100A", "INTRODUCTORY PSYCHOLOGY: I", "A-"},
			{"Semester GPA: 7.2", "Cumulative GPA: " + CGPA}};

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grades);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinnerTerms);
		spinner.setOnItemSelectedListener(this);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> termAdapter = ArrayAdapter.createFromResource(this,
		        R.array.terms_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		termAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(termAdapter);
		
		help_message = (TextView) findViewById(R.id.instructionGradeTextView);
		semester_gpa = (TextView) findViewById(R.id.semester_gpaTextView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_grades, menu);
		return true;
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
		ListView listView = (ListView) findViewById(R.id.gradeList);
		String[][] values = grades_spring2013;

    	String selectedTerm = (String) parent.getItemAtPosition(pos);
    	if (selectedTerm.equalsIgnoreCase("Second Term: Jan - Apr 2013")){
    		values = grades_spring2013;
    		help_message.setVisibility(View.VISIBLE);
    	} else if (selectedTerm.equalsIgnoreCase("First Term: Sep - Dec 2012")){
    		values = grades_fall2012;
    		help_message.setVisibility(View.INVISIBLE);
    	} else if (selectedTerm.equalsIgnoreCase("Second Term: Jan - Apr 2012")){
    		values = grades_spring2012;
    		help_message.setVisibility(View.INVISIBLE);
    	} else if (selectedTerm.equalsIgnoreCase("First Term: Sep - Dec 2011")){
    		values = grades_fall2011;
    		help_message.setVisibility(View.INVISIBLE);
    	} else if (selectedTerm.equalsIgnoreCase("Second Term: Jan - Apr 2011")){
    		values = grades_spring2011;
    		help_message.setVisibility(View.INVISIBLE);
    	} else if (selectedTerm.equalsIgnoreCase("First Term: Jan - Apri 2010")){
    		values = grades_fall2010;
    		help_message.setVisibility(View.INVISIBLE);
    	}
    	

    	// prepare the list of all records
    	List<HashMap<String, String>> fillGrades = new ArrayList<HashMap<String, String>>();
    	for(int i = 0; i < 5; i++){
    		HashMap<String, String> map = new HashMap<String, String>();
    		map.put("course", values[i][0]);
    		map.put("course_title", values[i][1]);
    		map.put("grade", values[i][2]);
    		fillGrades.add(map);
    	}
    	
        SimpleAdapter adapter = new SimpleAdapter(this, fillGrades, R.layout.grid_item, from, to);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        
        semester_gpa.setText(values[5][0]);
    }
    
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
    
    public void onItemClick(AdapterView<?> parent, View view, int position,long itemID) {
    	if (help_message.getVisibility() == View.VISIBLE){
        	Intent intent = new Intent(this, GradeClassActivity.class);
            String message = Integer.toString(position);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);    		
    	}
    }
}
