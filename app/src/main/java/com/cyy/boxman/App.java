package com.cyy.boxman;

import android.app.Application;

/**
 * Created by cyy on 17/3/15.
 *
 */

public class App extends Application {

    private static App mApp = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }

    public static App getInstance(){
        return mApp;
    }
}
