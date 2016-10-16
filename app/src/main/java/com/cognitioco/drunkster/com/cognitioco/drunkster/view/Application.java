package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import com.orm.SugarApp;
import com.orm.SugarContext;

/**
 * Created by dasan on 10/16/2016.
 */

public class Application extends SugarApp {


    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(getApplicationContext());

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
