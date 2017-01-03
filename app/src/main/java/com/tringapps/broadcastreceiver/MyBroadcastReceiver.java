package com.tringapps.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by geethu on 15/11/16.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String state = extras.getString(TelephonyManager.EXTRA_STATE);
            Log.w("MY_DEBUG_TAG", state);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                String phoneNum = extras
                        .getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.w("MY_DEBUG_TAG", phoneNum);
                    Intent intent1 = new Intent(context,MainActivity.class);
                    intent1.setFlags(intent1.FLAG_ACTIVITY_NEW_TASK | intent1.FLAG_ACTIVITY_SINGLE_TOP);
                    intent1.putExtra("phone", phoneNum);
                    context.startActivity(intent1);
            }
        }
    }

}


