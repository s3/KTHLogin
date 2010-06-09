package com.s3.kthlogin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class KTHLoginSettingsActivity extends Activity {
	
	
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
        setContentView(R.layout.main);
        
        final EditText user = (EditText)findViewById(R.id.EditText01);
        final EditText pass = (EditText)findViewById(R.id.EditText02);
        
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		final SharedPreferences.Editor editor = prefs.edit();
		
		if (prefs.getBoolean("saved", false)) {
			user.setText(prefs.getString("username",""));
			pass.setText(prefs.getString("password",""));
		}
		
        
        
        
        Button b = (Button)findViewById(R.id.Button01);
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String username = user.getText().toString().replace(" ", "");
				String password = pass.getText().toString().replace(" ", "");
				
				if (username.length() == 0 || password.length() == 0)
					return;
				
				editor.putBoolean("saved", true);
				editor.putString("username", username);
				editor.putString("password", password);
				editor.commit();
				KTHLoginSettingsActivity.this.finish();
				
			}
		});
        
        b = (Button)findViewById(R.id.Button02);
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				KTHLoginSettingsActivity.this.finish();				
			}
		});
        
	}

}
