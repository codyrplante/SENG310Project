package com.example.uvicscheduler;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class TimeTableActivity extends Activity {
	Button button_class305a, button_class305b, button_class305c, button_class330a, button_class330b, button_class330c, button_class360a, 
			button_class360b, button_class360c, button_class370a, button_class370b, button_class370c, button_class310a, button_class310b;

	TextView week;
	int weekOf = 1;
	String[] weeklisting = new String[] {"Week Of Feb 25, 2013", "Week Of Mar 4, 2013", "Week Of Mar 11, 2013", "Week Of Mar 18, 2013"};

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_time_table);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		week = (TextView)findViewById(R.id.weekGlanceTextView);
		week.setText(weeklisting[weekOf]);
		
		button_class305a = (Button) findViewById(R.id.button_class305a);
		button_class305a.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFFAA0000));
		button_class305b = (Button) findViewById(R.id.button_class305b);
		button_class305b.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFFAA0000));
		button_class305c = (Button) findViewById(R.id.button_class305c);
		button_class305c.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFFAA0000));
		
		button_class330a = (Button) findViewById(R.id.button_class330a);
		button_class330a.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFFFFA500));
		button_class330b = (Button) findViewById(R.id.button_class330b);
		button_class330b.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFFFFA500));
		button_class330c = (Button) findViewById(R.id.button_class330c);
		button_class330c.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFFFFA500));
		
		button_class360a = (Button) findViewById(R.id.button_class360a);
		button_class360a.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFF357EC7));
		button_class360b = (Button) findViewById(R.id.button_class360b);
		button_class360b.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFF357EC7));
		button_class360c = (Button) findViewById(R.id.button_class360c);
		button_class360c.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFF357EC7));
		
		button_class370a = (Button) findViewById(R.id.button_class370a);
		button_class370a.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFF008000));
		button_class370b = (Button) findViewById(R.id.button_class370b);
		button_class370b.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFF008000));
		button_class370c = (Button) findViewById(R.id.button_class370c);
		button_class370c.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFF008000));
		
		button_class310a = (Button) findViewById(R.id.button_class310a);
		button_class310a.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFFFF00FF));
		button_class310b = (Button) findViewById(R.id.button_class310b);
		button_class310b.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFFFF00FF));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. 
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void viewClass(View view){
		Intent intent = new Intent(this, TimetableClassActivity.class);
		startActivity(intent);
	}
	
	public void prevWeek(View view){
		if (weekOf > 0){
			weekOf--;
		}
		week.setText(weeklisting[weekOf]);
	}
	
	public void nextWeek(View view){
		if (weekOf < weeklisting.length-1){
			weekOf++;
		}
		week.setText(weeklisting[weekOf]);
	}
}
