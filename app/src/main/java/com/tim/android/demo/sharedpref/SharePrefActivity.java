package com.tim.android.demo.sharedpref;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.tim.android.demo.R;
import com.tim.android.demo.utils.Logger;

/**
 * SharePrefActivity
 *
 * @author Tell.Tim
 * @date 2019/12/27 13:44
 */
public class SharePrefActivity extends Activity {
      private static final String TAG = "SharePrefActivity";
      private static final Logger logger = Logger.getLogger(TAG);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_pref);
        String value = "15013670707&create_at=5489464665311";
        logger.d("value is "+value.substring(0,value.indexOf("&")));
    }

    public void click1(View view) {
        logger.d("click1");
        SharedPreferences sharedPreferences = getSharedPreferences(AppConst.AUTH_SHARED_PREF,MODE_PRIVATE);
        sharedPreferences.edit().putString(AppConst.AUTH_ACCOUNT,"15013670707").apply();
    }
    public void click2(View view) {
        logger.d("click2");
        SharedPreferences sharedPreferences = getSharedPreferences(AppConst.AUTH_SHARED_PREF,MODE_PRIVATE);
        sharedPreferences.edit().putString(AppConst.AUTH_ACCOUNT,"15112569512").apply();
    }

    public void click3(View view) {
        logger.d("click3");
        SharedPreferences sharedPreferences = getSharedPreferences(AppConst.AUTH_SHARED_PREF,MODE_PRIVATE);
        sharedPreferences.edit().putString(AppConst.AUTH_ACCOUNT, AppConst.UN_AUTH_ACCOUNT).apply();
    }

    public void click4(View view) {
        logger.d("click4");
        SharedPreferences sharedPreferences = getSharedPreferences(AppConst.AUTH_SHARED_PREF,MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }
}
