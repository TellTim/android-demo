package com.tim.android.demo.bind;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tim.android.demo.utils.Logger;
import com.tim.android.demo.R;

public class MainActivity extends AppCompatActivity {
      private static final String TAG = "MainActivity";
      private static final Logger logger = Logger.getLogger(TAG);
    MyConn myConn;
    MyService.MyBind myBind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logger.d("onCreate,then bindService");
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, MyService.class);
        myConn = new MyConn();
        bindService(intent, myConn, BIND_AUTO_CREATE);
    }

    public void click(View view) {

        //自己new对象 脱离了谷歌框架
        //        MyService myService = new MyService();
        logger.d("click");
        myBind.callBanZheng(10200);
    }

    //监视服务的状态
    private class MyConn implements ServiceConnection {
        //当服务连接成功调用
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBind = (MyService.MyBind) service;
            logger.d("onServiceConnected");
        }
        //失去连接
        @Override
        public void onServiceDisconnected(ComponentName name) {
            logger.d("onServiceDisconnected");
        }
    }

    @Override
    protected void onDestroy() {
        logger.d("onDestroy,then unbindService");
        unbindService(myConn);
        super.onDestroy();
    }
}
