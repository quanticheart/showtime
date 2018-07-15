package com.master.killercode.wizard.Splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.master.killercode.wizard.Wizard.WizardActivity;
import com.master.killercode.wizard.Wizard.WizardPageModel;

import java.util.ArrayList;

public class SplashActivity {
    private Activity activity;
    private Intent intentSplash;
    private Class initialClass;
    private Class afterClass;
    private ArrayList<WizardPageModel> wList = new ArrayList<>();

    private String wizard = "Wizard";

    public SplashActivity(Activity activity) {
        this.activity = activity;
        intentSplash = new Intent(activity, Splash.class);
    }

    public SplashActivity(Activity activity, Class afterSplash) {
        this.activity = activity;
        this.initialClass = afterSplash;
        intentSplash = new Intent(activity, Splash.class);
        intentSplash.putExtra("class", initialClass);
    }

    public void show() {
        setIntent();
        activity.startActivity(intentSplash);
    }

    public void show(Boolean finish) {
        setIntent();
        activity.startActivity(intentSplash);
        if (finish)
            activity.finish();
    }

    public void setWizard(ArrayList<WizardPageModel> wList) {
        this.wList = wList;
    }

    public void setSplashFinished(String nameSplash) {
        intentSplash.putExtra("namesplash", nameSplash);
    }

    public void setTimer(int seconds) {
        intentSplash.putExtra("seconds", seconds);
    }

    public void setWizardThemeGoogle() {
        intentSplash.putExtra("thw", true);
    }


    private void setIntent() {

        intentSplash.putExtra("arr", wList);
    }

}
