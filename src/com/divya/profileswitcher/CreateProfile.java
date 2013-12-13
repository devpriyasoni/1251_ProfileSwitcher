package com.divya.profileswitcher;

//import java.io.ObjectOutputStream.PutField;

import android.app.Activity;
import android.os.Bundle;
import android.content.*;
import android.view.View;
import android.widget.*;

public class CreateProfile extends Activity 
{
	EditText mesg1;
	EditText mesg2;
	String mesgstr1,mesgstr2;
    Button create;
    public static String file = "data";
	SharedPreferences data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.create_profile);
		mesg1=(EditText)findViewById(R.id.profilekey);
		mesg2=(EditText)findViewById(R.id.confirmkey);
		create=(Button)findViewById(R.id.save);
		create.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mesgstr1 = mesg1.getText().toString();
				mesgstr2 = mesg2.getText().toString();
				if(mesgstr1.equals(mesgstr2))
				{
					SharedPreferences prefs = getSharedPreferences(file, MODE_PRIVATE);
					SharedPreferences.Editor editor = prefs.edit();
					editor.putString("sharedstring", mesgstr1);
					editor.commit();
					Intent openpage = new Intent("com.divya.profileswitcher.SaveKey");
					startActivity(openpage);
				}
				else
				{
					mesg1.setText("");
					mesg2.setText("");
					Toast msg = Toast.makeText(CreateProfile.this, "Profile Key Not Matched !!", Toast.LENGTH_LONG);
					msg.show();
				}
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
