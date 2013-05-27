package com.example.uvicscheduler;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class HomeMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_home_menu, menu);
		return true;
	}

	public void agendaView(View view){
		Intent intent = new Intent(this, AgendaDayActivity.class);
		startActivity(intent);
	}
	
	public void timetableView(View view){
		Intent intent = new Intent(this, TimeTableActivity.class);
		startActivity(intent);
	}
	
	public void gradesView(View view){
		Intent intent = new Intent(this, GradesActivity.class);
		startActivity(intent);
	}	
	
	public void settingsView(View view){
		Intent intent = new Intent(this, SettingsActivity.class);
		startActivity(intent);
	}	
	
	public void signOut(View view){
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}	
}
