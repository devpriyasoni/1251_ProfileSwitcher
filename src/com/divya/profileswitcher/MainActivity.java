package com.divya.profileswitcher;

//import java.security.PublicKey;

import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	public static String file = "data";
	SharedPreferences data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	try{
        
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getSharedPreferences(file, 0);
        String string = prefs.getString("sharedString","no_password");
        if(string.equals("no_password"))
        {
        	Intent openpage = new Intent("com.divya.profileswitcher.CreateProfile");
        	startActivity(openpage);
        }
        else
        {
        	Intent openpage = new Intent("com.divya.profileswitcher.ValidateKey");
        	startActivity(openpage);
        	
        }
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	finish();
    }
    
}
