package com.s3.kthlogin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;

public class KTHLoginService extends Service {


	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
    public void onCreate() {
		Log.d("kth.service", "service running");
		
		new LoginTask().execute();
       
    }
	
	/*	POST to https://wlan-auth.lan.kth.se/login.html
		buttonClicked = 4
		redirect_url = ""
		err_flag = 0
		info_flag = 0
		err_msg = ""
		username = "..."
		password = "..." */

	
	private class LoginTask extends AsyncTask<String, String, Void> {

		@Override
		protected Void doInBackground(String... params) {
			Log.d("kth.service","performing login");
			
			SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
			if (prefs.getBoolean("saved", false)) {
				String username = prefs.getString("username", "");
				String password = prefs.getString("password", "");
				
				Log.d("kth.service", "username: " + username + ", password: " + password);
				
				WifiManager wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);
				WifiInfo info = wifi.getConnectionInfo();
				
				
				
				Log.d("kth.service", "Info: " + info.toString());
				
				
			} else {
				Log.d("kth.service", "no saved settings, not attempting login");
			}
			
			return null;
		}
		
	}
	
	protected void onPostExecute(final Void unused)  {
		// TODO notify user
	}


}
