package com.s3.kthlogin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class KTHLoginReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		if (!arg1.getBooleanExtra(android.net.wifi.WifiManager.EXTRA_SUPPLICANT_CONNECTED, false))
			return;
		
		Log.d("kth.receiver", "receiver running");
		
		Intent i = new Intent(arg0, KTHLoginService.class);
		arg0.startService(i);
	}

	
	
}