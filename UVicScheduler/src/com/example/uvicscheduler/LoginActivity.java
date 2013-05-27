package com.example.uvicscheduler;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_login);
		
		TextView userhelp = (TextView) findViewById(R.id.userHelpTextView);
		userhelp.setTextColor(Color.parseColor("#0000FF"));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}
	
	public void signin(View view){
		Intent intent = new Intent(this, HomeMenuActivity.class);
		startActivity(intent);
	}
	
    public void whatsThis(View v) {
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.login_dialog);
		dialog.setTitle("What's This?");

		TextView text = (TextView) dialog.findViewById(R.id.dialogText);
		text.setText("Your NetLink ID is your online identification at the University of Victoria that can be used to access computing services and applications.");
	
		Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
		// if button is clicked, close the custom dialog
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		dialog.show();
	}  
    
    public void userHelp(View v) {
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.login_dialog);
		dialog.setTitle("User / Password Help");

		Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
		// if button is clicked, close the custom dialog
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		dialog.show();
	}  
}
