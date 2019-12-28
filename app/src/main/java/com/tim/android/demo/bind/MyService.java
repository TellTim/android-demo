package com.tim.android.demo.bind;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;
import com.tim.android.demo.utils.Logger;

/**
 * MyService
 *
 * @author Tell.Tim
 * @date 2019/12/26 20:13
 */
public class MyService extends Service {
    private static final String TAG = "MyService";
    private static final Logger logger = Logger.getLogger(TAG);

    public MyService() {
    }

    @Override public void onCreate() {
        super.onCreate();
        logger.d("onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        logger.d("onBind");
        return new MyBind();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        logger.d("onUnbind");
        return super.onUnbind(intent);
    }

    public void banZheng(int money) {
        logger.d("banZheng");
        if (money > 1000) {
            Toast.makeText(getApplicationContext(), "帮你办", Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(getApplicationContext(), "钱少,不办", Toast.LENGTH_LONG).show();
        }
    }

    //定义中间人
    public class MyBind extends Binder {
        public void callBanZheng(int money) {
            //调用办证的方法
            logger.d("callBanZheng");
            banZheng(money);
        }
    }

    @Override public void onDestroy() {
        super.onDestroy();
        logger.d("onDestroy");
    }
}
