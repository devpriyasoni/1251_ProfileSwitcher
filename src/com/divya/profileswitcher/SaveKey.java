package com.divya.profileswitcher;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class SaveKey extends Activity 
{
     Button save1;
     EditText mess;
     public static String file = "data";
     SharedPreferences data;
     String changestr;
     
     @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);
    	data = getSharedPreferences(file, 0);
    	save1 = (Button) findViewById(R.id.bsave);
    	mess = (EditText) findViewById(R.id.changetext);
    	save1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				changestr = mess.getText().toString();
				SharedPreferences prefs = getSharedPreferences(file, MODE_PRIVATE);
				SharedPreferences.Editor editor = prefs.edit();
				editor.putString("sharedString", changestr);
				
				editor.commit();
				Toast msg = Toast.makeText(SaveKey.this, "Profile Key Saved Successfully !!", Toast.LENGTH_LONG);
				
				msg.show();
			}
		});
    }
     
     @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	finish();
    }
}
