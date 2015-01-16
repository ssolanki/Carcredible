package com.sahil.carcredible;

import android.app.Application;

class MyApp extends Application {

    private int setDefault=0;

    public int getDeafultVarValue() {
        return setDefault;
    }

    public void setDefaultVarValue(int str) {
        setDefault = str;
    }
}