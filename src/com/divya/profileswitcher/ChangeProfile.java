package com.divya.profileswitcher;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.Toast;

public class ChangeProfile extends Activity
{
	
	private AudioManager maudio;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    maudio = (AudioManager)getSystemService(AUDIO_SERVICE);
	    maudio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
	    AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
	    audioManager.setStreamVolume(AudioManager.STREAM_RING, audioManager.getStreamMaxVolume(AudioManager.STREAM_RING), AudioManager.FLAG_PLAY_SOUND);
	    Toast msg = Toast.makeText(ChangeProfile.this, "General Mode Activated !!", Toast.LENGTH_LONG);
	    msg.show();
	    setContentView(R.layout.activity_main);
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		setContentView(R.layout.activity_main);
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		setContentView(R.layout.activity_main);
	}
}
