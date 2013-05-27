package com.example.uvicscheduler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class AgendaAdapter extends BaseAdapter {
	private Context mContext;
	private final String[] mData;

    public AgendaAdapter(Context c, String[] data) {
        mContext = c;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.length;
    }

    @Override
    public Object getItem(int arg0) {
        return mData[arg0];
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { 
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        View vi=convertView;
		if (convertView == null) {
			vi = inflater.inflate(R.layout.agenda_listcell, null);
		}
			
		CheckBox check = (CheckBox) vi.findViewById(R.id.checkBox1);
		TextView text = (TextView) vi.findViewById(R.id.text);
		text.setText(mData[position]);
		if (mData[position].startsWith("CSC 305")){
			text.setBackgroundColor(0x99AA0000);	
		} else if (mData[position].startsWith("CSC 330")){
			text.setBackgroundColor(0x99FFA500);
		} else if (mData[position].startsWith("CSC 360")){
			text.setBackgroundColor(0x99357EC7);
		} else if (mData[position].startsWith("CSC 370")){
			text.setBackgroundColor(0x99008000);
		} else {
			text.setBackgroundColor(0x99FF00FF);
		}
		if (mData[position].equals("SENG 310 - Prototype")){
			check.setChecked(true);
		}
		return vi;
    }
}
