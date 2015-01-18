package com.sahil.carcredible;

import android.app.Application;

class MyApp extends Application {

    private int setDefault=0,max_budget=80,min_budget=0;

    public int getDeafultVarValue() {
        return setDefault;
    }

    public void setDefaultVarValue(int str, int max, int min) {
        setDefault = str;
        max_budget = max;
        min_budget = min;
        
    }
}