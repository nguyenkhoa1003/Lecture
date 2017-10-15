package com.laptrinhandroid.lecture;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by ndkhoa on 10/8/17.
 */

public class MyService extends Service {
    /** indicates how to behave if the service is killed */
    int mStartMode;

    /** interface for clients that bind */
    IBinder mBinder = new MyBinder();

    /** indicates whether onRebind should be used */
    boolean mAllowRebind;

    /** Called when the service is being created. */
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
    }

    /** The service is starting, due to a call to startService() */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return Service.START_NOT_STICKY;
    }

    /** A client is binding to the service with bindService() */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "Service onBind", Toast.LENGTH_LONG).show();
        return mBinder;
    }

    /** Called when all clients have unbound with unbindService() */
    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "Service onUnbind", Toast.LENGTH_LONG).show();
        return mAllowRebind;
    }

    /** Called when a client is binding to the service with bindService()*/
    @Override
    public void onRebind(Intent intent) {
        Toast.makeText(this, "Service onRebind", Toast.LENGTH_LONG).show();
    }

    /** Called when The service is no longer used and is being destroyed */
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }


    public class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }


}
