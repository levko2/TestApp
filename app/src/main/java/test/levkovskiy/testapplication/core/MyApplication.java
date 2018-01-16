package test.levkovskiy.testapplication.core;

import android.app.Application;

import test.levkovskiy.testapplication.net.NetManager;

/**
 * Created by Admin on 06.11.2016.
 */

public class MyApplication extends Application{
    NetManager netManager;

    @Override
    public void onCreate() {
        super.onCreate();
        netManager = new NetManager();

    }

    public NetManager getNetManager() {
        return netManager;
    }

    public void setNetManager(NetManager netManager) {
        this.netManager = netManager;
    }
}
