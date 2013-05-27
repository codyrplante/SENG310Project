package com.example.uvicscheduler;

import android.content.Context;
import android.graphics.LightingColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MonthAdapter extends BaseAdapter {
	private Context mContext;
	private final String[] mDates;

    public MonthAdapter(Context c, String[] dates) {
        mContext = c;
		mDates = dates;
    }

    @Override
    public int getCount() {
        return mDates.length;
    }

    @Override
    public Object getItem(int arg0) {
        return mDates[arg0];
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { 
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        
		if (convertView == null) {
 
			gridView = new View(mContext);
 
			// get layout from mobile.xml
			gridView = inflater.inflate(R.layout.agenda_month_gridcell, null);
 
			// set value into textview
			TextView textView = (TextView) gridView.findViewById(R.id.calendar_day_gridcell);
			Button calendar_day_gridcell = (Button) gridView.findViewById(R.id.calendar_day_gridcell);
			textView.setText(mDates[position]);
 
			String date = mDates[position];
 
			if (date.equals("4")){
				calendar_day_gridcell.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFFFF00FF));
			} else if (date.equals("13")){
				calendar_day_gridcell.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFF357EC7));
			} else if (date.equals("15")){
				calendar_day_gridcell.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFFFFA500));
			} else if (date.equals("19")){
				calendar_day_gridcell.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFF357EC7));
			} else if (date.equals("22")){
				calendar_day_gridcell.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFFAA0000));
			} else if (date.equals("26")){
				calendar_day_gridcell.getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0xFF008000));
			}
		} else {
			gridView = (View) convertView;
		}
		
        return gridView;
    }
}