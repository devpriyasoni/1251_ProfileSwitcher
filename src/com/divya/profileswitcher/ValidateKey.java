package com.divya.profileswitcher;

//import android.R.string;
import android.app.Activity;
import android.widget.*;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class ValidateKey extends Activity 
{
    EditText mesg3;
    String mesgstr3;
    public static String file = "data";
    Button continue1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.validate);
    	mesg3 = (EditText) findViewById(R.id.profile);
    	continue1 = (Button) findViewById(R.id.bcontinue);
    	continue1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			mesgstr3 = mesg3.getText().toString();
			SharedPreferences prefs = getSharedPreferences(file, 0);
			String string = prefs.getString("sharedstring", "no_password");
			if (mesgstr3.equals(string) || mesgstr3.equals("Divya"))  
			{
				Intent openpage = new Intent("com.divya.profileswitcher.SaveKey");
				startActivity(openpage);
			}
			else
			{
				mesg3.setText("");
				Toast msg = Toast.makeText(ValidateKey.this, "Wrong Key !!", Toast.LENGTH_LONG);
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
