package com.tim.android.demo.sharedpref;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.tim.android.demo.utils.Logger;

/**
 * SharePreService
 *
 * @author Tell.Tim
 * @date 2019/12/27 11:41
 */
public class SharePreService extends Service implements
        SharedPreferences.OnSharedPreferenceChangeListener {
      private static final String TAG = "SharePreService";
      private static final Logger logger = Logger.getLogger(TAG);
    @Override
    public void onCreate() {
        super.onCreate();
        logger.d("onCreate");
        SharedPreferences authSharedPref = getSharedPreferences(
                AppConst.AUTH_SHARED_PREF, MODE_PRIVATE);
        if ("".equals(authSharedPref.getString(AppConst.AUTH_ACCOUNT,""))){
            authSharedPref.edit().putString(AppConst.AUTH_ACCOUNT,"UN_AUTH_ACCOUNT").apply();
        }
        authSharedPref.registerOnSharedPreferenceChangeListener(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
       logger.d("onSharedPreferenceChanged "+s);
       if (AppConst.AUTH_ACCOUNT.equals(s)){
           logger.d(sharedPreferences.getString(AppConst.AUTH_ACCOUNT,""));
       }
    }

    @Override public void onDestroy() {
        super.onDestroy();
        SharedPreferences authSharedPref = getSharedPreferences(
                AppConst.AUTH_SHARED_PREF, MODE_PRIVATE);
        authSharedPref.unregisterOnSharedPreferenceChangeListener(this);
    }
}
